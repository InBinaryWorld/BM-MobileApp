package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.baseData.form.payment;

import android.view.View;
import android.widget.TextView;

import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.BaseViewHolder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClickablePaymentFormViewHolder extends BaseViewHolder {
    public View emptyView;
    public View dataView;
    public TextView empty;
    public TextView label;
    public TextView paymentMethodLabel;
    public TextView paymentMethod;
    public TextView dueDateLabel;
    public TextView dueDate;
}
