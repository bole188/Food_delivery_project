package DTOs;

import java.sql.*;

public class LogDTO {
	private String job;
	private String tableName;
	private java.sql.Timestamp createdAt;
	
	public LogDTO() {}
	
	public LogDTO(String j, String TableName, java.sql.Timestamp ct) {
		this.job = j;
		this.tableName = TableName;
		this.createdAt = ct;
	}
	
	public String getJob() {
		return job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	
	public String getTableName() {
		return this.tableName;
	}
	
	public void setTableName(String tn) {
		this.tableName = tn;
	}
	
	public java.sql.Timestamp getCreatedAt(){
		return this.createdAt;
	}
	
	public void setCreatedAt(java.sql.Timestamp s) {
		this.createdAt = s;
	}
	
	public String toString() {
		return "Log{" +
                "Job=" + job +
                ", TableName=" + this.tableName +
                ", Timestamp=" + this.createdAt +
                '}';
	}
}
