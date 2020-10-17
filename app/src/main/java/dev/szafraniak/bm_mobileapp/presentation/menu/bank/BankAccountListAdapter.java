package dev.szafraniak.bm_mobileapp.presentation.menu.bank;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;

import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.BankAccount;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListAdapter;

public class BankAccountListAdapter extends BaseListAdapter<BankAccount, BankAccount> {

    @LayoutRes
    private static final int layoutId = R.layout.row_list_bank_account;

    public BankAccountListAdapter(LayoutInflater inflater, List<BankAccount> initValue) {
        super(inflater, initValue);
    }

    static class ViewHolder {
        TextView accountName;
        TextView accountNumber;
    }

    @Override
    protected View createView(LayoutInflater inflater, int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.accountName = convertView.findViewById(R.id.tv_account_name);
            viewHolder.accountNumber = convertView.findViewById(R.id.tv_account_number);
            convertView.setTag(viewHolder);
        }
        BankAccount item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.accountName.setText(item.getName());
        holder.accountNumber.setText(item.getNumber());
        return convertView;
    }

    @Override
    protected BankAccount extractGetItemValue(BankAccount item) {
        return item;
    }

}