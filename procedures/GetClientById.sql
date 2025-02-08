CREATE PROCEDURE GetClientById(
    IN p_client_id INT
)
BEGIN
    SELECT client_id, first_name, last_name, address, phone_number, city_name
    FROM Client
    WHERE client_id = p_client_id;
END;