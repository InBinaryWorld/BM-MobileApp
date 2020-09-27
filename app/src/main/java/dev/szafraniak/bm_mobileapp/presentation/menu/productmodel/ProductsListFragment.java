package dev.szafraniak.bm_mobileapp.presentation.menu.productmodel;

import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.details.ProductModelDetailsFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseAdapter;
import dev.szafraniak.bm_mobileapp.presentation.shared.search.SearchListFragmentWithBtn;

@EFragment(R.layout.fragment_search_list_with_btn)
public class ProductsListFragment extends SearchListFragmentWithBtn<ProductModel>
        implements ProductsListView {

    @Inject
    ProductsListPresenter presenter;

    @Inject
    Gson gson;


    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_product_model_list;
    }

    @Override
    protected int getFlButtonTextId() {
        return R.string.product_model_list_fl_btn_create;
    }

    @Override
    protected void onFlButtonClick(View view) {
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_PRODUCT_MODEL_CREATE);
    }

    @Override
    protected void loadData() {
        presenter.loadData();
    }

    @Override
    protected BaseAdapter<ProductModel> createAdapter() {
        return new ProductModelListAdapter(getContext());
    }

    @Override
    public void onItemClick(ProductModel item) {
        Bundle args = new Bundle();
        args.putString(ProductModelDetailsFragment.KEY_PRODUCT_MODEL, gson.toJson(item));
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_PRODUCT_MODEL_DETAILS, args);
    }

}
