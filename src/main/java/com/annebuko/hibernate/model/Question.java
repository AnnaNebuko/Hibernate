package com.annebuko.hibernate.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Question {

  @Id
  @SequenceGenerator(
      name = "etest_sequence",
      sequenceName = "etest_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "etest_sequence"
  )
  Long id;

  @ManyToMany
  @JoinTable(
      name = "etests_answers",
      joinColumns = @JoinColumn(name = "etest_id"),
      inverseJoinColumns = @JoinColumn(name = "answer_id")
  )
  Set<Answer> answers;

  @Column(nullable = false)
  // OneToMany relationship with Difficulty
  Long complexity_id;

}
