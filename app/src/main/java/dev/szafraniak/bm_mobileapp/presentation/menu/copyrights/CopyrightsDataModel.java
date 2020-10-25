package dev.szafraniak.bm_mobileapp.presentation.menu.copyrights;

import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.mics.CopyrightAuthorsModel;
import lombok.Data;

@Data
public class CopyrightsDataModel {
    List<CopyrightAuthorsModel> authors;
    String deliveryBy;

}
