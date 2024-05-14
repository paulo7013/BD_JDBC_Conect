package main.java.org.example.repo;

import main.java.org.example.entity.Poluchatel;

import java.sql.*;

public class RepoPrint extends RDBcon {
    public void print() throws SQLException {
        Statement stmt = this.getStatement(this.connectToDB());
        ResultSet set = stmt.executeQuery("SELECT * FROM izdanie AS iz JOIN podpiska AS pod JOIN poluchatel as pol " +
                "ON iz.id = pod.id_Izdanie AND pol.id = pod.id_Poluchatel");
        while (set.next()){

            System.out.print(set.getString("family") + "\t "
                    + set.getString("name") + "\t "
                    + set.getString("otchestvo") + "\t ул."
                    + set.getString("street") + " дом: "
                    + set.getString("house") + " кв. "
                    + set.getString("flat") + " "

                    + set.getString("type")+ " "
                    + set.getString("i_name")+ " $"
                    + set.getString("price")+ " срок подписки: "
                    + set.getString("period")+ " дата подписки: "
                    + set.getString("startYarer")+ " "
                    + set.getString("startMonth") + "\n");
        }
        this.closeConnection(stmt);
    }
}
