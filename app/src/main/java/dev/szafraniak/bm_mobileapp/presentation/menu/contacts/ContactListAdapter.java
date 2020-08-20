package dev.szafraniak.bm_mobileapp.presentation.menu.contacts;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseAdapter;

public class ContactListAdapter<T extends Contact> extends BaseAdapter<T> {

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

    @Override
    protected List<T> filteringFunction(List<T> allItemsList, String searchText) {
        List<String> keywords = Arrays.asList(searchText.toLowerCase().split(" "));
        List<T> list = new ArrayList<>();
        for (T contact : allItemsList) {
            String itemString = String.format("%s %s %s", contact.getName(),
                    contact.getAddress().getFullAddress(), contact.getPhone()).toLowerCase();
            if (keywords.stream().allMatch(itemString::contains)) {
                list.add(contact);
            }
        }
        return list;
    }
}