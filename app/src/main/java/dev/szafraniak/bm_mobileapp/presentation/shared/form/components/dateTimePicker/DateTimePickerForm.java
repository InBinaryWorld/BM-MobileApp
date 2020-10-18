package dev.szafraniak.bm_mobileapp.presentation.shared.form.components.dateTimePicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.BaseFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.datePicker.DatePickerForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.timePicker.TimePickerForm;

public class DateTimePickerForm extends BaseFormRow<LocalDateTime, DateTimePickerFormViewHolder, DateTimePickerFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group;

    DatePickerForm datePickerForm;
    TimePickerForm timePickerForm;


    public DateTimePickerForm(LayoutInflater inflater, ViewGroup viewGroup, DateTimePickerFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void showValueOnView(LocalDateTime value) {
        if (value == null) {
            datePickerForm.setValue(null);
            timePickerForm.setValue(null);
            return;
        }
        datePickerForm.setValue(value.toLocalDate());
        timePickerForm.setValue(value.toLocalTime());
        onValueChange();
    }

    @Override
    protected DateTimePickerFormViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, DateTimePickerFormConfig config) {
        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);
        View invalidView = inflater.inflate(R.layout.row_component_invalid_message, viewGroup, false);
        datePickerForm = new DatePickerForm(inflater, groupList, config.getDateConfig());
        timePickerForm = new TimePickerForm(inflater, groupList, config.getTimeConfig());

        groupList.addView(datePickerForm.getView());
        groupList.addView(timePickerForm.getView());
        groupList.addView(invalidView);

        DateTimePickerFormViewHolder holder = new DateTimePickerFormViewHolder();
        holder.errorTV = invalidView.findViewById(R.id.tv_error_msg);
        holder.error = invalidView;
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, DateTimePickerFormConfig config) {
        DateTimePickerFormViewHolder holder = getViewHolder();
        holder.errorTV.setText(config.getInvalidMessage());
        datePickerForm.setOnValueChange(this::onValueChange);
        timePickerForm.setOnValueChange(this::onValueChange);
        onValueChange();
    }

    @Override
    protected void updateView(boolean isValid) {
        boolean isComponentErrorVisible = timePickerForm.isValid() && datePickerForm.isValid()
            && !isValid();
        DateTimePickerFormViewHolder holder = getViewHolder();
        holder.error.setVisibility(isComponentErrorVisible ? View.VISIBLE : View.GONE);
    }

    @Override
    public LocalDateTime getValue() {
        LocalTime time = timePickerForm.getValue();
        LocalDate date = datePickerForm.getValue();
        if (time == null && date == null) {
            return null;
        }
        LocalTime time1 = time == null ? LocalTime.now() : time;
        LocalDate date1 = date == null ? LocalDate.now() : date;
        return LocalDateTime.of(date1, time1);
    }

}
