package main.java.org.example.entity;

public class Podpiska {
    int id_Izdanie;
    int id_Poluchatel;
    int period;
    int startYear;
    int startMonth;

    public Podpiska(int id_Izdanie, int id_Poluchatel, int period, int startYear, int startMonth) {
        this.id_Izdanie = id_Izdanie;
        this.id_Poluchatel = id_Poluchatel;
        this.period = period;
        this.startYear = startYear;
        this.startMonth = startMonth;
    }

    public int getId_Izdanie() {
        return id_Izdanie;
    }

    public int getId_Poluchatel() {
        return id_Poluchatel;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
    }
}
