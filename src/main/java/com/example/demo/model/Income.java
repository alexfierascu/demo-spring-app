package com.example.demo.model;


import com.example.demo.enums.IncomeCategoryType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "income")
public class Income extends LineItem {

  @Enumerated(EnumType.STRING)
  @Column(name = "income_category")
  private IncomeCategoryType incomeCategory;
}
