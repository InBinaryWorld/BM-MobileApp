package dev.szafraniak.bm_mobileapp.presentation.menu.dashboard;

import android.annotation.SuppressLint;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.stats.FinancesStatsModel;
import dev.szafraniak.bm_mobileapp.business.models.stats.InvoicesStatsModel;
import dev.szafraniak.bm_mobileapp.business.models.stats.ResourcesStatsModel;
import dev.szafraniak.bm_mobileapp.business.utils.Parsers;
import dev.szafraniak.bm_mobileapp.presentation.shared.load.BaseSRLLoadFragment;

@EFragment(R.layout.fragment_dashboard)
public class DashboardFragment extends BaseSRLLoadFragment implements DashboardView {

    @Inject
    DashboardPresenter presenter;

    private ViewHolder holder;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
        holder = createViewHolder();
    }


    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_dashboard;
    }

    @Override
    protected void loadData() {
        presenter.loadData();
    }

    @Override
    public void setError(Throwable throwable) {
        showError();
    }

    @Override
    public void setData(DashboardDataModel data) {
        fulFillView(data);
        showData();
    }

    private void fulFillView(DashboardDataModel data) {
        FinancesStatsModel finances = data.getStatsModel().getFinances();
        ResourcesStatsModel resources = data.getStatsModel().getResources();
        InvoicesStatsModel invoices = data.getStatsModel().getInvoices();
        fullFillFinances(finances);
        fullFillResources(resources);
        fullFillInvoices(invoices);
    }

    @SuppressLint("SetTextI18n")
    private void fullFillInvoices(InvoicesStatsModel invoices) {
        String lastInvoice = Parsers.safeFormatPrice(invoices.getLastInvoiceValue());
        holder.paid.setText(Integer.toString(invoices.getPaid()));
        holder.unpaid.setText(Integer.toString(invoices.getUnpaid()));
        holder.paidValue.setText(Parsers.safeFormatPrice(invoices.getPaidValue()));
        holder.unpaidValue.setText(Parsers.safeFormatPrice(invoices.getUnpaidValue()));
        holder.paidValueCurrency.setText(invoices.getCurrency());
        holder.unpaidValueCurrency.setText(invoices.getCurrency());
        if (lastInvoice == null) {
            holder.lastInvoice.setText(R.string.dashboard_no_data);
            holder.lastInvoiceCurrency.setText("");
        } else {
            holder.lastInvoice.setText(lastInvoice);
            holder.lastInvoiceCurrency.setText(invoices.getCurrency());
        }
    }

    @SuppressLint("SetTextI18n")
    private void fullFillResources(ResourcesStatsModel resources) {
        holder.productModels.setText(Integer.toString(resources.getProductModelsNumber()));
        holder.serviceModels.setText(Integer.toString(resources.getServiceModelsNumber()));
        holder.warehouses.setText(Integer.toString(resources.getWarehousesNumber()));
        holder.productsValue.setText(Parsers.safeFormatPrice(resources.getTotalGrossValue()));
        holder.productsValueCurrency.setText(resources.getCurrency());
    }

    private void fullFillFinances(FinancesStatsModel finances) {
        String lastEvent = Parsers.safeFormatPrice(finances.getLastChange());
        holder.income.setText(Parsers.safeFormatPrice(finances.getTotalIncome()));
        holder.incomeCurrency.setText(finances.getCurrency());
        holder.outcome.setText(Parsers.safeFormatPrice(finances.getTotalOutcome()));
        holder.outcomeCurrency.setText(finances.getCurrency());
        holder.currentState.setText(Parsers.safeFormatPrice(finances.getCurrentState()));
        holder.currentStateCurrency.setText(finances.getCurrency());
        if (lastEvent == null) {
            holder.lastEvent.setText(R.string.dashboard_no_data);
            holder.lastEventCurrency.setText("");
        } else {
            holder.lastEvent.setText(lastEvent);
            holder.lastEventCurrency.setText(finances.getCurrency());
        }
    }

    private ViewHolder createViewHolder() {
        ViewHolder holder = new ViewHolder();
        holder.currentState = (TextView) findViewById(R.id.tv_current_state);
        holder.currentStateCurrency = (TextView) findViewById(R.id.tv_current_state_currency);
        holder.outcome = (TextView) findViewById(R.id.tv_outcome);
        holder.outcomeCurrency = (TextView) findViewById(R.id.tv_outcome_currency);
        holder.income = (TextView) findViewById(R.id.tv_income);
        holder.incomeCurrency = (TextView) findViewById(R.id.tv_income_currency);
        holder.lastEvent = (TextView) findViewById(R.id.tv_last_event);
        holder.lastEventCurrency = (TextView) findViewById(R.id.tv_last_event_currency);
        holder.productModels = (TextView) findViewById(R.id.tv_product_models);
        holder.serviceModels = (TextView) findViewById(R.id.tv_service_models);
        holder.warehouses = (TextView) findViewById(R.id.tv_warehouses);
        holder.productsValue = (TextView) findViewById(R.id.tv_products_value);
        holder.productsValueCurrency = (TextView) findViewById(R.id.tv_products_value_currency);
        holder.paid = (TextView) findViewById(R.id.tv_paid);
        holder.unpaid = (TextView) findViewById(R.id.tv_unpaid);
        holder.paidValue = (TextView) findViewById(R.id.tv_paid_value);
        holder.paidValueCurrency = (TextView) findViewById(R.id.tv_paid_value_currency);
        holder.unpaidValue = (TextView) findViewById(R.id.tv_unpaid_value);
        holder.unpaidValueCurrency = (TextView) findViewById(R.id.tv_unpaid_value_currency);
        holder.lastInvoice = (TextView) findViewById(R.id.tv_last_invoice);
        holder.lastInvoiceCurrency = (TextView) findViewById(R.id.tv_last_invoice_currency);
        return holder;
    }

    static class ViewHolder {
        TextView income;
        TextView incomeCurrency;
        TextView outcome;
        TextView outcomeCurrency;
        TextView currentState;
        TextView currentStateCurrency;
        TextView lastEvent;
        TextView lastEventCurrency;
        TextView warehouses;
        TextView productsValue;
        TextView productsValueCurrency;
        TextView productModels;
        TextView serviceModels;
        TextView paid;
        TextView unpaid;
        TextView paidValue;
        TextView paidValueCurrency;
        TextView unpaidValue;
        TextView unpaidValueCurrency;
        TextView lastInvoice;
        TextView lastInvoiceCurrency;
    }

}
