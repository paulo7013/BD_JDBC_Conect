package main.java.org.example.repo;

import main.java.org.example.entity.Podpiska;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Rpodpiska extends RepoDB<Podpiska> {

    @Override
    public void newTable() throws SQLException {
        this.executeRequest("DROP TABLE if exists 'podpiska'");
        String st = String.format("CREATE TABLE if not exists 'podpiska' " +
                "('id_Izdanie' INTEGER, 'id_Poluchatel' INTEGER, " +
                "'period' INT, 'startYarer' INT, 'startMonth' INT," +
                "CONSTRAINT podpiska PRIMARY KEY (id_Izdanie, id_Poluchatel));");
        this.executeRequest(st);
    }

    @Override
    public Integer Add(Podpiska podpiska) throws SQLException {
        String st = String.format("INSERT INTO podpiska (id_Izdanie, id_Poluchatel, period, startYarer, startMonth)" +
                        "VALUES ('%s','%s','%s','%s','%s')",
                podpiska.getId_Izdanie(),
                podpiska.getId_Poluchatel(),
                podpiska.getPeriod(),
                podpiska.getStartYear(),
                podpiska.getStartMonth());
        this.executeRequest(st);
        return null;
    }

    @Override
    public void Delete(Podpiska podpiska) throws SQLException {
        String st = String.format("DELETE FROM podpiska WHERE id_Izdanie = '%s' AND id_Poluchatel = '%s' " ,
                podpiska.getId_Izdanie(),
                podpiska.getId_Poluchatel());
        this.executeRequest(st);
    }

    @Override
    public void Update(Podpiska podpiska) throws SQLException {
        String st = String.format("UPDATE podpiska SET id_Izdanie = '%s', id_Poluchatel = '%s', period = '%s', " +
                        "startYarer = '%s', startMonth = '%s' WHERE id_Izdanie = '%s'AND id_Poluchatel = '%s'" ,
                podpiska.getId_Izdanie(),
                podpiska.getId_Poluchatel(),
                podpiska.getPeriod(),
                podpiska.getStartYear(),
                podpiska.getStartMonth(),
                podpiska.getId_Izdanie(),
                podpiska.getId_Poluchatel());
        this.executeRequest(st);
    }

    @Override
    public List<Podpiska> getList() throws SQLException {
        Statement stmt = this.getStatement(this.connectToDB());
        ResultSet res = stmt.executeQuery("SELECT * FROM podpiska as pod");
        List<Podpiska> li = new ArrayList<>();
        while (res.next()){
            li.add(new Podpiska(res.getInt("id_Izdanie"), res.getInt("id_Poluchatel"),
                    res.getInt("period"), res.getInt("startYarer"), res.getInt("startMonth") ));
            System.out.print("\n" + res.getInt("id_Izdanie")+ " ");
            System.out.print(res.getInt("id_Poluchatel")+ " ");
            System.out.print(res.getInt("period")+ " ");
            System.out.print(res.getInt("startYarer")+ " ");
            System.out.println(res.getInt("startMonth")+ "\n");
        }
        this.closeConnection(stmt);
        return null;
    }
}
