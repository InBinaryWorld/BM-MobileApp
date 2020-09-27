package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.create;

import android.view.LayoutInflater;
import android.widget.LinearLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.CreateIndividualContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormFragment;

@EFragment(R.layout.fragment_base_form)
public class IndividualContactCreateFragment extends BaseFormFragment<CreateIndividualContactRequest,
        IndividualContactCreateFormConfig> implements IndividualContactCreateView {

    @Inject
    IndividualContactCreatePresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    protected FormInterface<CreateIndividualContactRequest> createForm(
            LayoutInflater inflater, LinearLayout linearLayout, IndividualContactCreateFormConfig config) {
        return new IndividualContactCreateForm(inflater, linearLayout, config);
    }

    @Override
    protected void loadData() {
        // Nothing to load, just show form
        IndividualContactCreateFormConfig config = presenter.createConfig();
        startForm(config);
    }

    @Override
    protected void onSubmit(CreateIndividualContactRequest object) {
        presenter.createContact(object);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_create_contact;
    }
}
