/** Pengujian mandiri tanpa pustaka tambahan. */
public class PengujianRental {
    private static int lulus;
    private static void uji(String nama, Runnable aksi) {
        try { aksi.run(); lulus++; System.out.println("LULUS: " + nama); }
        catch (RuntimeException | AssertionError e) { System.out.println("GAGAL: " + nama + " - " + e); }
    }
    private static void cek(boolean kondisi) { if (!kondisi) throw new AssertionError("Hasil tidak sesuai"); }
    private static void ditolak(Runnable aksi) {
        try { aksi.run(); } catch (IllegalArgumentException e) { return; }
        throw new AssertionError("Seharusnya ditolak");
    }
    public static void main(String[] args) {
        Rental r = new Rental("Rental OCHA ARSITA", 5);
        Kendaraan k = new Kendaraan("K1", "Avanza", 150000);
        Penyewa p = new Penyewa("P1", "Budi", "08123456", "Kendari");
        uji("Tambah kendaraan", () -> { r.tambahKendaraan(k); cek(r.cariKendaraan("K1") == k); });
        uji("Tambah penyewa", () -> { r.tambahPenyewa(p); cek(r.cariPenyewa("P1") == p); });
        uji("Sewa tiga hari", () -> { r.buatSewa("K1", "P1", 3); cek(r.getTotal() == 450000 && !k.isTersedia()); });
        uji("Sewa ganda", () -> ditolak(() -> r.buatSewa("K1", "P1", 1)));
        uji("Kode duplikat", () -> ditolak(() -> r.tambahKendaraan(k)));
        uji("Durasi nol", () -> ditolak(() -> new Sewa(k,p,0)));
        uji("Stack kosong", () -> { StackSewa s = new StackSewa(1); cek(s.pop() == null && s.peek() == null); });
        uji("Stack penuh", () -> { StackSewa s = new StackSewa(1); Sewa a = new Sewa(k,p,1); cek(s.push(a) && s.isFull() && !s.push(a) && s.pop() == a); });
        uji("Nama kosong", () -> ditolak(() -> new Kendaraan("K2", "", 100)));
        uji("Input angka salah", () -> ditolak(() -> Integer.parseInt("abc")));
        uji("Pembatalan", () -> { r.batalkanTerakhir(); cek(k.isTersedia() && r.getTotal() == 0); });
        System.out.println("Lulus: " + lulus + "/11");
        if (lulus != 11) throw new AssertionError("Pengujian gagal");
    }
}
