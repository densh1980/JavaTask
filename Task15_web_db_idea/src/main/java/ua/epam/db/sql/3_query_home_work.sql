

-- Вывести список продуктов  и  категорий в которые они входят
SELECT 	p.name AS Product,
		GROUP_CONCAT(c.name SEPARATOR ', ') AS Style
	FROM categories c JOIN categories_products cp ON 
      c.id=cp.categories_id  JOIN products p ON products_id = p.id
	GROUP BY p.id
    ORDER BY Product;
    
-- вывести список всех заказов с детализацией  имени, стоимости  и количества  продукции в заказе а также полной суммы к оплате  
SELECT oi.orders_id AS Order_№,(SELECT CONCAT(u.first_name," ", u.last_name) FROM users u WHERE id = o.users_id) AS Customer,
	GROUP_CONCAT(CONCAT("Название товара : \"", p.name,"\"  ко-во:" ,oi.product_qty," шт. цена:",p.price,"грн.") SEPARATOR '  ') AS Order_Details,
    SUM(oi.product_qty * p.price) AS Total_amount_UAH
 FROM orders_items oi JOIN products p ON oi.products_id = p.id JOIN orders o ON o.id = oi.orders_id 
 GROUP BY oi.orders_id;

--  вывести ко-во видео продукции в каждой категории 
SELECT 	cp.categories_id AS category_ID,
		(SELECT c.name FROM categories c WHERE c.Id = cp.categories_id) AS category ,
        COUNT(p.name) AS count
 FROM products p JOIN categories_products cp ON  p.Id = cp.products_id
 WHERE 'video' IN (SELECT mt.type FROM media_types mt WHERE mt.Id = p.media_types_id)
 GROUP BY cp.categories_id;
  

--  вывести товары с максимальным и минимальным рейтингом 
SELECT GROUP_CONCAT(p.name SEPARATOR ', ') AS Product, p.rating FROM products p  
WHERE p.rating IN ( (SELECT MIN(rating) FROM products) , (SELECT MAX(rating) FROM products) )
GROUP BY p.rating;


-- Вывести фамилии людей чей статус заказа  'new'
-- Вложенный SELECT запрос
SELECT last_name
	FROM users
    WHERE users.id IN
    (SELECT orders.users_id 
     FROM orders 
     WHERE orders.order_status ='new');

-- Коррелированный подзапрос
SELECT last_name
	FROM users
    WHERE 'new' IN 
    (SELECT order_status 
     FROM orders 
     WHERE users_id = users.id);


--  Вывести количество виниловых пластинок находящихся в продаже
-- Коррелированный подзапрос
SELECT Count(name) As Vinil_Plates_Count_IN_STOCK
	FROM products p
	WHERE 'vinil_record' IN
	(SELECT record_mediums.type
     FROM record_mediums
     WHERE id = p.record_mediums_id);
     
-- Вывести сумму которую потратила Мария Шепель  в магазине за все время	    
SELECT SUM(price) AS money_spend_by_user FROM orders_items,products
WHERE products_id = products.id
  -- AND products.media_types_id = 2
  AND orders_id IN 
	(SELECT y.id 
     FROM users x,orders y
	 WHERE last_name = 'Шепель' AND y.users_id =x.id);

-- Вывести всех пользователей  и указать размер скидки  для каждого
SELECT CONCAT(last_name, " ",first_name) AS 'name',
	   CASE
	   WHEN sale IS NULL THEN 0
	   ELSE sale
       END AS 'sale, %'
FROM users u  LEFT JOIN sale_procent sp ON u.id =sp.users_id
ORDER BY last_name; 


						