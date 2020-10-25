package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form.product;

import android.app.Activity;

import java.math.BigDecimal;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.InvoiceItemFormModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete.AutoCompleteTextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.price.PriceFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductAutoCompleteFormConfig extends BaseFormConfig<InvoiceItemFormModel> {

    private AutoCompleteTextFormConfig<String, ProductModel> productNameConfig;
    private TextFormConfig<String> quantityUnitConfig;
    public TextFormConfig<BigDecimal> quantityConfig;
    public PriceFormConfig priceFormConfig;
    private Activity activity;
    private List<ProductModel> availableProducts;

}
