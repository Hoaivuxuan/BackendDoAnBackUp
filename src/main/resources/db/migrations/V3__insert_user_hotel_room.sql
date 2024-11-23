--
INSERT INTO hotel (address, check_in_time, check_out_time, city_id, description, hotel_email, hotel_name, latitude, longitude, owner_id, phone_number, rating, total_rating, review_count, status, type_of_hotel, website)
VALUES
('123 Main St', '14:00', '12:00', 9, 'Located in the heart of the city', 'info@cityhotel.com', 'City Hotel', 21.0285, 105.8542, 1, '0909123456', 0, 0, 0,'confirmed', 'Luxury', 'www.cityhotel.com'),

('456 Beach Ave', '15:00', '11:00', 2, 'Beachfront hotel with stunning ocean views', 'contact@beachresort.com', 'Beach Resort', 20.9951, 105.8689, 1, '0909987654', 0,0, 0, 'confirmed', 'Resort', 'www.beachresort.com'),

('789 Mountain Rd', '13:00', '10:00', 3, 'Cozy mountain retreat ideal for relaxation', 'stay@mountainlodge.com', 'Mountain Lodge', 22.1234, 104.2234, 1, '0912345678', 0,0, 0, 'waiting', 'Lodge', 'www.mountainlodge.com'),

('101 Skyview Dr', '14:00', '12:00', 1, 'High-rise hotel with panoramic views of the city skyline', 'skyview@luxurytower.com', 'Luxury Tower', 21.1235, 105.8745, 1, '0911122334', 0,0, 0, 'confirmed', 'Luxury', 'www.luxurytower.com'),

('222 Countryside Lane', '16:00', '11:00', 4, 'Peaceful retreat located in the countryside', 'contact@farmstay.com', 'Farmstay Retreat', 20.8765, 106.5432,1, '0909234567', 0,0, 0, 'refused', 'Farmstay', 'www.farmstayretreat.com');


INSERT INTO room (available_rooms, description, hotel_id, max_guests, price_per_day, room_size, type_of_bed, type_of_room, view)
VALUES
(5, 'Standard room with basic amenities', 1, 2, 50.00, 20, 'Queen', 'Standard', 'City View'),
(3, 'Deluxe room with king-size bed and city view', 1, 3, 100.00, 30, 'King', 'Deluxe', 'City View'),
(8, 'Oceanfront room with direct access to the beach', 2, 4, 150.00, 40, 'Double', 'Beachfront', 'Ocean View'),
(6, 'Family suite with two bedrooms and beach access', 2, 6, 200.00, 60, 'Double', 'Suite', 'Ocean View'),
(10, 'Mountain-view room with a cozy atmosphere', 3, 2, 70.00, 25, 'Twin', 'Standard', 'Mountain View'),
(4, 'Luxury suite with panoramic mountain views', 3, 4, 250.00, 50, 'King', 'Suite', 'Mountain View'),
(7, 'Executive room with skyline view', 4, 2, 180.00, 35, 'King', 'Executive', 'City View'),
(5, 'Presidential suite with top-floor panoramic views', 4, 5, 400.00, 100, 'King', 'Presidential', 'City View'),
(6, 'Countryside room with garden access', 5, 2, 60.00, 20, 'Double', 'Standard', 'Garden View'),
(3, 'Farmhouse suite with views of the countryside', 5, 4, 120.00, 45, 'Queen', 'Suite', 'Countryside View');


INSERT INTO tour (name, address, start_time, end_time, description, city_id)
VALUES
('Tour khám phá thành phố', '123 Đường ABC, Quận 1', '2024-12-01 08:00:00', '2024-12-01 17:00:00', 'Một ngày khám phá thành phố với các điểm tham quan nổi bật.', 1),
('Tour du lịch sinh thái', '456 Đường DEF, Quận 2', '2024-12-02 09:00:00', '2024-12-02 18:00:00', 'Trải nghiệm du lịch sinh thái trong khu bảo tồn thiên nhiên.', 2),
('Tour leo núi', '789 Đường GHI, Quận 3', '2024-12-03 07:00:00', '2024-12-03 16:00:00', 'Hành trình leo núi với cảnh quan hùng vĩ.', 3);


INSERT INTO nearby_attraction (distance, hotel_id, tour_id)
VALUES
(4, 1, 1);


