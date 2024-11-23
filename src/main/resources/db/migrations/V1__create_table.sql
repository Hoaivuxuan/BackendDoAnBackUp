CREATE TABLE users (
    id INT auto_increment primary key,
    name varchar(100),
    first_name varchar(100),
    last_name varchar(100),
    phone_number varchar(20) unique,
    avatar varchar(255),
    email varchar(255) not null unique,
    country varchar(255),
    address varchar(255),
    date_of_birth DATE,
    active TINYINT(1),
    password varchar(100) not null,
    role varchar(100)
);

CREATE TABLE city (
    id INT AUTO_INCREMENT PRIMARY KEY,
    city_name NVARCHAR(100) NOT NULL,
    type NVARCHAR(100),
    parent_id INT
);


CREATE TABLE hotel (
    id INT AUTO_INCREMENT PRIMARY KEY,
    hotel_name NVARCHAR(100) NOT NULL,
    hotel_email NVARCHAR(100),
    phone_number NVARCHAR(20),
    address NVARCHAR(255),
    longitude FLOAT,
    latitude FLOAT,
    description TEXT,
    check_in_time TIME,
    check_out_time TIME,
    website NVARCHAR(255),
    rating FLOAT,
    total_rating INT,
    review_count INT,
    city_id INT,
    owner_id INT,
    status NVARCHAR(255),
    type_of_hotel NVARCHAR(255),
    CONSTRAINT fk_hotel_city FOREIGN KEY (city_id) REFERENCES city(id),
    CONSTRAINT fk_hotel_owner FOREIGN KEY (owner_id) REFERENCES users(id)
);

CREATE TABLE hotel_image (
    id INT AUTO_INCREMENT PRIMARY KEY,
    image_url NVARCHAR(255),
    hotel_id INT,
    CONSTRAINT fk_hotel_image_hotel FOREIGN KEY (hotel_id) REFERENCES hotel(id)
);


CREATE TABLE room (
    id INT AUTO_INCREMENT PRIMARY KEY,
    price_per_day FLOAT,
    description TEXT,
    max_guests INT,
    room_size INT,
    view NVARCHAR(255),
    available_rooms INT,
    hotel_id INT,
    type_of_room NVARCHAR(255),
    type_of_bed NVARCHAR(255),
    CONSTRAINT fk_room_hotel FOREIGN KEY (hotel_id) references hotel(id)
);

create table amenity (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name NVARCHAR(255)
);

create table amenity_for_room (
    id INT AUTO_INCREMENT PRIMARY KEY,
    amenity_id INT,
    room_id INT,
    CONSTRAINT fk_amenity_for_room_amenity FOREIGN KEY (amenity_id) REFERENCES amenity(id),
    CONSTRAINT fk_amenity_for_room_room FOREIGN KEY (room_id) REFERENCES room(id)
);


CREATE TABLE booking_room (
    id INT AUTO_INCREMENT PRIMARY KEY,
    booking_date DATE,
    adults INT,
    children INT,
    check_in_date DATE,
    check_out_date DATE,
    total_price FLOAT,
    total_rooms INT,
    status NVARCHAR(255),
    user_id INT,
    CONSTRAINT fk_booking_room_users foreign key (user_id) references users(id)
);

CREATE TABLE booked_room (
    id INT AUTO_INCREMENT PRIMARY KEY,
    amount INT,
    price_per FLOAT,
    room_id INT,
    booking_room_id INT,
    CONSTRAINT fk_booked_room_room foreign key (room_id) references room(id),
    CONSTRAINT fk_booked_room_booking foreign key (booking_room_id) references booking_room(id)
);


CREATE TABLE rental_facility (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name NVARCHAR(100) NOT NULL,
    phone_number NVARCHAR(20),
    email NVARCHAR(100),
    description TEXT,
    address TEXT,
    city_id INT,
    owner_id INT,
    CONSTRAINT fk_rental_facility_city FOREIGN KEY (city_id) REFERENCES city(id),
    CONSTRAINT fk_rental_facility_owner FOREIGN KEY (owner_id) REFERENCES users(id)
);


CREATE TABLE vehicle (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name NVARCHAR(255),
    price_per_hour FLOAT,
    stake FLOAT,
    image_url NVARCHAR(255),
    description TEXT,
    seat_amount INT,
    luggage_amount INT,
    facility_id INT,
    fuel_type NVARCHAR(255),
    vehicle_type NVARCHAR(255),
    CONSTRAINT fk_motor_rental_facility foreign key (facility_id) references rental_facility(id)
);


CREATE TABLE motor (
    motor_id INT PRIMARY KEY,
    type_of_motor NVARCHAR(255),
    handle_bar_type NVARCHAR(255),
    FOREIGN KEY (motor_id) references vehicle(id)
);


