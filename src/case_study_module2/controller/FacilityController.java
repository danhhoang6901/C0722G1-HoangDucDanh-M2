package case_study_module2.controller;

import case_study_module2.service.IFacilityService;
import case_study_module2.service.impl.FacilityService;

import java.util.Scanner;

public class FacilityController {
    private static Scanner scanner = new Scanner(System.in);
    private static IFacilityService facilityService = new FacilityService();


    public static void facilityManagement() {
        while (true) {
            System.out.println("--QUẢN LÝ CƠ SỞ--");
            System.out.println("1. Hiển thị danh sách cơ sở");
            System.out.println("2. Thêm cơ sở mới");
            System.out.println("3. Hiển thị danh sách cơ sở bảo trì");
            System.out.println("4. Trở lại menu chính");
            System.out.print("Chọn: ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    facilityService.displayAllFacility();
                    break;
                case 2:
                    while (true) {
                        System.out.println("Chọn loại dịch vụ muốn thêm: ");
                        System.out.println("1. Thêm Villa mới");
                        System.out.println("2. Thêm House mới");
                        System.out.println("3. Thêm Room mới");
                        System.out.println("4. Quay lại menu chính");
                        System.out.print("Chọn: ");
                        int chooseFacility = Integer.parseInt(scanner.nextLine());
                        switch (chooseFacility) {
                            case 1:
                                facilityService.addVilla();
                                break;
                            case 2:
                                facilityService.addHouse();
                                break;
                            case 3:
                                facilityService.addRoom();
                                break;
                            case 4:
                                break;
                            default:
                                System.err.println("Lựa chọn của bạn không đúng!");
                        }
                        break;
                    }
                    break;
                case 3:
                    facilityService.displayFacilityMaintenance();
                    break;
                case 4:
                    return;
                default:
                    System.err.println("Lựa chọn của bạn không đúng!");
            }
        }
    }
}
