CREATE PROCEDURE UpdateProduct(
    IN p_product_id INT,
    IN p_name VARCHAR(255),
    IN p_price DOUBLE,
    IN p_restaurant_id INT,
    IN p_product_type_id INT
)
BEGIN
    UPDATE Product
    SET name = p_name,
        price = p_price,
        restaurant_id = p_restaurant_id,
        product_type_id = p_product_type_id
    WHERE product_id = p_product_id;
END;