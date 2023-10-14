# mock-case-module3
create table if not exists address
(
    address_id   int auto_increment
        primary key,
    city         varchar(45)      not null,
    district     varchar(45)      not null,
    house_number varchar(45)      not null,
    is_deleted   bit default b'0' not null
);

create table if not exists role
(
    role_id   int         not null
        primary key,
    role_name varchar(45) not null
);

create table if not exists seller
(
    user_id      int              not null
        primary key,
    username     varchar(45)      not null,
    password     text             not null,
    phone_number varchar(45)      not null,
    ho_ten       varchar(45)      not null,
    email        varchar(45)      not null,
    is_deleted   bit default b'0' not null
);

create table if not exists properties
(
    property_id    int auto_increment
        primary key,
    property_name  varchar(45)      not null,
    property_price mediumtext       not null,
    area           int              not null,
    address_id     int              not null,
    seller_id      int              not null,
    is_deleted     bit default b'0' not null,
    constraint address_id
        foreign key (address_id) references address (address_id),
    constraint seller_id
        foreign key (seller_id) references seller (user_id)
);

create table if not exists users
(
    user_id    int auto_increment
        primary key,
    username   varchar(45)      not null,
    password   text             not null,
    role_id    int              not null,
    is_deleted bit default b'0' not null,
    constraint role_id
        foreign key (role_id) references role (role_id)
);

