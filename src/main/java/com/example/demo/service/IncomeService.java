package com.example.demo.service;


import com.example.demo.model.Income;
import com.example.demo.repository.IncomeRepository;
import com.example.demo.validation.exceptions.BusinessValidationException;
import com.example.demo.validation.exceptions.HttpMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class IncomeService {

  @Autowired
  private IncomeRepository incomeRepository;


  public List<Income> getAllIncomes () {

    List<Income> incomes = incomeRepository.findAll();
    return incomes;
  }


  public Income getIncomeById (Integer id) {

    Optional<Income> incomeOptional = incomeRepository.findById(id);
    if (!incomeOptional.isPresent()) {
      throw new BusinessValidationException(
          new HttpMessage("Requested Income was not found"),
          HttpStatus.NOT_FOUND
      );
    }
    Income income = incomeOptional.get();
    return income;
  }


  public Income saveIncome (Income newIncome) {

    Income createdIncome = incomeRepository.save(newIncome);
    return createdIncome;
  }


  public Income updateIncome (Integer id, Income newIncome) {

    if (!incomeRepository.existsById(id)) {
      throw new BusinessValidationException(new HttpMessage(
          "Requested Income could not be updated as it does not exist"), HttpStatus.NOT_FOUND);
    }
    newIncome.setId(id);
    Income updateIncome = incomeRepository.save(newIncome);
    return updateIncome;
  }


  public void deleteById (Integer id) {

    incomeRepository.deleteById(id);
  }
}
