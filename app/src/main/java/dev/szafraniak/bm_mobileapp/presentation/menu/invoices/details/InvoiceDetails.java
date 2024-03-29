package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.details;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.Invoice;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.details.state.InvoiceStatusForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.base.BaseDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.textview.date.LocalDateTextViewDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.textview.date.OffsetDateTextViewDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.textview.number.PriceTextViewDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.textview.text.TextTextViewDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.FormInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.EditTextViewHolder;

public class InvoiceDetails extends BaseDetails<Invoice, BaseViewHolder, InvoiceDetailsConfig> {

    @LayoutRes
    private final int layoutId = R.layout.form_base_group_with_padding;

    TextTextViewDetails invoiceNumber;
    TextTextViewDetails buyerName;
    PriceTextViewDetails grossValue;
    LocalDateTextViewDetails issueDate;
    LocalDateTextViewDetails sellDate;
    LocalDateTextViewDetails dueDate;
    OffsetDateTextViewDetails creationDate;
    OffsetDateTextViewDetails dateOfPayment;
    InvoiceStatusForm statusForm;

    private FormInterface.Callback onPaidOffAction;

    public InvoiceDetails(LayoutInflater inflater, ViewGroup viewGroup, InvoiceDetailsConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void showValueOnView(Invoice value) {
        if (value == null) {
            buyerName.setValue(null);
            issueDate.setValue(null);
            sellDate.setValue(null);
            dueDate.setValue(null);
            grossValue.setValue(null);
            creationDate.setValue(null);
            dateOfPayment.setValue(null);
            invoiceNumber.setValue(null);
            statusForm.setValue(null);
            return;
        }
        buyerName.setValue(value.getBuyerName());
        issueDate.setValue(value.getIssueDate());
        sellDate.setValue(value.getSellDate());
        dueDate.setValue(value.getDueDate());
        grossValue.setValue(value.getTotalAmount().getGross());
        creationDate.setValue(value.getCreationDate());
        dateOfPayment.setValue(value.getDateOfPayment());
        invoiceNumber.setValue(value.getInvoiceName());
        statusForm.setValue(value.getIsPaid());
    }

    @Override
    protected EditTextViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, InvoiceDetailsConfig config) {
        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);

        invoiceNumber = new TextTextViewDetails(inflater, groupList, config.getInvoiceNumberConfig());
        buyerName = new TextTextViewDetails(inflater, groupList, config.getBuyerNameConfig());
        issueDate = new LocalDateTextViewDetails(inflater, groupList, config.getIssueDateConfig());
        sellDate = new LocalDateTextViewDetails(inflater, groupList, config.getSellDateConfig());
        dueDate = new LocalDateTextViewDetails(inflater, groupList, config.getDueDateConfig());
        creationDate = new OffsetDateTextViewDetails(inflater, groupList, config.getCreationDateConfig());
        dateOfPayment = new OffsetDateTextViewDetails(inflater, groupList, config.getDateOfPaymentConfig());
        grossValue = new PriceTextViewDetails(inflater, groupList, config.getGrossConfig());
        statusForm = new InvoiceStatusForm(inflater, groupList, config.getStatusConfig());

        groupList.addView(invoiceNumber.getView());
        groupList.addView(buyerName.getView());
        groupList.addView(statusForm.getView());
        groupList.addView(dateOfPayment.getView());
        groupList.addView(creationDate.getView());
        groupList.addView(issueDate.getView());
        groupList.addView(sellDate.getView());
        groupList.addView(dueDate.getView());
        groupList.addView(grossValue.getView());

        EditTextViewHolder holder = new EditTextViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, InvoiceDetailsConfig config) {
        // Dodatkowa konfiguracja
        statusForm.setOnModifyInvoiceRequest(() -> {
            if (onPaidOffAction != null) {
                onPaidOffAction.call();
            }
        });
    }

    public void setOnInvoiceChange(FormInterface.Callback onPaidOffAction) {
        this.onPaidOffAction = onPaidOffAction;
    }

}

