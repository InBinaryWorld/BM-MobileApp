package dev.szafraniak.bm_mobileapp.presentation.menu.finances.modify;

import dev.szafraniak.bm_mobileapp.business.models.entity.finantialRow.UpdateFinancialRowRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormView;

public interface FinancialEventModifyView extends BaseFormView {

    void setModifyModel(UpdateFinancialRowRequest model);

}
