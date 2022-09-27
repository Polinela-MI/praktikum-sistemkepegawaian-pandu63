package Modul04;

public class KaryawanParuhWaktu extends Karyawan {
    private int totalJamKerja;
    private int lembur;
    private int penalty;
    public KaryawanParuhWaktu(int nik, String nama, int gajiPokok) {
        super(nik, nama, gajiPokok);
    }
    public int getTotalJamKerja() {
        return totalJamKerja;
    }
    public void setTotalJamKerja(int totalJamKerja) {
        this.totalJamKerja = totalJamKerja;
    }
    public int getLembur() {
        return lembur;
    }
    public void setLembur(int lembur) {
        this.lembur = lembur;
    }
    public int getPenalty() {
        return penalty;
    }
    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }
    public void hitungGaji() {
        super.hitungGaji();
        double gajiPerMinggu = gajiPokok*20;
        double tunjTransport = gajiPerMinggu*0.05;
        double totalGaji = gajiPerMinggu + tunjTransport;
        if (totalJamKerja>20);
        lembur = (totalJamKerja - 20) * (gajiPokok+2000);
        totalGaji = totalGaji+lembur;
        if (totalJamKerja<20);
        penalty = (20-totalJamKerja)*gajiPokok;
        totalGaji =totalGaji-penalty;
        double pajak=totalGaji*0.025;
        double total = totalGaji-pajak;
    }
}