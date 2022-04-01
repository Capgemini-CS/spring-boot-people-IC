package com.people.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "color")
    private String color;

    @Column(name = "brand", nullable = false)
    private String brand;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

}
