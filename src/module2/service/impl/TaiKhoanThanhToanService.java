package module2.service.impl;

import module2.model.TaiKhoanThanhToan;
import module2.model.TaiKhoanTietKiem;
import module2.service.ITaiKhoanThanhToanService;
import module2.service.exception.NotFoundBankAccountException;
import module2.util.tai_khoan_thanh_toan.ReadFileTaiKhoanThanhToan;
import module2.util.tai_khoan_thanh_toan.WriteFileTaiKhoanThanhToan;
import module2.util.tai_khoan_tiet_kiem.ReadFileTaiKhoanTietKiem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaiKhoanThanhToanService implements ITaiKhoanThanhToanService {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<TaiKhoanThanhToan> taiKhoanThanhToans = new ArrayList<>();
    private static final String SRC_TAI_KHOAN_THANH_TOAN = "src\\module2\\data\\tai_khoan_thanh_toan.csv";

    public TaiKhoanThanhToan infoTaiKhoan() {
        int id = taiKhoanThanhToans.size() + 1;

        String maTaKhoan;
        do {
            System.out.print("Nhập mã tài khoản: ");
            try {
                maTaKhoan = scanner.nextLine();
                if (!maTaKhoan.matches("^[0-9]{9}$")) {
                    throw new NotFoundBankAccountException("Mã tài khoản không hợp lệ!");
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

        int soThe;
        do {
            System.out.print("Nhập số thẻ: ");
            try {
                soThe = Integer.parseInt(scanner.nextLine());
                if (soThe < 0) {
                    throw new NotFoundBankAccountException("Số thẻ phải là số dương!");
                }
                break;
            } catch (NotFoundBankAccountException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        int soTien;
        do {
            System.out.print("Nhập số tiền trong tài khoản: ");
            try {
                soTien = Integer.parseInt(scanner.nextLine());
                if (soTien < 0) {
                    throw new NotFoundBankAccountException("Số tiền phải là số dương!");
                }
                break;
            } catch (NotFoundBankAccountException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        return new TaiKhoanThanhToan(id, maTaKhoan, tenTaiKhoan, ngayTaoTaiKhoan, soThe, soTien);
    }

    @Override
    public void addTaiKhoanThanhToan() {
        TaiKhoanThanhToan taiKhoanThanhToan = this.infoTaiKhoan();
        taiKhoanThanhToans.add(taiKhoanThanhToan);
        WriteFileTaiKhoanThanhToan.writeFileTaiKhoanThanhToan(SRC_TAI_KHOAN_THANH_TOAN, taiKhoanThanhToans);
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void deleteTaiKhoanThanhToan() {
        taiKhoanThanhToans = ReadFileTaiKhoanThanhToan.readFileTaiKhoanThanhToan(SRC_TAI_KHOAN_THANH_TOAN);
        String maTaiKhoan;
        boolean flagDelete = false;

        do {
            System.out.print("Nhập mã tài khoản muốn xóa: ");
            try {
                maTaiKhoan = scanner.nextLine();
                for (int i = 0; i < taiKhoanThanhToans.size(); i++) {
                    if (taiKhoanThanhToans.get(i).getMaTaiKhoan().contains(maTaiKhoan)) {
                        System.out.println("Bạn có muốn xóa tài khoản này?");
                        System.out.println("Nhấn Y: Yes");
                        System.out.println("Nhấn N: No");
                        System.out.print("Chọn: ");
                        String choice = scanner.nextLine();
                        if (choice.equals("Y")) {
                            taiKhoanThanhToans.remove(i);
                            WriteFileTaiKhoanThanhToan.writeFileTaiKhoanThanhToan(SRC_TAI_KHOAN_THANH_TOAN, taiKhoanThanhToans);
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
    public void displayAllTaiKhoanThanhToan() {
        taiKhoanThanhToans = ReadFileTaiKhoanThanhToan.readFileTaiKhoanThanhToan(SRC_TAI_KHOAN_THANH_TOAN);
        if (taiKhoanThanhToans.size() == 0) {
            System.out.println("Danh sách trống!");
        } else {
            for (TaiKhoanThanhToan taiKhoanThanhToan : taiKhoanThanhToans) {
                System.out.println(taiKhoanThanhToan);
            }
        }
    }

    @Override
    public void searchTaiKhoanThanhToan() {
        taiKhoanThanhToans = ReadFileTaiKhoanThanhToan.readFileTaiKhoanThanhToan(SRC_TAI_KHOAN_THANH_TOAN);
        System.out.print("Nhập tên tài khoản bạn muốn tìm kiếm: ");
        String tenTaiKhoan = scanner.nextLine();
        boolean flag = false;
        for (TaiKhoanThanhToan taiKhoanThanhToan : taiKhoanThanhToans) {
            if (taiKhoanThanhToan.getTenTaiKhoan().contains(tenTaiKhoan)) {
                System.out.println(taiKhoanThanhToan);
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Không tìm thấy tài khoản!");
        }
    }
}

