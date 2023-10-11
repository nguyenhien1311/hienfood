package com.hien.food.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "types")
public class Type implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @JdbcTypeCode(SqlTypes.CHAR)
  @Column(length = 36, columnDefinition = "VARCHAR(36)", insertable = false, updatable = false)
  private UUID id;

  @Column(name = "name", columnDefinition = "VARCHAR(200)")
  private String name;

  @Column(name = "image", columnDefinition = "VARCHAR(200)")
  private String image;

  @OneToMany(mappedBy = "ingredientType", cascade = CascadeType.ALL)
  private List<Ingredient> ingredients;

}
