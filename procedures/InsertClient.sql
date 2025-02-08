CREATE PROCEDURE InsertClient(
    IN p_client_id INT,
    IN p_first_name VARCHAR(100),
    IN p_last_name VARCHAR(100),
    IN p_address VARCHAR(255),
    IN p_phone_number VARCHAR(15),
    IN p_city_name VARCHAR(100)
)
BEGIN
    INSERT INTO Client (client_id, first_name, last_name, address, phone_number, city_name)
    VALUES (p_client_id, p_first_name, p_last_name, p_address, p_phone_number, p_city_name);
END;