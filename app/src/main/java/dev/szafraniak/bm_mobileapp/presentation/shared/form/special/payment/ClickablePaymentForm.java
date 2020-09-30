package dev.szafraniak.bm_mobileapp.presentation.shared.form.special.payment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;

import java.util.Map;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.payment.PaymentMethod;
import dev.szafraniak.bm_mobileapp.business.utils.Parsers;
import dev.szafraniak.bm_mobileapp.business.utils.Validator;
import dev.szafraniak.bm_mobileapp.presentation.shared.Callback;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseForm;

public class ClickablePaymentForm extends BaseForm<PaymentModel, ClickablePaymentFormViewHolder, ClickablePaymentFormConfig> {

    private static final String REQUIRED_HINT_SUFFIX = "*";
    private PaymentModel paymentModelHolder;

    @LayoutRes
    private final static int layoutId = R.layout.row_form_clickable_payment;
    private Callback onClickCallback;

    public ClickablePaymentForm(LayoutInflater inflater, ViewGroup viewGroup, ClickablePaymentFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void showValueOnView(PaymentModel value) {
        paymentModelHolder = value;
        boolean areDataPresent = isEmpty(value);
        ClickablePaymentFormViewHolder holder = getViewHolder();
        holder.dataView.setVisibility(areDataPresent ? View.VISIBLE : View.GONE);
        holder.emptyView.setVisibility(areDataPresent ? View.GONE : View.VISIBLE);
        if (areDataPresent) {
            holder.dueDate.setText(Parsers.safeFormat(value.getDueDate()));
            holder.paymentMethod.setText(getPaymentDisplayName(value.getClass()));
        }
    }

    private String getPaymentDisplayName(Class<? extends PaymentModel> aClass) {
        Map<Class<? extends PaymentMethod>, String> displayNames = getConfig().getPaymentMethodDisplayNames();
        return displayNames.get(aClass);
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
    protected void setupView(ClickablePaymentFormConfig config) {
        String suffix = config.isRequired() ? REQUIRED_HINT_SUFFIX : "";
        String label = String.format("%s%s", config.getLabel(), suffix);
        ClickablePaymentFormViewHolder holder = getViewHolder();
        holder.label.setText(label);
        holder.dueDateLabel.setText(config.getDueDateLabel());
        holder.paymentMethodLabel.setText(config.getPaymentTypeLabel());
        holder.empty.setText(config.getEmptyText());
        holder.view.setOnClickListener(this::onClick);
    }

    public void setOnClickAction(Callback onClickCallback) {
        this.onClickCallback = onClickCallback;
    }

    private void onClick(View view) {
        if (onClickCallback != null) {
            onClickCallback.call();
        }
    }

    @Override
    public PaymentModel getValue() {
        return paymentModelHolder;
    }

    private boolean isEmpty(PaymentModel value) {
        return value != null && value.getPaymentMethod() != null && value.getDueDate() != null;
    }

    @Override
    public boolean isValid() {
        PaymentModel value = getValue();
        if (isEmpty(value)) {
            return !getConfig().isRequired();
        }
        return Validator.validatePaymentMethod(value.getPaymentMethod())
                && Validator.validateDueDate(value.getDueDate());
    }
}
