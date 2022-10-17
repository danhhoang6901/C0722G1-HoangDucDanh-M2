package module2.model;

public abstract class TaiKhoan {
    private int id;
    private String maTaiKhoan;
    private String tenTaiKhoan;
    private String ngayTaoTaiKhoan;

    public abstract String getInfo();

    public TaiKhoan() {
    }

    public TaiKhoan(int id, String maTaiKhoan, String tenTaiKhoan, String ngayTaoTaiKhoan) {
        this.id = id;
        this.maTaiKhoan = maTaiKhoan;
        this.tenTaiKhoan = tenTaiKhoan;
        this.ngayTaoTaiKhoan = ngayTaoTaiKhoan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getNgayTaoTaiKhoan() {
        return ngayTaoTaiKhoan;
    }

    public void setNgayTaoTaiKhoan(String ngayTaoTaiKhoan) {
        this.ngayTaoTaiKhoan = ngayTaoTaiKhoan;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s", id, maTaiKhoan, tenTaiKhoan, ngayTaoTaiKhoan);
    }
}
