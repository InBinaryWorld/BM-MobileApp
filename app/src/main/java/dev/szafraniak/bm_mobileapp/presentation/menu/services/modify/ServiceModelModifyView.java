package dev.szafraniak.bm_mobileapp.presentation.menu.services.modify;

import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormView;

public interface ServiceModelModifyView extends BaseFormView {

    void setModifyModel(ServiceModel serviceModel);
}
