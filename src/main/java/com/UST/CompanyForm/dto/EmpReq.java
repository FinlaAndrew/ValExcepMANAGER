package com.UST.CompanyForm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpReq {
        @Id
        @GeneratedValue
        @NotNull(message="Name required")
        @Size(min=5,max=20)
        public String name;
        @NotBlank(message="Required field")
        public String dept;

}

