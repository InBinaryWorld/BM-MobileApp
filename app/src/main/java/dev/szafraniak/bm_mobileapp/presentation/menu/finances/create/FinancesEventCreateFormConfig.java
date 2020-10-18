package dev.szafraniak.bm_mobileapp.presentation.menu.finances.create;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.business.models.entity.finantialRow.CreateFinancialRowRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.dateTimePicker.DateTimePickerFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class FinancesEventCreateFormConfig extends BaseFormConfig<CreateFinancialRowRequest> {

    private TextFormConfig<String> titleConfig;
    private TextFormConfig<BigDecimal> amountConfig;
    private TextFormConfig<String> descriptionConfig;
    private DateTimePickerFormConfig dateTimePickerConfig;

}

