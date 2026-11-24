import java.util.Scanner;
/** Menu console aplikasi rental. */
public class Main {
    private static final Scanner input=new Scanner(System.in);
    private static String baca(String label){System.out.print(label+": ");return input.nextLine().trim();}
    public static void main(String[] args){Rental rental=new Rental();System.out.println("OCHA ARSITA - 22515063 | Rental Kendaraan");while(true){System.out.println("\n1. Tambah kendaraan\n2. Daftar kendaraan\n3. Tambah penyewa\n4. Daftar penyewa\n5. Buat sewa (push)\n6. Cari kendaraan\n7. Batalkan terakhir (pop)\n8. Lihat terakhir (peek)\n9. Tampilkan stack\n10. Ringkasan\n0. Keluar");if(!input.hasNextLine())return;try{switch(baca("Pilihan")){
        case "1": rental.tambahKendaraan(new Kendaraan(baca("Kode"),baca("Nama"),Double.parseDouble(baca("Tarif harian"))));break;
        case "2": rental.daftarKendaraan();break;
        case "3": rental.tambahPenyewa(new Penyewa(baca("Kode"),baca("Nama"),baca("Telepon"),baca("Alamat")));break;
        case "4": rental.daftarPenyewa();break;
        case "5": rental.buatSewa(baca("Kode kendaraan"),baca("Kode penyewa"),Integer.parseInt(baca("Lama hari")));break;
        case "6": Kendaraan k=rental.cariKendaraan(baca("Kode"));if(k==null)System.out.println("Tidak ditemukan");else k.tampilkanInfo();break;
        case "7": rental.batalkanTerakhir();break;
        case "8": rental.lihatTerakhir();break;
        case "9": rental.tampilkanStack();break;
        case "10": rental.ringkasan();break;
        case "0": return;
        default: System.out.println("Pilihan tidak valid");
    }}catch(NumberFormatException e){System.out.println("Masukkan angka yang valid");}catch(IllegalArgumentException e){System.out.println("Kesalahan: "+e.getMessage());}catch(java.util.NoSuchElementException e){return;}}}
}
