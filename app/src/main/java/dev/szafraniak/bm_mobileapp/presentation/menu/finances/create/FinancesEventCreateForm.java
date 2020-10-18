package dev.szafraniak.bm_mobileapp.presentation.menu.finances.create;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.finantialRow.CreateFinancialRowRequest;
import dev.szafraniak.bm_mobileapp.business.utils.Parsers;
import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.dateTimePicker.DateTimePickerForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.number.DecimalEditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRow;

public class FinancesEventCreateForm extends BaseForm<CreateFinancialRowRequest, BaseViewHolder, FinancesEventCreateFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group_with_padding;

    TextEditTextFormRow titleForm;
    DateTimePickerForm eventDateForm;
    DecimalEditTextFormRow amountForm;
    TextEditTextFormRow descriptionForm;

    public FinancesEventCreateForm(LayoutInflater inflater, ViewGroup viewGroup, FinancesEventCreateFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void updateView(boolean isValid) {
    }

    @Override
    protected void showValueOnView(CreateFinancialRowRequest value) {
        if (value == null) {
            titleForm.setValue(null);
            amountForm.setValue(null);
            eventDateForm.setValue(null);
            descriptionForm.setValue(null);
            return;
        }
        titleForm.setValue(value.getTitle());
        amountForm.setValue(value.getAmountChange());
        eventDateForm.setValue(Parsers.parseToLocalDateTime(value.getEventDate()));
        descriptionForm.setValue(value.getDescription());
    }

    @Override
    public CreateFinancialRowRequest getValue() {
        String title = titleForm.getValue();
        String description = descriptionForm.getValue();
        BigDecimal amount = amountForm.getValue();
        LocalDateTime dateTime = eventDateForm.getValue();
        if (title == null && description == null && amount == null && dateTime == null) {
            return null;
        }
        OffsetDateTime offsetDateTime = Parsers.parseToOffsetDateTime(dateTime);
        CreateFinancialRowRequest model = new CreateFinancialRowRequest();
        model.setTitle(title);
        model.setEventDate(offsetDateTime);
        model.setAmountChange(amount);
        model.setDescription(description);
        return model;
    }

    @Override
    protected BaseViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, FinancesEventCreateFormConfig config) {
        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);
        titleForm = new TextEditTextFormRow(inflater, groupList, config.getTitleConfig());
        amountForm = new DecimalEditTextFormRow(inflater, groupList, config.getAmountConfig());
        eventDateForm = new DateTimePickerForm(inflater, groupList, config.getDateTimePickerConfig());
        descriptionForm = new TextEditTextFormRow(inflater, groupList, config.getDescriptionConfig());

        groupList.addView(titleForm.getView());
        groupList.addView(amountForm.getView());
        groupList.addView(eventDateForm.getView());
        groupList.addView(descriptionForm.getView());

        BaseViewHolder holder = new BaseViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, FinancesEventCreateFormConfig config) {
        titleForm.setOnValidationStateChanged(this::onValueChange);
        amountForm.setOnValidationStateChanged(this::onValueChange);
        eventDateForm.setOnValidationStateChanged(this::onValueChange);
        descriptionForm.setOnValidationStateChanged(this::onValueChange);
    }

    @Override
    public boolean isValid() {
        return titleForm.isValid() && amountForm.isValid()
            && eventDateForm.isValid() && descriptionForm.isValid();
    }
}


