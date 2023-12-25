create database aadhar_db;
use aadhar_db;

create table aadhar_master(
	aadharId varchar(50) not null,
    firstName varchar(50) not null,
    lastName varchar(50) not null,
    phoneNo varchar(10) not null,
    address varchar(100) not null,
    primary key(aadharId)
);

insert into aadhar_master (aadharId,firstName,lastName,address,phoneNo) values ('123456789010', 'Robert','Smith','#25, Millers Road, Banglore','875656987');
insert into aadhar_master (aadharId,firstName,lastName,address,phoneNo) values ('123456789011', 'Jack','Williams','#25/31, Cunningham Road, Banglore','9663525543');
insert into aadhar_master (aadharId,firstName,lastName,address,phoneNo) values ('123456789012', 'Jane','Miller','Twin Bunglow, Hinjewadi, Pune','9865311466');
insert into aadhar_master (aadharId,firstName,lastName,address,phoneNo) values ('123456789013', 'Thomas','Lewis','F-10, Jubilee Hills, Hyderabad','9086542321');
insert into aadhar_master (aadharId,firstName,lastName,address,phoneNo) values ('123456789014', 'Richard','Thompson','764, GachchiBowli, Hyderabad','9086543227');
insert into aadhar_master (aadharId,firstName,lastName,address,phoneNo) values ('123456789015', 'Steve','Phillip','11, Dollars Colony, Bangalore','8765407633');
insert into aadhar_master (aadharId,firstName,lastName,address,phoneNo) values ('123456789016', 'Frank','Taylor','543, JP Nagar, Mysore','8509782211');
insert into aadhar_master (aadharId,firstName,lastName,address,phoneNo) values ('123456789017', 'Christopher','Brown','679, Bandra, Mumbai','7654322093');
insert into aadhar_master (aadharId,firstName,lastName,address,phoneNo) values ('123456789018', 'John','Wilson','345, Andheri Mumbai','9765094321');
insert into aadhar_master (aadharId,firstName,lastName,address,phoneNo) values ('123456789019', 'Sophia','Jones','76/R, Pimple, Pune','906217649');