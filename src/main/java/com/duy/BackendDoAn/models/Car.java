package com.duy.BackendDoAn.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "car")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "car_id")
@SuperBuilder
@DiscriminatorValue("car")
public class Car extends Vehicle{
    @Column(name = "transmission")
    private String transmission_type;

    @Column(name = "baggage_capacity")
    private Long baggage_capacity;

    @Column(name = "seats")
    private Long seats;

}
