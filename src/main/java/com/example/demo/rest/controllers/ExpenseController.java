package com.example.demo.rest.controllers;

import com.example.demo.model.Expense;
import com.example.demo.service.ExpenseService;
import com.example.demo.validation.exceptions.HttpMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses(){
        List<Expense> expenses=expenseService.getAllExpenses();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity getExpenseById(@PathVariable("id") Integer id){
        Expense expense=expenseService.getExpenseById(id);
        return new ResponseEntity(expense, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Expense> createExpense(@Valid @RequestBody Expense newExpense){
        Expense createdExpense = expenseService.saveExpanse(newExpense);
        return new ResponseEntity(createdExpense, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable("id") Integer id, Expense newExpense){
        Expense updatedExpense = expenseService.updateExpanse(id, newExpense);
        return new ResponseEntity<>(updatedExpense, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpenseById(@PathVariable("id") Integer id){
        expenseService.deleteById(id);
        return new ResponseEntity(new HttpMessage("Expense deleted succesfully"), HttpStatus.OK);
    }
}
