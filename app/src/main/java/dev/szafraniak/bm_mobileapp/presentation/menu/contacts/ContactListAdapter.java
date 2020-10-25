package dev.szafraniak.bm_mobileapp.presentation.menu.contacts;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import dev.szafraniak.bm_mobileapp.presentation.shared.search.BaseFilterListAdapter;

public class ContactListAdapter<T extends Contact> extends BaseFilterListAdapter<T, T> {

    private static final int layoutId = R.layout.row_list_contact;
    private final Context context;

    public ContactListAdapter(Context context, List<T> initialList) {
        super(LayoutInflater.from(context), initialList);
        this.context = context;
    }

    static class ViewHolder {
        TextView contactName;
        TextView address;
        ImageView phone;
    }

    @Override
    protected View createView(LayoutInflater inflater, int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.contactName = convertView.findViewById(R.id.tv_contact_name);
            viewHolder.address = convertView.findViewById(R.id.tv_address);
            viewHolder.phone = convertView.findViewById(R.id.iv_phone);
            convertView.setTag(viewHolder);
        }
        T item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        fullFillView(item, holder);
        return convertView;
    }

    private void fullFillView(T item, ViewHolder holder) {
        Address address = item.getAddress();
        holder.contactName.setText(item.getName());
        holder.address.setText(address.getShortAddress());
        boolean hasPhone = item.getPhone() != null;
        holder.phone.setEnabled(hasPhone);
        if (hasPhone) {
            holder.phone.setOnClickListener(
                view -> openDialer(item.getPhone())
            );
        }
    }

    private void openDialer(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        context.startActivity(intent);
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