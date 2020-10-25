package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.timePicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;

import java.time.LocalTime;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.utils.Formatter;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.labeled.LabelFormRow;


public class TimePickerForm extends LabelFormRow<LocalTime, TimePickerFormViewHolder, TimePickerFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.row_time_picker;

    private MaterialTimePicker.Builder builder;

    private FragmentManager fragmentManager;

    private LocalTime timeVale;

    public TimePickerForm(LayoutInflater inflater, ViewGroup viewGroup, TimePickerFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void setLabel(String label) {
        TimePickerFormViewHolder holder = getViewHolder();
        holder.label.setText(label);
    }

    @Override
    protected void updateView(boolean isValid) {
        LocalTime date = getValue();
        boolean isNull = date == null;
        TimePickerFormViewHolder holder = getViewHolder();
        holder.error.setVisibility(isValid ? View.GONE : View.VISIBLE);
        holder.dataView.setVisibility(isNull ? View.GONE : View.VISIBLE);
        holder.emptyView.setVisibility(!isNull ? View.GONE : View.VISIBLE);
        holder.value.setText(Formatter.safeFormatTime(getValue()));
    }

    @Override
    protected void showValueOnView(LocalTime value) {
        timeVale = value;
        onValueChange();
    }

    @Override
    protected TimePickerFormViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, TimePickerFormConfig config) {
        TimePickerFormViewHolder holder = new TimePickerFormViewHolder();
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
    protected void setupView(LayoutInflater inflater, TimePickerFormConfig config) {
        TimePickerFormViewHolder holder = getViewHolder();
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

    private MaterialTimePicker.Builder setupBaseBuilder(TimePickerFormConfig config) {
        MaterialTimePicker.Builder builder = new MaterialTimePicker.Builder();
        builder.setTimeFormat(TimeFormat.CLOCK_24H);
        builder.setTitleText(config.getLabel());
        return builder;
    }

    private void showPicker(View view) {
        LocalTime time = LocalTime.now();
        if (timeVale != null) {
            time = timeVale;
        }
        builder.setHour(time.getHour());
        builder.setMinute(time.getMinute());
        MaterialTimePicker timePicker = builder.build();
        timePicker.addOnPositiveButtonClickListener(v -> this.onTimePicked(timePicker));
        timePicker.show(fragmentManager, "TimePicker");
    }

    private void onTimePicked(MaterialTimePicker view) {
        timeVale = LocalTime.of(view.getHour(), view.getMinute());
        onValueChange();
    }

    @Override
    public LocalTime getValue() {
        return timeVale;
    }

}
