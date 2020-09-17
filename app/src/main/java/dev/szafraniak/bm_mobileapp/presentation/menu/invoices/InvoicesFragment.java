package dev.szafraniak.bm_mobileapp.presentation.menu.invoices;

import android.view.View;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.Invoice;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseAdapter;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListFragmentWithBtn;

@EFragment(R.layout.fragment_invoices)
public class InvoicesFragment extends BaseListFragmentWithBtn<Invoice> implements InvoicesView {

    @ViewById(R.id.tv_header_text)
    TextView headerTextView;

    @Inject
    InvoicesPresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
        firstLoadData();
    }

    @Override
    protected int getFlButtonTextId() {
        return R.string.invoice_list_fl_btn_text;
    }

    @Override
    protected void onFlButtonClick(View view) {
//        Navigator.navigateTo(this, FragmentFactory.);
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

    }

    @Override
    protected BaseAdapter<Invoice> createAdapter() {
        return new InvoiceListAdapter(getContext());
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_invoices_list_text;
    }
}
