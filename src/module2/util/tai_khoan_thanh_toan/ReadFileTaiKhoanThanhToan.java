package module2.util.tai_khoan_thanh_toan;

import module2.model.TaiKhoanThanhToan;
import module2.util.ReadFile;

import java.util.ArrayList;
import java.util.List;

public class ReadFileTaiKhoanThanhToan {
    public static List<TaiKhoanThanhToan> readFileTaiKhoanThanhToan(String src) {
        List<String> strings = ReadFile.readFile(src);
        List<TaiKhoanThanhToan> taiKhoanThanhToans = new ArrayList<>();
        String[] info;

        for (String line : strings) {
            info = line.split(",");
            taiKhoanThanhToans.add(new TaiKhoanThanhToan(Integer.parseInt(info[0]), info[1], info[2], info[3], Integer.parseInt(info[4]), Integer.parseInt(info[5])));
        }
        return taiKhoanThanhToans;
    }
}
