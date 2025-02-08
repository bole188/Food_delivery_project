CREATE PROCEDURE GetAllProducts()
BEGIN
    SELECT product_id, name, price, restaurant_id, product_type_id
    FROM Product;
END;