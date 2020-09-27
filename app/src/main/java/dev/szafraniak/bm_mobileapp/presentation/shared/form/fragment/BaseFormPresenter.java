package dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment;

import android.os.Bundle;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.result.ActionStatusFragment;
import lombok.Setter;

public abstract class BaseFormPresenter<T, F extends BaseFormView, C extends BaseFormConfig> {


    @Setter
    protected F view;

    protected void onError(Throwable throwable) {
        view.setActionFailed(throwable);
    }

    protected void onSuccess(T object) {
        Bundle bundle = new Bundle();
        String buttonText = view.getContext().getString(R.string.action_status_back_to_home);
        bundle.putString(ActionStatusFragment.BUTTON_TEXT_KEY, buttonText);
        bundle.putString(ActionStatusFragment.STATE_KEY, ActionStatusFragment.STATE_SUCCEEDED);
        Navigator.backOneAndNavigateTo(view, FragmentFactory.FRAGMENT_ACTION_STATUS, bundle);
    }

    public abstract C createConfig();
}
