/** Entitas pelanggan rental. */
public class Penyewa {
    private String kode,nama,telepon,alamat;
    public Penyewa(){this("P0","Belum diisi","0","Belum diisi");}
    public Penyewa(String kode,String nama,String telepon,String alamat){setKode(kode);setNama(nama);setTelepon(telepon);setAlamat(alamat);}
    private String valid(String s){if(s==null||s.isBlank())throw new IllegalArgumentException("Data kosong");return s;}
    public String getKode(){return kode;} public String getNama(){return nama;} public String getTelepon(){return telepon;} public String getAlamat(){return alamat;}
    public void setKode(String kode){this.kode=valid(kode);} public void setNama(String nama){this.nama=valid(nama);} public void setTelepon(String telepon){if(telepon==null||!telepon.matches("[0-9+ -]+")||!telepon.matches(".*[0-9].*"))throw new IllegalArgumentException("Telepon tidak valid");this.telepon=telepon;} public void setAlamat(String alamat){this.alamat=valid(alamat);}
    public void ubahKontak(String nomor){setTelepon(nomor);} public boolean cocokKode(String k){return kode.equalsIgnoreCase(k);} public void tampilkanInfo(){System.out.println(kode+" | "+nama+" | "+telepon+" | "+alamat);}
}
