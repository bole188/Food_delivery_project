CREATE PROCEDURE DeleteProduct(
    IN p_product_id INT
)
BEGIN
    DELETE FROM Product
    WHERE product_id = p_product_id;
END;