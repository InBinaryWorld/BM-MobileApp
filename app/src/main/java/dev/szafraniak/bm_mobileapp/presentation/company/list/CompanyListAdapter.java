package dev.szafraniak.bm_mobileapp.presentation.company.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;

import java.math.BigDecimal;
import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.business.models.stats.CompanyStatsModel;
import dev.szafraniak.bm_mobileapp.business.utils.Parsers;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListAdapter;

public class CompanyListAdapter extends BaseListAdapter<CompanyListModel, CompanyListModel> {

    @LayoutRes
    private static final int layoutId = R.layout.row_card_company;

    public CompanyListAdapter(LayoutInflater inflater, List<CompanyListModel> initValue) {
        super(inflater, initValue);
    }


    static class ViewHolder {
        TextView unpaidInvoices;
        TextView companyName;
        TextView address;
        TextView productValue;
        TextView financesValue;
    }

    @Override
    protected View createView(LayoutInflater inflater, int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.companyName = convertView.findViewById(R.id.tv_company_name);
            viewHolder.address = convertView.findViewById(R.id.tv_address);
            viewHolder.productValue = convertView.findViewById(R.id.tv_product_value);
            viewHolder.unpaidInvoices = convertView.findViewById(R.id.tv_unpaid_invoices);
            viewHolder.financesValue = convertView.findViewById(R.id.tv_current_finances_value);
            convertView.setTag(viewHolder);
        }
        CompanyListModel item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        fillView(item, holder);
        return convertView;
    }

    private void fillView(CompanyListModel item, ViewHolder holder) {
        Company company = item.getCompany();
        CompanyStatsModel stats = item.getCompanyStats();

        holder.companyName.setText(company.getName());
        holder.address.setText(getShortAddress(company));
        holder.productValue.setText(getProductsValue(stats, company.getCurrency()));
        holder.financesValue.setText(getFinancesValue(stats, company.getCurrency()));
        holder.unpaidInvoices.setText(Integer.toString(stats.getInvoices().getUnpaid()));
    }

    private String getFinancesValue(CompanyStatsModel stats, String currency) {
        BigDecimal value = stats.getFinances().getCurrentState();
        String valueString = Parsers.safeFormatPrice(value);
        return String.format("%s %s", valueString, currency);
    }

    private String getShortAddress(Company company) {
        return company.getHeadquarter().getShortAddress();
    }

    private String getProductsValue(CompanyStatsModel stats, String currency) {
        BigDecimal productsGross = stats.getProducts().getTotalGrossValue();
        String grossString = Parsers.safeFormatPrice(productsGross);
        return String.format("%s %s", grossString, currency);
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