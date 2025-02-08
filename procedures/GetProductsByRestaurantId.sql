CREATE DEFINER=`root`@`localhost` PROCEDURE `GetProductsByRestaurantId`(IN restaurantId INT)
BEGIN
    SELECT * FROM Product WHERE restaurant_id = restaurantId;
END