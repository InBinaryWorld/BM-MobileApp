package dev.szafraniak.bm_mobileapp.presentation.menu.services;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.services.details.ServiceModelDetailsFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.search.SearchListFragmentWithBtn;

@EFragment(R.layout.fragment_search_list_with_btn)
public class ServiceModelListFragment extends SearchListFragmentWithBtn<ServiceModel, ServiceModelListAdapter>
        implements ServiceModelListView {

    @Inject
    ServiceModelListPresenter presenter;

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
        return R.string.header_service_model_list;
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_text_service_model_list;
    }

    @Override
    protected void onButtonClick(View view) {
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_SERVICE_MODEL_CREATE);
    }

    @Override
    protected void loadData() {
        presenter.loadData();
    }

    @Override
    protected ServiceModelListAdapter createAdapter() {

        return new ServiceModelListAdapter(LayoutInflater.from(getContext()), new ArrayList<>());
    }

    @Override
    public void onItemClick(ServiceModel item) {
        Bundle args = new Bundle();
        args.putString(ServiceModelDetailsFragment.KEY_SERVICE_MODEL, gson.toJson(item));
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_SERVICE_MODEL_DETAILS, args);
    }

}
