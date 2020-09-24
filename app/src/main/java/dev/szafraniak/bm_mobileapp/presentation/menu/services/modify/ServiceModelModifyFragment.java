package dev.szafraniak.bm_mobileapp.presentation.menu.services.modify;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.UpdateServiceModelRequest;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.config.FormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormFragment;

@EFragment(R.layout.fragment_base_form)
public class ServiceModelModifyFragment extends BaseFormFragment<UpdateServiceModelRequest> implements ServiceModelModifyView {

    public final static String KEY_SERVICE_MODEL = "SERVICE_MODEL_KEY";

    @Inject
    ServiceModelModifyPresenter presenter;

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
        super.initialize();
    }

    @Override
    protected UpdateServiceModelRequest getFormModel() {
        UpdateServiceModelRequest model = new UpdateServiceModelRequest();
        model.setPriceSuggestion(new Price());
        return model;
    }

    @Override
    protected void onSubmit(UpdateServiceModelRequest object) {
        presenter.modifyServiceModel(object, serviceModel.getId());
    }

    @Override
    protected FormConfig<UpdateServiceModelRequest> createFormConfig() {
        return new ServiceModelModifyFormConfig(inflater, formLayout, serviceModel);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_service_model_create;
    }
}
