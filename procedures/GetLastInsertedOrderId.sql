CREATE DEFINER=`root`@`localhost` PROCEDURE `GetLastInsertedOrderId`()
BEGIN
    SELECT MAX(order_id) AS last_order_id FROM `Order`;
END