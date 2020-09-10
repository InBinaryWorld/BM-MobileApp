package dev.szafraniak.bm_mobileapp.presentation.menu.resources;

import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.BaseFragment;

import static dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory.FRAGMENT_PRODUCT_MODEL_LIST;

@EFragment(R.layout.fragment_resources)
public class ResourcesFragment extends BaseFragment implements ResourcesView {

    @ViewById(R.id.tv_header_text)
    TextView headerTextView;

    @Inject
    ResourcesPresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        headerTextView.setText(R.string.header_resources);
    }

    @Click(R.id.btn_products)
    public void productsClick() {
        Navigator.navigateTo(this, FRAGMENT_PRODUCT_MODEL_LIST);
    }

    @Click(R.id.btn_services)
    public void servicesClick() {

    }

    @Click(R.id.btn_warehouses)
    public void warehousesClick() {

    }
}
