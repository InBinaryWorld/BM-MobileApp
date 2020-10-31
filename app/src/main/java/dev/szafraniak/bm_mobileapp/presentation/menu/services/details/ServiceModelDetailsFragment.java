package dev.szafraniak.bm_mobileapp.presentation.menu.services.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.services.modify.ServiceModelModifyFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.fragment.BaseDetailsWithBtnAndTrashFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.base.DetailsInterface;

@EFragment(R.layout.fragment_base_details_with_trash)
public class ServiceModelDetailsFragment extends BaseDetailsWithBtnAndTrashFragment<ServiceModel, ServiceModelDetailsConfig>
    implements ServiceModelDetailsView {

    public final static String KEY_SERVICE_MODEL = "SERVICE_MODEL_KEY";

    @Inject
    ServiceModelDetailsPresenter presenter;

    @Inject
    Gson gson;

    ServiceModel serviceModel;


    private void fetchArgumentsData() {
        Bundle args = getArguments();
        if (args == null || !args.containsKey(KEY_SERVICE_MODEL)) {
            Navigator.back(this);
            return;
        }
        String companyJSON = getArguments().getString(KEY_SERVICE_MODEL);
        serviceModel = gson.fromJson(companyJSON, ServiceModel.class);
    }

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        fetchArgumentsData();
        presenter.setView(this);
    }

    @Override
    protected void loadData() {
        presenter.loadData(serviceModel.getId());
    }

    public void setData(ServiceModel model) {
        ServiceModelDetailsConfig config = presenter.createConfig();
        startForm(config, model);
    }

    @Override
    protected DetailsInterface<ServiceModel> createForm(LayoutInflater inflater, ViewGroup viewGroup, ServiceModelDetailsConfig config) {
        return new ServiceModelDetails(inflater, detailsLayout, config);
    }

    @Override
    protected void onFblClick() {
        Bundle args = new Bundle();
        args.putString(ServiceModelModifyFragment.KEY_SERVICE_MODEL, gson.toJson(serviceModel));
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_SERVICE_MODEL_MODIFY, args);
    }

    @Override
    protected void onTrash() {
        presenter.deleteModel(serviceModel.getId());
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_service_model_details;
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_service_model_details;
    }


}
