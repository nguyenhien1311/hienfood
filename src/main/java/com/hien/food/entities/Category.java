package com.hien.food.entities;

import com.hien.food.dto.CategoryDTO;
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
@Table(name = "categories")
public class Category implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @JdbcTypeCode(SqlTypes.CHAR)
  @Column(length = 36, columnDefinition = "VARCHAR(36)", insertable = false, updatable = false)
  private UUID id;

  @Column(name = "name", columnDefinition = "VARCHAR(200)")
  private String name;

  @Column(name = "image", columnDefinition = "VARCHAR(200)")
  private String image;

  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
  private List<Recipe> recipes;

  public CategoryDTO transformToDto() {
    return CategoryDTO.builder().id(this.id).name(this.name).image(this.image).build();
  }

}
