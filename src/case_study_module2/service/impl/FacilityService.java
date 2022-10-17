package case_study_module2.service.impl;

import case_study_module2.model.facility.Facility;
import case_study_module2.model.facility.House;
import case_study_module2.model.facility.Room;
import case_study_module2.model.facility.Villa;
import case_study_module2.service.IFacilityService;
import case_study_module2.util.facility.ReadFileFacility;
import case_study_module2.util.facility.WriteFileFacility;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FacilityService implements IFacilityService {
    private static Scanner scanner = new Scanner(System.in);
    public static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    private static Map<Facility, Integer> facilityMaintenance = new LinkedHashMap<>();
    private static final String SRC_FACILITY = "src\\case_study_module2\\data\\facility.csv";

    @Override
    public void displayAllFacility() {
        facilityIntegerMap = ReadFileFacility.readFileFacility(SRC_FACILITY);
        Set<Facility> facilities = facilityIntegerMap.keySet();
        if (facilityIntegerMap.size() == 0) {
            System.err.println("Danh sách trống!");
        } else {
            for (Facility facility : facilities) {
                System.out.println(facility + "," + facilityIntegerMap.get(facility));
            }
        }
    }

    @Override
    public void addVilla() {
        Villa villa = VillaService.infoVilla();
        facilityIntegerMap.put(villa, 0);
        WriteFileFacility.writeFileFacility(SRC_FACILITY, facilityIntegerMap);
        System.out.println("Thêm mới Villa thành công");
    }

    @Override
    public void addHouse() {
        House house = HouseService.infoHouse();
        facilityIntegerMap.put(house, 0);
        WriteFileFacility.writeFileFacility(SRC_FACILITY, facilityIntegerMap);
        System.out.println("Thêm mới House thành công");
    }

    @Override
    public void addRoom() {
        Room room = RoomService.infoRoom();
        facilityIntegerMap.put(room, 0);
        WriteFileFacility.writeFileFacility(SRC_FACILITY, facilityIntegerMap);
        System.out.println("Thêm mới Room thành công");
    }

    @Override
    public void displayFacilityMaintenance() {
        facilityIntegerMap = ReadFileFacility.readFileFacility(SRC_FACILITY);
        for (Facility facility : facilityIntegerMap.keySet()) {
            if (facilityIntegerMap.get(facility) >= 5) {
                facilityMaintenance.put(facility, facilityIntegerMap.get(facility));
            }
        }
        for (Facility facility : facilityMaintenance.keySet()) {
            System.out.println(facility + "," + facilityMaintenance.get(facility));
        }
    }

    public Facility findFacilityId(String id) {
        facilityIntegerMap = ReadFileFacility.readFileFacility(SRC_FACILITY);
        Set<Facility> facilities = facilityIntegerMap.keySet();
        for (Facility facility : facilities) {
            if (facility.getServiceId().contains(id)) {
                return facility;
            }
        }
        return null;
    }
}




