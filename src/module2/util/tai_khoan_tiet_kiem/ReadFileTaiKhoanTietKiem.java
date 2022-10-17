package module2.util.tai_khoan_tiet_kiem;

import module2.model.TaiKhoanTietKiem;
import module2.util.ReadFile;

import java.util.ArrayList;
import java.util.List;

public class ReadFileTaiKhoanTietKiem {
    public static List<TaiKhoanTietKiem> readFileTaiKhoanTietKiem(String src) {
        List<String> strings = ReadFile.readFile(src);
        List<TaiKhoanTietKiem> taiKhoanTietKiems = new ArrayList<>();
        String[] info;

        for (String line : strings) {
            info = line.split(",");
            taiKhoanTietKiems.add(new TaiKhoanTietKiem(Integer.parseInt(info[0]), info[1], info[2], info[3], Integer.parseInt(info[4]), info[5], Integer.parseInt(info[6]), Integer.parseInt(info[7])));
        }
        return taiKhoanTietKiems;
    }
}
