package com.example.demo.model;

import com.example.demo.enums.ExpenseCategoryType;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.Enumerated;

@Data
@Entity
@Table(name = "expense")
public class Expense extends LineItem{

    @Enumerated(EnumType.STRING)
    @Column(name = "expense_category")
    private ExpenseCategoryType expanseCategory;

}
