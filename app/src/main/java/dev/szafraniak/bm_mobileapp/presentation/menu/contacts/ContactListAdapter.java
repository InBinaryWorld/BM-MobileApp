package dev.szafraniak.bm_mobileapp.presentation.menu.contacts;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import dev.szafraniak.bm_mobileapp.presentation.shared.search.BaseFilterAdapter;

public class ContactListAdapter<T extends Contact> extends BaseFilterAdapter<T> {

    public ContactListAdapter(Context context) {
        super(context, R.layout.row_list_contact);
    }

    static class ViewHolder {
        TextView contactName;
        TextView address;
    }

    @Override
    protected View createView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(resourceId, parent, false);
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

}