CREATE PROCEDURE GetProductById(
    IN p_product_id INT
)
BEGIN
    SELECT product_id, name, price, restaurant_id, product_type_id
    FROM Product
    WHERE product_id = p_product_id;
END;