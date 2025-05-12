
import java.util.Scanner; // Mengimpor kelas Scanner untuk membaca input dari pengguna
// Kelas Mahasiswa merepresentasikan data mahasiswa

class Mahasiswa {

    String nim;       // Menyimpan Nomor Induk Mahasiswa
    String nama;      // Menyimpan nama mahasiswa
    String jurusan;   // Menyimpan jurusan mahasiswa
    double ipk;       // Menyimpan IPK mahasiswa

    // Konstruktor untuk menginisialisasi atribut mahasiswa
    public Mahasiswa(String nim, String nama, String jurusan, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    // Override method toString untuk menampilkan data mahasiswa dengan format yang rapi
    @Override//mrngganti
    public String toString() {
        return String.format("NIM: %s\nNama: %s\nJurusan: %s\nIPK: %.2f", nim, nama, jurusan, ipk);
    }
}
// Kelas utama untuk menjalankan program pencarian data mahasiswa

public class PencarianDataMahasiswa {

    public static void main(String[] args) {
        // Inisialisasi array berisi data mahasiswa
        Mahasiswa[] daftarMahasiswa = {
            new Mahasiswa("2023001", "Budi Santoso", "Teknik Informatika", 3.75),
            new Mahasiswa("2023002", "Andi Wijaya", "Sistem Informasi", 3.50),
            new Mahasiswa("2023003", "Dewi Lestari", "Teknik Komputer", 3.90),
            new Mahasiswa("2023004", "Rina Maulana", "Teknik Informatika", 3.60),
            new Mahasiswa("2023005", "Doni Kusuma", "Manajemen Informatika", 3.25),
            new Mahasiswa("2023006", "Sinta Rahma", "Sistem Informasi", 3.85),
            new Mahasiswa("2023007", "Rudi Hermawan", "Teknik Komputer", 3.40)
        };

        // Membuat objek Scanner untuk membaca input dari pengguna
        Scanner scanner = new Scanner(System.in);

        // Menampilkan judul program
        System.out.println("=== SISTEM PENCARIAN DATA MAHASISWA ===");

        // Meminta pengguna untuk memasukkan NIM mahasiswa yang dicari
        System.out.print("Masukkan NIM Mahasiswa yang dicari: ");
        String nimCari = scanner.nextLine(); // Membaca input NIM dari pengguna

        // Melakukan pencarian mahasiswa berdasarkan NIM
        Mahasiswa hasilPencarian = cariMahasiswaByNIM(daftarMahasiswa, nimCari);

        // Menampilkan hasil pencarian
        System.out.println("\nHASIL PENCARIAN:");
        if (hasilPencarian != null) {
            // Jika mahasiswa ditemukan, tampilkan datanya
            System.out.println("Mahasiswa ditemukan!");
            System.out.println(hasilPencarian);
        } else {
            // Jika tidak ditemukan, tampilkan pesan tidak ditemukan
            System.out.println("Mahasiswa dengan NIM " + nimCari + " tidak ditemukan.");
        }

        // Menutup objek Scanner
        scanner.close();
    }

    // Method untuk mencari mahasiswa berdasarkan NIM (pencarian linear)
    public static Mahasiswa cariMahasiswaByNIM(Mahasiswa[] daftarMahasiswa, String nim) {
        for (int i = 0; i < daftarMahasiswa.length; i++) {
            // Bandingkan setiap NIM mahasiswa dalam array dengan NIM yang dicari
            if (daftarMahasiswa[i].nim.equals(nim)) {
                return daftarMahasiswa[i]; // Mengembalikan objek mahasiswa jika cocok
            }
        }
        // Jika tidak ditemukan, kembalikan null
        return null;
    }
}
