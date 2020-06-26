package dev.szafraniak.bm_mobileapp.presentation.login;

import dev.szafraniak.bm_mobileapp.presentation.BaseActivity;
import dev.szafraniak.bm_mobileapp.presentation.BaseView;

public abstract class LoginView extends BaseActivity implements BaseView {

    abstract void onSilentFailed();

    abstract void onFailed();
}
