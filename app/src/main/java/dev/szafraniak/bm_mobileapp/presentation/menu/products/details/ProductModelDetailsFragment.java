package dev.szafraniak.bm_mobileapp.presentation.menu.products.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

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
import dev.szafraniak.bm_mobileapp.presentation.shared.details.fragment.BaseDetailsFragmentWithBtn;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.DetailsInterface;

@EFragment(R.layout.fragment_base_details)
public class ProductModelDetailsFragment extends BaseDetailsFragmentWithBtn<ProductModel>
        implements ProductModelDetailsView {

    public final static String KEY_PRODUCT_MODEL = "KEY_PRODUCT_MODEL";

    @Inject
    ProductModelDetailsPresenter presenter;

    @Inject
    Gson gson;

    ProductModel productModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fetchArgumentsData();
    }

    private void fetchArgumentsData() {
        Bundle args = getArguments();
        if (args == null || !args.containsKey(KEY_PRODUCT_MODEL)) {
            Navigator.back(this);
            return;
        }
        String companyJSON = getArguments().getString(KEY_PRODUCT_MODEL);
        productModel = gson.fromJson(companyJSON, ProductModel.class);
    }

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    protected DetailsInterface<ProductModel> createForm(LayoutInflater inflater, LinearLayout linearLayout) {
        ProductModelDetailsConfig config = presenter.createConfig();
        return new ProductModelDetails(inflater, detailsLayout, config);
    }

    @Override
    protected void onFblClick(View view) {
        Bundle args = new Bundle();
        args.putString(ProductModelModifyFragment.KEY_PRODUCT_MODEL, gson.toJson(productModel));
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_PRODUCT_MODEL_MODIFY, args);
    }

    @Override
    protected void loadData() {
        presenter.loadData(productModel.getId());
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_product_model_details;
    }

    @Override
    protected int getFlBtnTextResourceId() {
        return R.string.product_model_details_fl_btn_text;
    }
}