INSERT INTO hotel_image (image_url, hotel_id)
VALUES
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-01.jpg?alt=media&token=5dbb6493-370b-4040-b27d-1839319fd14b", 1),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-02.jpg?alt=media&token=100aafb6-52c3-44cd-9f3e-d6450a9ef133", 1),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-03.jpg?alt=media&token=02d05419-1248-4487-9885-c09ccc7026e3", 1);


INSERT INTO amenity_for_hotel (amenity_id, hotel_id) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1);

INSERT INTO hotel_policy (cancellation_policy, deposit_required, pets_allowed, smoking_policy, extra_bed_policy, hotel_id)
VALUES (
    'Hủy phòng miễn phí 24 giờ trước khi nhận phòng.',
    'Không cần đặt cọc.',
    true,
    'Không hút thuốc trong phòng.',
    'Không có giường phụ.',
    1
);

INSERT INTO amenity_for_room (amenity_id, room_id)
VALUES
(25, 1),
(26, 1),
(27, 1);


--INSERT INTO booking_room (booking_date, check_in_date, check_out_date, total_price, status, user_id)
--VALUES
--('2024-10-01', '2024-10-05', '2024-10-10', 500.00, 'confirmed', 1),
--('2024-10-02', '2024-10-06', '2024-10-11', 600.00, 'confirmed', 2),
--('2024-10-03', '2024-10-07', '2024-10-12', 700.00, 'confirmed', 3),
--('2024-10-04', '2024-10-08', '2024-10-13', 800.00, 'confirmed', 4),
--('2024-10-05', '2024-10-09', '2024-10-14', 900.00, 'confirmed', 5),
--('2024-10-06', '2024-10-10', '2024-10-15', 1000.00, 'confirmed', 6),
--('2024-10-07', '2024-10-11', '2024-10-16', 1100.00, 'confirmed', 7),
--('2024-10-08', '2024-10-12', '2024-10-17', 1200.00, 'confirmed', 1),
--('2024-10-09', '2024-10-13', '2024-10-18', 1300.00, 'confirmed', 2),
--('2024-10-10', '2024-10-14', '2024-10-19', 1400.00, 'confirmed', 3),
--('2024-10-11', '2024-10-15', '2024-10-20', 1500.00, 'confirmed', 4),
--('2024-10-12', '2024-10-16', '2024-10-21', 1600.00, 'confirmed', 5),
--('2024-10-13', '2024-10-17', '2024-10-22', 1700.00, 'confirmed', 6),
--('2024-10-14', '2024-10-18', '2024-10-23', 1800.00, 'confirmed', 7);
--
--
--INSERT INTO booked_room (amount, price_per, room_id, booking_room_id)
--VALUES
--(2, 150.00, 1, 1),
--(3, 200.00, 2, 2),
--(1, 180.00, 3, 3),
--(4, 220.00, 4, 4),
--(2, 170.00, 5, 5),
--(3, 250.00, 6, 6),
--(1, 140.00, 7, 7),
--(2, 160.00, 8, 8),
--(3, 190.00, 9, 9),
--(2, 210.00, 10, 10),
--(4, 230.00, 11, 11),
--(2, 200.00, 12, 12),
--(1, 150.00, 13, 13),
--(3, 240.00, 14, 14),
--(1, 150.00, 15, 1),
--(4, 230.00, 16, 2),
--(2, 180.00, 17, 3);
--
--INSERT INTO rental_facility (name, phone_number, email, description, address, city_id, owner_id)
--VALUES
--('Main Street Facility', '0123456789', 'main.street@example.com', 'Cozy facility in the heart of the city.', '123 Main St', 1, 1),
--('Beachside Retreat', '0987654321', 'beachside@example.com', 'Relaxing beachside retreat.', '456 Ocean Dr', 2, 2),
--('Mountain Escape', '0765432109', 'mountain.escape@example.com', 'Scenic mountain escape.', '789 Mountain Rd', 3, 3),
--('City Center Hub', '0123456780', 'city.center@example.com', 'Convenient city center location.', '101 Central Ave', 4, 4),
--('Countryside Villa', '0998765432', 'countryside.villa@example.com', 'Charming countryside villa.', '202 Country Ln', 5, 5),
--('Lakeside Lodge', '0976543210', 'lakeside.lodge@example.com', 'Peaceful lakeside lodge.', '303 Lakeview Blvd', 6, 6);
--
--
--
--
--
--
--
