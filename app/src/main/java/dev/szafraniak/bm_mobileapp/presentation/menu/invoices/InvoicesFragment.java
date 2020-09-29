package dev.szafraniak.bm_mobileapp.presentation.menu.invoices;

import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.Invoice;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseAdapter;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListFragmentWithBtn;

@EFragment(R.layout.fragment_invoices)
public class InvoicesFragment extends BaseListFragmentWithBtn<Invoice> implements InvoicesView {

    @Inject
    InvoicesPresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_text_invoice_list;
    }

    @Override
    protected void onButtonClick(View view) {
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_INVOICES_CREATE_BASE_DATA);
    }

    @Override
    protected void loadData() {
        presenter.loadData();
    }

    @Override
    public void onItemClick(Invoice item) {
//        Navigator.navigateTo(this, FragmentFactory.);
    }

    @Click(R.id.btn_show_finances)
    public void showFinances() {
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_FINANCES);
    }

    @Override
    protected BaseAdapter<Invoice> createAdapter() {
        return new InvoiceListAdapter(getContext());
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_invoice_list;
    }
}
