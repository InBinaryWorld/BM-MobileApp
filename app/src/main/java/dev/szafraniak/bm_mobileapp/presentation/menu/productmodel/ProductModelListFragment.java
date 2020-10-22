package dev.szafraniak.bm_mobileapp.presentation.menu.productmodel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.details.ProductModelDetailsFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.scanner.Scanner;
import dev.szafraniak.bm_mobileapp.presentation.shared.search.SearchListFragmentWithBtn;

@EFragment(R.layout.fragment_search_product_list)
public class ProductModelListFragment extends SearchListFragmentWithBtn<ProductModel, ProductModelListAdapter>
    implements ProductModelListView {

    @Inject
    ProductModelListPresenter presenter;

    @Inject
    Gson gson;

    private Scanner scanner;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
        setupScanner();
    }

    private void setupScanner() {
        scanner = new Scanner(getActivity());
        scanner.addBarcodeListener(barcode -> {
            searchView.setQuery(barcode.displayValue, true);
        });
    }

    @Click(R.id.iv_scanner)
    public void onScannerIconClick(View view) {
        scanner.openScanner();
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_product_model_list;
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_text_product_model_list;
    }

    @Override
    protected void onButtonClick(View view) {
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_PRODUCT_MODEL_CREATE);
    }

    @Override
    protected void loadData() {
        presenter.loadData();
    }

    @Override
    protected ProductModelListAdapter createAdapter() {
        return new ProductModelListAdapter(LayoutInflater.from(getContext()), new ArrayList<>());
    }

    @Override
    public void onItemClick(ProductModel item) {
        Bundle args = new Bundle();
        args.putString(ProductModelDetailsFragment.KEY_PRODUCT_MODEL, gson.toJson(item));
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_PRODUCT_MODEL_DETAILS, args);
    }

}
