package com.duy.BackendDoAn.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hotel_policy")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelPolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cancellation_policy")
    private String cancellation_policy;

    @Column(name = "deposit_required")
    private String deposit_required;

    @Column(name = "pets_allowed")
    private boolean pets_allowed;

    @Column(name = "smoking_policy")
    private String smoking_policy;

    @Column(name = "extra_bed_policy")
    private String extra_bed_policy;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @JsonBackReference
    private Hotel hotel;
}
