INSERT INTO city (city_name, type, parent_id)
VALUES
-- Thành phố trực thuộc TW
('Hà Nội', 'thành phố', NULL),
('Hồ Chí Minh', 'thành phố', NULL),
('Đà Nẵng', 'thành phố', NULL),
('Hải Phòng', 'thành phố', NULL),
('Cần Thơ', 'thành phố', NULL),
('Huế', 'thành phố', NULL),
-- Thành phố trực thuộc TPTW
('Thủ Đức', 'thành phố', 2),
('Thủy Nguyên', 'thành phố', 4),
-- Các tỉnh còn lại
('An Giang', 'tỉnh', NULL),
('Bà Rịa-Vũng Tàu', 'tỉnh', NULL),
('Bắc Giang', 'tỉnh', NULL),
('Bắc Kạn', 'tỉnh', NULL),
('Bạc Liêu', 'tỉnh', NULL),
('Bắc Ninh', 'tỉnh', NULL),
('Bến Tre', 'tỉnh', NULL),
('Bình Định', 'tỉnh', NULL),
('Bình Dương', 'tỉnh', NULL),
('Bình Phước', 'tỉnh', NULL),
('Bình Thuận', 'tỉnh', NULL),
('Cà Mau', 'tỉnh', NULL),
('Cao Bằng', 'tỉnh', NULL),
('Đắk Lắk', 'tỉnh', NULL),
('Đắk Nông', 'tỉnh', NULL),
('Điện Biên', 'tỉnh', NULL),
('Đồng Nai', 'tỉnh', NULL),
('Đồng Tháp', 'tỉnh', NULL),
('Gia Lai', 'tỉnh', NULL),
('Hà Giang', 'tỉnh', NULL),
('Hà Nam', 'tỉnh', NULL),
('Hà Tĩnh', 'tỉnh', NULL),
('Hải Dương', 'tỉnh', NULL),
('Hậu Giang', 'tỉnh', NULL),
('Hòa Bình', 'tỉnh', NULL),
('Hưng Yên', 'tỉnh', NULL),
('Khánh Hòa', 'tỉnh', NULL),
('Kiên Giang', 'tỉnh', NULL),
('Kon Tum', 'tỉnh', NULL),
('Lai Châu', 'tỉnh', NULL),
('Lâm Đồng', 'tỉnh', NULL),
('Lạng Sơn', 'tỉnh', NULL),
('Lào Cai', 'tỉnh', NULL),
('Long An', 'tỉnh', NULL),
('Nam Định', 'tỉnh', NULL),
('Nghệ An', 'tỉnh', NULL),
('Ninh Bình', 'tỉnh', NULL),
('Ninh Thuận', 'tỉnh', NULL),
('Phú Thọ', 'tỉnh', NULL),
('Phú Yên', 'tỉnh', NULL),
('Quảng Bình', 'tỉnh', NULL),
('Quảng Nam', 'tỉnh', NULL),
('Quảng Ngãi', 'tỉnh', NULL),
('Quảng Ninh', 'tỉnh', NULL),
('Quảng Trị', 'tỉnh', NULL),
('Sóc Trăng', 'tỉnh', NULL),
('Sơn La', 'tỉnh', NULL),
('Tây Ninh', 'tỉnh', NULL),
('Thái Bình', 'tỉnh', NULL),
('Thái Nguyên', 'tỉnh', NULL),
('Thanh Hóa', 'tỉnh', NULL),
('Tiền Giang', 'tỉnh', NULL),
('Trà Vinh', 'tỉnh', NULL),
('Tuyên Quang', 'tỉnh', NULL),
('Vĩnh Long', 'tỉnh', NULL),
('Vĩnh Phúc', 'tỉnh', NULL),
('Yên Bái', 'tỉnh', NULL);

INSERT INTO attraction (name, latitude, longitude, address, type, image, city_id)
VALUES
(
    'Hồ Gươm',
    21.0285, 105.8520,
    'Phố Đinh Tiên Hoàng, Hoàn Kiếm, Hà Nội',
    'Di tích lịch sử',
    'ho_guom.jpg',
    1
),
(
    'Lăng Chủ tịch Hồ Chí Minh',
    21.0369, 105.8342,
    '2 Hùng Vương, Ba Đình, Hà Nội',
    'Di tích lịch sử',
    'lang_bac.jpg',
    1
),
(
    'Chợ Bến Thành',
    10.7725, 106.6981,
    'Quận 1, Thành phố Hồ Chí Minh',
    'Địa điểm mua sắm',
    'cho_ben_thanh.jpg',
    2
),
(
    'Cầu Rồng',
    16.0605, 108.2271,
    'Đường Nguyễn Văn Linh, Đà Nẵng',
    'Công trình kiến trúc',
    'cau_rong.jpg',
    3
),
(
    'Bãi biển Mỹ Khê',
    16.0599, 108.2496,
    'Đường Võ Nguyên Giáp, Đà Nẵng',
    'Bãi biển',
    'my_khe_beach.jpg',
    3
),
(
    'Bảo tàng Quân đội',
    21.0308, 105.8330,
    '28A Điện Biên Phủ, Ba Đình, Hà Nội',
    'Bảo tàng',
    'bao_tang_quan_doi.jpg',
    1
),
(
    'Bảo tàng Cần Thơ',
    10.0343, 105.7871,
    'Số 1 Đại lộ Hòa Bình, Cần Thơ',
    'Bảo tàng',
    'bao_tang_can_tho.jpg',
    5
),
(
    'Vinpearl Land Nha Trang',
    12.2388, 109.1967,
    'Đảo Hòn Tre, Nha Trang',
    'Khu vui chơi',
    'vinpearl_land.jpg',
    35
),
(
    'Chùa Dơi',
    9.6033, 105.9787,
    'Đường Lê Hồng Phong, Sóc Trăng',
    'Di tích văn hóa',
    'chua_doi.jpg',
    54
),
(
    'Nhà thờ Đức Bà',
    10.7798, 106.6994,
    'Quận 1, Thành phố Hồ Chí Minh',
    'Công trình kiến trúc',
    'nha_tho_duc_ba.jpg',
    2
);

-----------------------------------------------------------------------------------------------







