package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base.payment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;

import org.jetbrains.annotations.NotNull;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.payment.PaymentMethod;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.business.utils.Parsers;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.PaymentFormModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.clickable.ClickableHolderForm;

import static dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory.FRAGMENT_INVOICES_CREATE_PAYMENT;

public class ClickablePaymentForm extends ClickableHolderForm<PaymentFormModel, ClickablePaymentFormViewHolder, ClickablePaymentFormConfig> {

    @LayoutRes
    private final static int layoutId = R.layout.row_form_clickable_payment;

    public ClickablePaymentForm(LayoutInflater inflater, ViewGroup viewGroup, ClickablePaymentFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void viewOnNullValue() {
        ClickablePaymentFormViewHolder holder = getViewHolder();
        holder.dataView.setVisibility(View.GONE);
        holder.emptyView.setVisibility(View.VISIBLE);
    }

    @Override
    protected void viewOnNotNullValue(@NotNull PaymentFormModel value) {
        ClickablePaymentFormViewHolder holder = getViewHolder();
        holder.dataView.setVisibility(View.VISIBLE);
        holder.emptyView.setVisibility(View.GONE);
        holder.dueDate.setText(Parsers.safeFormatDate(value.getDueDate()));
        holder.paymentMethod.setText(getPaymentDisplayName(value.getPaymentMethod()));
    }

    @Override
    protected void setLabel(String label) {
        ClickablePaymentFormViewHolder holder = getViewHolder();
        holder.label.setText(label);
    }

    @Override
    protected ClickablePaymentFormViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, ClickablePaymentFormConfig config) {
        ClickablePaymentFormViewHolder holder = new ClickablePaymentFormViewHolder();
        holder.view = inflater.inflate(layoutId, viewGroup, false);
        holder.label = holder.view.findViewById(R.id.tv_label);
        holder.empty = holder.view.findViewById(R.id.tv_empty);
        holder.dueDate = holder.view.findViewById(R.id.tv_due_date);
        holder.dueDateLabel = holder.view.findViewById(R.id.tv_due_date_label);
        holder.paymentMethod = holder.view.findViewById(R.id.tv_payment_type);
        holder.paymentMethodLabel = holder.view.findViewById(R.id.tv_payment_type_label);
        holder.dataView = holder.view.findViewById(R.id.cl_data_view);
        holder.emptyView = holder.view.findViewById(R.id.cl_empty_view);
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, ClickablePaymentFormConfig config) {
        ClickablePaymentFormViewHolder holder = getViewHolder();
        holder.dueDateLabel.setText(config.getDueDateLabel());
        holder.paymentMethodLabel.setText(config.getPaymentTypeLabel());
        holder.empty.setText(config.getEmptyText());
        holder.view.setOnClickListener(this::navigateToPayment);
    }

    private void navigateToPayment(View clickedView) {
        executeSafeNavigation(view -> Navigator.navigateTo(view, FRAGMENT_INVOICES_CREATE_PAYMENT));
    }

    private String getPaymentDisplayName(PaymentMethod paymentMethod) {
        return getConfig().getPaymentMethodDisplayNames().get(paymentMethod.getClass());
    }

}
