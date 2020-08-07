package dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount;

import lombok.Data;

@Data
public class CreateBankAccountRequest {

    private String name;

    private String value;

}
