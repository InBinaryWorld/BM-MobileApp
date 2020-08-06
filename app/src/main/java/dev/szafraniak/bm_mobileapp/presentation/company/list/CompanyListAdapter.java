package dev.szafraniak.bm_mobileapp.presentation.company.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.IdNameEntity;
import dev.szafraniak.bm_mobileapp.presentation.BaseAdapter;

public class CompanyListAdapter extends BaseAdapter<IdNameEntity> {

    public CompanyListAdapter(Context context, int res) {
        super(context, res);
    }

    @Override
    protected View createView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.support_simple_spinner_dropdown_item, null);

        ((TextView) rowView.getRootView()).setText(items.get(position).getName());
        return rowView;
    }
}
