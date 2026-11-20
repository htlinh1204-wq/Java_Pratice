import java.util.ArrayList;

public class HocVien {
    public int maHV;
    public String hoTen;
    public ArrayList<MonHoc> monHocList;   // chưa khởi tạo, mặc định là null

    public HocVien(int maHV, String hoTen) {
        this.maHV = maHV;
        this.hoTen = hoTen;
    }

    public void addMonHoc(MonHoc m) {
        if (monHocList == null)
            monHocList = new ArrayList<>();
        if (!monHocList.contains(m)) {
            monHocList.add(m);
            m.addHocVien(this);
        }
    }

    public void removeMonHoc(MonHoc m) {
        if (monHocList != null && monHocList.contains(m)) {
            monHocList.remove(m);
            m.removeHocVien(this);
        }
    }

    @Override
    public String toString() {
        String s = maHV + " " + hoTen + ":";
        if (monHocList != null)
            for (MonHoc m : monHocList)
                s += " " + m.tenMH + ";";
        return s;
    }
}