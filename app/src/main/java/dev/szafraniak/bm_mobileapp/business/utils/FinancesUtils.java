package dev.szafraniak.bm_mobileapp.business.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import dev.szafraniak.bm_mobileapp.business.models.entity.amount.Amount;
import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.InvoiceItemFormModel;
import lombok.Data;

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

    public static Amount countAmount(List<InvoiceItemFormModel> items) {
        List<TaxGroupAmountModel> taxGroups = groupByTax(items);
        BigDecimal totalNet = sumBy(taxGroups, TaxGroupAmountModel::getNet);
        BigDecimal totalTax = sumBy(taxGroups, TaxGroupAmountModel::getTax);
        BigDecimal totalGross = sumBy(taxGroups, TaxGroupAmountModel::getGross);
        Amount amount = new Amount();
        amount.setNet(totalNet);
        amount.setTax(totalTax);
        amount.setGross(totalGross);
        return amount;
    }

    public static Amount countAmount(InvoiceItemFormModel item) {
        BigDecimal quantity = item.getQuantity();
        Price price = item.getPrice();
        BigDecimal net = price.getNet().setScale(2, RoundingMode.HALF_UP)
            .multiply(quantity).setScale(2, RoundingMode.HALF_UP);
        BigDecimal tax = price.getTaxRate().movePointLeft(2).multiply(net)
            .setScale(2, RoundingMode.HALF_UP);
        BigDecimal gross = net.add(tax);
        Amount amount = new Amount();
        amount.setNet(net);
        amount.setTax(tax);
        amount.setGross(gross);
        return amount;
    }


    private static List<TaxGroupAmountModel> groupByTax(List<InvoiceItemFormModel> items) {
        return items.stream()
            .collect(Collectors.groupingBy(item -> item.getPrice().getTaxRate()))
            .entrySet().stream().map(entry -> {
                List<Amount> amounts = entry.getValue().stream()
                    .map(FinancesUtils::countAmount).collect(Collectors.toList());
                BigDecimal net = sumBy(amounts, Amount::getNet);
                BigDecimal tax = entry.getKey().movePointLeft(2).multiply(net)
                    .setScale(2, RoundingMode.HALF_UP);
                BigDecimal gross = net.add(tax);
                return new TaxGroupAmountModel(net, tax, gross, entry.getKey());
            }).collect(Collectors.toList());
    }

    private static <T> BigDecimal sumBy(List<T> list, Function<T, BigDecimal> fieldFunc) {
        return list.stream().reduce(new BigDecimal("0"), (acc, next) -> acc.add(fieldFunc.apply(next)), BigDecimal::add);
    }

    @Data
    private static class TaxGroupAmountModel {
        public TaxGroupAmountModel(BigDecimal net, BigDecimal tax, BigDecimal gross, BigDecimal taxRate) {
            this.net = net;
            this.tax = tax;
            this.gross = gross;
            this.taxRate = taxRate;
        }

        private BigDecimal net;
        private BigDecimal tax;
        private BigDecimal gross;
        private BigDecimal taxRate;
    }
}
