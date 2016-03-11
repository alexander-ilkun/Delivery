INSERT INTO `delivery`.`roles`(`id`, `name`) VALUES 
	('1', 'ROLE_ADMIN'),
	('2', 'ROLE_USER');

INSERT INTO `delivery`.`pizzas`(`id`, `name`, `price`, `type`) VALUES
	('1', 'Caribbean', 4.0, 'SEA'),
	('2', 'Meatza', 6.0, 'MEAT'),
	('3', 'Brooklyn', 6.0, 'VEGETARIAN'),
	('4', 'Barbecue', 8.0, 'MEAT'),
	('5', 'Carbonara', 8.0, 'MEAT');
 
INSERT INTO `delivery`.`bonus_cards`(`id`, `amount`) VALUES
	('1', '100'),
	('2', '100');

INSERT INTO `delivery`.`user_details` (`id`, `name`, `password`, `bonus_card_id`) VALUES 
	('1', 'admin', '$2a$04$dtjK9fXUeU5ei0p8Ao2IOe/a5w2OFcq3O99/aj5FgdVNjAhl1nyT6', '1'),
	('2', 'user', '$2a$04$jTWWdzHezZCSkpiC14Ux9.tutFtVqIMQiUhrMOpL6Xt7iKDmVBSUO', '2');

INSERT INTO `delivery`.`user_details_roles` (`users_id`, `roles_id`) VALUES
	('1', '1'),
	('1', '2'),
	('2', '2');

INSERT INTO `delivery`.`addresses` (`id`, `apartments`, `city`, `district`, `postcode`, `street`) VALUES 
	('1', '16', 'Kyiv', 'Pechersk', '1616', 'Lesi Ukrainki 16'),
    ('2', '16', 'Kyiv', 'Podol', '1616', 'Vozdvizhenska 16');


INSERT INTO `delivery`.`user_details_addresses` (`User_id`, `addresses_id`) VALUES
	('1', '1'),
    ('1', '2'),
	('2', '1'),
	('2', '2');
