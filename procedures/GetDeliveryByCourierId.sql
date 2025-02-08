CREATE DEFINER=`root`@`localhost` PROCEDURE `GetDeliveryByCourierId`(IN p_courier_id INT)
BEGIN
    SELECT d.delivery_id, d.courier_id, d.restaurant_id, d.delivery_date, d.delivery_time, r.name
	FROM Delivery d
	INNER JOIN Restaurant r ON r.restaurant_id = d.restaurant_id
	WHERE d.courier_id = p_courier_id;
END