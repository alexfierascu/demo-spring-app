package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Validated

public class LineItem {

  @Id
  @SequenceGenerator(name = "item_generator", allocationSize = 1, sequenceName = "item_seq")
  @GeneratedValue(generator = "item_generation", strategy = GenerationType.SEQUENCE)
  @Column(name = "id")
  private Integer id;

  @NotEmpty
  @Column(name = "description", nullable = false)
  private String description;

  @NotNull
  @Column(name = "date")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  private LocalDate date;

  @NotNull(message = "must not be absent")
  @Min(1)
  @Column(name = "sum", nullable = false)
  private Double sum;
}

