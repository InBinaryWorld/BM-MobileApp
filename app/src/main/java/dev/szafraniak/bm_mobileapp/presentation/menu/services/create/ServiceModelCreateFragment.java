package dev.szafraniak.bm_mobileapp.presentation.menu.services.create;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.CreateServiceModelRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.FormInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormFragment;

@EFragment(R.layout.fragment_base_form)
public class ServiceModelCreateFragment extends BaseFormFragment<CreateServiceModelRequest, CreateServiceFormConfig>
    implements ServiceModelCreateView {

    @Inject
    ServiceModelCreatePresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    protected int getButtonTextId() {
        return R.string.header_service_model_create;
    }

    @Override
    protected FormInterface<CreateServiceModelRequest> createForm(LayoutInflater inflater, ViewGroup linearLayout, CreateServiceFormConfig config) {
        return new CreateServiceForm(inflater, linearLayout, config);
    }

    @Override
    protected void onSubmit(CreateServiceModelRequest object) {
        presenter.createServiceModel(object);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_service_model_create;
    }

    @Override
    protected void loadData() {
        CreateServiceFormConfig config = presenter.createConfig();
        startForm(config);
    }
}
