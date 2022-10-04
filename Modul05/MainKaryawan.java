package Modul05;

import Modul04.Karyawan;
import Modul04.KaryawanParuhWaktu;
import Modul04.KaryawanPenuhWaktu;
import Modul04.Manager;
import java.io.*;
import java.util.ArrayList;

public class MainKaryawan {
    public static BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
    public static ArrayList<Karyawan> karyawan = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        int menu;
        do{
            System.out.print("-----------------------------------------\n" +
                    "Sistem Karyawan PT. XYZ ABC Jaya\n" +
                    "-----------------------------------------\n" +
                    "1. Registrasi\n" +
                    "2. Lihat Daftar\n" +
                    "3. Cetak Slip Gaji\n" +
                    "-----------------------------------------\n" +
                    "Pilih menu (1 - 3, 0: keluar dari menu): ");
            menu=Integer.parseInt(in.readLine());
            if(menu==1){
                String nama, kode;
                int gaji, kerja;
                System.out.print("Masukkan Nama : ");
                nama=in.readLine();
                System.out.print("Masukkan kode karyawan : ");
                kode=in.readLine();
                if(kode.equals("MJR")){
                    System.out.print("Masukkan gaji pokok mingguan : ");
                    gaji=Integer.parseInt(in.readLine());
                    System.out.print("Masukkan nilai kinerja minggu ini (0-100) : ");
                    kerja=Integer.parseInt(in.readLine());
                    karyawan.add(new Manager(nama,gaji,0,kerja));
                }else{
                    System.out.print("Masukkan gaji pokok per jam : ");
                    gaji=Integer.parseInt(in.readLine());
                    System.out.print("Masukkan total jam kerja minggu ini : ");
                    kerja=Integer.parseInt(in.readLine());
                    if(kode.equals("KFT")){
                        karyawan.add(new KaryawanPenuhWaktu(nama,gaji,kerja));
                    }else if(kode.equals("KPT")){
                        karyawan.add(new KaryawanParuhWaktu(nama,gaji,kerja));
                    }
                }
                System.out.println();
            }else if(menu==2){
                System.out.println("-------------------------------------\n" +
                        " Daftar Karyawan PT XYZ ABC Jaya\n" +
                        "-------------------------------------");
                for(Karyawan karyawan : karyawan){
                    System.out.printf("%03d - %s - %s\n",karyawan.getNik(),karyawan.getNamaLengkap(),karyawan.HitungGaji());
                }
                System.out.println("-------------------------------------");
            }else if(menu==3){
                System.out.println("Masukkan NIK:");
                int nik = Integer.parseInt(in.readLine());
                for (Karyawan karyawan:karyawan) {
                    if(karyawan.getNik()==nik){
                        cetakSlipGaji(karyawan);
                        break;
                    }
                }
            }
        }while (true);
    }
        public static void cetakSlipGaji(Karyawan karyawan){
            String gaji = Karyawan.HitungGaji();
            if(karyawan instanceof Manager){
                Manager Manager = (Manager) karyawan;
                System.out.printf("%d - %s%20s: %d%%\n",karyawan.getNik(),karyawan.getNamaLengkap(),"Kinerja Minggu Ini",Manager.getPencKinerja());
                System.out.println("------------------------------------------------");
            }else{
                System.out.printf("%d - %s%20s: %d\n",karyawan.getNik(),karyawan.getNamaLengkap(),"Total Jam Kerja",karyawan.getJamKerja());
                System.out.println("------------------------------------------------");
            }

            if(karyawan instanceof Manager){
                System.out.printf("%-30s: %s\n","Gaji Pokok",("Rp. "+ Karyawan.getGajiPokok()));
                System.out.printf("%-30s: %s\n","Tunjangan Transportasi",("Rp. "+karyawan.getTunjanganTransportasi()));
                System.out.printf("%-30s: %s\n\n",(karyawan.getMisc()<0?"Penalty":"Bonus "),("Rp. "+karyawan.getMisc()));
                System.out.printf("%-30s: %s\n\n","Pajak",("Rp. "+karyawan.getPajak()));
                System.out.printf("%-30s: %s\n","Gaji sebelum pajak",("Rp. "+(karyawan.getGajiPokok()+karyawan.getMisc()+karyawan.getTunjanganTransportasi())));
            }else if(karyawan instanceof KaryawanParuhWaktu){
                System.out.printf("%-30s: %s\n","Gaji Pokok",("Rp. "+(karyawan.getGajiPokok()*20)));
                System.out.printf("%-30s: %s\n","Tunjangan Transportasi",("Rp. "+karyawan.getTunjanganTransportasi()));
                System.out.printf("%-30s: %s\n\n",(karyawan.getMisc()<0?"Penalty":"Bonus "),("Rp. "+karyawan.getMisc()));
                System.out.printf("%-30s: %s\n\n","Pajak",("Rp. "+karyawan.getPajak()));
                System.out.printf("%-30s: %s\n","Gaji sebelum pajak",("Rp. "+((karyawan.getGajiPokok()*20)+karyawan.getMisc()+karyawan.getTunjanganTransportasi())));
            }else if(karyawan instanceof KaryawanPenuhWaktu){
                System.out.printf("%-30s: %s\n","Gaji Pokok",("Rp. "+(karyawan.getGajiPokok()*40)));
                System.out.printf("%-30s: %s\n","Tunjangan Transportasi",("Rp. "+karyawan.getTunjanganTransportasi()));
                System.out.printf("%-30s: %s\n\n",(karyawan.getMisc()<0?"Penalty":"Bonus "),("Rp. "+karyawan.getMisc()));
                System.out.printf("%-30s: %s\n\n","Pajak",("Rp. "+karyawan.getPajak()));
                System.out.printf("%-30s: %s\n","Gaji sebelum pajak",("Rp. "+((karyawan.getGajiPokok()*40)+karyawan.getMisc()+karyawan.getTunjanganTransportasi())));
            }
            System.out.println("------------------------------------------------");
            System.out.printf("%-30s: %s\n","Pendapatan Gaji",gaji);
        }
    }