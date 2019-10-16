package com.example.demo.rest.controllers;


import com.example.demo.model.Income;
import com.example.demo.service.IncomeService;
import com.example.demo.validation.exceptions.HttpMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path = "/incomes")
public class IncomeController {

  @Autowired
  private IncomeService incomeService;


  @GetMapping
  public ResponseEntity<List<Income>> getAllIncomes () {

    List<Income> incomes = incomeService.getAllIncomes();
    return new ResponseEntity(incomes, HttpStatus.OK);
  }


  @GetMapping("/{id}")
  public ResponseEntity<Income> getIncomeById (@PathVariable("id") Integer id) {

    Income income = incomeService.getIncomeById(id);
    return new ResponseEntity(income, HttpStatus.OK);
  }


  @PostMapping
  public ResponseEntity<Income> createIncome (@Valid @RequestBody Income newIncome) {

    Income createdIncome = incomeService.saveIncome(newIncome);
    return new ResponseEntity(createdIncome, HttpStatus.CREATED);
  }


  @PutMapping("/{id}")
  public ResponseEntity<Income> updateIncome (
      @PathVariable("id") Integer id,
      @Valid @RequestBody Income newIncome
  ) {

    Income updateIncome = incomeService.updateIncome(id, newIncome);
    return new ResponseEntity<>(updateIncome, HttpStatus.OK);
  }


  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteIncomeById (@PathVariable("id") Integer id) {

    incomeService.deleteById(id);
    return new ResponseEntity(new HttpMessage("Income deleted succesfully"), HttpStatus.OK);
  }
}
