package case_study_module2.util.facility;

import case_study_module2.model.facility.Facility;
import case_study_module2.util.WriteFileFuruma;

import java.util.Map;
import java.util.Set;

public class WriteFileFacility {
    public static void writeFileFacility(String src, Map<Facility, Integer> facilityIntegerMap) {
        String data = "";
        Set<Facility> facilities = facilityIntegerMap.keySet();
        for (Facility facility : facilities) {
            data += facility.getInfo() + "," + facilityIntegerMap.get(facility);
            data += "\n";
        }
        WriteFileFuruma.writeFileFuruma(src, data);
    }
}
