CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAllLogs`()
BEGIN
	SELECT * FROM Log;
END