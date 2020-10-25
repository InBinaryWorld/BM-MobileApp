package dev.szafraniak.bm_mobileapp.presentation.menu.copyrights;

import android.view.LayoutInflater;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.mics.CopyrightAuthorsModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListFragment;

@EFragment(R.layout.fragment_copyrights)
public class CopyrightsFragment extends BaseListFragment<CopyrightAuthorsModel, CopyrightsListAdapter> implements CopyrightsView {

    @ViewById(R.id.tv_delivered_by)
    TextView deliveredBy;

    @Inject
    CopyrightsPresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_copyrights;
    }

    @Override
    protected void loadData() {
        presenter.loadData();
    }

    @Override
    public void onItemClick(CopyrightAuthorsModel item) {
        presenter.openInBrowser(item.getUrl());
    }

    @Override
    protected CopyrightsListAdapter createAdapter() {
        return new CopyrightsListAdapter(LayoutInflater.from(getContext()), new ArrayList<>());
    }

    @Override
    public void setData(CopyrightsDataModel model) {
        setData(model.getAuthors());
        deliveredBy.setText(model.getDeliveryBy());
    }
}
