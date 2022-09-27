package Modul04;

    public class Karyawan {
        int nik;
        String namaLengkap;
        int gajiPokok;

        public Karyawan(int nik, String namaLengkap, int gajiPokok) {
            this.nik = nik;
            this.namaLengkap = namaLengkap;
            this.gajiPokok = gajiPokok;
        }

        public int getNik() {
            return nik;
        }

        public String getNamaLengkap(){
            return namaLengkap;
        }

        public int gajiPokok() {
            return gajiPokok;
        }

        public void hitungGaji() {
            double tunjanganTransport = gajiPokok * 0.05;
            double tunjanganKinerja = gajiPokok * 0.1;
            double tunjMakan = 35000 * 20;
            double totalSebelumPajak = gajiPokok + tunjanganTransport + tunjanganKinerja + tunjMakan;

            double pajak = totalSebelumPajak * 0.025;

            double total = totalSebelumPajak - pajak;

            System.out.println(" Rp. " + total);
        }
    }
