package dev.szafraniak.bm_mobileapp.presentation.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.Constance;

@SuppressLint("Registered")
@EActivity(R.layout.activity_login)
public class LoginActivity extends LoginView {

    @ViewById(R.id.cl_logo_component)
    ConstraintLayout logoContainer;

    @ViewById(R.id.cl_buttons_container)
    ConstraintLayout buttonsContainer;

    @ViewById(R.id.cl_silent_container)
    ConstraintLayout silentContainer;

    @ViewById(R.id.cl_progress_container)
    ConstraintLayout progressContainer;

    @ViewById(R.id.cl_logo_host)
    ConstraintLayout logoHost;

    @ViewById(R.id.cl_buttons_host)
    ConstraintLayout buttonsHost;

    @ViewById(R.id.cl_silent_host)
    ConstraintLayout silentHost;

    @ViewById(R.id.cl_progress_host)
    ConstraintLayout progressHost;

    @Inject
    LoginPresenter presenter;

    @AfterViews
    public void initialize() {
        ((BMApplication) getApplication()).getAppComponent().inject(this);
        presenter.initializePresenter(this);
        new Handler().postDelayed(this::startLoginProcess, Constance.SPLASH_DISPLAY_LENGTH);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        presenter.registerLoginService(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void startLoginProcess() {
        super.onStart();
        moveLogo(1000, 0);
        if (presenter.isSilentLoginEnabled()) {
            setSilentComponentVisibility(View.VISIBLE, 500, 500);
            new Handler().postDelayed(presenter::performSilentLogin, 1000);
        } else {
            setButtonComponentVisibility(View.VISIBLE, 500, 500);
        }
    }

    @Click(R.id.btn_login_google)
    protected void googleSignIn() {
        showProgressBar();
        presenter.signInWithGoogle();
    }

    @Click(R.id.btn_login_facebook)
    protected void facebookSignIn() {
        showProgressBar();
        presenter.signInWithFacebook();
    }

    @Override
    void onFailed() {
        showError();
    }

    @Override
    void onSilentFailed() {
        setSilentComponentVisibility(View.GONE, 500, 0);
        setButtonComponentVisibility(View.VISIBLE, 500, 300);
    }

    private void showProgressBar() {
        setButtonComponentVisibility(View.GONE, 500, 0);
        setLoginInProgressComponentVisibility(View.VISIBLE, 500, 300);
    }

    private void showError() {
        Toast.makeText(this, R.string.login_failed_toast, Toast.LENGTH_SHORT).show();
        setLoginInProgressComponentVisibility(View.GONE, 500, 0);
        setButtonComponentVisibility(View.VISIBLE, 500, 300);
    }

    private void setLoginInProgressComponentVisibility(int visibility, int duration, int delay) {
        Transition transition = getFade(duration, delay);
        TransitionManager.beginDelayedTransition(progressHost, transition);
        progressContainer.setVisibility(visibility);
    }

    private void setButtonComponentVisibility(int visibility, int duration, int delay) {
        Transition transition = getFade(duration, delay);
        TransitionManager.beginDelayedTransition(buttonsHost, transition);
        buttonsContainer.setVisibility(visibility);
    }

    private void setSilentComponentVisibility(int visibility, int duration, int delay) {
        Transition transition = getFade(duration, delay);
        TransitionManager.beginDelayedTransition(silentHost, transition);
        silentContainer.setVisibility(visibility);
    }

    private void moveLogo(int duration, int delay) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(logoHost);
        constraintSet.setVerticalBias(logoContainer.getId(), 0.28f);

        Transition transition = getChangeBounds(duration, delay);
        TransitionManager.beginDelayedTransition(logoHost, transition);
        constraintSet.applyTo(logoHost);
    }

    public Transition getFade(int duration, int delay) {
        Transition fade = new Fade();
        fade.setDuration(duration);
        fade.setStartDelay(delay);
        return fade;
    }

    public Transition getChangeBounds(int duration, int delay) {
        Transition changeBounds = new ChangeBounds();
        changeBounds.setDuration(duration);
        changeBounds.setStartDelay(delay);
        return changeBounds;
    }
}
