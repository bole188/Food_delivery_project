CREATE PROCEDURE InsertProduct(
    IN p_product_id INT,
    IN p_name VARCHAR(255),
    IN p_price DOUBLE,
    IN p_restaurant_id INT,
    IN p_product_type_id INT
)
BEGIN
    INSERT INTO Product (product_id, name, price, restaurant_id, product_type_id)
    VALUES (p_product_id, p_name, p_price, p_restaurant_id, p_product_type_id);
END;