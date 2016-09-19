create table users(
id int primary key not null auto_increment,
email varchar(255) unique not null,
password varchar(255) not null,
name varchar(255),
phoneNumber varchar(255),
location varchar(255),
typeOfUser varchar(255));

create table ads(
id int primary key not null auto_increment,
brand varchar(255) not null,
model varchar(255) not null,
category varchar(255) not null,
engine_by_fuel varchar(255) not null,
engine_capacity int not null,
power int,
transmission varchar(255) not null,
year int not null,
mileage int,
price int not null,
color varchar(255) not null,
date varchar(255) not null,
techFeatures varchar(1000),
additionalInfo varchar(500),
photos varchar(1000) ,
user_id int not null,
CONSTRAINT fk_adUser FOREIGN KEY (user_id)
REFERENCES users(id));