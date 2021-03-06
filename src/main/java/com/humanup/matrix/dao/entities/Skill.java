package com.humanup.matrix.dao.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString(of = {"id", "libelle", "description", "typeSkills", "persons"})
@Entity
@Table(name = "skill")
public class Skill implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "libelle")
  String libelle;

  @Column(name = "description")
  String description;

  @ManyToOne
  @JoinColumn(name = "type_id")
  TypeSkills typeSkills;

  @ManyToMany(
      fetch = FetchType.LAZY,
      cascade = {CascadeType.PERSIST, CascadeType.MERGE},
      mappedBy = "skills")
  Set<Person> persons = new HashSet<>();
}
