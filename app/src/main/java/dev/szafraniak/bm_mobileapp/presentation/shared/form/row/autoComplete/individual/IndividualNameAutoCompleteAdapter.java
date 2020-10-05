package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete.individual;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;

import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete.BaseAutoCompleteListAdapter;

public class IndividualNameAutoCompleteAdapter extends BaseAutoCompleteListAdapter<IndividualContact> {

    @LayoutRes
    private static final int layoutId = R.layout.row_dropdown_contact;

    public IndividualNameAutoCompleteAdapter(LayoutInflater inflater, List<IndividualContact> initialList) {
        super(inflater, initialList);
    }

    @Override
    public String getItemFilterValue(IndividualContact item) {
        return item.getFirstName();
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
        IndividualContact item = getWholeItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.contactName.setText(item.getFirstName());
        holder.contactAddress.setText(item.getAddress().getShortAddress());
        return convertView;
    }

    @Override
    protected String extractGetItemValue(IndividualContact item) {
        return item.getFirstName();
    }

}
