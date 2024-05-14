package main.java.org.example.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class RDBcon {
    void executeRequest(String request) throws SQLException {
        Statement stmt = this.getStatement(this.connectToDB());
        stmt.execute(request);
        stmt.close();
    }
    Statement getStatement(Connection conn) throws SQLException{
        return conn.createStatement();
    }
    Connection connectToDB() throws SQLException{

        Connection conn = DriverManager.getConnection("jdbc:sqlite:TEST1.s3db");
        if (conn == null){
            System.out.println("Error connection DB");
            return null;
        }
        return conn;
    }
    public void closeConnection(Statement stmt) throws SQLException{
        stmt.close();
    }
}
