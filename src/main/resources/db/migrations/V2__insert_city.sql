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





