package dev.szafraniak.bm_mobileapp.presentation.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.BuildConfig;
import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.memory.UserPreferences;
import dev.szafraniak.bm_mobileapp.presentation.BaseActivity;
import timber.log.Timber;

import static dev.szafraniak.bm_mobileapp.business.Constance.ACTIVITY_RESULT_CODE_GOOGLE_LOGIN;

@SuppressLint("Registered")
@EActivity(R.layout.login_activity)
public class LoginActivity extends BaseActivity implements LoginView {

    @Inject
    UserPreferences userPreferences;

    @Inject
    LoginPresenter presenter;

    private GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BMApplication) getApplication()).getAppComponent().inject(this);
        presenter.setView(this);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(BuildConfig.GOOGLE_CLIENT_ID)
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (userPreferences.silentLoginEnabled()) {
            showProgressBar();
            mGoogleSignInClient.silentSignIn()
                    .addOnCompleteListener(this, this::handleGoogleSignInResult);
        }
    }

    @Override
    public void showProgressBar() {
    }

    @Override
    public void showError() {
    }

    @Click(R.id.sign_in)
    public void credentialSignIn() {
        showProgressBar();
        presenter.signInWithCredentials("test", "test");
    }

    @Click(R.id.sign_in_google_button)
    protected void signIn() {
        showProgressBar();
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, ACTIVITY_RESULT_CODE_GOOGLE_LOGIN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ACTIVITY_RESULT_CODE_GOOGLE_LOGIN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleGoogleSignInResult(task);
        }
    }

    private void handleGoogleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            if (account != null && account.getIdToken() != null) {
                presenter.exchangeGoogleToken(account.getIdToken());
            } else {
                showError();
            }
        } catch (ApiException e) {
            Timber.e("signInResult:failed code=%s", e.getStatusCode());
            showError();
        }
    }
}
