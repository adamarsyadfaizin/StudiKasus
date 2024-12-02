import java.util.Scanner;

public class PencatatanPrestasi {
    static int MAX_PRESTASI = 100; 
    static String[][] prestasiArray = new String[MAX_PRESTASI][5]; 
    static int jumlahPrestasi = 0; 
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
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

            if (pilihan == 1) {
                tambahPrestasi();
            } else if (pilihan == 2) {
                tampilkanPrestasi();
            } else if (pilihan == 3) {
                analisisPrestasi();
            } else if (pilihan == 4) {
                System.out.println("Keluar dari program.");
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 4);
    }

    public static void tambahPrestasi() {
        if (jumlahPrestasi >= MAX_PRESTASI) {
            System.out.println("Data prestasi sudah penuh!");
            return;
        }

        System.out.println("\n=== Tambah Data Prestasi ===");
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan Jenis Prestasi: ");
        String jenis = scanner.nextLine();

        String tingkat;
        do {
            System.out.print("Masukkan Tingkat Prestasi (Lokal/Nasional/Internasional): ");
            tingkat = scanner.nextLine();
            if (!tingkat.equalsIgnoreCase("Lokal") && !tingkat.equalsIgnoreCase("Nasional") && !tingkat.equalsIgnoreCase("Internasional")) {
                System.out.println("Tingkat tidak valid! Harus Lokal, Nasional, atau Internasional.");
            }
        } while (!tingkat.equalsIgnoreCase("Lokal") && !tingkat.equalsIgnoreCase("Nasional") && !tingkat.equalsIgnoreCase("Internasional"));

        int tahun;
        do {
            System.out.print("Masukkan Tahun Prestasi (2010 - Sekarang): ");
            tahun = scanner.nextInt();
            scanner.nextLine(); 
            if (tahun < 2010 || tahun > java.time.Year.now().getValue()) {
                System.out.println("Tahun tidak valid! Harus antara 2010 hingga tahun sekarang.");
            }
        } while (tahun < 2010 || tahun > java.time.Year.now().getValue());

        prestasiArray[jumlahPrestasi][0] = nama;
        prestasiArray[jumlahPrestasi][1] = nim;
        prestasiArray[jumlahPrestasi][2] = jenis;
        prestasiArray[jumlahPrestasi][3] = tingkat;
        prestasiArray[jumlahPrestasi][4] = String.valueOf(tahun);
        jumlahPrestasi++;

        System.out.println("Data prestasi berhasil ditambahkan!");
    }

    public static void tampilkanPrestasi() {
        System.out.println("\n=== Daftar Semua Prestasi ===");
        if (jumlahPrestasi == 0) {
            System.out.println("Belum ada data prestasi.");
        } else {
            for (int i = 0; i < jumlahPrestasi; i++) {
                System.out.println((i + 1) + ". Nama: " + prestasiArray[i][0] +
                        ", NIM: " + prestasiArray[i][1] +
                        ", Jenis: " + prestasiArray[i][2] +
                        ", Tingkat: " + prestasiArray[i][3] +
                        ", Tahun: " + prestasiArray[i][4]);
            }
        }
    }

    public static void analisisPrestasi() {
        System.out.println("\n=== Analisis Prestasi Berdasarkan Jenis dan Tahun ===");
        System.out.print("Masukkan Jenis Prestasi: ");
        String jenisDicari = scanner.nextLine();
        System.out.print("Masukkan Tahun Prestasi: ");
        int tahunDicari = scanner.nextInt();
        scanner.nextLine(); 

        boolean ditemukan = false;

        for (int i = 0; i < jumlahPrestasi; i++) {
            if (prestasiArray[i][2].equalsIgnoreCase(jenisDicari) &&
                Integer.parseInt(prestasiArray[i][4]) == tahunDicari) {
                System.out.println("Nama: " + prestasiArray[i][0] +
                        ", NIM: " + prestasiArray[i][1] +
                        ", Tingkat: " + prestasiArray[i][3] +
                        ", Tahun: " + prestasiArray[i][4]);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada data prestasi dengan kriteria tersebut.");
        }
    }
}