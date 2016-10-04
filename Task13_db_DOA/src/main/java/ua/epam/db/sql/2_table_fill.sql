INSERT INTO `shmyhin_epam_tasks_db`.`users` (`first_name`, `last_name`, `phone`, `email`) 
VALUES	('Мария', 'Шепель', '333-22-11', 'asd@com'),
		('Иван', 'Сидоренко', '123-34-55', 'sdf@rrr.ua'),
		('Иван', 'Калетник', '245 -22-99', 'mba@asd.com'),
		('Инна ', 'Сидоренко', '678-31-45', 'mba@dsa.ru'),
		('Дмитрий ', 'Маринин', '299-13-19', 'ghj@com'),
		('Joe', 'Black', '444-13-11', 'new@gmail.com');

INSERT INTO `shmyhin_epam_tasks_db`.`record_mediums` (`id`, `type`) 
VALUES (1,'CD'),(2,'DVD'),(3,'Blu-ray'),(4,'vinil_record'),(5,'cassette');

INSERT INTO `shmyhin_epam_tasks_db`.`media_types` (`id`, `type`) VALUES 
(1,'audio'),(2,'video');


INSERT INTO `shmyhin_epam_tasks_db`.`products` (`id`,`name`, `description`, `production_year`, `Qty`, `price`, `rating`, `record_mediums_id`, `media_types_id`) 
VALUES 	
-- music		
        (1,'Metallica - Six Feet Down Under',NULL,2010, 5, 50, 6, 1, 1),
		(2,'Metallica - Load',				NULL, 1996, 7, 200,10, 4, 1),
        (3,'Metallica - REload',			NULL, 1997, 8, 200, 9, 4, 1),
        (4,'Мельница - Дикие травы',		NULL, 2009, 8, 50, 8, 1, 1),
-- films        
		(5,'Mad Max',						NULL, 1979, 3,  70, 7, 5, 2),
		(6,'Lethal Weapon',					NULL, 1987, 1,  70,10, 5, 2),
		(7,'Air America',					NULL, 1990, 2,  99, 7, 1, 2),
		(8,'Forever Young',					NULL, 1992, 3, 128, 9, 1, 2),
		(9,'Maverick',						NULL, 1994, 5, 129, 6, 1, 2),
		(10,'Braveheart',					NULL, 1995, 5, 129, 10,2, 2),
        (11,'Conspiracy Theory',			NULL, 1997, 5, 151, 8, 2, 2),
        (12,'What Women Want',				NULL, 2000,16, 152, 5, 3, 2),
        (13,'Patriot',						NULL, 2000,18, 153, 6, 3, 2),
		(14,'The Expendables 3',			NULL, 2014,25, 154, 7, 3, 2);
        
INSERT INTO `shmyhin_epam_tasks_db`.`categories` (`id`, `name`)
VALUES (1, 'Rock'),(2,'Folk'),(3, 'Pop'),(4, 'Rap/HipHop'),
  
(5,'Adventure'),(6,'Action'),(7,'Biography'),(8,'Comedy'),(9,'Crime'),(10,'Drama'),(11,'Detective'),(12,'Fantasy'),
(13,'History'),(14,'Horror'),(15,'Fiction'),(16,'Mystery'),(17,'Sci-Fi'),(18,'Thriller'),(20,'War'),(21,'Western'),(22,'Romance');

INSERT INTO `shmyhin_epam_tasks_db`.`categories_products` (`products_id`,`categories_id`)
VALUES (1,1),
	   (2,1),
       (3,1),
       (4,1),(4,2),
	   (5,6),(5,5),(5,15),
       (6,6),(6,11),
       (7,6),(7,8),
       (8,10),(8,17),(8,22),
       (9,21),(9,5),(9,8),
       (10,10),(10,13),(10,20),
       (11,6),(11,9),(11,16),(11,18),
       (12,8),(12,12),(12,22),
       (13,6),(13,10),(13,13),(13,20),
       (14,6),(14,5),(14,18);

       
INSERT INTO `shmyhin_epam_tasks_db`.`orders` (`id`,`users_id`, `order_status`, `total_amount`)
VALUES	(1,1, 'new', NULL),(2,3,'new',NULL),(3,5,'new',NULL),(4,6,'in_progress',NULL),(5,1, 'new', NULL);

INSERT INTO `shmyhin_epam_tasks_db`.`orders_items` (`orders_id`, `products_id`, `product_qty`)
VALUES (1, 5, 1),(1, 2, 2),
	   (2, 14, 1),
       (3, 9, 1),(3,4,2),
       (4, 5, 1),
       (5, 8, 1),(5, 9, 1);

INSERT INTO `shmyhin_epam_tasks_db`.`sale_procent` (`users_id`,`sale`)
VALUES (2, 10),(3, 10),(6, 20),(4, 3);
         
         
        