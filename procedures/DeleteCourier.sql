CREATE PROCEDURE DeleteCourier(
    IN p_courier_id INT
)
BEGIN
    DELETE FROM Courier
    WHERE courier_id = p_courier_id;
END;