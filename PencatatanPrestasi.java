import java.util.Scanner;

public class PencatatanPrestasi {
    static String[][] dataPrestasi; 
    static int jumlahData = 0; 
    static final int MAX_DATA = 100; 
    static Scanner scanner = new Scanner(System.in);
    static int tahunSaatIni; 

    public static void main(String[] args) {
        dataPrestasi = new String[MAX_DATA][5]; 
        System.out.print("Masukkan tahun saat ini (misalnya: 2024): ");
        tahunSaatIni = scanner.nextInt();
        scanner.nextLine(); 
        int pilihan;
        do {
            System.out.println("\n=== PENCATATAN PRESTASI MAHASISWA ===");
            System.out.println("1. Tambah Data Prestasi");
            System.out.println("2. Tampilkan Semua Prestasi");
            System.out.println("3. Analisis Prestasi Berdasarkan Jenis dan Tahun");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 
            switch (pilihan) {
                case 1:
                    tambahDataPrestasi();
                    break;
                case 2:
                    tampilkanSemuaPrestasi();
                    break;
                case 3:
                    analisisPrestasi();
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 4);
    }
    public static void tambahDataPrestasi() {
        if (jumlahData >= MAX_DATA) {
            System.out.println("Kapasitas data penuh! Tidak dapat menambahkan data baru.");
            return;
        }
        System.out.println("\n=== Tambah Data Prestasi ===");
        System.out.print("Masukkan Nama Mahasiswa: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan NIM Mahasiswa: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan Jenis Prestasi: ");
        String jenis = scanner.nextLine();
        String tingkat;
        do {
            System.out.print("Masukkan Tingkat Prestasi (Lokal/Nasional/Internasional): ");
            tingkat = scanner.nextLine();
            if (!tingkat.equalsIgnoreCase("Lokal") && 
                !tingkat.equalsIgnoreCase("Nasional") && 
                !tingkat.equalsIgnoreCase("Internasional")) {
                System.out.println("Tingkat tidak valid! Harus Lokal, Nasional, atau Internasional.");
            }
        } while (!tingkat.equalsIgnoreCase("Lokal") && 
                 !tingkat.equalsIgnoreCase("Nasional") && 
                 !tingkat.equalsIgnoreCase("Internasional"));

        int tahun;
        do {
            System.out.print("Masukkan Tahun Prestasi (2010 - " + tahunSaatIni + "): ");
            tahun = scanner.nextInt();
            scanner.nextLine(); 
            if (tahun < 2010 || tahun > tahunSaatIni) {
                System.out.println("Tahun tidak valid! Harus antara 2010 hingga " + tahunSaatIni + ".");
            }
        } while (tahun < 2010 || tahun > tahunSaatIni);
        dataPrestasi[jumlahData][0] = nama;
        dataPrestasi[jumlahData][1] = nim;
        dataPrestasi[jumlahData][2] = jenis;
        dataPrestasi[jumlahData][3] = tingkat;
        dataPrestasi[jumlahData][4] = Integer.toString(tahun); 
        jumlahData++;

        System.out.println("Data prestasi berhasil ditambahkan.");
    }
}