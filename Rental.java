import java.util.ArrayList;
/** Pengelola data dan transaksi rental. */
public class Rental {
    private String nama;
    private final ArrayList<Kendaraan> kendaraan=new ArrayList<>();
    private final ArrayList<Penyewa> penyewa=new ArrayList<>();
    private final StackSewa riwayat;
    private double total;
    public Rental(){this("Rental OCHA ARSITA",5);}
    public Rental(String nama,int kapasitas){setNama(nama);this.riwayat=new StackSewa(kapasitas);}
    public String getNama(){return nama;} public void setNama(String nama){if(nama==null||nama.isBlank())throw new IllegalArgumentException("Nama kosong");this.nama=nama;} public double getTotal(){return total;}
    public Kendaraan cariKendaraan(String kode){for(Kendaraan k:kendaraan)if(k.getKode().equalsIgnoreCase(kode))return k;return null;}
    public Penyewa cariPenyewa(String kode){for(Penyewa p:penyewa)if(p.cocokKode(kode))return p;return null;}
    public void tambahKendaraan(Kendaraan k){if(k==null||cariKendaraan(k.getKode())!=null)throw new IllegalArgumentException("Kendaraan kosong atau kode duplikat");kendaraan.add(k);}
    public void tambahPenyewa(Penyewa p){if(p==null||cariPenyewa(p.getKode())!=null)throw new IllegalArgumentException("Penyewa kosong atau kode duplikat");penyewa.add(p);}
    public void daftarKendaraan(){if(kendaraan.isEmpty())System.out.println("Belum ada kendaraan");for(Kendaraan k:kendaraan)k.tampilkanInfo();}
    public void daftarPenyewa(){if(penyewa.isEmpty())System.out.println("Belum ada penyewa");for(Penyewa p:penyewa)p.tampilkanInfo();}
    public void buatSewa(String k,String p,int hari){if(riwayat.isFull())throw new IllegalArgumentException("Stack penuh");Kendaraan v=cariKendaraan(k);Penyewa u=cariPenyewa(p);if(v==null||u==null)throw new IllegalArgumentException("Data tidak ditemukan");Sewa s=new Sewa(v,u,hari);if(!Double.isFinite(total+s.hitungBiaya()))throw new IllegalArgumentException("Total terlalu besar");s.mulai();riwayat.push(s);total+=s.hitungBiaya();s.tampilkanInfo();}
    public void batalkanTerakhir(){Sewa s=riwayat.pop();if(s==null){System.out.println("Stack kosong");return;}s.selesai();total-=s.hitungBiaya();System.out.println("Transaksi terakhir dibatalkan");}
    public void lihatTerakhir(){Sewa s=riwayat.peek();if(s==null)System.out.println("Stack kosong");else s.tampilkanInfo();}
    public void tampilkanStack(){riwayat.tampilkan();}
    public void ringkasan(){System.out.printf("%s | Kendaraan: %d | Penyewa: %d | Transaksi: %d | Total: Rp%.2f%n",nama,kendaraan.size(),penyewa.size(),riwayat.size(),total);}
}
