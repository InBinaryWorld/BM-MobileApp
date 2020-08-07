package dev.szafraniak.bm_mobileapp.business.models.entity.employee;

import java.math.BigDecimal;
import java.time.LocalDate;

import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import lombok.Data;

@Data
public class Employee {

    private Long id;

    private IndividualContact individualContact;

    private String jobPosition;

    private LocalDate firstEmploymentDate;

    private BigDecimal salary;

}
