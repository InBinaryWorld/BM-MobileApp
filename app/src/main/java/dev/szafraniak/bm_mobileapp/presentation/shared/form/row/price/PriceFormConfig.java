package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.price;

import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.BaseFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PriceFormConfig extends BaseFormConfig<Price> {


    private T initValue;

    protected PriceFormParser parser;
    protected PriceValidator validator;
    protected String netInvalidMessage;
    protected String taxInvalidMessage;
    protected String netLabel;
    protected String taxRateLabel;
    protected String grossLabel;
    protected String netInitValue;
    protected String taxRateInitValue;
    protected String grossInitValue;

}
