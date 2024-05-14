package main.java.org.example.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class RepoDB<T> extends RDBcon {
    abstract void newTable() throws SQLException;
    abstract Integer  Add(T object) throws SQLException;
    abstract void  Delete(T object) throws SQLException;
    abstract void Update(T object) throws SQLException;
    abstract List<T> getList() throws SQLException;
}
