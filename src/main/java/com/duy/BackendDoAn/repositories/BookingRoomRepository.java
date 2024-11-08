package com.duy.BackendDoAn.repositories;

import com.duy.BackendDoAn.models.BookingRoom;
import com.duy.BackendDoAn.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BookingRoomRepository extends JpaRepository<BookingRoom, Long> {
    Page<BookingRoom> findByUser(User user, Pageable pageable);
}