CREATE TABLE car (
    car_id INT PRIMARY KEY,
    transmission_type NVARCHAR(255),
    trunk_capacity NVARCHAR(255),
    FOREIGN KEY (car_id) references vehicle(id)
);

CREATE TABLE booking_vehicle (
    id INT AUTO_INCREMENT PRIMARY KEY,
    booking_date DATE,
    start_date DATE,
    start_time TIME,
    start_address NVARCHAR(255),
    return_date DATE,
    return_time TIME,
    return_address NVARCHAR(255),
    total_price FLOAT,
    user_id INT,
    vehicle_id INT,
    CONSTRAINT fk_booking_motor_users foreign key (user_id) references users(id),
    CONSTRAINT fk_booking_motor_motor foreign key (vehicle_id) references vehicle(id)
);

create table accessory (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name NVARCHAR(255),
    price FLOAT,
    type NVARCHAR(255)
);

CREATE TABLE accessory_booking (
    id INT AUTO_INCREMENT PRIMARY KEY,
    price_per FLOAT,
    accessory_id INT,
    booking_vehicle_id INT,
    CONSTRAINT fk_service_booking_service foreign key (accessory_id) references accessory(id),
    CONSTRAINT fk_service_booking_booking foreign key (booking_vehicle_id) references booking_vehicle(id)
);


CREATE TABLE tour (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name NVARCHAR(255),
    address NVARCHAR(255),
    start_time TIME,
    end_time TIME,
    description TEXT,
    city_id INT,
    CONSTRAINT fk_tour_city foreign key (city_id) references city(id)
);

CREATE TABLE tour_image (
    id INT AUTO_INCREMENT PRIMARY KEY,
    image_url NVARCHAR(255),
    tour_id INT,
    CONSTRAINT fk_tour_image_tour foreign key (tour_id) references tour(id)
);


CREATE TABLE ticket_class (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name NVARCHAR(255),
    adult_price FLOAT,
    children_price FLOAT,
    available_ticket INT,
    description TEXT,
    tour_id INT,
    CONSTRAINT fk_ticket_class_tour foreign key (tour_id) references tour(id)
);

CREATE TABLE profit (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name NVARCHAR(255)
);

CREATE TABLE ticket_profit (
    id INT AUTO_INCREMENT PRIMARY KEY,
    profit_id INT,
    ticket_class_id INT,
    CONSTRAINT fk_ticket_profit_profit foreign key (profit_id) references profit(id),
    CONSTRAINT fk_ticket_profit_ticket foreign key (ticket_class_id) references ticket_class(id)
);

CREATE TABLE booking_ticket (
    id INT AUTO_INCREMENT PRIMARY KEY,
    booking_date DATE,
    tour_date DATE,
    number_adult_ticket INT,
    number_children_ticket INT,
    total_price FLOAT,
    ticket_class_id INT,
    user_id INT,
    CONSTRAINT fk_booking_ticket_ticket foreign key (ticket_class_id) references ticket_class(id),
    CONSTRAINT fk_booking_ticket_user foreign key (user_id) references users(id)
);

CREATE TABLE review (
    id INT AUTO_INCREMENT PRIMARY key,
    rating INT,
    comment TEXT,
    review_date DATE,
    hotel_id INT,
    user_id INT,
    CONSTRAINT fk_evaluation_hotel foreign key (hotel_id) references hotel(id),
    CONSTRAINT fk_evaluation_user foreign key (user_id) references users(id)
);

CREATE TABLE nearby_attraction (
    id INT AUTO_INCREMENT PRIMARY KEY,
    distance FLOAT,
    hotel_id INT,
    tour_id INT,
    CONSTRAINT fk_nearby_hotel foreign key (hotel_id) references hotel(id),
    CONSTRAINT fk_nearby_tour foreign key (tour_id) references tour(id)
);

CREATE TABLE hotel_policy (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cancellation_policy NVARCHAR(255),
    deposit_required NVARCHAR(255),
    pets_allowed TINYINT(1),
    smoking_policy NVARCHAR(255),
    extra_bed_policy NVARCHAR(255),
    hotel_id INT,
    CONSTRAINT fk_policy_hotel foreign key (hotel_id) references hotel(id)
);

CREATE TABLE amenity_for_hotel (
    id INT AUTO_INCREMENT PRIMARY KEY,
    amenity_id INT,
    hotel_id INT,
    CONSTRAINT fk_amenity_for_hotel_amenity FOREIGN KEY (amenity_id) REFERENCES amenity(id),
    CONSTRAINT fk_amenity_for_hotel_hotel FOREIGN KEY (hotel_id) REFERENCES hotel(id)
);













