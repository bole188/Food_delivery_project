CREATE PROCEDURE GetCourierById(
    IN p_courier_id INT
)
BEGIN
    SELECT courier_id, first_name, last_name, phone_number, wallet_id, vehicle_id
    FROM Courier
    WHERE courier_id = p_courier_id;
END;