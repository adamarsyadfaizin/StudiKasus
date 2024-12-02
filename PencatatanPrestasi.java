import java.util.Scanner;

public class PencatatanPrestasi {
    int MAX_PRESTASI = 100; 
    String[][] prestasiArray = new String[MAX_PRESTASI][5]; 
    int jumlahPrestasi = 0; 
    Scanner scanner = new Scanner(System.in);

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
            scanner.nextLine(); // Membersihkan buffer input

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
    }

    
    

