package dev.szafraniak.bm_mobileapp.presentation.company.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseAdapter;

public class CompanyListAdapter extends BaseAdapter<CompanyListModel> {

    public CompanyListAdapter(Context context) {
        super(context, R.layout.row_card_company);
    }

    static class ViewHolder {
        TextView companyName;
        TextView address;
        TextView productValue;
    }

    @Override
    protected View createView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(resourceId, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.companyName = convertView.findViewById(R.id.tv_company_name);
            viewHolder.address = convertView.findViewById(R.id.tv_address);
            viewHolder.productValue = convertView.findViewById(R.id.tv_product_value);
            convertView.setTag(viewHolder);
        }
        CompanyListModel item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        Company company = item.getCompany();
        Address address = company.getHeadquarter();
        holder.companyName.setText(company.getName());
        holder.address.setText(address.getShortAddress());
        holder.productValue.setText(item.getProductsValue());
        return convertView;
    }

}