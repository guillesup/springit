package com.vega.springit.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Link extends Auditable {

  @Id @GeneratedValue private Long id;
  private String title;
  private String url;

  @OneToMany(mappedBy = "link")
  private Set<Comment> comments = new HashSet<>();
}
