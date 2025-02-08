
CREATE PROCEDURE GetClientId(
    IN ClientID INT
)
BEGIN
    SELECT * FROM Clients
    WHERE ClientID = ClientID;
END;