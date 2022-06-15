package com.annebuko.hibernate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Topic {
  @Id
  @SequenceGenerator(
      name = "topic_sequence",
      sequenceName = "topic_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "topic_sequence"
  )
  Long id;

  //One topic has many questions
  @JsonIgnore
  @OneToMany(mappedBy = "topic")
  Set<Question> questions;
}
