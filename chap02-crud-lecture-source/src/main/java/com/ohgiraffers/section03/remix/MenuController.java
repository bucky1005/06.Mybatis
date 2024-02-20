package com.ohgiraffers.section03.remix;



import java.util.List;
import java.util.Map;

public class MenuController {
    private final MenuService menuService;
    private final PrintResult printResult;

    public MenuController() {
        this.menuService = new MenuService();
        this.printResult = new PrintResult();
    }

    public void findAllMenu() {
        List<MenuDTO> menus = menuService.findAllMenu();

        if(!menus.isEmpty()) {
            printResult.printMenus(menus);
        } else {
            printResult.printErrorMessage("전체 메뉴 조회 실패!!");
        }
    }

    public void findMenuByMenuCode(Map<String, String> parameter) {
        /* 설명. parameter의 value값을 String에서 Int로 변경 */
        int menuCode = Integer.valueOf(parameter.get("menuCode"));      // get(key)를 입력하여 value를 가져옴

        MenuDTO menu = menuService.findMenuByMenuCode(menuCode);

        if(menu != null){
            printResult.printMenu(menu);
        } else {
            printResult.printErrorMessage(menuCode + "번의 메뉴는 없습니다.");
        }

    }

    public void registMenu(Map<String, String> parameter) {
//        System.out.println("MenuController 계층의 registMenu 메소드 실행...");

        String menuName = parameter.get("menuName");
        int menuPrice = Integer.valueOf(parameter.get("menuPrice"));
        int categoryCode = Integer.valueOf(parameter.get("categoryCode"));

        MenuDTO menu = new MenuDTO();
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);
        menu.setCategoryCode(categoryCode);

        if(menuService.registMenu(menu)) {
            System.out.println("MenuController 계층의 if문 실행...");

            printResult.pritSucceessMessage("regist");
            printResult.printMenu(menu);
        } else {
            printResult.printErrorMessage("메뉴 추가 실패!@");
        }
    }

    public void modifyMenu(Map<String, String> parameter) {
        int menuCode = Integer.valueOf(parameter.get("menuCode"));
        String menuName = parameter.get("menuName");
        int menuPrice = Integer.valueOf(parameter.get("menuPrice"));

        MenuDTO menu = new MenuDTO();
        menu.setMenuCode(menuCode);
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);

        if (menuService.modifyMenu(menu)) {
            printResult.printMenu(menu);
            printResult.pritSucceessMessage("modify");
        } else {
            printResult.printErrorMessage("메뉴 수정 실패@!");
        }
    }

    public void removeMenu(Map<String, String> parameter) {
        int menuCode = Integer.valueOf(parameter.get("menuCode"));

        if(menuService.removeMenu(menuCode)) {
            printResult.pritSucceessMessage("remove");
        } else {
            printResult.printErrorMessage("메뉴 삭제 실패@!");
        }
    }
}
