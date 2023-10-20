package dev.jgranizo.inditex.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;;

@Entity
@Table(name = "BRANDS")
public class Brands {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Getter
    @Setter
    @Column(name = "NAME", nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(name = "CREATION_DATE", nullable = false)
    private Long creationDate;

    @Getter
    @Setter
    @Column(name = "MODIFICATION_DATE", nullable = false)
    private Long modificationDate;

}
