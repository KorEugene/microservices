create table products
(
    id          bigserial primary key,
    title       varchar(255),
    price       int,
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);
insert into products (title, price)
values ('Bread', 25),
       ('Milk', 80),
       ('Cheese', 450),
       ('Watermelon', 150),
       ('Melon', 250),
       ('Strawberry', 500),
       ('Lemon', 100),
       ('Meat', 450),
       ('Fish', 450),
       ('Onion', 450);
