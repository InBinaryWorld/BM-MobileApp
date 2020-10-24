package dev.szafraniak.bm_mobileapp.business.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import dev.szafraniak.bm_mobileapp.business.models.AmountModel;
import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.InvoiceItemFormModel;

public class FinancesUtils {

    public static BigDecimal safeCountGross(BigDecimal net, BigDecimal taxRate) {
        if (net == null || !Validator.validateNetPrice(net) ||
            taxRate == null || !Validator.validateTaxRate(taxRate)) {
            return null;
        }
        BigDecimal tax = taxRate.movePointLeft(2).multiply(net)
            .setScale(2, RoundingMode.HALF_UP);
        return tax.add(net);
    }

    public static AmountModel countAmount(InvoiceItemFormModel item) {
        Price price = item.getPrice();
        return countAmount(price.getNet(), price.getTaxRate(), item.getQuantity());
    }

    public static AmountModel countAmount(List<InvoiceItemFormModel> items) {
        List<AmountModel> taxGroupAmounts = items.stream()
            .collect(Collectors.groupingBy(item -> item.getPrice().getTaxRate()))
            .entrySet().stream().map(entry -> {
                BigDecimal taxRate = entry.getKey();
                List<BigDecimal> netAmounts = entry.getValue().stream().map(item ->
                    countNetAmount(item.getPrice().getNet(), item.getQuantity())
                ).collect(Collectors.toList());
                return countTaxGroupAmount(taxRate, netAmounts);
            }).collect(Collectors.toList());

        BigDecimal totalNet = sumBy(taxGroupAmounts, AmountModel::getNet);
        BigDecimal totalTax = sumBy(taxGroupAmounts, AmountModel::getTax);
        BigDecimal totalGross = sumBy(taxGroupAmounts, AmountModel::getGross);
        return new AmountModel(totalNet, totalTax, totalGross);
    }

    public static BigDecimal countNetAmount(BigDecimal netPrice, BigDecimal quantity) {
        return netPrice.setScale(2, RoundingMode.HALF_UP)
            .multiply(quantity).setScale(2, RoundingMode.HALF_UP);
    }

    public static AmountModel countAmount(BigDecimal netPrice, BigDecimal taxRate, BigDecimal quantity) {
        return countAmount(countNetAmount(netPrice, quantity), taxRate);
    }

    public static AmountModel countAmount(BigDecimal netAmount, BigDecimal taxRate) {
        BigDecimal tax = taxRate.movePointLeft(2).multiply(netAmount)
            .setScale(2, RoundingMode.HALF_UP);
        BigDecimal gross = netAmount.add(tax);
        return new AmountModel(netAmount, tax, gross);
    }

    public static AmountModel countTaxGroupAmount(BigDecimal taxRate, List<BigDecimal> netAmounts) {
        BigDecimal netAmount = sumBy(netAmounts, net -> net);
        return countAmount(netAmount, taxRate);
    }

    public static <T> BigDecimal sumBy(List<T> list, Function<T, BigDecimal> fieldFunc) {
        return list.stream().reduce(new BigDecimal("0"), (acc, next) -> acc.add(fieldFunc.apply(next)), BigDecimal::add);
    }

}
