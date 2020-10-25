package dev.szafraniak.bm_mobileapp.presentation.company.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;

import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.business.models.stats.CompanyStatsModel;
import dev.szafraniak.bm_mobileapp.business.utils.Formatter;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListAdapter;

public class CompanyListAdapter extends BaseListAdapter<CompanyListModel, CompanyListModel> {

    @LayoutRes
    private static final int layoutId = R.layout.row_card_company;

    public CompanyListAdapter(LayoutInflater inflater, List<CompanyListModel> initValue) {
        super(inflater, initValue);
    }

    static class ViewHolder {
        TextView companyName;
        TextView address;
        TextView productValue;
        TextView productValueCurrency;
        TextView financesValue;
        TextView financesValueCurrency;
    }

    @Override
    protected View createView(LayoutInflater inflater, int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.companyName = convertView.findViewById(R.id.tv_company_name);
            viewHolder.address = convertView.findViewById(R.id.tv_address);
            viewHolder.productValue = convertView.findViewById(R.id.tv_product_value);
            viewHolder.financesValue = convertView.findViewById(R.id.tv_finances_state);
            viewHolder.productValueCurrency = convertView.findViewById(R.id.tv_products_value_currency);
            viewHolder.financesValueCurrency = convertView.findViewById(R.id.tv_finances_state_currency);
            convertView.setTag(viewHolder);
        }
        CompanyListModel item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        fillView(item, holder);
        return convertView;
    }

    private void fillView(CompanyListModel item, ViewHolder holder) {
        CompanyStatsModel stats = item.getCompanyStats();
        Company company = item.getCompany();
        String currency = company.getCurrency();

        holder.companyName.setText(company.getName());
        holder.address.setText(getShortAddress(company));
        holder.productValue.setText(getProductsValue(stats));
        holder.financesValue.setText(getFinancesValue(stats));
        holder.productValueCurrency.setText(currency);
        holder.financesValueCurrency.setText(currency);
    }

    private String getFinancesValue(CompanyStatsModel stats) {
        return Formatter.safeFormatPrice(stats.getFinances().getCurrentState());
    }

    private String getProductsValue(CompanyStatsModel stats) {
        return Formatter.safeFormatPrice(stats.getResources().getTotalGrossValue());
    }

    private String getShortAddress(Company company) {
        return company.getHeadquarter().getShortAddress();
    }

    @Override
    protected CompanyListModel extractGetItemValue(CompanyListModel item) {
        return item;
    }

    @Override
    protected long getItemId(CompanyListModel item) {
        return 0;
    }

}