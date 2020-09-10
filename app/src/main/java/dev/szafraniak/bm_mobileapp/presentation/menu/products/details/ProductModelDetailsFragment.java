package dev.szafraniak.bm_mobileapp.presentation.menu.products.details;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.products.modify.ProductModelModifyFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.BaseDetailsFragmentWithBtn;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.config.DetailsConfig;

@EFragment(R.layout.fragment_base_details)
public class ProductModelDetailsFragment extends BaseDetailsFragmentWithBtn<ProductModel>
        implements ProductModelDetailsView {

    public final static String KEY_PRODUCT_MODEL = "PRODUCT_MODEL_KEY";

    @Inject
    ProductModelDetailsPresenter presenter;

    ProductModel productModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() == null || !getArguments().containsKey(KEY_PRODUCT_MODEL)) {
            Navigator.back(this);
        }
        String companyJSON = getArguments().getString(KEY_PRODUCT_MODEL);
        productModel = new Gson().fromJson(companyJSON, ProductModel.class);
    }

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
        firstLoadData();
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_product_model_details;
    }

    @Override
    protected int getFblBtnTextResourceId() {
        return R.string.product_model_details_fl_btn_text;
    }

    @Override
    protected void onFblClick(View view) {
        Bundle args = new Bundle();
        args.putString(ProductModelModifyFragment.KEY_PRODUCT_MODEL, new Gson().toJson(productModel));
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_PRODUCT_MODEL_MODIFY, args);

    }

    @Override
    protected void loadData() {
        presenter.loadData(productModel);
    }

    @Override
    protected DetailsConfig<ProductModel> createDetailsConfig() {
        return new ProductModelDetailsConfig(inflater, layout);
    }
}
