package Modul04;

public class Manager extends Karyawan {
    private int persKinerja;
    private int bonus;
    public Manager(int nik, String nama, int gajiPokok) {
        super(nik, nama, gajiPokok);
    }
    public int getPersKinerja() {
        return persKinerja;
    }
    public void setPersKinerja(int persKinerja) {
        this.persKinerja = persKinerja;
    }
    public int getBonus() {
        return bonus;
    }
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    @Override
    public void hitungGaji() {
        super.hitungGaji();
        double tunjTransport = gajiPokok()*0.1;
        double subtotal = gajiPokok()+tunjTransport;
        if (persKinerja>50);
        bonus= gajiPokok()*persKinerja/100;
        subtotal=subtotal*bonus;
        double pajak = subtotal*0.025;
        double total = subtotal-pajak;
    }
}