CREATE PROCEDURE DeleteClient(
    IN p_client_id INT
)
BEGIN
    DELETE FROM Client
    WHERE client_id = p_client_id;
END;