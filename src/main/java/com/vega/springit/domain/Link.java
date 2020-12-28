package com.vega.springit.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Link extends Auditable implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull private String title;
  @NotNull private String url;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "link", orphanRemoval = true)
  private List<Comment> comments = new ArrayList<>();

  public Link(@NotNull String title, @NotNull String url) {
    this.title = title;
    this.url = url;
  }

  public void addComment(Comment comment) {
    this.comments.add(comment);
    comment.setLink(this);
  }

  public void removeComment(Comment comment) {
    this.comments.remove(comment);
    comment.setLink(null);
  }

  public void removeAllComments() {
    for (Comment comment : this.comments) {
      comment.setLink(null);
    }

    this.comments.clear();
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Link link = (Link) o;
    return this.id != null && this.id.equals(link.id);
  }

  @Override
  public String toString() {
    return "Link{" + "id=" + id + ", title='" + title + '\'' + ", url='" + url + '\'' + '}';
  }
}
