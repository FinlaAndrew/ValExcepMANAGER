package com.UST.CompanyForm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Manager {
    @Id
    @GeneratedValue
    public Long id;
    public String name;
    public String dept;

}
