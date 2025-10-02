package demo;

import java.time.Instant;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

@Table("book")
public class Book {
  @Id
  private Long id;

  private String title;
  private String author;
  @Column("created_at")
  private Instant createdAt = Instant.now();

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }
  public String getAuthor() { return author; }
  public void setAuthor(String author) { this.author = author; }
  public Instant getCreatedAt() { return createdAt; }
  public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
