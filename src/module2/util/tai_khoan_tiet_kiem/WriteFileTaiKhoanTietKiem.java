package module2.util.tai_khoan_tiet_kiem;

import module2.model.TaiKhoanTietKiem;
import module2.util.WriteFile;

import java.util.List;

public class WriteFileTaiKhoanTietKiem {
    public static void writeFileTaiKhoanTietKiem(String src, List<TaiKhoanTietKiem> taiKhoanTietKiems) {
        String data = "";
        for (TaiKhoanTietKiem taiKhoanTietKiem : taiKhoanTietKiems) {
            data += taiKhoanTietKiem.toString();
            data += "\n";
        }
        WriteFile.writeFile(src, data);
    }
}
