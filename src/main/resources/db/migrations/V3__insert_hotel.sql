--
INSERT INTO hotel (
    hotel_name, hotel_email, phone_number, address, longitude, latitude, description,
    check_in_time, check_out_time, website, rating, total_rating, review_count,
    city_id, type_of_hotel, cancellation_policy, deposit_required, pets_allowed,
    smoking_policy, extra_bed_policy
) VALUES
(
    'The Ascott Apartments',
    'reservations@theascott.com',
    '+842838272688',
    '72 Nguyễn Thị Minh Khai, Quận 3, TP. Hồ Chí Minh',
    106.6902, 10.7622,
    'Một căn hộ hiện đại với đầy đủ tiện nghi, tọa lạc tại trung tâm TP. Hồ Chí Minh, nơi bạn có thể dễ dàng tiếp cận các điểm tham quan nổi tiếng như Bảo tàng Mỹ thuật và Công viên Tao Đàn.',
    '14:00',
    '12:00',
    'https://www.ascott.com',
    4.5, 180, 85, 2,
    'Apartment',
    'Hủy miễn phí trong vòng 48 giờ trước khi nhận phòng.',
    'Yes',
    1, 0, 0
),
(
    'Furama Resort Danang',
    'reservations@furamadanang.com',
    '+842363847888',
    '105 Võ Nguyên Giáp, Khuê Mỹ, Ngũ Hành Sơn, Đà Nẵng',
    108.2563, 16.0600,
    'Khu nghỉ dưỡng cao cấp nằm sát bãi biển với các tiện ích như spa, nhà hàng và hồ bơi rộng lớn, mang đến trải nghiệm nghỉ dưỡng đẳng cấp cho du khách với các dịch vụ cao cấp, lý tưởng cho kỳ nghỉ gia đình hoặc các buổi hội nghị.',
    '15:00',
    '12:00',
    'https://www.furamadanang.com',
    4.6, 340, 200, 3,
    'Resort',
    'Hủy miễn phí trong vòng 72 giờ trước khi nhận phòng.',
    'Yes',
    1, 0, 1
),
(
    'Vinhomes Central Park',
    'info@vinhomescentralpark.com',
    '+842837205353',
    '720A Điện Biên Phủ Landmark, Bình Thạnh, TP. Hồ Chí Minh',
    106.7060, 10.7919,
    'Căn hộ dịch vụ sang trọng nằm trong khu đô thị Vinhomes Central Park với các tiện nghi hiện đại như trung tâm thương mại, công viên xanh và tiện ích cao cấp, là lựa chọn lý tưởng cho các chuyến công tác dài ngày hoặc gia đình.',
    '14:00',
    '12:00',
    'https://www.vinhomescentralpark.com',
    4.7, 310, 190, 2,
    'Apartment',
    'Hủy miễn phí trong vòng 48 giờ trước khi nhận phòng.',
    'Yes',
    1, 0, 0
),
(
    'Anantara Mui Ne Resort',
    'reservations@anantaramuine.com',
    '+842523740999',
    'Bãi biển Mũi Né, 12A Nguyễn Đình Chiểu, Hàm Tiên, Phan Thiết, Bình Thuận',
    108.1918, 10.9408,
    'Khu nghỉ dưỡng cao cấp với các biệt thự sang trọng, dịch vụ spa và các hoạt động ngoài trời, tọa lạc tại bãi biển Mui Ne nổi tiếng, lý tưởng cho những ai muốn tận hưởng không gian thư giãn giữa thiên nhiên biển xanh.',
    '15:00',
    '12:00',
    'https://www.anantaramuine.com',
    4.6, 280, 160, 19, 'Resort',
    'Hủy miễn phí trong vòng 72 giờ trước khi nhận phòng.',
    'Yes',
    1, 0, 1
),
(
    'Azerai La Residence',
    'contact@azerailaresidence.com',
    '+842323837474',
    '05 Lê Lợi, TP. Huế, Thừa Thiên-Huế',
    107.5869, 16.4627,
    'Khu nghỉ dưỡng này mang đến một không gian thư giãn với các phòng nghỉ sang trọng, dịch vụ spa cao cấp, và các hoạt động ngoài trời thú vị, là điểm đến lý tưởng cho những ai muốn khám phá văn hóa và lịch sử tại thành phố Huế.',
    '14:00',
    '12:00',
    'https://www.azerailaresidence.com',
    4.8, 400, 250, 6,
    'Resort',
    'Hủy miễn phí trong vòng 72 giờ trước khi nhận phòng.',
    'Yes',
    1, 0, 1
),
(
    'Alma Resort Cam Ranh',
    'contact@alma.com.vn',
    '+842583589999',
    'Khu du lịch Bắc Bán đảo Cam Ranh, Cam Hải Đông, Cam Lâm, Khánh Hòa',
    109.1856, 12.1714,
    'Khu nghỉ dưỡng biển này cung cấp không gian thoải mái với các biệt thự ven biển, khu vui chơi nước cho trẻ em, nhà hàng đẳng cấp và các hoạt động thể thao mạo hiểm, rất phù hợp cho kỳ nghỉ gia đình và nhóm bạn.',
    '14:00',
    '12:00',
    'https://www.alma.com.vn',
    4.7, 390, 230, 35,
    'Resort',
    'Hủy miễn phí trong vòng 48 giờ trước khi nhận phòng.',
    'Yes',
    1, 0, 1
),
(
    'InterContinental Hanoi Westlake',
    'reservations@ichotelsgroup.com',
    '+842462708888',
    '5 Từ Hoa, Quảng An, Tây Hồ, Hà Nội',
    105.8559, 21.0840,
    'Khách sạn 5 sao này nằm ven hồ Tây, cung cấp phòng nghỉ sang trọng và dịch vụ tuyệt vời, là lựa chọn lý tưởng cho các chuyến công tác và kỳ nghỉ dài ngày tại thủ đô Hà Nội.',
    '15:00',
    '12:00',
    'https://www.intercontinental.com/hanoi',
    4.5, 310, 210, 1,
    'Hotel',
    'Hủy miễn phí trong vòng 72 giờ trước khi nhận phòng.',
    'Yes',
    1, 0, 1
),
(
    'Vinpearl Resort & Spa Phu Quoc',
    'reservations@vinpearl.com',
    '+842973559999',
    'Bãi Dài, Gành Dầu, Phú Quốc, Kiên Giang',
    103.9753, 10.2540,
    'Khu nghỉ dưỡng Vinpearl trên đảo Phú Quốc nổi bật với các biệt thự sang trọng, công viên nước và bãi biển riêng, là nơi lý tưởng để thư giãn và vui chơi cùng gia đình hoặc bạn bè.',
    '15:00',
    '12:00',
    'https://www.vinpearl.com',
    4.6, 280, 190, 36,
    'Resort',
    'Hủy miễn phí trong vòng 72 giờ trước khi nhận phòng.',
    'Yes',
    1, 0, 1
),
(
    'Grand Mercure Danang',
    'contact@grandmercuredanang.com',
    '+842363961800',
    'Lô A1 Khu biệt thự Đảo Xanh, Hòa Cường Bắc, Hải Châu, Đà Nẵng',
    108.2113, 16.0700,
    'Khách sạn Grand Mercure nằm tại bãi biển trung tâm Đà Nẵng, cung cấp phòng nghỉ hiện đại, nhà hàng chất lượng và khu vực hồ bơi tuyệt vời, là lựa chọn hoàn hảo cho kỳ nghỉ thư giãn hoặc các hội nghị công ty.',
    '14:00',
    '12:00',
    'https://www.grandmercuredanang.com',
    4.5, 270, 175, 1,
    'Hotel',
    'Hủy miễn phí trong vòng 48 giờ trước khi nhận phòng.',
    'Yes',
    1, 0, 1
),
(
    'Muong Thanh Grand Hanoi','info@muongthanh.com',
    '+842439288888',
    'CC2, Bắc Linh Đàm, Hoàng Mai, Hà Nội',
    105.7598, 21.0275,
    'Khách sạn Muong Thanh Grand cung cấp các phòng nghỉ tiện nghi, gần trung tâm thủ đô Hà Nội với các dịch vụ như phòng hội nghị và nhà hàng sang trọng, là lựa chọn lý tưởng cho du khách công tác và nghỉ dưỡng.',
    '14:00',
    '12:00',
    'https://www.muongthanh.com',
    4.3, 320, 210, 1,
    'Hotel',
    'Hủy miễn phí trong vòng 48 giờ trước khi nhận phòng.',
    'Yes',
    1, 0, 1
),
(
    'Sheraton Hanoi Hotel',
    'reservations@sheratonhanoi.com',
    '+842437199000',
    'K5 Nghi Tàm, 11 Xuân Diệu, Quảng An, Tây Hồ, Hà Nội',
    105.8467, 21.0425,
    'Khách sạn Sheraton Hanoi mang đến không gian nghỉ dưỡng sang trọng với các tiện nghi cao cấp, nhà hàng phong cách quốc tế, và dịch vụ thư giãn như spa và phòng tập gym, rất phù hợp cho du khách công tác và nghỉ dưỡng dài ngày.',
    '15:00',
    '12:00',
    'https://www.sheratonhanoi.com',
    4.6, 360, 220, 1,
    'Hotel',
    'Hủy miễn phí trong vòng 72 giờ trước khi nhận phòng.',
    'Yes',
    1, 0, 1
),
(
    'Saigon Prince Hotel',
    'contact@saigonprince.com',
    '+842838220288',
    '63 Nguyễn Huệ, Bến Nghé, Quận 1, TP. Hồ Chí Minh',
    106.6959, 10.7624,
    'Khách sạn Saigon Prince tọa lạc tại vị trí đắc địa trong khu trung tâm thành phố Hồ Chí Minh, cung cấp các phòng nghỉ tiện nghi và dịch vụ chuyên nghiệp, là lựa chọn tuyệt vời cho các chuyến công tác và du lịch.',
    '14:00',
    '12:00',
    'https://www.saigonprince.com',
    4.4, 300, 180, 1,
    'Hotel',
    'Hủy miễn phí trong vòng 48 giờ trước khi nhận phòng.',
    'Yes',
    1, 0, 0
),
(
    'Ninh Chu Hotel',
    'info@ninhchu.com',
    '+842583227777',
    'Khu phố Ninh Chu, Phan Rang, Ninh Thuận',
    108.9733, 11.5926,
    'Ninh Chu Hotel là một khách sạn 3 sao gần biển Ninh Chu, với các phòng nghỉ rộng rãi và tầm nhìn ra biển. Khách sạn cung cấp các dịch vụ tiện nghi như spa, nhà hàng và khu vực tắm nắng, lý tưởng cho kỳ nghỉ gia đình hoặc các chuyến du lịch cuối tuần.',
    '14:00',
    '12:00',
    'https://www.ninhchu.com',
    4.3, 180, 100, 1,
    'Hotel',
    'Hủy miễn phí trong vòng 72 giờ trước khi nhận phòng.',
    'Yes',
    1, 0, 1
),
(
    'Mui Ne Paradise',
    'contact@muineparadise.com',
    '+842523840011',
    '130D Nguyễn Đình Chiểu, Mũi Né, Phan Thiết, Bình Thuận',
    108.2469, 10.9400,
    'Mui Ne Paradise là khu nghỉ dưỡng ven biển với các biệt thự sang trọng, hồ bơi lớn và nhà hàng phục vụ ẩm thực quốc tế. Khách sạn mang đến một không gian thư giãn tuyệt vời, thích hợp cho du khách yêu thích biển cả và những buổi tối lãng mạn.',
    '15:00',
    '12:00',
    'https://www.muineparadise.com',
    4.7, 320, 200, 19,
    'Resort',
    'Hủy miễn phí trong vòng 48 giờ trước khi nhận phòng.',
    'Yes',
    1, 0, 1
);


