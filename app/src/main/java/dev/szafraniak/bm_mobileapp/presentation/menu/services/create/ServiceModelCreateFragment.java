package dev.szafraniak.bm_mobileapp.presentation.menu.services.create;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.CreateServiceModelRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.config.FormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormFragment;

@EFragment(R.layout.fragment_base_form)
public class ServiceModelCreateFragment extends BaseFormFragment<CreateServiceModelRequest>
        implements ServiceModelCreateView {

    @Inject
    ServiceModelCreatePresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
        super.initialize();
    }

    @Override
    protected CreateServiceModelRequest getFormModel() {
        return new CreateServiceModelRequest();
    }

    @Override
    protected void onSubmit(CreateServiceModelRequest object) {
        presenter.createServiceModel(object);
    }

    @Override
    protected FormConfig<CreateServiceModelRequest> createFormConfig() {
        return new ServiceModelCreateFormConfig(inflater, formLayout);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_create_service_model;
    }
}
