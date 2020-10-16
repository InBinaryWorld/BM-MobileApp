package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.details.state;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.UpdateInvoiceRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.base.BaseDetails;

public class InvoiceStatusForm extends BaseDetails<Boolean, InvoiceStatusViewHolder, InvoiceStatusFormConfig> {

    @LayoutRes
    private final static int layoutId = R.layout.row_invoice_paid_status;

    private OnModifyInvoiceRequest onModifyInvoiceRequest;

    public InvoiceStatusForm(LayoutInflater inflater, ViewGroup viewGroup, InvoiceStatusFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void showValueOnView(Boolean isPaid) {
        InvoiceStatusViewHolder holder = getViewHolder();
        holder.stateValue.setText(getConfig().getDisplayValues().get(isPaid));
        holder.button.setVisibility(isPaid ? View.GONE : View.VISIBLE);
    }

    @Override
    protected InvoiceStatusViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, InvoiceStatusFormConfig config) {
        InvoiceStatusViewHolder holder = new InvoiceStatusViewHolder();
        holder.view = inflater.inflate(layoutId, viewGroup, false);
        holder.label = holder.view.findViewById(R.id.tv_label);
        holder.button = holder.view.findViewById(R.id.btn_mark_as_paid);
        holder.stateValue = holder.view.findViewById(R.id.tv_state_value);
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, InvoiceStatusFormConfig config) {
        InvoiceStatusViewHolder holder = getViewHolder();
        holder.label.setText(config.getLabel());
        holder.button.setEnabled(true);
        holder.button.setOnClickListener(view -> {
            blockButton();
            UpdateInvoiceRequest request = new UpdateInvoiceRequest();
            request.setIsPaid(true);
            onModifyInvoiceRequest.onModifyRequest(request);
        });
    }

    public interface OnModifyInvoiceRequest {
        void onModifyRequest(UpdateInvoiceRequest request);
    }

    public void setOnModifyInvoiceRequest(OnModifyInvoiceRequest onModify) {
        this.onModifyInvoiceRequest = onModify;
    }

    public void blockButton() {
        InvoiceStatusViewHolder holder = getViewHolder();
        holder.button.setEnabled(false);
    }

    public void unblockProgress() {
        InvoiceStatusViewHolder holder = getViewHolder();
        holder.button.setEnabled(true);
    }

}
