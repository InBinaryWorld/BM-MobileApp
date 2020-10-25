package dev.szafraniak.bm_mobileapp.presentation.menu.copyrights;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.mics.CopyrightAuthorsModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.search.BaseFilterListAdapter;

public class CopyrightsListAdapter extends BaseFilterListAdapter<CopyrightAuthorsModel, CopyrightAuthorsModel> {

    private static final int layoutId = R.layout.row_list_copyrights;

    public CopyrightsListAdapter(LayoutInflater inflater, List<CopyrightAuthorsModel> initialList) {
        super(inflater, initialList);
    }

    static class ViewHolder {
        TextView name;
    }

    @Override
    protected View createView(LayoutInflater inflater, int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = convertView.findViewById(R.id.tv_name);
            convertView.setTag(viewHolder);
        }
        CopyrightAuthorsModel item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        fullFillView(holder, item);
        return convertView;
    }

    private void fullFillView(ViewHolder holder, CopyrightAuthorsModel item) {
        holder.name.setText(item.getName());
    }

    @Override
    protected CopyrightAuthorsModel extractGetItemValue(CopyrightAuthorsModel item) {
        return item;
    }

    @Override
    protected long getItemId(CopyrightAuthorsModel item) {
        return 0;
    }

    @Override
    public String getItemFilterValue(CopyrightAuthorsModel item) {
        return item.getName();
    }

}