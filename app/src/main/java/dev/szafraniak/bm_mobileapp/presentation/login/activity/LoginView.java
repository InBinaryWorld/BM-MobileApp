package dev.szafraniak.bm_mobileapp.presentation.login.activity;

import dev.szafraniak.bm_mobileapp.presentation.shared.base.BaseActivity;
import dev.szafraniak.bm_mobileapp.presentation.shared.base.BaseView;

public abstract class LoginView extends BaseActivity implements BaseView {

    abstract void onSilentFailed();

    abstract void onFailed();
}
