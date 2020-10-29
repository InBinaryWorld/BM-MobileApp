package dev.szafraniak.bm_mobileapp.presentation.menu.services.modify;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.UpdateServiceModelRequest;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.FormInterface;

@EFragment(R.layout.fragment_base_form)
public class ServiceModelModifyFragment extends BaseFormFragment<UpdateServiceModelRequest, ModifyServiceModelFormConfig> implements ServiceModelModifyView {

    public final static String KEY_SERVICE_MODEL = "SERVICE_MODEL_KEY";

    @Inject
    ServiceModelModifyPresenter presenter;

    @Inject
    Gson gson;

    ServiceModel serviceModel;

    private void fetchArgumentsData() {
        Bundle args = getArguments();
        if (args == null || !args.containsKey(KEY_SERVICE_MODEL)) {
            Navigator.back(this);
            return;
        }
        String companyJSON = args.getString(KEY_SERVICE_MODEL);
        serviceModel = gson.fromJson(companyJSON, ServiceModel.class);
    }


    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        fetchArgumentsData();
        presenter.setView(this);
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_modify_form;
    }


    @Override
    protected FormInterface<UpdateServiceModelRequest> createForm(LayoutInflater inflater, ViewGroup linearLayout, ModifyServiceModelFormConfig config) {
        return new ModifyServiceModelForm(inflater, linearLayout, config);
    }

    @Override
    protected void onSubmit(UpdateServiceModelRequest object) {
        presenter.modifyServiceModel(object, serviceModel.getId());
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_service_model_modify;
    }

    @Override
    protected void loadData() {
        presenter.loadData(serviceModel.getId());
    }

    @Override
    public void setModifyModel(ServiceModel serviceModel) {
        UpdateServiceModelRequest model = new UpdateServiceModelRequest();
        model.setName(serviceModel.getName());
        model.setQuantityUnit(serviceModel.getQuantityUnit());
        model.setPriceSuggestion(serviceModel.getPriceSuggestion());

        ModifyServiceModelFormConfig config = presenter.createConfig();
        startForm(config, model);
    }
}
