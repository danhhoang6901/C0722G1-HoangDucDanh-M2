package module2.service.impl;

import module2.model.TaiKhoanTietKiem;
import module2.service.ITaiKhoanTietKiemService;
import module2.service.exception.NotFoundBankAccountException;
import module2.util.tai_khoan_tiet_kiem.ReadFileTaiKhoanTietKiem;
import module2.util.tai_khoan_tiet_kiem.WriteFileTaiKhoanTietKiem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaiKhoanTietKiemService implements ITaiKhoanTietKiemService {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<TaiKhoanTietKiem> taiKhoanTietKiems = new ArrayList<>();
    private static final String SRC_TAI_KHOAN_TIET_KIEM = "src\\module2\\data\\tai_khoan_tiet_kiem.csv";

    public TaiKhoanTietKiem infoTaiKhoan() {
        taiKhoanTietKiems = ReadFileTaiKhoanTietKiem.readFileTaiKhoanTietKiem(SRC_TAI_KHOAN_TIET_KIEM);
        int id = taiKhoanTietKiems.size() + 1;

        String maTaKhoan;
        do {
            System.out.print("Nhập mã tài khoản: ");
            try {
                maTaKhoan = scanner.nextLine();
                if (!maTaKhoan.matches("^[0-9]{9}$")) {
                    throw new NotFoundBankAccountException("Mã tài khoản không hợp lệ!");
                }
                for (TaiKhoanTietKiem taiKhoanTietKiem : taiKhoanTietKiems) {
                    if (taiKhoanTietKiem.getMaTaiKhoan().equals(maTaKhoan)) {
                        throw new NotFoundBankAccountException("Mã tài khoản đã tồn tại!");
                    }
                }
                break;
            } catch (NotFoundBankAccountException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        String tenTaiKhoan;
        do {
            System.out.print("Nhập tên tài khoản: ");
            try {
                tenTaiKhoan = scanner.nextLine();
                if (!tenTaiKhoan.matches("^\\D{5,50}\\s*$")) {
                    throw new NotFoundBankAccountException("Tên không hợp lệ!");
                }
                break;
            } catch (NotFoundBankAccountException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        String ngayTaoTaiKhoan;
        do {
            System.out.print("Nhập ngày tạo tài khoản theo định dạng dd/MM/yyyy: ");
            try {
                ngayTaoTaiKhoan = scanner.nextLine();
                if (!ngayTaoTaiKhoan.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
                    throw new NotFoundBankAccountException("Không đúng định dạng dd/MM/yyyy!");
                }
                break;
            } catch (NotFoundBankAccountException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        int soTienGui;
        do {
            System.out.print("Nhập số tiền gửi: ");
            try {
                soTienGui = Integer.parseInt(scanner.nextLine());
                if (soTienGui < 0 || soTienGui > 1000000000) {
                    throw new NotFoundBankAccountException("Số tiền gửi phải là số dương và không quá 1 tỷ!");
                }
                break;
            } catch (NotFoundBankAccountException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        String ngayGui;
        do {
            System.out.print("Nhập ngày gửi theo định dạng dd/MM/yyyy: ");
            try {
                ngayGui = scanner.nextLine();
                if (!ngayGui.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
                    throw new NotFoundBankAccountException("Không đúng định dạng dd/MM/yyyy!");
                }
                break;
            } catch (NotFoundBankAccountException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        int laiSuat;
        do {
            System.out.print("Nhập lãi suất: ");
            try {
                laiSuat = Integer.parseInt(scanner.nextLine());
                if (laiSuat < 0) {
                    throw new NotFoundBankAccountException("Lãi suất phải là số dương!");
                }
                break;
            } catch (NotFoundBankAccountException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        int kyHan;
        do {
            System.out.print("Nhập kỳ hạn (số tháng ): ");
            try {
                kyHan = Integer.parseInt(scanner.nextLine());
                if (kyHan < 0) {
                    throw new NotFoundBankAccountException("Kỳ hạn phải số dương!");
                }
                break;
            } catch (NotFoundBankAccountException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        return new TaiKhoanTietKiem(id, maTaKhoan, tenTaiKhoan, ngayTaoTaiKhoan, soTienGui, ngayGui, laiSuat, kyHan);
    }

    @Override
    public void addTaiKhoanTietKiem() {
        TaiKhoanTietKiem taiKhoanTietKiem = this.infoTaiKhoan();
        taiKhoanTietKiems.add(taiKhoanTietKiem);
        WriteFileTaiKhoanTietKiem.writeFileTaiKhoanTietKiem(SRC_TAI_KHOAN_TIET_KIEM, taiKhoanTietKiems);
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void deleteTaiKhoanTietKien() {
        taiKhoanTietKiems = ReadFileTaiKhoanTietKiem.readFileTaiKhoanTietKiem(SRC_TAI_KHOAN_TIET_KIEM);
        String maTaKhoan;
        boolean flagDelete = false;
        do {
            System.out.print("Nhập mã tài khoản muốn xóa: ");
            try {
                maTaKhoan = scanner.nextLine();
                for (int i = 0; i < taiKhoanTietKiems.size(); i++) {
                    if (taiKhoanTietKiems.get(i).getMaTaiKhoan().contains(maTaKhoan)) {
                        System.out.println("Bạn có muốn xóa tài khoản này?");
                        System.out.println("Nhấn Y: Yes");
                        System.out.println("Nhấn N: No");
                        System.out.print("Chọn: ");
                        String choice = scanner.nextLine();
                        if (choice.equals("Y")) {
                            taiKhoanTietKiems.remove(i);
                            WriteFileTaiKhoanTietKiem.writeFileTaiKhoanTietKiem(SRC_TAI_KHOAN_TIET_KIEM, taiKhoanTietKiems);
                            System.out.println("Xóa thành công");
                        }
                        flagDelete = true;
                        break;
                    }
                }
                if (!flagDelete) {
                    throw new NotFoundBankAccountException("Không tìm thấy tài khoản!");
                }
                break;
            } catch (NotFoundBankAccountException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

    }

    @Override
    public void displayAllTaiKhoanTietKiem() {
        taiKhoanTietKiems = ReadFileTaiKhoanTietKiem.readFileTaiKhoanTietKiem(SRC_TAI_KHOAN_TIET_KIEM);
        if (taiKhoanTietKiems.size() == 0) {
            System.out.println("Danh sách trống!");
        } else {
            for (TaiKhoanTietKiem taiKhoanTietKiem : taiKhoanTietKiems) {
                System.out.println(taiKhoanTietKiem);
            }
        }
    }

    @Override
    public void searchTaiKhoanTietKiem() {
        taiKhoanTietKiems = ReadFileTaiKhoanTietKiem.readFileTaiKhoanTietKiem(SRC_TAI_KHOAN_TIET_KIEM);
        System.out.print("Nhập tên tài khoản bạn muốn tìm kiếm: ");
        String tenTaiKhoan = scanner.nextLine();
        boolean flag = false;
        for (TaiKhoanTietKiem taiKhoanTietKiem : taiKhoanTietKiems) {
            if (taiKhoanTietKiem.getTenTaiKhoan().contains(tenTaiKhoan)) {
                System.out.println(taiKhoanTietKiem);
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Không tìm thấy tài khoản!");
        }
    }
}
