package com.example.demo.service;


import com.example.demo.model.Expense;
import com.example.demo.repository.ExpenseRepository;
import com.example.demo.validation.exceptions.BusinessValidationException;
import com.example.demo.validation.exceptions.HttpMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ExpenseService {

  @Autowired
  public ExpenseRepository expenseRepository;


  public List<Expense> getAllExpenses () {

    List<Expense> expenses = expenseRepository.findAll();
    return expenses;
  }


  public Expense getExpenseById (Integer id) {

    Optional<Expense> expenseOptional = expenseRepository.findById(id);
    if (!expenseOptional.isPresent()) {
      throw new BusinessValidationException(
          new HttpMessage("Requested Income was not found"),
          HttpStatus.OK
      );
    }
    Expense expense = expenseOptional.get();
    return expense;
  }


  public Expense saveExpanse (Expense newExpense) {

    Expense createdExpense = expenseRepository.save(newExpense);
    return createdExpense;
  }


  public Expense updateExpanse (Integer id, Expense newExpense) {

    if (!expenseRepository.existsById(id)) {
      throw new BusinessValidationException(new HttpMessage(""), HttpStatus.NOT_FOUND);
    }
    newExpense.setId(id);
    Expense updatedExpanse = expenseRepository.save(newExpense);
    return newExpense;
  }


  public void deleteById (Integer id) {

    expenseRepository.deleteById(id);
  }
}
