package dev.szafraniak.bm_mobileapp.presentation.menu.bank.modify;

import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.UpdateBankAccountRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormView;

public interface BankAccountModifyView extends BaseFormView {

    void setModifyModel(UpdateBankAccountRequest model);

}
