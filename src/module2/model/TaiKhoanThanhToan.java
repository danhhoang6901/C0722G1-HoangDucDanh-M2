package module2.model;

public class TaiKhoanThanhToan extends TaiKhoan {
    private int soThe;
    private int soTien;

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s", super.toString(), soThe, soTien);
    }

    public TaiKhoanThanhToan() {
    }

    public TaiKhoanThanhToan(int soThe, int soTien) {
        this.soThe = soThe;
        this.soTien = soTien;
    }

    public TaiKhoanThanhToan(int id, String maTaiKhoan, String tenTaiKhoan, String ngayTaoTaiKhoan, int soThe, int soTien) {
        super(id, maTaiKhoan, tenTaiKhoan, ngayTaoTaiKhoan);
        this.soThe = soThe;
        this.soTien = soTien;
    }

    public int getSoThe() {
        return soThe;
    }

    public void setSoThe(int soThe) {
        this.soThe = soThe;
    }

    public int getSoTien() {
        return soTien;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s", super.toString(), soThe, soTien);
    }
}
