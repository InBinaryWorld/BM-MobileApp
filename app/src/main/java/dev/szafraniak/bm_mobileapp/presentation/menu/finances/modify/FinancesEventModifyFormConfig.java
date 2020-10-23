package dev.szafraniak.bm_mobileapp.presentation.menu.finances.modify;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.business.models.entity.finantialRow.UpdateFinancialRowRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.dateTimePicker.DateTimePickerFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class FinancesEventModifyFormConfig extends BaseFormConfig<UpdateFinancialRowRequest> {

    private TextFormConfig<String> titleConfig;
    private TextFormConfig<BigDecimal> amountConfig;
    private TextFormConfig<String> descriptionConfig;
    private DateTimePickerFormConfig dateTimePickerConfig;

}
