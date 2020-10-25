package dev.szafraniak.bm_mobileapp.presentation.menu.bank.modify;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.BankAccount;
import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.UpdateBankAccountRequest;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.FormInterface;

@EFragment(R.layout.fragment_base_form)
public class BankAccountModifyFragment extends BaseFormFragment<UpdateBankAccountRequest, BankAccountModifyFormConfig>
    implements BankAccountModifyView {

    public final static String KEY_BANK_ACCOUNT = "KEY_BANK_ACCOUNT";

    @Inject
    Gson gson;

    @Inject
    BankAccountModifyPresenter presenter;

    BankAccount bankAccount;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        fetchArgumentsData();
        presenter.setView(this);
    }

    private void fetchArgumentsData() {
        Bundle args = getArguments();
        if (args == null || !args.containsKey(KEY_BANK_ACCOUNT)) {
            Navigator.back(this);
            return;
        }
        String companyJSON = args.getString(KEY_BANK_ACCOUNT);
        bankAccount = gson.fromJson(companyJSON, BankAccount.class);
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_modify_form;
    }

    @Override
    protected FormInterface<UpdateBankAccountRequest> createForm(
        LayoutInflater inflater, ViewGroup linearLayout, BankAccountModifyFormConfig config) {
        return new BankAccountModifyForm(inflater, linearLayout, config);
    }

    @Override
    protected void onSubmit(UpdateBankAccountRequest request) {
        presenter.modifyBankAccount(bankAccount.getId(), request);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_bank_account_modify;
    }

    @Override
    protected void loadData() {
        presenter.loadData(bankAccount.getId());
    }

    @Override
    public void setModifyModel(UpdateBankAccountRequest model) {
        BankAccountModifyFormConfig config = presenter.createConfig();
        startForm(config, model);
    }

}
