package dev.szafraniak.bm_mobileapp.presentation.menu.invoices;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.memory.forms.FormsManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.Invoice;
import dev.szafraniak.bm_mobileapp.business.models.stats.FinancesStatsModel;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.business.utils.Formatter;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.details.InvoiceDetailsFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListFragmentWithBtn;

@EFragment(R.layout.fragment_invoices)
public class InvoicesFragment extends BaseListFragmentWithBtn<Invoice, InvoiceListAdapter> implements InvoicesView {

    @ViewById(R.id.tv_last_event)
    TextView lastEvent;

    @ViewById(R.id.tv_last_event_currency)
    TextView lastEventCurrency;

    @ViewById(R.id.tv_finances_state)
    TextView financesState;

    @ViewById(R.id.tv_finances_state_currency)
    TextView financesStateCurrency;

    @Inject
    InvoicesPresenter presenter;

    @Inject
    FormsManager formsManager;

    @Inject
    Gson gson;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
        FragmentManager manager = getFragmentManager();
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_invoice_list;
    }

    @Override
    protected void onButtonClick(View view) {
        formsManager.resetCreateInvoiceForm();
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_INVOICES_CREATE_BASE_DATA);
    }

    @Override
    protected void loadData() {
        presenter.loadData();
    }

    @Override
    public void onItemClick(Invoice item) {
        Bundle bundle = new Bundle();
        bundle.putString(InvoiceDetailsFragment.KEY_INVOICE, gson.toJson(item));
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_INVOICES_DETAILS, bundle);
    }

    @Click(R.id.card_finances)
    public void showFinances() {
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_FINANCES);
    }

    @Override
    protected InvoiceListAdapter createAdapter() {
        return new InvoiceListAdapter(getContext(), new ArrayList<>());
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_invoice_list;
    }

    @Override
    public void setData(InvoicesDataModel invoicesDataModel) {
        fullFillFinancesCard(invoicesDataModel.getFinancesStats());
        setData(invoicesDataModel.getInvoiceCollection());
    }

    private void fullFillFinancesCard(FinancesStatsModel financesStats) {
        financesState.setText(Formatter.safeFormatPrice(financesStats.getCurrentState()));
        financesStateCurrency.setText(financesStats.getCurrency());
        BigDecimal lastCharge = financesStats.getLastChange();
        if (lastCharge == null) {
            lastEvent.setText(R.string.invoices_finances_card_no_events);
            lastEventCurrency.setText("");
        } else {
            lastEvent.setText(Formatter.safeFormatPrice(lastCharge));
            lastEventCurrency.setText(financesStats.getCurrency());
        }
    }
}
