package case_study_module2.util.facility;

import case_study_module2.model.facility.Facility;
import case_study_module2.model.facility.House;
import case_study_module2.model.facility.Room;
import case_study_module2.model.facility.Villa;
import case_study_module2.util.ReadFileFuruma;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReadFileFacility {
    public static Map<Facility, Integer> readFileFacility(String src) {
        List<String> strings = ReadFileFuruma.readFileRuruma(src);
        Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
        String[] info;
        for (String line : strings) {
            info = line.split(",");
            if (info[0].contains("SVVL")) {
                facilityIntegerMap.put(new Villa(info[0], info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]), Integer.parseInt(info[4]), info[5], info[6], Integer.parseInt(info[7]), Integer.parseInt(info[8])), Integer.parseInt(info[9]));
            } else if (info[0].contains("SVHO")) {
                facilityIntegerMap.put(new House(info[0], info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]), Integer.parseInt(info[4]), info[5], info[6], Integer.parseInt(info[7])), Integer.parseInt(info[8]));
            } else if (info[0].contains("SVRO")) {
                facilityIntegerMap.put(new Room(info[0], info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]), Integer.parseInt(info[4]), info[5], info[6]), Integer.parseInt(info[7]));
            }
        }
        return facilityIntegerMap;
    }
}
