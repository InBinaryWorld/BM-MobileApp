package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.price;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.Constance;
import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.business.utils.FinancesUtils;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.editText.number.DecimalEditTextDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.number.DecimalEditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.number.IntegerEditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.BaseViewHolder;

public class PriceForm extends BaseForm<Price, BaseViewHolder, PriceFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group;

    DecimalEditTextFormRow netFormRow;
    IntegerEditTextFormRow taxRateFormRow;
    DecimalEditTextDetails grossDetails;

    public PriceForm(LayoutInflater inflater, ViewGroup viewGroup, PriceFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void updateView(boolean isValid) {
        if (isValid()) {
            BigDecimal net = netFormRow.getValue();
            BigDecimal taxRate = taxRateFormRow.getValue();
            BigDecimal gross = FinancesUtils.safeCountGross(net, taxRate);
            grossDetails.setValue(gross);
        } else {
            grossDetails.setValue(null);
        }
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
        price.setGross(gross);
        price.setTaxRate(taxRate);
        price.setCurrency(Constance.CURRENCY);
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
    protected void setupView(LayoutInflater inflater, PriceFormConfig config) {
        netFormRow.setOnValueChange(this::onValueChange);
        taxRateFormRow.setOnValueChange(this::onValueChange);
    }

}
