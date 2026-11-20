import java.util.ArrayList;

public class ChuongTrinh {
    public static void main(String[] args) {
        // Tạo đối tượng
        HocVien a = new HocVien(12, "Nguyễn Văn A");
        HocVien b = new HocVien(34, "Lê Thị B");

        MonHoc cauLong = new MonHoc(1, "Cầu lông");
        MonHoc quanVot = new MonHoc(2, "Quần vợt");
        MonHoc bongBan = new MonHoc(3, "Bóng bàn");
        MonHoc boiLoi  = new MonHoc(4, "Bơi lội");

        GiaoVien long_ = new GiaoVien(10, "Thầy Long");
        GiaoVien chi   = new GiaoVien(20, "Cô Chi");

        // Học viên đăng ký môn học (chỉ cần gọi một chiều, chiều ngược lại tự cập nhật)
        a.addMonHoc(cauLong);
        a.addMonHoc(quanVot);
        b.addMonHoc(quanVot);
        b.addMonHoc(bongBan);
        b.addMonHoc(boiLoi);

        // Giáo viên dạy môn học
        long_.addMonHoc(cauLong);
        long_.addMonHoc(boiLoi);
        chi.addMonHoc(cauLong);
        chi.addMonHoc(quanVot);
        chi.addMonHoc(bongBan);

        // Gom vào ArrayList để in
        ArrayList<HocVien> dsHV = new ArrayList<>();
        dsHV.add(a);
        dsHV.add(b);

        ArrayList<MonHoc> dsMH = new ArrayList<>();
        dsMH.add(cauLong);
        dsMH.add(quanVot);
        dsMH.add(bongBan);
        dsMH.add(boiLoi);

        ArrayList<GiaoVien> dsGV = new ArrayList<>();
        dsGV.add(long_);
        dsGV.add(chi);

        System.out.println("Học viên:");
        for (HocVien hv : dsHV) System.out.println("    " + hv);

        System.out.println("Môn học:");
        for (MonHoc mh : dsMH) System.out.println("    " + mh);

        System.out.println("Giáo viên:");
        for (GiaoVien gv : dsGV) System.out.println("    " + gv);

        // Kiểm tra thao tác xóa: hai chiều phải cùng được cập nhật
        System.out.println("\n--- Sau khi Nguyễn Văn A hủy môn Quần vợt ---");
        a.removeMonHoc(quanVot);
        System.out.println("    " + a);
        System.out.println("    " + quanVot);

        // Học viên chưa đăng ký môn nào: danh sách vẫn là null, toString không được lỗi
        System.out.println("\n--- Học viên chưa đăng ký môn nào ---");
        HocVien c = new HocVien(56, "Trần Văn C");
        System.out.println("    " + c);
    }
}