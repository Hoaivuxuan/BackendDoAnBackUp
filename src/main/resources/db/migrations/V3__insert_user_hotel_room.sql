--
INSERT INTO hotel (
    hotel_name, hotel_email, phone_number, address, longitude, latitude, description,
    check_in_time, check_out_time, website, rating, total_rating, review_count,
    city_id, type_of_hotel, cancellation_policy, deposit_required, pets_allowed,
    smoking_policy, extra_bed_policy
) VALUES
(
    'Sunset Paradise Hotel',
    'contact@sunsetparadise.com',
    '+84 123 456 789',
    '123 Beach Road, Nha Trang',
    109.1952,
    12.2388,
    'A luxurious hotel with sea-facing rooms and top-notch amenities.',
    '14:00',
    '12:00',
    'https://sunsetparadise.com',
    4.7,
    235,
    150,
    1,  -- city_id (giả định)
    'Luxury',
    'Free cancellation up to 48 hours before check-in.',
    'Yes',
    1,  -- pets_allowed
    0,  -- smoking_policy
    1   -- extra_bed_policy
),
(
    'Mountain View Inn',
    'info@mountainview.com',
    '+84 987 654 321',
    '456 Hill Street, Da Lat',
    108.4453,
    11.9404,
    'A cozy mountain retreat perfect for nature lovers.',
    '15:00',
    '11:00',
    'https://mountainviewinn.com',
    4.5,
    180,
    90,
    2,  -- city_id (giả định)
    'Boutique',
    'Non-refundable within 24 hours of check-in.',
    'No',
    0,
    1,
    0
),
(
    'Urban Central Hotel',
    'reservations@urbancentral.vn',
    '+84 456 789 012',
    '789 City Center, Ho Chi Minh City',
    106.7009,
    10.7769,
    'Modern hotel in the heart of the city with excellent connectivity.',
    '13:00',
    '12:00',
    'https://urbancentral.vn',
    4.3,
    320,
    210,
    3,  -- city_id (giả định)
    'Business',
    'Free cancellation up to 72 hours before check-in.',
    'Yes',
    1,
    0,
    1
);


INSERT INTO room (available_rooms, description, hotel_id, max_guests, price_per_day, room_size, type_of_bed, type_of_room, view)
VALUES
(5, 'Standard room with basic amenities', 1, 2, 50.00, 20, 'Queen', 'Standard', 'City View'),
(3, 'Deluxe room with king-size bed and city view', 1, 3, 100.00, 30, 'King', 'Deluxe', 'City View'),
(8, 'Oceanfront room with direct access to the beach', 2, 4, 150.00, 40, 'Double', 'Beachfront', 'Ocean View'),
(6, 'Family suite with two bedrooms and beach access', 2, 6, 200.00, 60, 'Double', 'Suite', 'Ocean View'),
(10, 'Mountain-view room with a cozy atmosphere', 3, 2, 70.00, 25, 'Twin', 'Standard', 'Mountain View');


INSERT INTO tour (name, address, start_time, end_time, description, attraction_id)
VALUES
('Tour khám phá thành phố', '123 Đường ABC, Quận 1', '2024-12-01 08:00:00', '2024-12-01 17:00:00', 'Một ngày khám phá thành phố với các điểm tham quan nổi bật.', 1),
('Tour du lịch sinh thái', '456 Đường DEF, Quận 2', '2024-12-02 09:00:00', '2024-12-02 18:00:00', 'Trải nghiệm du lịch sinh thái trong khu bảo tồn thiên nhiên.', 2),
('Tour leo núi', '789 Đường GHI, Quận 3', '2024-12-03 07:00:00', '2024-12-03 16:00:00', 'Hành trình leo núi với cảnh quan hùng vĩ.', 3);


INSERT INTO nearby_attraction (distance, hotel_id, attraction_id)
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

INSERT INTO amenity_for_room (amenity_id, room_id)
VALUES
(25, 1),
(26, 1),
(27, 1);


-- V1__insert_rental_facility_data.sql
INSERT INTO rental_facility (name, phone_number, email, description, address, attraction_id, rating, total_rating, review_count)
VALUES
('Hoàn Kiếm Bike Rental', '024-12345678', 'info@hoankiemrental.vn', 'Dịch vụ cho thuê xe đạp quanh Hồ Gươm.', 'Số 10 phố Hàng Bạc, Hoàn Kiếm, Hà Nội', 1, 4.5, 450, 100),
('Ba Đình Motorbike Rental', '024-23456789', 'contact@badinhmotor.vn', 'Cho thuê xe máy, thuận tiện di chuyển quanh Ba Đình.', 'Số 20 Đội Cấn, Ba Đình, Hà Nội', 2, 4.6, 320, 85),
('Bến Thành Scooter Rental', '028-98765432', 'support@benthanhscooter.vn', 'Cho thuê xe tay ga tại trung tâm TP.HCM.', 'Số 5 Lê Lợi, Quận 1, TP.HCM', 3, 4.8, 700, 150),
('Mỹ Khê Car Rental', '0236-4567890', 'info@mykhecarrental.vn', 'Dịch vụ cho thuê ô tô gần bãi biển Mỹ Khê.', 'Đường Võ Nguyên Giáp, Đà Nẵng', 5, 4.7, 600, 120),
('Cần Thơ Bicycle Rental', '0292-5678901', 'booking@canthobike.vn', 'Cho thuê xe đạp tham quan thành phố Cần Thơ.', 'Số 25 Nguyễn Trãi, Ninh Kiều, Cần Thơ', 7, 4.3, 200, 50),
('Vinpearl Nha Trang Car Rental', '0258-1234567', 'contact@vinpearlcarrental.com', 'Dịch vụ thuê xe sang tại Vinpearl Land Nha Trang.', 'Đảo Hòn Tre, Nha Trang', 8, 4.9, 1200, 300),
('Bến Thành Motor Rental', '028-34567890', 'info@benthanhmotor.vn', 'Cho thuê xe máy gần chợ Bến Thành.', 'Số 12 Nguyễn An Ninh, Quận 1, TP.HCM', 3, 4.4, 480, 110),
('Cầu Rồng Scooter Rental', '0236-6789012', 'support@cauRongscooter.vn', 'Dịch vụ cho thuê xe máy gần Cầu Rồng.', 'Số 8 Trần Hưng Đạo, Đà Nẵng', 4, 4.5, 350, 90),
('Cần Thơ Car Rental', '0292-6789012', 'contact@canthocarrental.vn', 'Dịch vụ cho thuê ô tô gần Chùa Dơi.', 'Số 3 Nguyễn Trung Trực, Cần Thơ', 9, 4.6, 400, 100),
('Đức Bà Bike Rental', '028-78901234', 'info@ducbabikerental.vn', 'Cho thuê xe đạp tham quan Nhà thờ Đức Bà.', 'Số 15 Hai Bà Trưng, Quận 1, TP.HCM', 10, 4.3, 380, 95);








