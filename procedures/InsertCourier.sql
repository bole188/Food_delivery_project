CREATE PROCEDURE InsertCourier(
    IN p_courier_id INT,
    IN p_first_name VARCHAR(100),
    IN p_last_name VARCHAR(100),
    IN p_phone_number VARCHAR(15),
    IN p_wallet_id INT,
    IN p_vehicle_id INT
)
BEGIN
    INSERT INTO Courier (courier_id, first_name, last_name, phone_number, wallet_id, vehicle_id)
    VALUES (p_courier_id, p_first_name, p_last_name, p_phone_number, p_wallet_id, p_vehicle_id);
END;

