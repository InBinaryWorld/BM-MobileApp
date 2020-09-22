package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.create;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.CreateWarehouseRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.BaseFormFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.config.FormConfig;

@EFragment(R.layout.fragment_base_form)
public class WarehouseCreateFragment extends BaseFormFragment<CreateWarehouseRequest>
        implements WarehouseCreateView {

    @Inject
    WarehouseCreatePresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
        super.initialize();
    }

    @Override
    protected CreateWarehouseRequest getFormModel() {
        return new CreateWarehouseRequest();
    }

    @Override
    protected void onSubmit(CreateWarehouseRequest object) {
        presenter.createWarehouse(object);
    }

    @Override
    protected FormConfig<CreateWarehouseRequest> createFormConfig() {
        return new WarehouseCreateFormConfig(inflater, formLayout);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_warehouse_create;
    }
}
