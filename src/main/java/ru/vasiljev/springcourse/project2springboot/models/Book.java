package ru.vasiljev.springcourse.project2springboot.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Название не должно быть не пустым")
    @Size(min = 2, max = 50, message = "Название должно содержать от 2 до 50 символов")
    private String name;

    @Column(name = "author")
    @NotEmpty(message = "Поле автор не должно быть не пустым")
    private String author;

    @Column(name = "year")
    @Min(value = -1, message = "Год выпуска должен быть больше 0")
    private int year;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

    @Column(name = "owned_at")
    private LocalDateTime ownedAt;

    public Book() {

    }

    public Book(int id, String name, String author, int year) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public LocalDateTime getOwnedAt() {
        return ownedAt;
    }

    public void setOwnedAt(LocalDateTime ownedAt) {
        this.ownedAt = ownedAt;
    }

    public boolean isOverdue() {
        return LocalDateTime.now().isAfter(this.getOwnedAt().plusDays(10));
    }

}
