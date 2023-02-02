package dev.szafraniak.bm_mobileapp.presentation.menu.finances.create;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.business.models.entity.finantialRow.CreateFinancialRowRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.dateTimePicker.DateTimePickerFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.text.TextEditTextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class FinancesEventCreateFormConfig extends BaseFormConfig<CreateFinancialRowRequest> {

    private TextEditTextFormConfig titleConfig;
    private TextFormConfig<BigDecimal> amountConfig;
    private TextEditTextFormConfig descriptionConfig;
    private DateTimePickerFormConfig dateTimePickerConfig;

}

