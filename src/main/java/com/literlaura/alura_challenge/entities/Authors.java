package com.literlaura.alura_challenge.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "author")
public class Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long birthYear;
    private Long deathYear;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Books> books;

    public Authors() {
    }

    public Authors(String name, Long birthYear, Long deathYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }

    public String getBirthAndDeathYear(){
        return filterNullYears();
    }

    private String filterNullYears(){
        if(birthYear == null || deathYear == null){
            return "No hay datos de fecha de nacimiento o muerte";
        } else {
            return getBirthYear() + "-" + getDeathYear();
        }
    }
    @Override
    public String toString() {
            return "Nombre del autor: " + getName() + ", " + "\nFecha de nacimiento: " + filterNullYears();
        }
}
