package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.datePicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;

import java.time.LocalDate;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.utils.Formatter;
import dev.szafraniak.bm_mobileapp.business.utils.Parser;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.labeled.LabelFormRow;

public class DatePickerForm extends LabelFormRow<LocalDate, DatePickerFormViewHolder, DatePickerFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.row_date_picker;

    private MaterialDatePicker.Builder<Long> builder;

    private FragmentManager fragmentManager;

    private Long dateInUTCMils;

    public DatePickerForm(LayoutInflater inflater, ViewGroup viewGroup, DatePickerFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void setLabel(String label) {
        DatePickerFormViewHolder holder = getViewHolder();
        holder.label.setText(label);
    }

    @Override
    protected void updateView(boolean isValid) {
        LocalDate date = getValue();
        boolean isNull = date == null;
        DatePickerFormViewHolder holder = getViewHolder();
        holder.error.setVisibility(isValid ? View.GONE : View.VISIBLE);
        holder.dataView.setVisibility(isNull ? View.GONE : View.VISIBLE);
        holder.emptyView.setVisibility(!isNull ? View.GONE : View.VISIBLE);
        holder.value.setText(Formatter.safeFormatDate(getValue()));
    }

    @Override
    protected void showValueOnView(LocalDate value) {
        dateInUTCMils = Parser.parseToMillsAtStartOfDay(value);
        onValueChange();
    }

    @Override
    protected DatePickerFormViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, DatePickerFormConfig config) {
        DatePickerFormViewHolder holder = new DatePickerFormViewHolder();
        holder.view = inflater.inflate(layoutId, viewGroup, false);
        holder.empty = holder.view.findViewById(R.id.tv_empty);
        holder.label = holder.view.findViewById(R.id.tv_label);
        holder.value = holder.view.findViewById(R.id.tv_value);
        holder.error = holder.view.findViewById(R.id.tv_invalid_view);
        holder.dataView = holder.view.findViewById(R.id.cl_data_view);
        holder.emptyView = holder.view.findViewById(R.id.cl_empty_view);
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, DatePickerFormConfig config) {
        DatePickerFormViewHolder holder = getViewHolder();
        holder.dataView.setVisibility(View.GONE);
        holder.emptyView.setVisibility(View.VISIBLE);
        holder.error.setVisibility(View.GONE);
        holder.error.setText(config.getInvalidText());
        holder.empty.setText(config.getEmptyText());
        holder.view.setClickable(true);
        holder.view.setOnClickListener(this::showPicker);
        builder = setupBaseBuilder(config);
        fragmentManager = extractFMFromView(holder.view);
    }

    private FragmentManager extractFMFromView(View view) {
        RxAppCompatActivity activity = (RxAppCompatActivity) view.getContext();
        return activity.getSupportFragmentManager();
    }

    private MaterialDatePicker.Builder<Long> setupBaseBuilder(DatePickerFormConfig config) {
        CalendarConstraints.Builder calendarBuilder = new CalendarConstraints.Builder();
        if (config.getPickerValidator() != null) {
            calendarBuilder.setValidator(config.getPickerValidator());
        }

        MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();
        builder.setCalendarConstraints(calendarBuilder.build());
        builder.setTitleText(config.getLabel());
        return builder;
    }

    private void showPicker(View view) {
        builder.setSelection(dateInUTCMils);
        MaterialDatePicker<Long> datePicker = builder.build();
        datePicker.addOnPositiveButtonClickListener(this::onDatePicked);
        datePicker.show(fragmentManager, "DatePicker");
    }

    private void onDatePicked(Long pickedDateInMils) {
        dateInUTCMils = pickedDateInMils;
        onValueChange();
    }

    @Override
    public LocalDate getValue() {
        if (dateInUTCMils == null) {
            return null;
        }
        return Parser.parseMillsToLocalDate(dateInUTCMils);
    }

}
