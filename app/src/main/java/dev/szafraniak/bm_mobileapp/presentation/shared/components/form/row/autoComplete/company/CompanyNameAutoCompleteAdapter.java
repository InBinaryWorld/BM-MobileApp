package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete.company;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;

import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete.BaseAutoCompleteListAdapter;

public class CompanyNameAutoCompleteAdapter extends BaseAutoCompleteListAdapter<CompanyContact> {

    @LayoutRes
    private static final int layoutId = R.layout.row_dropdown_contact;

    public CompanyNameAutoCompleteAdapter(LayoutInflater inflater, List<CompanyContact> initialList) {
        super(inflater, initialList);
    }

    @Override
    public String getItemFilterValue(CompanyContact item) {
        return item.getName();
    }

    private class ViewHolder {
        TextView contactName;
        TextView contactAddress;
    }

    @Override
    protected View createView(LayoutInflater inflater, int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.contactName = convertView.findViewById(R.id.tv_contact_name);
            viewHolder.contactAddress = convertView.findViewById(R.id.tv_contact_address);
            convertView.setTag(viewHolder);
        }
        CompanyContact item = getWholeItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.contactName.setText(item.getName());
        holder.contactAddress.setText(item.getAddress().getShortAddress());
        return convertView;
    }

    @Override
    protected String extractGetItemValue(CompanyContact item) {
        return item.getName();
    }

    @Override
    protected long getItemId(CompanyContact item) {
        return item.getId();
    }

}
