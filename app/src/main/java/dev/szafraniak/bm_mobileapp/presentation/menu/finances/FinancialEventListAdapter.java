package dev.szafraniak.bm_mobileapp.presentation.menu.finances;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;

import java.math.BigDecimal;
import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.finantialRow.FinancialRow;
import dev.szafraniak.bm_mobileapp.business.utils.Parsers;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListAdapter;

public class FinancialEventListAdapter extends BaseListAdapter<FinancialRow, FinancialRow> {

    @LayoutRes
    private static final int layoutId = R.layout.row_list_financial_event;

    private final int colorIncome;
    private final int colorOutcome;

    public FinancialEventListAdapter(LayoutInflater inflater, List<FinancialRow> initValue) {
        super(inflater, initValue);
        Context context = inflater.getContext();
        colorIncome = context.getColor(R.color.colorSuccess);
        colorOutcome = context.getColor(R.color.colorError);
    }

    static class ViewHolder {
        TextView title;
        TextView amount;
        TextView amountCurrency;
        TextView eventDate;
    }

    @Override
    protected View createView(LayoutInflater inflater, int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.title = convertView.findViewById(R.id.tv_title);
            viewHolder.amount = convertView.findViewById(R.id.tv_amount);
            viewHolder.amountCurrency = convertView.findViewById(R.id.tv_amount_currency);
            viewHolder.eventDate = convertView.findViewById(R.id.tv_event_date);
            convertView.setTag(viewHolder);
        }
        FinancialRow item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        fullFillView(holder, item);
        return convertView;
    }

    private void fullFillView(ViewHolder holder, FinancialRow item) {
        BigDecimal amount = item.getAmountChange();
        BigDecimal absAmount = amount.abs();
        boolean isIncome = amount.signum() >= 0;

        holder.title.setText(item.getTitle());
        holder.eventDate.setText(Parsers.safeFormatDate(item.getEventDate()));
        holder.amountCurrency.setText(item.getCurrency());
        holder.amount.setText(Parsers.safeFormatPrice(absAmount));
        holder.amount.setTextColor(isIncome ? colorIncome : colorOutcome);

    }

    @Override
    protected FinancialRow extractGetItemValue(FinancialRow item) {
        return item;
    }

    @Override
    protected long getItemId(FinancialRow item) {
        return item.getId();
    }

}