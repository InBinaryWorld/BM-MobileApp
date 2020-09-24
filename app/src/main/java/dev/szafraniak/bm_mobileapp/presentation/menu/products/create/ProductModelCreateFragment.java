package dev.szafraniak.bm_mobileapp.presentation.menu.products.create;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.CreateProductModelRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.config.FormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormFragment;

@EFragment(R.layout.fragment_base_form)
public class ProductModelCreateFragment extends BaseFormFragment<CreateProductModelRequest> implements ProductModelCreateView {

    @Inject
    ProductModelCreatePresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
        super.initialize();
    }

    @Override
    protected CreateProductModelRequest getFormModel() {
        return new CreateProductModelRequest();
    }

    @Override
    protected void onSubmit(CreateProductModelRequest object) {
        presenter.createProductModel(object);
    }

    @Override
    protected FormConfig<CreateProductModelRequest> createFormConfig() {
        return new ProductModelCreateFormConfig(inflater, formLayout);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_product_model_create;
    }
}
