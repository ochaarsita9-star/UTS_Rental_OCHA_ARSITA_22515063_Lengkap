/** Transaksi dan perhitungan biaya sewa. */
public class Sewa {
    private Kendaraan kendaraan;
    private Penyewa penyewa;
    private int hari;
    private double tarif;
    private boolean aktif;
    public Sewa(){this(new Kendaraan(),new Penyewa(),1);}
    public Sewa(Kendaraan kendaraan,Penyewa penyewa,int hari){if(kendaraan==null||penyewa==null||hari<=0)throw new IllegalArgumentException("Data sewa tidak valid");this.kendaraan=kendaraan;this.penyewa=penyewa;this.hari=hari;this.tarif=kendaraan.getTarif();this.aktif=false;if(!Double.isFinite(hitungBiaya()))throw new IllegalArgumentException("Biaya terlalu besar");}
    public Kendaraan getKendaraan(){return kendaraan;} public Penyewa getPenyewa(){return penyewa;} public int getHari(){return hari;} public double getTarif(){return tarif;} public boolean isAktif(){return aktif;}
    public double hitungBiaya(){return tarif*hari;}
    public void mulai(){if(aktif)throw new IllegalArgumentException("Sewa sudah aktif");kendaraan.sewakan();this.aktif=true;}
    public void selesai(){if(aktif){kendaraan.kembalikan();this.aktif=false;}}
    public void tampilkanInfo(){System.out.printf("%s | %s | %d hari | Rp%.2f | %s%n",kendaraan.getKode(),penyewa.getNama(),hari,hitungBiaya(),aktif?"Aktif":"Selesai");}
}
