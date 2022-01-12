package entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity(name = "book")
@Table(name = "CARTI")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "autor", length = 100)
    private String author;

    public Book(String author) {
        this.author = author;
    }

    public Book(long l, String author) {
    }
}
