CREATE PROCEDURE UpdateClient(
    IN p_client_id INT,
    IN p_first_name VARCHAR(100),
    IN p_last_name VARCHAR(100),
    IN p_address VARCHAR(255),
    IN p_phone_number VARCHAR(15),
    IN p_city_name VARCHAR(100)
)
BEGIN
    UPDATE Client
    SET first_name = p_first_name,
        last_name = p_last_name,
        address = p_address,
        phone_number = p_phone_number,
        city_name = p_city_name
    WHERE client_id = p_client_id;
END;