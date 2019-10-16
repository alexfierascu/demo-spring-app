package com.example.demo.model;


import com.example.demo.enums.ExpenseCategoryType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "expense")
public class Expense extends LineItem {

  @Enumerated(EnumType.STRING)
  @Column(name = "expense_category")
  private ExpenseCategoryType expanseCategory;

}
