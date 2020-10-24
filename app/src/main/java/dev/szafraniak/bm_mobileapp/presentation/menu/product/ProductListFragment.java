package dev.szafraniak.bm_mobileapp.presentation.menu.product;

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
import dev.szafraniak.bm_mobileapp.business.models.entity.product.Product;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.Warehouse;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.product.create.ProductCreateFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.product.modify.ProductModifyFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.scanner.Scanner;
import dev.szafraniak.bm_mobileapp.presentation.shared.search.SearchListFragmentWithBtn;

@EFragment(R.layout.fragment_search_product_list)
public class ProductListFragment extends SearchListFragmentWithBtn<Product, ProductListAdapter>
    implements ProductListView {

    public final static String KEY_WAREHOUSE = "WAREHOUSE_KEY";

    @Inject
    ProductListPresenter presenter;

    @Inject
    Gson gson;

    private Scanner scanner;

    private Warehouse warehouse;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        fetchArgumentsData();
        presenter.setView(this);
        setupScanner();
    }

    private void fetchArgumentsData() {
        Bundle args = getArguments();
        if (args == null || !args.containsKey(KEY_WAREHOUSE)) {
            Navigator.back(this);
            return;
        }
        String companyJSON = args.getString(KEY_WAREHOUSE);
        warehouse = gson.fromJson(companyJSON, Warehouse.class);
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
        return R.string.header_product_list;
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_product_list;
    }

    @Override
    protected void onButtonClick(View view) {
        Bundle args = new Bundle();
        args.putString(ProductCreateFragment.KEY_WAREHOUSE, gson.toJson(warehouse));
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_PRODUCT_CREATE, args);
    }

    @Override
    protected void loadData() {
        presenter.loadData(warehouse.getId());
    }

    @Override
    protected ProductListAdapter createAdapter() {
        return new ProductListAdapter(LayoutInflater.from(getContext()), new ArrayList<>());
    }

    @Override
    public void onItemClick(Product item) {
        Bundle args = new Bundle();
        args.putString(ProductModifyFragment.KEY_PRODUCT, gson.toJson(item));
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_PRODUCT_MODIFY, args);
    }

}
