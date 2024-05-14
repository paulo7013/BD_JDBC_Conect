
import main.java.org.example.entity.Izdanie;
import main.java.org.example.entity.Podpiska;
import main.java.org.example.entity.Poluchatel;
import main.java.org.example.repo.RepoPrint;
import main.java.org.example.repo.Rizdanie;
import main.java.org.example.repo.Rpodpiska;
import main.java.org.example.repo.Rpoluchatel;

import java.sql.SQLException;

public class main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.sqlite.JDBC");
        RepoPrint print = new RepoPrint();
        Rizdanie rizdanie = new Rizdanie();
        rizdanie.newTable();
        Rpodpiska rpodpiska = new Rpodpiska();
        rpodpiska.newTable();
        Rpoluchatel rpoluchatel = new Rpoluchatel();
        rpoluchatel.newTable();

        Izdanie iz1 = new Izdanie(0,"Журнал", "Мурзилка", 44);
        Izdanie iz2 = new Izdanie(0,"Журнал", "Рыболов", 55);

        Poluchatel pol1 = new Poluchatel(0, "Сидоров","Николай","Николаевич","Пушкина",12,53);
        Poluchatel pol2 = new Poluchatel(0, "Порошня","Дмитрий","Скргеевич","Малышева",46,135);

        Podpiska pod1 = new Podpiska(1,1,12,2003,1);
        Podpiska pod2 = new Podpiska(1,2,9,2003,4);
        Podpiska pod3 = new Podpiska(2,1,3,2016,7);

        rizdanie.Add(iz1);
        rizdanie.Add(iz2);

        rpoluchatel.Add(pol1);
        rpoluchatel.Add(pol2);

        rpodpiska.Add(pod1);
        rpodpiska.Add(pod2);
        rpodpiska.Add(pod3);

        /*rizdanie.getList();
        rpodpiska.getList();
        rpoluchatel.getList();*/

        print.print();
    }
}