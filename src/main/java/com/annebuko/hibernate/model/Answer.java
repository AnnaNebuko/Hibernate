package com.annebuko.hibernate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Answer {

  @Id
  @SequenceGenerator(
      name = "answer_sequence",
      sequenceName = "answer_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "answer_sequence"
  )
  Long id;

  //To solve recursive problem - @JsonIgnore
  //Because we do not want display question for each answer
  @JsonIgnore
  @ManyToMany(mappedBy = "answers")
  Set<Question> questions;
}
