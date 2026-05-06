

public class Mahasiswa10 {
    String nim;
    String nama;
    String kelas;
    double ipk;
    String keperluan;

    public Mahasiswa10() {}

    public Mahasiswa10(String nm, String name, String kls, double ip) {
        this.nim   = nm;
        this.nama  = name;
        this.kelas = kls;
        this.ipk   = ip;
    }

    public void tampilInformasi() {
        System.out.printf("%-15s %-15s %-5s %.1f%n", nama, nim, kelas, ipk);
    }
}