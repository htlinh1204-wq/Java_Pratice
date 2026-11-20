package buoi_3;

import java.util.Scanner;

public class Buoi_3 {

      public static void main(String[] args) {
          
          // Cau 6
//     Scanner sc = new Scanner(System.in);
//     System.out.print(" Nhap so hang va cot: ");
//     int hang = sc.nextInt();
//     int cot  = sc.nextInt();
//     double a[][]= new double[hang][cot];
//     System.out.println(" Nhap cac phan tu: ");
//     for(int i = 0; i < hang ; i++)
//         for(int j = 0; j < cot ; j++){
//             System.out.print("a[" + i + "][" + j + "]: ");
//             a[i][j] = sc.nextDouble();
//        }
//     Location loc = Location.locateLargest(a);
//     System.out.print("Phan tu llon nhat la " + loc.maxValue + " o vi tri (" + row + ", " + column  + ")");
//     

        //-----------Cau 7----------
        Scanner sc = new Scanner(System.in);
        System.out.print("Tử số của phân số thứ 1: ");
        int tuso1 = sc.nextInt();
        System.out.print("Mẫu số của phân số thứ 1: ");
        int mauso1 = sc.nextInt();
        System.out.print("Tử số của phân số thứ 2: ");
        int tuso2 = sc.nextInt();
        System.out.print("Mẫu số của phân số thứ 2: ");
        int mauso2 = sc.nextInt();

        PhanSo ps1= new PhanSo(tuso1, mauso1);
        PhanSo ps2= new PhanSo(tuso2, mauso2);
        
        PhanSo tong = ps1.cong(ps2);
        PhanSo hieu = ps1.tru(ps2);
        PhanSo nhan = ps1.nhan(ps2);
        PhanSo chia = ps1.chia(ps2);
        
        System.out.println(ps1.toString() + " + " +  ps2.toString() + " = " + tong.toString());
        System.out.println(ps1.toString() + " - " +  ps2.toString() + " = " + hieu.toString());
        System.out.println(ps1.toString() + " * " +  ps2.toString() + " = " + nhan.toString());
        System.out.println(ps1.toString() + " / " +  ps2.toString() + " = " + chia.toString());

      }
}

class Location{
    public int row, column;
    public double maxValue;
    //Khai bao mac dinh
    public Location(int row, int column, double maxValue){
        this.row = row; this.column = column; this.maxValue = maxValue;
    }
    
    //Tao phuong thuc tim max
    public static Location locateLargest(double[][] a){
        int hang =0;
        int cot = 0;
        double maxVal = a[hang][cot];
        for(int i = 0; i< a.length; i++)  //Duyet hang
            for(int j = 0; j< a[i].length; j++)  //Duyet cot
                if(a[i][j] > maxVal){
                    hang = i ; cot = j; maxVal = a[i][j];
                }
        return new Location(hang, cot, maxVal);
    }
}


class PhanSo{
    private int tu, mau;
    public PhanSo (int tu, int mau){
        this.mau = mau ; this.tu = tu;
    }
    
    @Override
    public String toString(){
        return tu + "/" + mau;
    }
    
    // Tim uoc so chung de toi gian
    public int USCLN(int a, int b){
        //Eculid
        a= Math.abs(a); b = Math.abs(b); // Tranh TH 1/-4
        while(b!= 0 ){
            int r= a%b;
            a = b;
            b = r;
        }
        return a;
    }
    
    //Phuong thuc toi gian phan so
    public void toiGian(){
        int usc = USCLN(this.tu, this.mau);
        this.tu= this.tu/usc;
        this.mau = this.mau/usc;
    }
    
    //Phuong thuc cong
    public PhanSo cong(PhanSo ps){
        int newTu  = this.tu*ps.mau + this.mau*ps.tu;
        int newMau = this.mau*ps.mau;
        
        PhanSo p =new PhanSo(newTu, newMau);
        p.toiGian();
        return p ;
    }
    
    //Phuong Thuc Tru
    public PhanSo tru(PhanSo ps){
        int newTu  = this.tu*ps.mau - this.mau*ps.tu;
        int newMau = this.mau*ps.mau;
        
        PhanSo p =new PhanSo(newTu, newMau);
        p.toiGian();
        return p ;
    }
    
    //Phương thuc nhan
    public PhanSo nhan(PhanSo ps){
        int newTu  = this.tu*ps.tu;
        int newMau = this.mau*ps.mau;
        
        PhanSo p =new PhanSo(newTu, newMau);
        p.toiGian();
        return p ;
    }
    
      //Phương thuc chia
    public PhanSo chia(PhanSo ps){
        int newTu  = this.tu*ps.mau;
        int newMau = this.mau*ps.tu;
        
        PhanSo p =new PhanSo(newTu, newMau);
        p.toiGian();
        return p ;
    }
}

/**
* 1.Viết chương trình yêu cầu người dùng nhập vào một số thập phân, sau đó hiển thị số đó dưới dạng phân số. 
* Định nghĩa lớp PhanSo với các thành phần dữ liệu và phương thức cần thiết để thực hiện yêu cầu. 
* Ví dụ:
* Nhap so thap phan: 3.25
* Phan so cua 3.25 la: 13/4
 */

