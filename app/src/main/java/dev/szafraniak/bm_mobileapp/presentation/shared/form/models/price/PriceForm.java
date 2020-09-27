package dev.szafraniak.bm_mobileapp.presentation.shared.form.models.price;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.business.utils.FinancesUtils;
import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.editText.number.DecimalEditTextDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.number.DecimalEditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.number.IntegerEditTextFormRow;

public class PriceForm extends BaseForm<Price, BaseViewHolder, PriceFormConfig> implements FormInterface<Price> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group;

    DecimalEditTextFormRow netFormRow;
    IntegerEditTextFormRow taxRateFormRow;
    DecimalEditTextDetails grossDetails;


    public PriceForm(LayoutInflater inflater, ViewGroup viewGroup, PriceFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    public Price getValue() {
        BigDecimal net = netFormRow.getValue();
        BigDecimal taxRate = taxRateFormRow.getValue();
        if (net == null && taxRate == null) {
            return null;
        }
        BigDecimal gross = FinancesUtils.safeCountGross(net, taxRate);
        Price price = new Price();
        price.setNet(net);
        price.setTaxRate(taxRate);
        price.setGross(gross);
        return price;
    }

    @Override
    public boolean isValid() {
        return netFormRow.isValid() && taxRateFormRow.isValid();
    }

    @Override
    protected void showValueOnView(Price value) {
        if (value == null) {
            netFormRow.setValue(null);
            taxRateFormRow.setValue(null);
            grossDetails.setValue(null);
            return;
        }
        netFormRow.setValue(value.getNet());
        taxRateFormRow.setValue(value.getTaxRate());
        grossDetails.setValue(value.getGross());
    }

    @Override
    protected BaseViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, PriceFormConfig config) {
        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);

        netFormRow = new DecimalEditTextFormRow(inflater, groupList, config.getNetConfig());
        taxRateFormRow = new IntegerEditTextFormRow(inflater, groupList, config.getTaxConfig());
        grossDetails = new DecimalEditTextDetails(inflater, groupList, config.getGrossConfig());

        groupList.addView(netFormRow.getView());
        groupList.addView(taxRateFormRow.getView());
        groupList.addView(grossDetails.getView());

        BaseViewHolder holder = new BaseViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(PriceFormConfig config) {
        netFormRow.setOnValidationStateChanged(this::onFieldStateChanged);
        taxRateFormRow.setOnValidationStateChanged(this::onFieldStateChanged);
        netFormRow.setOnValueChange(this::updateGrossView);
        taxRateFormRow.setOnValueChange(this::updateGrossView);
        setValue(config.getInitValue());
    }

    void onFieldStateChanged(boolean isValid) {
        onValueChange();
    }

    private void updateGrossView(boolean isValid) {
        if (isValid()) {
            BigDecimal net = netFormRow.getValue();
            BigDecimal taxRate = taxRateFormRow.getValue();
            BigDecimal gross = FinancesUtils.safeCountGross(net, taxRate);
            grossDetails.setValue(gross);
        } else {
            grossDetails.setValue(null);
        }
    }

}
