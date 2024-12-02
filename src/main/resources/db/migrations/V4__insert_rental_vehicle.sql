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

INSERT INTO accessory (name, price, type) VALUES
('Helmet', 10.00, 'MOTOR'),
('GPS', 15.00, 'CAR'),
('Child Seat', 20.00, 'CAR'),
('Phone Holder', 5.00, 'MOTOR'),
('Roof Rack', 25.00, 'CAR'),
('Bluetooth Speaker', 8.00, 'MOTOR'),
('First Aid Kit', 7.00, 'CAR'),
('Extra Battery', 12.00, 'MOTOR');
