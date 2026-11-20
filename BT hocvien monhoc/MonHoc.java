import java.util.ArrayList;

public class MonHoc {
    public int maMH;
    public String tenMH;
    public ArrayList<HocVien> hocVienList;
    public ArrayList<GiaoVien> giaoVienList;

    public MonHoc(int maMH, String tenMH) {
        this.maMH = maMH;
        this.tenMH = tenMH;
    }

    public void addHocVien(HocVien hv) {
        if (hocVienList == null)
            hocVienList = new ArrayList<>();
        if (!hocVienList.contains(hv)) {
            hocVienList.add(hv);
            hv.addMonHoc(this);
        }
    }

    public void removeHocVien(HocVien hv) {
        if (hocVienList != null && hocVienList.contains(hv)) {
            hocVienList.remove(hv);
            hv.removeMonHoc(this);
        }
    }

    public void addGiaoVien(GiaoVien gv) {
        if (giaoVienList == null)
            giaoVienList = new ArrayList<>();
        if (!giaoVienList.contains(gv)) {
            giaoVienList.add(gv);
            gv.addMonHoc(this);
        }
    }

    public void removeGiaoVien(GiaoVien gv) {
        if (giaoVienList != null && giaoVienList.contains(gv)) {
            giaoVienList.remove(gv);
            gv.removeMonHoc(this);
        }
    }

    @Override
    public String toString() {
        String s = maMH + " " + tenMH + ":";
        if (hocVienList != null)
            for (HocVien hv : hocVienList)
                s += " " + hv.hoTen + ";";
        s += " (";
        if (giaoVienList != null)
            for (int i = 0; i < giaoVienList.size(); i++) {
                if (i > 0) s += " ";
                s += giaoVienList.get(i).hoTen + ";";
            }
        s += ")";
        return s;
    }
}