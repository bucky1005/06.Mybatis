package com.ohgiraffers.section03.remix;

import java.util.List;

public class PrintResult {
    public void printMenus(List<MenuDTO> menus) {
        menus.forEach(System.out::println);
    }

    public void pritSucceessMessage(String statusCode) {
        String successMessage = "";

        switch (statusCode) {
            case "find":
                successMessage = "메뉴가 조회되었습니다.";
                break;
            case "regist":
                successMessage = "메뉴 수정에 성공하였습니다.";
                break;
            case "modify":
                successMessage = "메뉴가 수정되었습니다.";
                break;
            case "remove":
                successMessage = "메뉴가 삭제되었습니다.";
                break;
        }
        System.out.println(successMessage);
    }

    public void printErrorMessage(String message) {
        System.out.println("에러메세지: " + message);
    }

    public void printMenu(MenuDTO menu) {
        /* 메모. menu.toString이나 menu나 똑같이 출력됨 */
//        System.out.println(menu.toString());
        System.out.println("menu = " + menu);
    }
}
