package com.duy.BackendDoAn.repositories;

import com.duy.BackendDoAn.models.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AttractionRepository extends JpaRepository<Attraction, Long> {
    @Query("SELECT a FROM Attraction a " +
            "JOIN a.offices o " +
            "JOIN o.rentalFacility rf " +
            "WHERE a.city.id = :cityId " +
            "AND rf.id = :rentalFacilityId")
    List<Attraction> findAttractionsByCityAndRentalFacilityId(@Param("cityId") Long cityId,
                                                              @Param("rentalFacilityId") Long rentalFacilityId);

    @Query("SELECT a FROM Attraction a " +
            "WHERE a.city.id = :cityId " +
            "AND a.type <> 'Office'")
    List<Attraction> findAttractionsByCityAndExcludeTypeOffice(@Param("cityId") Long cityId);

}
