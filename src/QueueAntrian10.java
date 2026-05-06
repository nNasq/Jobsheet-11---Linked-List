public class QueueAntrian10 {
    private NodeAntrian10 head;
    private NodeAntrian10 tail;
    private int size;
    private final int MAX_SIZE;

    public QueueAntrian10(int maxSize) {
        this.head     = null;
        this.tail     = null;
        this.size     = 0;
        this.MAX_SIZE = maxSize;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isFull() {
        return size >= MAX_SIZE;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
        System.out.println("  [INFO] Antrian berhasil dikosongkan.");
    }

    public void enqueue(TMahasiswa10 mhs) {
        if (isFull()) {
            System.out.println("  [GAGAL] Antrian penuh! Tidak dapat menambah data.");
            return;
        }
        NodeAntrian10 node = new NodeAntrian10(mhs, null);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail      = node;
        }
        size++;
        System.out.printf("  [OK] %s berhasil masuk antrian (nomor antrian: %d).%n",
                mhs.nama, size);
    }

    public TMahasiswa10 dequeue() {
        if (isEmpty()) {
            System.out.println("  [GAGAL] Antrian kosong! Tidak ada yang bisa dipanggil.");
            return null;
        }
        TMahasiswa10 dilayani = head.data;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return dilayani;
    }

    public void tampilTerdepan() {
        if (isEmpty()) {
            System.out.println("  [INFO] Antrian kosong.");
        } else {
            System.out.println("  Antrian terdepan:");
            System.out.printf("  %-12s %-20s %-6s %-5s %-30s%n",
                    "NIM","Nama","Kelas","IPK","Keperluan");
            System.out.println("  " + "-".repeat(78));
            head.data.tampilInformasi();
        }
    }

    public void tampilTerakhir() {
        if (isEmpty()) {
            System.out.println("  [INFO] Antrian kosong.");
        } else {
            System.out.println("  Antrian paling akhir:");
            System.out.printf("  %-12s %-20s %-6s %-5s %-30s%n",
                    "NIM","Nama","Kelas","IPK","Keperluan");
            System.out.println("  " + "-".repeat(78));
            tail.data.tampilInformasi();
        }
    }

    public int jumlahAntrian() {
        return size;
    }

    public void tampilAntrian() {
        if (isEmpty()) {
            System.out.println("  [INFO] Antrian kosong.");
            return;
        }
        System.out.println("  Daftar Antrian Layanan Unit Kemahasiswaan:");
        System.out.printf("  %-4s %-12s %-20s %-6s %-5s %-30s%n",
                "No.","NIM","Nama","Kelas","IPK","Keperluan");
        System.out.println("  " + "-".repeat(82));
        NodeAntrian10 tmp = head;
        int no = 1;
        while (tmp != null) {
            System.out.printf("  %-4d", no++);
            tmp.data.tampilInformasi();
            tmp = tmp.next;
        }
        System.out.println("  " + "-".repeat(82));
        System.out.printf("  Total mahasiswa mengantri: %d mahasiswa%n", size);
    }
}