INSERT INTO room (
    name, type, room_size, max_guests, type_bed_1, no_bed_1, type_bed_2, no_bed_2,
    price, available_rooms, hotel_id
) VALUES
-- Phòng cho Sunset Paradise Hotel (hotel_id = 1)
('Ocean View Deluxe', 'Deluxe', 50, 3, 'King', 1, NULL, 0, 200.0, 10, 1),
('Family Suite', 'Suite', 80, 5, 'Queen', 2, 'Single', 1, 350.0, 5, 1),
('Standard Room', 'Standard', 30, 2, 'Double', 1, NULL, 0, 120.0, 15, 1),

-- Phòng cho Mountain View Inn (hotel_id = 2)
('Mountain View Room', 'Deluxe', 40, 3, 'Queen', 1, NULL, 0, 180.0, 8, 2),
('Nature Suite', 'Suite', 70, 4, 'Queen', 2, NULL, 0, 300.0, 4, 2),
('Budget Room', 'Standard', 25, 2, 'Single', 2, NULL, 0, 100.0, 12, 2),

-- Phòng cho Urban Central Hotel (hotel_id = 3)
('City View Executive', 'Executive', 45, 3, 'King', 1, NULL, 0, 220.0, 7, 3),
('Business Suite', 'Suite', 60, 4, 'Queen', 1, 'Single', 1, 280.0, 6, 3),
('Compact Room', 'Standard', 20, 2, 'Double', 1, NULL, 0, 90.0, 20, 3);


