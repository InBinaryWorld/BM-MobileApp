package dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.type;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;

import java.util.HashMap;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.spinner.BaseSpinnerAdapter;

public class ContactTypeAdapter extends BaseSpinnerAdapter<ContactType, ContactType> {

    @LayoutRes
    private static final int layoutId = R.layout.row_spinner_base_preview;
    @LayoutRes
    private static final int dropdownLayoutId = R.layout.row_spinner_base_dropdown;

    private final ContactTypeFormConfig config;

    public ContactTypeAdapter(LayoutInflater inflater, ContactTypeFormConfig config) {
        super(inflater, config.getSpinnerItems());
        this.config = config;
    }

    @Override
    protected ContactType extractGetItemValue(ContactType item) {
        return item;
    }

    @Override
    protected long getItemId(ContactType item) {
        return 0;
    }

    @Override
    protected View createView(LayoutInflater inflater, int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = convertView.findViewById(R.id.tv_spinner_value);
            convertView.setTag(viewHolder);
        }
        ContactType item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        HashMap<ContactType, String> displayValues = config.getDisplayValues();
        holder.name.setText(displayValues.get(item));
        return convertView;
    }

    @Override
    protected View createDropdownView(LayoutInflater inflater, int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = inflater.inflate(dropdownLayoutId, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = convertView.findViewById(R.id.tv_spinner_value);
            convertView.setTag(viewHolder);
        }
        ContactType item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        HashMap<ContactType, String> displayValues = config.getDisplayValues();
        holder.name.setText(displayValues.get(item));
        return convertView;
    }

    private static class ViewHolder {
        TextView name;
    }

}
