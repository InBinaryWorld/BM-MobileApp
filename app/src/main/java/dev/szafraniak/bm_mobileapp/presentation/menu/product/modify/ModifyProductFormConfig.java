package dev.szafraniak.bm_mobileapp.presentation.menu.product.modify;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.business.models.entity.product.Product;
import dev.szafraniak.bm_mobileapp.business.models.entity.product.UpdateProductRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ModifyProductFormConfig extends BaseFormConfig<UpdateProductRequest> {

    public SimpleDetailsConfig<String> nameConfig;
    public SimpleDetailsConfig<String> barCodeConfig;
    public TextFormConfig<BigDecimal> quantityFormConfig;
    public Product product;

}

