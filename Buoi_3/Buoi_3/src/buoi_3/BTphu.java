
package buoi_3;

import java.util.Scanner;

public class BTphu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so thap phan: ");
        double so = sc.nextDouble();

        soThapPhan s = new soThapPhan(so);

        PhanSo ps = s.timPhanSo();

        System.out.println("Phan so cua " + so + " la: " + ps);

        sc.close();
    }
}

class PhanSo {
    private int tu, mau;

    public PhanSo(int tu, int mau) {
        if (mau == 0) {
            throw new IllegalArgumentException("Mau so phai khac 0!");
        }

        this.mau = mau;
        this.tu = tu;

        toiGian();
    }

    @Override
    public String toString() {
        return tu + "/" + mau;
    }

    // Tim uoc so chung lon nhat
    public int USCLN(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    // Toi gian phan so
    public void toiGian() {
        int usc = USCLN(this.tu, this.mau);

        this.tu = this.tu / usc;
        this.mau = this.mau / usc;

        // Dua dau am len tu so
        if (this.mau < 0) {
            this.tu = -this.tu;
            this.mau = -this.mau;
        }
    }
}

class soThapPhan {
    private double soTP;

    public soThapPhan(double soTP) {
        this.soTP = soTP;
    }

    public PhanSo timPhanSo() {

        int mauSo = 1;

        while (true) {

            double tuSo = this.soTP * mauSo;
            // Kiem tra tu so co phai so nguyen khong
            if (Math.abs(tuSo - Math.round(tuSo)) < 0.000000001) {
                return new PhanSo((int) Math.round(tuSo), mauSo);
            }
            mauSo++;
        }
    }
}
