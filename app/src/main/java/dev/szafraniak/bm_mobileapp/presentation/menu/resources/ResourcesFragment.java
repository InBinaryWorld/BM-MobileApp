package dev.szafraniak.bm_mobileapp.presentation.menu.resources;

import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.presentation.BaseFragment;

@EFragment(R.layout.resources_fragment)
public class ResourcesFragment extends BaseFragment implements ResourcesView {

    @ViewById(R.id.tv_header_text)
    TextView headerTextView;

    @Inject
    ResourcesPresenter presenter;

    @AfterViews
    public void initialize() {
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        headerTextView.setText("Resources");
    }

}
