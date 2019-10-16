package com.example.demo.repository;

import com.example.demo.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM expense WHERE ID = :id")
    public void deleteById(@Param("id") Integer id);
}
