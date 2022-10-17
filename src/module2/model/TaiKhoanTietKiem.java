package module2.model;

public class TaiKhoanTietKiem extends TaiKhoan {
    private int soTienGui;
    private String ngayGui;
    private int laiSuat;
    private int kyHan;

    public TaiKhoanTietKiem() {
    }

    public TaiKhoanTietKiem(int soTienGui, String ngayGui, int laiSuat, int kyHan) {
        this.soTienGui = soTienGui;
        this.ngayGui = ngayGui;
        this.laiSuat = laiSuat;
        this.kyHan = kyHan;
    }

    public TaiKhoanTietKiem(int id, String maTaiKhoan, String tenTaiKhoan, String ngayTaoTaiKhoan, int soTienGui, String ngayGui, int laiSuat, int kyHan) {
        super(id, maTaiKhoan, tenTaiKhoan, ngayTaoTaiKhoan);
        this.soTienGui = soTienGui;
        this.ngayGui = ngayGui;
        this.laiSuat = laiSuat;
        this.kyHan = kyHan;
    }

    public int getSoTienGui() {
        return soTienGui;
    }

    public void setSoTienGui(int soTienGui) {
        this.soTienGui = soTienGui;
    }

    public String getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(String ngayGui) {
        this.ngayGui = ngayGui;
    }

    public int getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(int laiSuat) {
        this.laiSuat = laiSuat;
    }

    public int getKyHan() {
        return kyHan;
    }

    public void setKyHan(int kyHan) {
        this.kyHan = kyHan;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s", super.toString(), soTienGui, ngayGui, laiSuat, kyHan);
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s", super.toString(), soTienGui, ngayGui, laiSuat, kyHan);
    }
}
