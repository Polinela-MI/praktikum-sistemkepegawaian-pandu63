public class Main {
    public static void main(String[] args) {
        int input = Integer.parseInt(args[0]);

        for (int i = 1; i < args.length; i += 3) {
            int nik = Integer.parseInt(args[i]);
            int gajiPokok = Integer.parseInt(args[i+2]);

            Karyawan k = new Karyawan(nik, args[i+1], gajiPokok);

            System.out.print(k.getNik() + "_" + k.getNamaLengkap());
            k.hitungGaji();
        }
        String[] kehadiran = {"5-H!4-H", "5-I!4-H,", "5-H!4-S", "5-A!4-H"};
        int pegawai5 = 0;
        int pegawai4 = 0;

        for (int i = 0; i < kehadiran.length; i++) {
            String[] kehadiranPegawai = kehadiran[i].split("!");

            for (int j = 0; j < kehadiranPegawai.length; j++) {
                String[] dataPegawai = kehadiranPegawai[j].split("-");
                if(Integer.parseInt(dataPegawai[0]) == 5) {
                    if(dataPegawai[1].equals("H")){
                        pegawai5++;
                    }
                } else if (Integer.parseInt(dataPegawai[0])== 4) {
                    if (dataPegawai[1].equals("H")){
                        pegawai4++;
                    }

                }
            }
        }
        System.out.println("Kehadiran Pegawai5 : " + pegawai5);
        System.out.println("Kehadiran Pegawai4 : " + pegawai4);
    }
}