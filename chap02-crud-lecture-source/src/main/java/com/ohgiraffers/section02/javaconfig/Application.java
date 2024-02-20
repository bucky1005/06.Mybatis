package com.ohgiraffers.section02.javaconfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();

        do {
            System.out.println("======== 메뉴 관리 ========");
            System.out.println("1. 메뉴 전체 조회");
            System.out.println("2. 메뉴 코드로 메뉴 조회");
            System.out.println("3. 신규 메뉴 추가");
            System.out.println("4. 메뉴 수정");
            System.out.println("5. 메뉴 삭제");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴 관리 번호를 입력하세요: ");
            int num = sc.nextInt();

            switch (num) {
                case 1:
                    menuController.findAllMenus();
                    break;
                case 2:
                    menuController.findMenuByMenuCode(inputMenuCode());
                    break;
                case 3:
                    menuController.registMenu(inputMenu());
                    break;
                case 4:
                    menuController.modifyMenu(intputModifyMenu());
                    break;
                case 5:
                    menuController.removeMenu(inputMenuCode());
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 번호를 입력하셨습니다.");
            }
        } while (true);
    }

    private static Map<String, String> intputModifyMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("변경할 메뉴의 번호를 입력해 주세요: ");
        String menuCode = sc.nextLine();
        System.out.print("신규 메뉴의 이름을 입력해주세요: ");
        String manuName = sc.nextLine();
        System.out.print("신규 메뉴의 가격을 입력해 주세요: ");
        String menuPrice = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("menuCode", menuCode);
        parameter.put("menuName", manuName);
        parameter.put("menuPrice", menuPrice);

        return parameter;
    }

    /* 설명. 사용자의 입력 값을 Map 형태로 반환(web에서는 key와 value의 형태로 request 객체에 담기는 parameter로 생각 */
    private static Map<String, String> inputMenuCode() {
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴 코드를 입력하세요: ");
        /* 메모. 메뉴 코드를 int가 아닌 String 타입으로 받는 이유
            컨트롤러에서 받아온 값은 모두 String 타입으로 넘어온다. 따라서 원하는 자료형에 맞게 타입을 키스팅해주어야 한다. */
        String menuCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("menuCode", menuCode);

        return parameter;
    }
    private static Map<String, String> inputMenu() {

        Scanner sc = new Scanner(System.in);
        System.out.print("신규 메뉴의 이름을 입력해주세요: ");
        String manuName = sc.nextLine();
        System.out.print("신규 메뉴의 가격을 입력해 주세요: ");
        String menuPrice = sc.nextLine();
        System.out.print("신규 메뉴의 카테고리 코드를 입력해 주세요: ");
        String categoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("menuName", manuName);
        parameter.put("menuPrice", menuPrice);
        parameter.put("categoryCode", categoryCode);

        return parameter;
    }
}
