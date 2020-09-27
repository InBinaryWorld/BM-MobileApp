package dev.szafraniak.bm_mobileapp.presentation.menu.services.details;

import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.fragment.BaseDetailsView;

public interface ServiceModelDetailsView extends BaseDetailsView<ServiceModel> {

    void setData(ServiceModel serviceModel);
}
