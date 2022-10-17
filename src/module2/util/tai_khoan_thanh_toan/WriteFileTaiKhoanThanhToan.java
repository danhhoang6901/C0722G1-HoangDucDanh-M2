package module2.util.tai_khoan_thanh_toan;

import module2.model.TaiKhoanThanhToan;
import module2.util.WriteFile;

import java.util.List;

public class WriteFileTaiKhoanThanhToan {
    public static void writeFileTaiKhoanThanhToan(String src, List<TaiKhoanThanhToan> taiKhoanThanhToans) {
        String data = "";
        for (TaiKhoanThanhToan taiKhoanThanhToan : taiKhoanThanhToans) {
            data += taiKhoanThanhToan.toString();
            data += "\n";
        }
        WriteFile.writeFile(src, data);
    }
}
