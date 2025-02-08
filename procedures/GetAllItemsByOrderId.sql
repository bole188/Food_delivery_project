CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAllItemsByOrderId`(IN p_order_id INT)
BEGIN
    SELECT order_id, product_id, item_name, item_quantity, item_price
    FROM Item
    WHERE order_id = p_order_id;
END