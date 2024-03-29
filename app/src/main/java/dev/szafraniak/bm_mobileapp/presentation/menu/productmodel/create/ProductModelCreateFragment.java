package dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.create;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.CreateProductModelRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.FormInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormFragment;

@EFragment(R.layout.fragment_base_form)
public class ProductModelCreateFragment extends BaseFormFragment<CreateProductModelRequest, CreateProductModelFormConfig> implements ProductModelCreateView {

    @Inject
    ProductModelCreatePresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_save;
    }

    @Override
    protected FormInterface<CreateProductModelRequest> createForm(LayoutInflater inflater, ViewGroup linearLayout, CreateProductModelFormConfig config) {
        return new CreateProductModelForm(inflater, linearLayout, config);
    }

    @Override
    protected void loadData() {
        CreateProductModelFormConfig config = presenter.createConfig();
        startForm(config);
    }

    @Override
    protected void onSubmit(CreateProductModelRequest object) {
        presenter.createProductModel(object);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_product_model_create;
    }
}
