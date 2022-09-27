package Modul04;

public class KaryawanPenuhWaktu extends Karyawan {
    private int totalJamKerja;
    private int lembur;
    private int penalty;
    public KaryawanPenuhWaktu(int nik, String nama, int gajiPokok) {
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
        double gajiPerMinggu = gajiPokok*40;
        double tunjTransport = gajiPerMinggu*0.05;
        double totalGaji = gajiPerMinggu + tunjTransport;
        if (totalJamKerja>40);
        lembur = (totalJamKerja - 40) * (gajiPokok+5000);
        totalGaji = totalGaji+lembur;
        if (totalJamKerja<40);
        penalty = (40-totalJamKerja)*gajiPokok;
        totalGaji =totalGaji-penalty;
        double pajak=totalGaji*0.025;
        double total = totalGaji-pajak;
    }
}