package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.create;

import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.address.CreateAddressRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.CreateIndividualContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.BaseFormFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.config.FormConfig;

@EFragment(R.layout.fragment_base_form)
public class IndividualContactCreateFragment extends BaseFormFragment<CreateIndividualContactRequest> implements IndividualContactCreateView {

    @ViewById(R.id.tv_header_text)
    TextView headerTextView;


    @Inject
    IndividualContactCreatePresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        headerTextView.setText(R.string.header_create_contact);
        presenter.setView(this);
    }

    @Override
    protected CreateIndividualContactRequest getFormModel() {
        CreateIndividualContactRequest model = new CreateIndividualContactRequest();
        model.setAddress(new CreateAddressRequest());
        return model;
    }

    @Override
    protected void onSubmit(CreateIndividualContactRequest object) {
        presenter.createCompany(object);
    }

    @Override
    protected FormConfig<CreateIndividualContactRequest> createFormConfig() {
        return new CompanyIndividualCreateFormConfig(inflater, layout);
    }

}
