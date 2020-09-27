package dev.szafraniak.bm_mobileapp.presentation.menu.company.modify;

import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormView;

public interface ModifyCompanyView extends BaseFormView {

    void setModifyModel(Company company);

}
