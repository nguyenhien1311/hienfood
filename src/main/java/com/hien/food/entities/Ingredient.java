package com.hien.food.entities;

import com.hien.food.dto.IngredientDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ingredients")
public class Ingredient implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @JdbcTypeCode(SqlTypes.CHAR)
  @Column(length = 36, columnDefinition = "VARCHAR(36)", insertable = false, updatable = false)
  private UUID id;

  @Column(name = "name", columnDefinition = "VARCHAR(200)")
  private String name;

  @Column(name = "image", columnDefinition = "VARCHAR(200)")
  private String image;

  @Column(name = "unit", columnDefinition = "VARCHAR(200)")
  private String unit;

  @ManyToOne
  @JoinColumn(name = "type_id")
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Type ingredientType;

  @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL)
  private List<RecipeDetail> detail;

  public IngredientDTO transformToDTO() {
    return IngredientDTO.builder()
        .id(this.id)
        .name(this.name)
        .unit(this.unit)
        .build();
  }

}
