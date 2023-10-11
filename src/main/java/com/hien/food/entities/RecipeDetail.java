package com.hien.food.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "recipe_detail")
public class RecipeDetail implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @JdbcTypeCode(SqlTypes.CHAR)
  @Column(length = 36, columnDefinition = "VARCHAR(36)", insertable = false, updatable = false)
  private UUID id;

  @Column(name = "amount", columnDefinition = "INT")
  private Integer amount;

  @ManyToOne
  @JoinColumn(name = "recipe_id")
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Recipe recipe;

  @ManyToOne
  @JoinColumn(name = "ingredient_id")
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Ingredient ingredient;

}
