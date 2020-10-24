package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.create;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.CreateWarehouseRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormFragment;

@EFragment(R.layout.fragment_base_form)
public class WarehouseCreateFragment extends BaseFormFragment<CreateWarehouseRequest, CreateWarehouseFormConfig>
    implements WarehouseCreateView {

    @Inject
    WarehouseCreatePresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_create_form;
    }

    @Override
    protected FormInterface<CreateWarehouseRequest> createForm(LayoutInflater inflater, ViewGroup linearLayout, CreateWarehouseFormConfig config) {
        return new CreateWarehouseForm(inflater, linearLayout, config);
    }

    @Override
    protected void onSubmit(CreateWarehouseRequest object) {
        presenter.createWarehouse(object);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_warehouse_create;
    }

    @Override
    protected void loadData() {
        CreateWarehouseFormConfig config = presenter.createConfig();
        startForm(config);
    }
}
