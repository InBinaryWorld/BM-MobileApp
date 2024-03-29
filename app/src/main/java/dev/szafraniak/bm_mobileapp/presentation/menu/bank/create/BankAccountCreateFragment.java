package dev.szafraniak.bm_mobileapp.presentation.menu.bank.create;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.CreateBankAccountRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.FormInterface;

@EFragment(R.layout.fragment_base_form)
public class BankAccountCreateFragment extends BaseFormFragment<CreateBankAccountRequest, BankAccountCreateFormConfig>
    implements BankAccountCreateView {

    @Inject
    BankAccountCreatePresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_save;
    }

    @Override
    protected FormInterface<CreateBankAccountRequest> createForm(LayoutInflater inflater,
                                                                 ViewGroup linearLayout,
                                                                 BankAccountCreateFormConfig config) {
        return new BankAccountCreateForm(inflater, linearLayout, config);
    }

    @Override
    protected void onSubmit(CreateBankAccountRequest object) {
        presenter.createCompany(object);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_bank_account_new;
    }

    @Override
    protected void loadData() {
        BankAccountCreateFormConfig config = presenter.createConfig();
        startForm(config);
    }
}
