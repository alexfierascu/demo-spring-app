package com.example.demo.repository;


import com.example.demo.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Transactional
@Repository
public interface IncomeRepository extends JpaRepository<Income, Integer> {

  @Modifying
  @Query(nativeQuery = true, value = "DELETE FROM income WHERE ID = :id")
  void deleteById (@Param("id") Integer id);
}

