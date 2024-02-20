package com.ohgiraffers.section03.remix;

import java.util.List;

/* 설명. MenuMapper 인터페이스에는 MenuMapper.xml 파일에 작성된 SQL 쿼리들을 필드로 담음 */
public interface MenuMapper {
    List<MenuDTO> selectAllMenus();
    MenuDTO selectMenu(int menuCode);
    int insertMenu(MenuDTO menu);
    int updateMenu(MenuDTO menu);
    int deleteMenu(int menuCode);
}
