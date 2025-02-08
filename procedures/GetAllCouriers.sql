CREATE PROCEDURE GetAllCouriers()
BEGIN
    SELECT courier_id, first_name, last_name, phone_number, wallet_id, vehicle_id
    FROM Courier;
END;