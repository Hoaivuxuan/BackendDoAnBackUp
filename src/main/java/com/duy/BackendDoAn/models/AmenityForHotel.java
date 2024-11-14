package com.duy.BackendDoAn.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "amenity_for_hotel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AmenityForHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "amenity_id")
    private Amenity amenity;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
