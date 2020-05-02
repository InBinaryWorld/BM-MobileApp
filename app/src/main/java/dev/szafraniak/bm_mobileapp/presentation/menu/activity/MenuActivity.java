package dev.szafraniak.bm_mobileapp.presentation.menu.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.AuthorizationService;
import dev.szafraniak.bm_mobileapp.business.memory.SessionManager;
import dev.szafraniak.bm_mobileapp.presentation.BaseActivity;
import io.reactivex.observers.DisposableCompletableObserver;
import timber.log.Timber;

@SuppressLint("Registered")
@EActivity(R.layout.menu_activity)
public class MenuActivity extends BaseActivity implements MenuView {

    @Inject
    AuthorizationService service;

    @Inject
    SessionManager session;

    @Inject
    MenuPresenter presenter;

    @ViewById(R.id.tv_response)
    TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BMApplication) getApplication()).getAppComponent().inject(this);
    }

    @Click(R.id.btn_logout)
    public void logoutBtnOnClick() {
        logout();
    }

    @Click(R.id.not_secured)
    public void notSecured() {
        presenter.notSecured();
    }

    @Click(R.id.secured)
    public void secured() {
        presenter.secured();
    }

    @Override
    public void setData(String data) {
        messageTextView.setText(data);
    }

    @Override
    public void logout() {
        service.logout(session.getRefreshToken())
                .compose(bindToLifecycle())
                .subscribe(new LogoutObserver());
    }

    private class LogoutObserver extends DisposableCompletableObserver {
        @Override
        public void onComplete() {
            setResult(RESULT_OK, null);
            finish();
        }

        @Override
        public void onError(Throwable e) {
            Timber.e(e);
        }
    }
}
