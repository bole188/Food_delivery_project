CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertDelivery`(
    IN p_delivery_id INT,
    IN p_courier_id INT,
    IN p_restaurant_id INT,
    IN p_delivery_date DATE,
    IN p_delivery_time TIME
)
BEGIN
    INSERT INTO Delivery (delivery_id, courier_id, restaurant_id, delivery_date, delivery_time)
    VALUES (p_delivery_id, p_courier_id, p_restaurant_id, p_delivery_date, p_delivery_time);
END