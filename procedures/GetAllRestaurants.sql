CREATE PROCEDURE GetAllRestaurants()
BEGIN
    SELECT restaurant_id, name, address
    FROM Restaurant;
END;