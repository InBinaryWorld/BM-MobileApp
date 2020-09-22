package dev.szafraniak.bm_mobileapp.presentation.menu.services.details;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.services.modify.ServiceModelModifyFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.BaseDetailsFragmentWithBtn;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.config.DetailsConfig;

@EFragment(R.layout.fragment_base_details)
public class ServiceModelDetailsFragment extends BaseDetailsFragmentWithBtn<ServiceModel>
        implements ServiceModelDetailsView {

    public final static String KEY_SERVICE_MODEL = "SERVICE_MODEL_KEY";

    @Inject
    ServiceModelDetailsPresenter presenter;

    @Inject
    Gson gson;

    ServiceModel serviceModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() == null || !getArguments().containsKey(KEY_SERVICE_MODEL)) {
            Navigator.back(this);
        }
        String companyJSON = getArguments().getString(KEY_SERVICE_MODEL);
        serviceModel = gson.fromJson(companyJSON, ServiceModel.class);
    }

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_service_model_details;
    }

    @Override
    protected int getFblBtnTextResourceId() {
        return R.string.service_model_details_fl_btn_text;
    }

    @Override
    protected void onFblClick(View view) {
        Bundle args = new Bundle();
        args.putString(ServiceModelModifyFragment.KEY_SERVICE_MODEL, gson.toJson(serviceModel));
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_SERVICE_MODEL_MODIFY, args);

    }

    @Override
    protected void loadData() {
        presenter.loadData(serviceModel.getId());
    }

    @Override
    protected DetailsConfig<ServiceModel> createDetailsConfig() {
        return new ServiceModelDetailsConfig(inflater, layout);
    }
}
