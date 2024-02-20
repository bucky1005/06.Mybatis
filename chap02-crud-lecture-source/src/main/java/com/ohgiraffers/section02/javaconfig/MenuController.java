package com.ohgiraffers.section02.javaconfig;

import java.util.List;
import java.util.Map;

public class MenuController {

    /* 메모. Service계층을 private final로 선언하는 이유
        1. 컨트롤러는 Service 계층을 반드시 주입받아야 한 다는 것을 명시적으로 알림
        2. final을 사용햐여 반드시 초기화되도록 함
     */
    private final MenuService menuService;
    private final PrintResult printResult;      // 결과 페이지에 해당하는(View 개념) 클래스

    /* 메모. 해당 클래스는 Spring이 아닌 일반 자바 클래스이므로, DI방식이 아닌 자바 방식으로 생성자를 만들었음(생성자 주입) */
    public MenuController() {
        menuService = new MenuService();
        printResult = new PrintResult();
    }

    public void findAllMenus() {

        List<MenuDTO> menuList = menuService.findAllMenus();

        if(!menuList.isEmpty()) {
            printResult.printMenus(menuList);
        } else {
            printResult.printErrorMessage("조회할 메뉴가 없습니다.");
        }
    }

    public void findMenuByMenuCode(Map<String, String> parameter) {

        /* 메모. Application에서 String 타입이였던 menuCode를 원하는 자료형(int) 타입으로 변경 */
        int menuCode = Integer.valueOf(parameter.get("menuCode"));

        MenuDTO menu = menuService.findMenuByMenuCode(menuCode);

        if (menu != null) {
            printResult.printMenu(menu);
        } else {
            printResult.printErrorMessage(menuCode + "번의 메뉴는 없습니다.");
        }
    }

    public void registMenu(Map<String, String> parameter) {
        String menuName = parameter.get("menuName");
        int menuPrice = Integer.valueOf(parameter.get("menuPrice"));
        int categoryCode = Integer.valueOf(parameter.get("categoryCode"));

        MenuDTO menu = new MenuDTO();
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);
        menu.setCategoryCode(categoryCode);

        /* 메모. Service 계층에서 메뉴 추가가 잘 되었는지 성공 여부를 받아옴. */
        if(menuService.registMenu(menu)) {
            printResult.printSuccessMessage("regist");
        } else {
            printResult.printErrorMessage("메뉴 추가 실패@");
        }
    }

    public void modifyMenu(Map<String, String> parameter) {
        /* 메모. Application에서 사용자가 입력한 값을 받아올 때 전부 String 타입이므로,
            다른 자료형은 직접 타입변환을 해주어야 한다. */
        int menuCode = Integer.valueOf(parameter.get("menuCode"));
        String menuName = parameter.get("menuName");
        int menuPrice = Integer.valueOf(parameter.get("menuPrice"));

        MenuDTO menu = new MenuDTO();
        menu.setMenuCode(menuCode);
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);

        if(menuService.modifyMenu(menu)) {
            printResult.printSuccessMessage("modify");
        } else
            printResult.printErrorMessage("메뉴 수정 실패@!");
    }

    public void removeMenu(Map<String, String> parameter) {
        int menuCode = Integer.valueOf(parameter.get("menuCode"));
        boolean result = menuService.removeMenu(menuCode);
        System.out.println("result = " + result);

        if(menuService.removeMenu(menuCode)) {
            printResult.printSuccessMessage("remove");
        } else
            printResult.printErrorMessage("메뉴 삭제 실패@!");
    }
}
