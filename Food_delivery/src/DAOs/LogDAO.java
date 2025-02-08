package DAOs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTOs.LogDTO;
import util.DatabaseHelper;

public class LogDAO {
	public void insert(LogDTO log) {
        // TODO
    }

    public LogDTO getById(LogDTO log) {
    	// TODO
    	return new LogDTO();
    }

    public List<LogDTO> getAll() {
        List<LogDTO> logs = new ArrayList<>();
        String procedureCall = "{CALL GetAllLogs()}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall);
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                logs.add(new LogDTO(                        
                        rs.getString("Job"),
                        rs.getString("TableName"),
                        rs.getTimestamp("created_at")                        
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logs;
    }

    public void update(LogDTO log) {
        // TODO
    }

    public void delete(int productId) {
        // TODO
    }
}

