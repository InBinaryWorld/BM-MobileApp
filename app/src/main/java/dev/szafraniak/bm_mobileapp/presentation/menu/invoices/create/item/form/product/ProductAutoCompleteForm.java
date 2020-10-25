package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form.product;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.LayoutRes;

import com.google.android.gms.vision.barcode.Barcode;

import java.math.BigDecimal;
import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.InvoiceItemFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form.ItemType;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete.product.ProductNameAutoCompleteForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.number.DecimalEditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.text.TextEditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.price.PriceForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.scanner.BarcodeCallback;
import dev.szafraniak.bm_mobileapp.presentation.shared.scanner.Scanner;

public class ProductAutoCompleteForm extends BaseForm<InvoiceItemFormModel, BaseViewHolder, ProductAutoCompleteFormConfig> implements BarcodeCallback {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group;

    ProductNameAutoCompleteForm productNameForm;
    DecimalEditTextFormRow quantityForm;
    TextEditTextFormRow quantityUnitForm;
    PriceForm priceForm;

    public ProductAutoCompleteForm(LayoutInflater inflater, ViewGroup viewGroup, ProductAutoCompleteFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void updateView(boolean isValid) {
    }

    @Override
    protected void showValueOnView(InvoiceItemFormModel value) {
        if (value == null) {
            productNameForm.setValue(null);
            quantityUnitForm.setValue(null);
            quantityForm.setValue(null);
            priceForm.setValue(null);
            return;
        }
        productNameForm.setValue(value.getName());
        quantityUnitForm.setValue(value.getQuantityUnit());
        quantityForm.setValue(value.getQuantity());
        priceForm.setValue(value.getPrice());
    }

    @Override
    protected BaseViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, ProductAutoCompleteFormConfig config) {
        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);

        productNameForm = new ProductNameAutoCompleteForm(inflater, groupList, config.getProductNameConfig());
        quantityUnitForm = new TextEditTextFormRow(inflater, groupList, config.getQuantityUnitConfig());
        quantityForm = new DecimalEditTextFormRow(inflater, groupList, config.getQuantityConfig());
        priceForm = new PriceForm(inflater, groupList, config.getPriceFormConfig());

        groupList.addView(productNameForm.getView());
        groupList.addView(quantityUnitForm.getView());
        groupList.addView(quantityForm.getView());
        groupList.addView(priceForm.getView());

        BaseViewHolder holder = new BaseViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, ProductAutoCompleteFormConfig config) {
        Scanner scanner = new Scanner(config.getActivity());
        scanner.addBarcodeListener(this);
        productNameForm.setOnScannerIconClick(scanner::openScanner);
        productNameForm.setOnValidationStateChanged(this::onValueChange);
        quantityUnitForm.setOnValidationStateChanged(this::onValueChange);
        quantityForm.setOnValidationStateChanged(this::onValueChange);
        priceForm.setOnValidationStateChanged(this::onValueChange);
        productNameForm.addOnItemSelected(item -> {
            quantityUnitForm.setValue(item.getQuantityUnit());
            priceForm.setValue(item.getPriceSuggestion());
        });
    }

    @Override
    public void onBarcode(Barcode barcode) {
        String code = barcode.displayValue;
        ProductAutoCompleteFormConfig config = getConfig();
        List<ProductModel> products = config.getAvailableProducts();
        ProductModel product = products.stream()
            .filter(item -> code.equals(item.getBarcode()))
            .findFirst().orElse(null);

        if (product == null) {
            Toast.makeText(getConfig().getActivity(), "No match found", Toast.LENGTH_LONG).show();
            return;
        }
        InvoiceItemFormModel model = new InvoiceItemFormModel();
        model.setName(product.getName());
        model.setPrice(product.getPriceSuggestion());
        model.setQuantityUnit(product.getQuantityUnit());
        setValue(model);
    }


    @Override
    public InvoiceItemFormModel getValue() {
        String name = productNameForm.getValue();
        BigDecimal quantity = quantityForm.getValue();
        String unit = quantityUnitForm.getValue();
        Price price = priceForm.getValue();
        if (name == null && quantity == null && unit == null && price == null) {
            return null;
        }
        InvoiceItemFormModel invoiceItem = new InvoiceItemFormModel();
        invoiceItem.setName(name);
        invoiceItem.setQuantity(quantity);
        invoiceItem.setQuantityUnit(unit);
        invoiceItem.setPrice(price);
        invoiceItem.setType(ItemType.PRODUCT);
        return invoiceItem;
    }

    @Override
    public boolean isValid() {
        return productNameForm.isValid() && quantityForm.isValid()
            && quantityUnitForm.isValid() && priceForm.isValid();
    }


}
