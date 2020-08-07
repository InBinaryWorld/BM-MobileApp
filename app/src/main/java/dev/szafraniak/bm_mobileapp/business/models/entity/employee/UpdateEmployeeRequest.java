package dev.szafraniak.bm_mobileapp.business.models.entity.employee;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class UpdateEmployeeRequest {

    private String jobPosition;

    private LocalDate firstEmploymentDate;

    private BigDecimal salary;

}
