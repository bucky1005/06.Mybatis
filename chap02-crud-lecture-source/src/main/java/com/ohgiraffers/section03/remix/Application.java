package com.ohgiraffers.section03.remix;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 설명. remix의 핵심은 DAO 계층을 인터페이스로 만들고 추상메소드만 남기는 방식이다. */
/* 설명. 쿼리가 있는 부분은 XMl로 작성한다(mapper용 쿼리) */
public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();

        /* 질문. 4. 메뉴 수정 프로그램 실행 해보면 아무런 변화가 없는데
            수정할 메뉴의 코드번호를 받아서 그 코드에 해당하는 메뉴를 수정해야 하는 것 아닌가욤 */
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
                    menuController.findAllMenu();
                    break;
                case 2:
                    menuController.findMenuByMenuCode(inputMenuCode());
                    break;
                case 3:
                    menuController.registMenu(inputMenu());
                    break;
                case 4:
                    menuController.modifyMenu(inputmodifyMenu());
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

    private static Map<String, String> inputmodifyMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("변경할 메뉴의 코드를 입력하세요: ");
        String menuCode = sc.nextLine();
        System.out.print("변경할 메뉴의 이름을 입력하세요: ");
        String menuName = sc.nextLine();
        System.out.print("변경할 메뉴의 가격을 입력하세요: ");
        String menuPrice = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("menuCode", menuCode);
        parameter.put("menuName", menuName);
        parameter.put("menuPrice", menuPrice);

        return parameter;
    }

    private static Map<String, String> inputMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("신규 메뉴의 이름을 입력하세요: ");
        String menuName = sc.nextLine();
        System.out.print("신규 메뉴의 가격을 입력하세요: ");
        String menuPrice = sc.nextLine();
        System.out.print("신규 메뉴의 카테고리 코드를 입력하세요: ");
        String categoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("menuName", menuName);
        parameter.put("menuPrice", menuPrice);
        parameter.put("categoryCode", categoryCode);

        return parameter;
    }

    private static Map<String, String> inputMenuCode() {
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴 코드를 입력하세요: ");
        String menuCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("menuCode", menuCode);        // key: "menuCode" 문자열, value: 사용자에게 입력받은 코드의 주소값

        return parameter;
    }
}
