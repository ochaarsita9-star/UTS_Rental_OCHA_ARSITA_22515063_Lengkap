/** Entitas kendaraan dan status ketersediaan. */
public class Kendaraan {
    private String kode, nama;
    private double tarif;
    private boolean tersedia;
    public Kendaraan() { this("K0", "Belum diisi", 1); }
    public Kendaraan(String kode, String nama, double tarif) { setKode(kode); setNama(nama); setTarif(tarif); this.tersedia=true; }
    public String getKode(){return kode;} public String getNama(){return nama;} public double getTarif(){return tarif;} public boolean isTersedia(){return tersedia;}
    public void setKode(String kode){if(kode==null||kode.isBlank())throw new IllegalArgumentException("Kode kosong");this.kode=kode;}
    public void setNama(String nama){if(nama==null||nama.isBlank())throw new IllegalArgumentException("Nama kosong");this.nama=nama;}
    public void setTarif(double tarif){if(!Double.isFinite(tarif)||tarif<=0)throw new IllegalArgumentException("Tarif tidak valid");this.tarif=tarif;}
    public void sewakan(){if(!tersedia)throw new IllegalArgumentException("Kendaraan sedang disewa");this.tersedia=false;}
    public void kembalikan(){this.tersedia=true;}
    public void tampilkanInfo(){System.out.printf("%s | %s | Rp%.2f | %s%n",kode,nama,tarif,tersedia?"Tersedia":"Disewa");}
}
