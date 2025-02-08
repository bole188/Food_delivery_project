CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertOrder`(
    IN p_delivery_id INT,
    IN p_client_id INT,
    IN p_restaurant_id INT,
    IN p_order_date DATE,
    IN p_order_time TIME
)
BEGIN
    INSERT INTO `Order` (delivery_id, client_id, restaurant_id, order_date, order_time)
    VALUES (p_delivery_id, p_client_id, p_restaurant_id, p_order_date, p_order_time);
END