package dev.szafraniak.bm_mobileapp.presentation.menu.copyrights;

import dev.szafraniak.bm_mobileapp.business.models.mics.CopyrightAuthorsModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListView;

public interface CopyrightsView extends BaseListView<CopyrightAuthorsModel> {

    void setData(CopyrightsDataModel model);
}
