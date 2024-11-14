package com.duy.BackendDoAn.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "room")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price_per_day")
    private Float price_per_day;

    @Column(name = "description")
    private String description;

    @Column(name = "max_guests")
    private Long max_guests;

    @Column(name = "room_size")
    private Long room_size;

    @Column(name = "view")
    private String view;

    @Column(name = "available_rooms")
    private Long available_room;

    @Column(name = "type_of_room")
    private String type_of_room;

    @Column(name = "type_of_bed")
    private String type_of_bed;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @JsonBackReference
    private Hotel hotel;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<AmenityForRoom> amenityForRooms;
}
