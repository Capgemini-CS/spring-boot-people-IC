package com.people.dto;

import com.people.entity.Car;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonDto {

    private Long id;

    private String name;

    private Integer age;

    private String cnp;

    private List<Car> cars;
}
