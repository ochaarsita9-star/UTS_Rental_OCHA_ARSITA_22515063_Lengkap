/** Stack transaksi berbasis array dengan kapasitas tetap. */
public class StackSewa {
    private final Sewa[] data;
    private int jumlah;
    public StackSewa(int kapasitas){if(kapasitas<=0)throw new IllegalArgumentException("Kapasitas tidak valid");data=new Sewa[kapasitas];}
    public boolean push(Sewa s){if(isFull()||s==null)return false;data[jumlah++]=s;return true;}
    public Sewa pop(){if(isEmpty())return null;Sewa s=data[--jumlah];data[jumlah]=null;return s;}
    public Sewa peek(){return isEmpty()?null:data[jumlah-1];}
    public boolean isEmpty(){return jumlah==0;} public boolean isFull(){return jumlah==data.length;} public int size(){return jumlah;}
    public void tampilkan(){if(isEmpty())System.out.println("Stack kosong");for(int i=jumlah-1;i>=0;i--)data[i].tampilkanInfo();}
}
