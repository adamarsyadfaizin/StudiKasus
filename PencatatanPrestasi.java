import java.util.Scanner;

public class PencatatanPrestasi {

    public static void main(String[] args) {
        String[][] dataPrestasi = new String[100][5]; 
        int jumlahData = 0; 
        int MAX_DATA = 100; 
        Scanner scanner = new Scanner(System.in); 
        int tahunSaatIni;

        System.out.print("Masukkan tahun saat ini (misalnya: 2024): ");
        tahunSaatIni = scanner.nextInt();
        scanner.nextLine(); 

        int pilihan;
        do {
            System.out.println("\n=== PENCATATAN PRESTASI MAHASISWA ===");
            System.out.println("1. Tambah Data Prestasi");
            System.out.println("2. Tampilkan Semua Prestasi");
            System.out.println("3. Analisis Prestasi Berdasarkan Jenis");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 
            switch (pilihan) {
                case 1:
                    jumlahData = tambahDataPrestasi(scanner, dataPrestasi, jumlahData, MAX_DATA, tahunSaatIni);
                    break;
                case 2:
                    tampilkanSemuaPrestasi(dataPrestasi, jumlahData);
                    break;
                case 3:
                    analisisPrestasi(scanner, dataPrestasi, jumlahData);
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 4);
    }

    public static int tambahDataPrestasi(Scanner scanner, String[][] dataPrestasi, int jumlahData, int MAX_DATA, int tahunSaatIni) {
        if (jumlahData >= MAX_DATA) {
            System.out.println("Kapasitas data penuh! Tidak dapat menambahkan data baru.");
            return jumlahData;
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
        return jumlahData;
    }

    public static void tampilkanSemuaPrestasi(String[][] dataPrestasi, int jumlahData) {
        System.out.println("\n=== Daftar Semua Prestasi ===");
        if (jumlahData == 0) {
            System.out.println("Belum ada data prestasi.");
        } else {
            for (int i = 0; i < jumlahData; i++) {
                System.out.println((i + 1) + ". Nama: " + dataPrestasi[i][0] +
                        ", NIM: " + dataPrestasi[i][1] +
                        ", Jenis: " + dataPrestasi[i][2] +
                        ", Tingkat: " + dataPrestasi[i][3] +
                        ", Tahun: " + dataPrestasi[i][4]);
            }
        }
    }

    public static void analisisPrestasi(Scanner scanner, String[][] dataPrestasi, int jumlahData) {
        System.out.println("\n=== Analisis Prestasi Berdasarkan Jenis ===");
        System.out.print("Masukkan Jenis Prestasi: ");
        String jenisDicari = scanner.nextLine();

        boolean ditemukan = false;

        for (int i = 0; i < jumlahData; i++) {
            if (dataPrestasi[i][2].equalsIgnoreCase(jenisDicari)) {
                System.out.println("Nama: " + dataPrestasi[i][0] +
                        ", NIM: " + dataPrestasi[i][1] +
                        ", Tingkat: " + dataPrestasi[i][3] +
                        ", Tahun: " + dataPrestasi[i][4]);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada data prestasi dengan jenis tersebut.");
        }
    }
}