INSERT INTO amenity (name) VALUES
('Wi-Fi miễn phí'),
('Bể bơi'),
('Dịch vụ giặt là'),
('Trung tâm thể dục'),
('Bãi đỗ xe miễn phí'),
('Nhà hàng'),
('Dịch vụ phòng'),
('Spa và chăm sóc sức khỏe'),
('Quầy bar'),
('Phòng hội nghị'),
('Đưa đón sân bay'),
('Phòng không hút thuốc'),
('Tiện nghi cho người khuyết tật'),
('Sân chơi trẻ em'),
('Máy điều hòa'),
('TV màn hình phẳng'),
('Tủ lạnh mini'),
('Két sắt'),
('Máy pha cà phê'),
('Bàn làm việc'),
('Ban công riêng'),
('Bồn tắm'),
('Đồ vệ sinh cá nhân miễn phí'),
('Máy sấy tóc'),
('Dép đi trong phòng'),
('Điện thoại nội bộ'),
('Bộ ấm chén'),
('Dịch vụ báo thức'),
('Wifi trong phòng');

INSERT INTO nearby_attraction (distance, hotel_id, attraction_id)
VALUES
(4, 1, 1);


INSERT INTO hotel_image (image_url, hotel_id)
VALUES
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-01.jpg?alt=media&token=5dbb6493-370b-4040-b27d-1839319fd14b", 1),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-02.jpg?alt=media&token=100aafb6-52c3-44cd-9f3e-d6450a9ef133", 1),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-03.jpg?alt=media&token=02d05419-1248-4487-9885-c09ccc7026e3", 1),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-01.jpg?alt=media&token=5dbb6493-370b-4040-b27d-1839319fd14b", 2),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-02.jpg?alt=media&token=100aafb6-52c3-44cd-9f3e-d6450a9ef133", 2),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-03.jpg?alt=media&token=02d05419-1248-4487-9885-c09ccc7026e3", 2),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-01.jpg?alt=media&token=5dbb6493-370b-4040-b27d-1839319fd14b", 3),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-02.jpg?alt=media&token=100aafb6-52c3-44cd-9f3e-d6450a9ef133", 3),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-03.jpg?alt=media&token=02d05419-1248-4487-9885-c09ccc7026e3", 3),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-01.jpg?alt=media&token=5dbb6493-370b-4040-b27d-1839319fd14b", 4),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-02.jpg?alt=media&token=100aafb6-52c3-44cd-9f3e-d6450a9ef133", 4),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-03.jpg?alt=media&token=02d05419-1248-4487-9885-c09ccc7026e3", 4),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-01.jpg?alt=media&token=5dbb6493-370b-4040-b27d-1839319fd14b", 5),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-02.jpg?alt=media&token=100aafb6-52c3-44cd-9f3e-d6450a9ef133", 5),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-03.jpg?alt=media&token=02d05419-1248-4487-9885-c09ccc7026e3", 5),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-01.jpg?alt=media&token=5dbb6493-370b-4040-b27d-1839319fd14b", 6),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-02.jpg?alt=media&token=100aafb6-52c3-44cd-9f3e-d6450a9ef133", 6),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-03.jpg?alt=media&token=02d05419-1248-4487-9885-c09ccc7026e3", 6),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-01.jpg?alt=media&token=5dbb6493-370b-4040-b27d-1839319fd14b", 7),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-02.jpg?alt=media&token=100aafb6-52c3-44cd-9f3e-d6450a9ef133", 7),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-03.jpg?alt=media&token=02d05419-1248-4487-9885-c09ccc7026e3", 7),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-01.jpg?alt=media&token=5dbb6493-370b-4040-b27d-1839319fd14b", 8),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-02.jpg?alt=media&token=100aafb6-52c3-44cd-9f3e-d6450a9ef133", 8),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-03.jpg?alt=media&token=02d05419-1248-4487-9885-c09ccc7026e3", 8),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-01.jpg?alt=media&token=5dbb6493-370b-4040-b27d-1839319fd14b", 9),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-02.jpg?alt=media&token=100aafb6-52c3-44cd-9f3e-d6450a9ef133", 9),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-03.jpg?alt=media&token=02d05419-1248-4487-9885-c09ccc7026e3", 9),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-01.jpg?alt=media&token=5dbb6493-370b-4040-b27d-1839319fd14b", 10),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-02.jpg?alt=media&token=100aafb6-52c3-44cd-9f3e-d6450a9ef133", 10),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-03.jpg?alt=media&token=02d05419-1248-4487-9885-c09ccc7026e3", 10),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-01.jpg?alt=media&token=5dbb6493-370b-4040-b27d-1839319fd14b", 11),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-02.jpg?alt=media&token=100aafb6-52c3-44cd-9f3e-d6450a9ef133", 11),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-03.jpg?alt=media&token=02d05419-1248-4487-9885-c09ccc7026e3", 11),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-01.jpg?alt=media&token=5dbb6493-370b-4040-b27d-1839319fd14b", 12),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-02.jpg?alt=media&token=100aafb6-52c3-44cd-9f3e-d6450a9ef133", 12),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-03.jpg?alt=media&token=02d05419-1248-4487-9885-c09ccc7026e3", 12),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-01.jpg?alt=media&token=5dbb6493-370b-4040-b27d-1839319fd14b", 13),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-02.jpg?alt=media&token=100aafb6-52c3-44cd-9f3e-d6450a9ef133", 13),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-03.jpg?alt=media&token=02d05419-1248-4487-9885-c09ccc7026e3", 13),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-01.jpg?alt=media&token=5dbb6493-370b-4040-b27d-1839319fd14b", 14),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-02.jpg?alt=media&token=100aafb6-52c3-44cd-9f3e-d6450a9ef133", 14),
("https://firebasestorage.googleapis.com/v0/b/travel-web-7b510.appspot.com/o/hotel%2Fimage-03.jpg?alt=media&token=02d05419-1248-4487-9885-c09ccc7026e3", 14);

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











