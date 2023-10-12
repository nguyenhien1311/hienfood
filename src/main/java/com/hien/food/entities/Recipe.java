package com.hien.food.entities;

import com.hien.food.dto.RecipeDTO;
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
@Table(name = "recipes")
public class Recipe implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @JdbcTypeCode(SqlTypes.CHAR)
  @Column(length = 36, columnDefinition = "VARCHAR(36)", insertable = false, updatable = false)
  private UUID id;

  @Column(name = "name", columnDefinition = "VARCHAR(200)")
  private String name;

  @Column(name = "image", columnDefinition = "VARCHAR(200)")
  private String image;

  @Column(name = "description", columnDefinition = "VARCHAR(200)")
  private String description;

  @ManyToOne
  @JoinColumn(name = "category_id")
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Category category;

  @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
  private List<RecipeDetail> detail;

  public RecipeDTO transformToDto() {
    return RecipeDTO.builder()
        .id(this.id)
        .name(this.name)
        .image(this.image)
        .description(this.description)
        .build();
  }

}
