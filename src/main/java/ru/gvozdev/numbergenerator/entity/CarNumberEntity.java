package ru.gvozdev.numbergenerator.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "car_number")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarNumberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer lettersNumb;
    private Integer numberValue;
    private String country;
    private Integer stateValue;

}
