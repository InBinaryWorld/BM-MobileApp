package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.price;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.BaseFormRowConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowValidator;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PriceFormRowConfig<E> extends BaseFormRowConfig<E, Price> {

    private FormRowValidator<BigDecimal> netValidator;
    private FormRowValidator<BigDecimal> taxRateValidator;
    private String netInvalidMessage;
    private String taxInvalidMessage;
    private String netLabel;
    private String taxRateLabel;
    private String grossLabel;
    private String netInitValue;
    private String taxRateInitValue;
    private String grossInitValue;

}
