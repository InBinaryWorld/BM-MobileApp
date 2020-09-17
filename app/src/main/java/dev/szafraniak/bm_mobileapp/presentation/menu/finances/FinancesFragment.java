package dev.szafraniak.bm_mobileapp.presentation.menu.finances;

import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.presentation.BaseHeaderFragment;

@EFragment(R.layout.fragment_finances)
public class FinancesFragment extends BaseHeaderFragment implements FinancesView {

    @ViewById(R.id.tv_header_text)
    TextView headerTextView;

    @Inject
    FinancesPresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_finances;
    }
}
