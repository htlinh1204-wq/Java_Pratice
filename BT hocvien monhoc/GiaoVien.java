import java.util.ArrayList;

public class GiaoVien {
    public int maGV;
    public String hoTen;
    public ArrayList<MonHoc> monHocList;

    public GiaoVien(int maGV, String hoTen) {
        this.maGV = maGV;
        this.hoTen = hoTen;
    }

    public void addMonHoc(MonHoc m) {
        if (monHocList == null)
            monHocList = new ArrayList<>();
        if (!monHocList.contains(m)) {
            monHocList.add(m);
            m.addGiaoVien(this);
        }
    }

    public void removeMonHoc(MonHoc m) {
        if (monHocList != null && monHocList.contains(m)) {
            monHocList.remove(m);
            m.removeGiaoVien(this);
        }
    }

    @Override
    public String toString() {
        String s = maGV + " " + hoTen + ":";
        if (monHocList != null)
            for (MonHoc m : monHocList)
                s += " " + m.tenMH + ";";
        return s;
    }
}