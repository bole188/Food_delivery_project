CREATE PROCEDURE UpdateCourier(
    IN p_courier_id INT,
    IN p_first_name VARCHAR(100),
    IN p_last_name VARCHAR(100),
    IN p_phone_number VARCHAR(15),
    IN p_wallet_id INT,
    IN p_vehicle_id INT
)
BEGIN
    UPDATE Courier
    SET first_name = p_first_name,
        last_name = p_last_name,
        phone_number = p_phone_number,
        wallet_id = p_wallet_id,
        vehicle_id = p_vehicle_id
    WHERE courier_id = p_courier_id;
END;