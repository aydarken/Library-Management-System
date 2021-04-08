package kz.lab9.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.lab9.models.Course;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "book")
    private Set<Course> course;

    private String name;
}