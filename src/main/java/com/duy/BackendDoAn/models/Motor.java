package com.duy.BackendDoAn.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "motor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "motor_id")
@SuperBuilder
@DiscriminatorValue("MOTOR")
public class Motor extends Vehicle {
    @Column(name = "capacity")
    private String capacity;
}
