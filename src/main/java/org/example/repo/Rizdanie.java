package main.java.org.example.repo;

import main.java.org.example.entity.Izdanie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Rizdanie extends RepoDB<Izdanie>{

    public void newTable() throws SQLException {
        this.executeRequest("DROP TABLE if exists 'izdanie'");
        String st = String.format("CREATE TABLE if not exists 'izdanie' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'type' text, 'i_name' text, 'price' INT);");
        this.executeRequest(st);
    }
    @Override
    public Integer Add(Izdanie izdanie) throws SQLException {
        int id;
        String query = "INSERT INTO izdanie (type, i_name, price)" +
                "VALUES (?,?,?)";
        try (Connection conn = connectToDB();
             PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, izdanie.getType());
            statement.setString(2, izdanie.getName());
            statement.setInt(3, izdanie.getPrice());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    izdanie.setId(id = generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Failed to get generated id for master.");
                }
            }
        }
        return id;
    }

    @Override
    public void Delete(Izdanie izdanie) throws SQLException {
        String st = String.format("DELETE FROM izdanie WHERE id = '%s'" , izdanie.getId());
        this.executeRequest(st);
    }

    @Override
    public void Update(Izdanie izdanie) throws SQLException {
        String st = String.format("UPDATE izdanie SET id = '%s', type = '%s', i_name = '%s',price = '%s' WHERE id = '%s'" ,
                izdanie.getId(),
                izdanie.getType(),
                izdanie.getName(),
                izdanie.getPrice(),
                izdanie.getId());
        this.executeRequest(st);
    }

    @Override
    public List<Izdanie> getList() throws SQLException {
        Statement stmt = this.getStatement(this.connectToDB());
        ResultSet res = stmt.executeQuery("SELECT * FROM izdanie as iz");
        List<Izdanie> li = new ArrayList<>();
        while (res.next()){
            li.add(new Izdanie(res.getInt("id"),res.getString("type"),res.getString("i_name"),res.getInt("price")));
            System.out.print(res.getString("id")+ " ");
            System.out.print(res.getString("type")+ " ");
            System.out.print(res.getString("i_name")+ " ");
            System.out.println(res.getString("price")+ "\n");
        }
        this.closeConnection(stmt);
        return li;
    }
}
