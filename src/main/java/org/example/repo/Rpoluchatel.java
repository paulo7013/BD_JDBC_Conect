package main.java.org.example.repo;

import main.java.org.example.entity.Izdanie;
import main.java.org.example.entity.Poluchatel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Rpoluchatel extends RepoDB<Poluchatel> {

    @Override
    public void newTable() throws SQLException {
        this.executeRequest("DROP TABLE if exists 'poluchatel'");
        String st = String.format("CREATE TABLE if not exists 'poluchatel' " +
                "('id' INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "'family' text, 'name' text, 'otchestvo' text," +
                "'street' text, 'house' INT, 'flat' INT);");
        this.executeRequest(st);
    }

    @Override
    public Integer Add(Poluchatel poluchatel) throws SQLException {
        String st = String.format("INSERT INTO poluchatel (family, name, otchestvo, street, house, flat)" +
                        "VALUES ('%s','%s','%s','%s','%s','%s')",
                poluchatel.getFamily(),
                poluchatel.getName(),
                poluchatel.getOtchestvo(),
                poluchatel.getStreet(),
                poluchatel.getHouse(),
                poluchatel.getFlat());
        this.executeRequest(st);
        return null;
    }

    @Override
    public void Delete(Poluchatel poluchatel) throws SQLException {
        String st = String.format("DELETE FROM poluchatel WHERE id = '%s'" , poluchatel.getId());
        this.executeRequest(st);
    }

    @Override
    public void Update(Poluchatel poluchatel) throws SQLException {
        String st = String.format("UPDATE poluchatel SET id = '%s', family = '%s', name = '%s',otchestvo = '%s'" +
                                    ",street = '%s',house = '%s',flat = '%s' WHERE id = '%s'" ,
                poluchatel.getId(),
                poluchatel.getFamily(),
                poluchatel.getName(),
                poluchatel.getOtchestvo(),
                poluchatel.getStreet(),
                poluchatel.getHouse(),
                poluchatel.getFlat(),
                poluchatel.getId());
        this.executeRequest(st);
    }

    @Override
    public List<Poluchatel> getList() throws SQLException {
        Statement stmt = this.getStatement(this.connectToDB());
        ResultSet res = stmt.executeQuery("SELECT * FROM poluchatel as pol");
        List<Poluchatel> li = new ArrayList<>();
        while (res.next()){
            li.add(new Poluchatel(res.getInt("id"), res.getString("family"), res.getString("name"),
                    res.getString("otchestvo"), res.getString("street"), res.getInt("house"),
                    res.getInt("flat") ) );
            System.out.print(res.getString("id")+ " ");
            System.out.print(res.getString("family")+ " ");
            System.out.print(res.getString("name")+ " ");
            System.out.println(res.getString("otchestvo")+ "\n");
        }
        this.closeConnection(stmt);
        return li;
    }
}
