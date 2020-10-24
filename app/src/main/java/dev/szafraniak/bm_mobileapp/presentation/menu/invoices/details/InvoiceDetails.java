package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.details;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.Invoice;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.details.state.InvoiceStatusForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.EditTextViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.base.BaseDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview.date.LocalDateTextViewDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview.date.OffsetDateTextViewDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview.number.DecimalTextViewDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview.text.TextTextViewDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormInterface;

public class InvoiceDetails extends BaseDetails<Invoice, BaseViewHolder, InvoiceDetailsConfig> {

    @LayoutRes
    private final int layoutId = R.layout.form_base_group_with_padding;

    TextTextViewDetails invoiceNumber;
    TextTextViewDetails buyerName;
    DecimalTextViewDetails grossValue;
    LocalDateTextViewDetails dueDate;
    OffsetDateTextViewDetails creationDate;
    InvoiceStatusForm statusForm;

    private FormInterface.Callback onPaidOffAction;

    public InvoiceDetails(LayoutInflater inflater, ViewGroup viewGroup, InvoiceDetailsConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void showValueOnView(Invoice value) {
        if (value == null) {
            buyerName.setValue(null);
            dueDate.setValue(null);
            grossValue.setValue(null);
            creationDate.setValue(null);
            invoiceNumber.setValue(null);
            statusForm.setValue(null);
            return;
        }
        buyerName.setValue(value.getBuyerName());
        dueDate.setValue(value.getDueDate());
        grossValue.setValue(value.getTotalAmount().getGross());
        creationDate.setValue(value.getCreationDate());
        invoiceNumber.setValue(value.getInvoiceName());
        statusForm.setValue(value.getIsPaid());
    }

    @Override
    protected EditTextViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, InvoiceDetailsConfig config) {
        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);

        invoiceNumber = new TextTextViewDetails(inflater, groupList, config.getInvoiceNumberConfig());
        buyerName = new TextTextViewDetails(inflater, groupList, config.getBuyerNameConfig());
        dueDate = new LocalDateTextViewDetails(inflater, groupList, config.getDueDateConfig());
        creationDate = new OffsetDateTextViewDetails(inflater, groupList, config.getCreationDateConfig());
        grossValue = new DecimalTextViewDetails(inflater, groupList, config.getGrossConfig());
        statusForm = new InvoiceStatusForm(inflater, groupList, config.getStatusConfig());

        groupList.addView(invoiceNumber.getView());
        groupList.addView(buyerName.getView());
        groupList.addView(statusForm.getView());
        groupList.addView(creationDate.getView());
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

