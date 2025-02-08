CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertItem`(
    IN p_order_id INT,
    IN p_product_id INT,
    IN p_item_name VARCHAR(255),
    IN p_item_quantity DOUBLE,
    IN p_item_price DOUBLE
)
BEGIN
    INSERT INTO Item (order_id, product_id, item_name, item_quantity, item_price)
    VALUES (p_order_id, p_product_id, p_item_name, p_item_quantity, p_item_price);
END