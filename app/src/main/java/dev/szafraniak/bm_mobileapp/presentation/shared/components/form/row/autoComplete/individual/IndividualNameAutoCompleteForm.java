package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete.individual;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete.AutoCompleteTextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete.BaseAutoCompleteListAdapter;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete.text.TextAutoCompleteTextForm;

public class IndividualNameAutoCompleteForm extends TextAutoCompleteTextForm<IndividualContact> {

    public IndividualNameAutoCompleteForm(LayoutInflater inflater, ViewGroup viewGroup, AutoCompleteTextFormConfig<String, IndividualContact> config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected BaseAutoCompleteListAdapter<IndividualContact> createAdapter(LayoutInflater inflater, AutoCompleteTextFormConfig<String, IndividualContact> config) {
        return new IndividualNameAutoCompleteAdapter(inflater, config.getListItems());
    }

}
