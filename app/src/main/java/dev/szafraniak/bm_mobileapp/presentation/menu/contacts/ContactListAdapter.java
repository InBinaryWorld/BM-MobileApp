package dev.szafraniak.bm_mobileapp.presentation.menu.contacts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import dev.szafraniak.bm_mobileapp.presentation.shared.search.BaseFilterListAdapter;

public class ContactListAdapter<T extends Contact> extends BaseFilterListAdapter<T, T> {

    private static final int layoutId = R.layout.row_list_contact;

    public ContactListAdapter(LayoutInflater inflater, List<T> initialList) {
        super(inflater, initialList);
    }

    static class ViewHolder {
        TextView contactName;
        TextView address;
    }

    @Override
    protected View createView(LayoutInflater inflater, int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.contactName = convertView.findViewById(R.id.tv_contact_name);
            viewHolder.address = convertView.findViewById(R.id.tv_address);
            convertView.setTag(viewHolder);
        }
        T item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        Address address = item.getAddress();
        holder.contactName.setText(item.getName());
        holder.address.setText(address.getShortAddress());
        return convertView;
    }

    @Override
    protected T extractGetItemValue(T item) {
        return item;
    }

    @Override
    protected long getItemId(T item) {
        return item.getId();
    }

    @Override
    public String getItemFilterValue(T item) {
        return item.getFilterValue();
    }

}