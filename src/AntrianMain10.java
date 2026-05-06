import java.util.Scanner;

public class AntrianMain10 {
    static Scanner sc = new Scanner(System.in);
    static QueueAntrian10 antrian = new QueueAntrian10(10);

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║   SISTEM ANTRIAN LAYANAN UNIT KEMAHASISWAAN      ║");
        System.out.println("╚══════════════════════════════════════════════════╝");

        boolean running = true;
        while (running) {
            tampilMenu();
            System.out.print("Pilih menu: ");
            String pilihan = sc.nextLine().trim();

            System.out.println();
            switch (pilihan) {
                case "1" -> daftarMahasiswa();
                case "2" -> panggilAntrian();
                case "3" -> antrian.tampilAntrian();
                case "4" -> antrian.tampilTerdepan();
                case "5" -> antrian.tampilTerakhir();
                case "6" -> System.out.println("  Jumlah mahasiswa mengantri: "
                        + antrian.jumlahAntrian() + " orang");
                case "7" -> cekStatus();
                case "8" -> {
                    System.out.print("  Yakin mengosongkan antrian? (y/n): ");
                    if (sc.nextLine().trim().equalsIgnoreCase("y"))
                        antrian.clear();
                }
                case "0" -> {
                    System.out.println("  Sistem antrian ditutup. Terima kasih!");
                    running = false;
                }
                default -> System.out.println("  [!] Pilihan tidak valid.");
            }
            System.out.println();
        }
    }

    static void tampilMenu() {
        System.out.println("──────────────────────────────────────────────────");
        System.out.println(" [1] Daftar Antrian (Enqueue)");
        System.out.println(" [2] Panggil / Layani Antrian (Dequeue)");
        System.out.println(" [3] Tampilkan Semua Antrian");
        System.out.println(" [4] Tampilkan Antrian Terdepan");
        System.out.println(" [5] Tampilkan Antrian Paling Akhir");
        System.out.println(" [6] Jumlah Mahasiswa Mengantri");
        System.out.println(" [7] Cek Status Antrian (Kosong / Penuh)");
        System.out.println(" [8] Kosongkan Antrian");
        System.out.println(" [0] Keluar");
        System.out.println("──────────────────────────────────────────────────");
    }

    static void daftarMahasiswa() {
        if (antrian.isFull()) {
            System.out.println("  [GAGAL] Antrian penuh!");
            return;
        }
        System.out.println("  -- Pendaftaran Antrian --");
        System.out.print("  NIM       : ");
        String nim = sc.nextLine();
        System.out.print("  Nama      : ");
        String nama = sc.nextLine();
        System.out.print("  Kelas     : ");
        String kls = sc.nextLine();
        System.out.print("  IPK       : ");
        double ipk;
        try {
            ipk = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            ipk = 0.0;
        }
        System.out.print("  Keperluan : ");
        String kep = sc.nextLine();

        TMahasiswa10 mhs = new TMahasiswa10(nim, nama, kls, ipk, kep);
        antrian.enqueue(mhs);
    }

    static void panggilAntrian() {
        System.out.println("  -- Memanggil Antrian Berikutnya --");
        TMahasiswa10 dilayani = antrian.dequeue();
        if (dilayani != null) {
            System.out.println("  ✔ Mahasiswa yang dipanggil untuk dilayani:");
            System.out.printf("    Nama      : %s%n", dilayani.nama);
            System.out.printf("    NIM       : %s%n", dilayani.nim);
            System.out.printf("    Kelas     : %s%n", dilayani.kelas);
            System.out.printf("    IPK       : %.2f%n", dilayani.ipk);
            System.out.printf("    Keperluan : %s%n", dilayani.keperluan);
            System.out.printf("  Sisa antrian: %d orang%n", antrian.jumlahAntrian());
        }
    }

    static void cekStatus() {
        System.out.println("  Status antrian:");
        System.out.println("    Kosong : " + (antrian.isEmpty() ? "YA" : "TIDAK"));
        System.out.println("    Penuh  : " + (antrian.isFull() ? "YA" : "TIDAK"));
        System.out.println("    Jumlah : " + antrian.jumlahAntrian() + " orang");
    }
}
