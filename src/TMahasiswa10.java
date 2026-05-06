

public class TMahasiswa10 {
    String nim;
    String nama;
    String kelas;
    double ipk;
    String keperluan;

    public TMahasiswa10() {
    }

    public TMahasiswa10(String nim, String nama, String kelas, double ipk, String keperluan) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.ipk = ipk;
        this.keperluan = keperluan;
    }

    public void tampilInformasi() {
        System.out.printf("  %-12s %-20s %-6s %.2f  %-30s%n",
                nim, nama, kelas, ipk, keperluan);
    }
}
