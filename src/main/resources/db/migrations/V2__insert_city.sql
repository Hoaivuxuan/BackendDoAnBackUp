INSERT INTO city (city_name, type, parent_id)
VALUES
('Hà Nội', 'Thành phố', NULL),
('Hồ Chí Minh', 'Thành phố', NULL),
('Đà Nẵng', 'Thành phố', NULL),
('Hải Phòng', 'Thành phố', NULL),
('Cần Thơ', 'Thành phố', NULL),
('Biên Hòa', 'Tỉnh', NULL),
('Nha Trang', 'Tỉnh', NULL),
('Hoàn Kiếm', 'Quận', 1),
('Ba Đình', 'Quận', 1);

INSERT INTO attraction (name, description, type, image, city_id)
VALUES
('Hồ Gươm', 'Hồ Gươm nằm ở trung tâm thành phố, gắn liền với lịch sử và văn hóa của Hà Nội.', 'Di tích lịch sử', 'ho_guom.jpg', 8),
('Lăng Chủ tịch Hồ Chí Minh', 'Lăng Bác là nơi lưu giữ thi hài của Chủ tịch Hồ Chí Minh.', 'Di tích lịch sử', 'lang_bac.jpg', 9),
('Chợ Bến Thành', 'Chợ nổi tiếng tại trung tâm thành phố Hồ Chí Minh.', 'Địa điểm mua sắm', 'cho_ben_thanh.jpg', 2),
('Cầu Rồng', 'Cây cầu độc đáo tại Đà Nẵng với hình dáng con rồng, có khả năng phun lửa.', 'Công trình kiến trúc', 'cau_rong.jpg', 3),
('Bãi biển Mỹ Khê', 'Bãi biển đẹp nhất Đà Nẵng, thu hút du khách.', 'Bãi biển', 'my_khe_beach.jpg', 3),
('Bảo tàng Quân đội', 'Bảo tàng lịch sử quân sự Việt Nam tại Hà Nội.', 'Bảo tàng', 'bao_tang_quan_doi.jpg', 1),
('Bảo tàng Cần Thơ', 'Bảo tàng giới thiệu về lịch sử và văn hóa Cần Thơ.', 'Bảo tàng', 'bao_tang_can_tho.jpg', 5),
('Vinpearl Land Nha Trang', 'Khu vui chơi giải trí hiện đại tại Nha Trang.', 'Khu vui chơi', 'vinpearl_land.jpg', 7),
('Chùa Dơi', 'Ngôi chùa nổi tiếng ở miền Tây, nơi sinh sống của nhiều loài dơi.', 'Di tích văn hóa', 'chua_doi.jpg', 5),
('Nhà thờ Đức Bà', 'Nhà thờ nổi tiếng tại trung tâm thành phố Hồ Chí Minh.', 'Công trình kiến trúc', 'nha_tho_duc_ba.jpg', 2),
('Văn phòng thuê xe ABC', 'Chuyên cung cấp các loại xe ô tô du lịch và xe máy cho thuê. Đội ngũ nhân viên nhiệt tình, chuyên nghiệp.', 'RENTAL', 'abc_office_image.jpg', 1),
('Dịch vụ thuê xe XYZ', 'Dịch vụ cho thuê xe máy, ô tô với giá cả phải chăng, thủ tục nhanh chóng.', 'RENTAL', 'xyz_office_image.jpg', 1),
('Công ty TNHH Thuê Xe 123', 'Cung cấp các dịch vụ thuê xe tự lái và có tài xế. Xe đời mới, đa dạng mẫu mã.', 'RENTAL', '123_office_image.jpg', 1),
('Văn phòng Thuê Xe Bình Minh', 'Địa điểm thuê xe uy tín, cung cấp các dòng xe từ phổ thông đến cao cấp.', 'RENTAL', 'binhminh_office_image.jpg', 1),
('Dịch vụ thuê xe Gia Hưng', 'Chuyên cho thuê xe du lịch, xe cưới hỏi và xe công tác dài hạn.', 'RENTAL', 'giahung_office_image.jpg', 1);


INSERT INTO users (name, first_name, last_name, phone_number, email, address, date_of_birth, active, password, role)
VALUES
('DUY', 'Duy', 'Nguyen', '0123456789', 'user1@com.example', '123 Main St', '1990-01-01', TRUE, 'password123', 'USER'),
('THANH', 'Thanh', 'Tran', '0987654321', 'user2@com.example', '456 Secondary St', '1995-05-05', TRUE, 'password456', 'ADMIN');

INSERT INTO accessory (name, price, type) VALUES
('Helmet', 10.00, 'MOTOR'),
('GPS', 15.00, 'CAR'),
('Child Seat', 20.00, 'CAR'),
('Phone Holder', 5.00, 'MOTOR'),
('Roof Rack', 25.00, 'CAR'),
('Bluetooth Speaker', 8.00, 'MOTOR'),
('First Aid Kit', 7.00, 'CAR'),
('Extra Battery', 12.00, 'MOTOR');

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





