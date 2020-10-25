package dev.szafraniak.bm_mobileapp.presentation.menu.product.create;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.business.models.entity.product.CreateProductRequest;
import dev.szafraniak.bm_mobileapp.presentation.menu.product.create.model.ProductModelSpinnerFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateProductFormConfig extends BaseFormConfig<CreateProductRequest> {

    public ProductModelSpinnerFormConfig productModelConfig;
    public TextFormConfig<BigDecimal> quantityConfig;

}

