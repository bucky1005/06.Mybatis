package com.ohgiraffers.section01.xml;

import java.util.List;
import java.util.Map;

/* 설명. MenuDAO와 동일함 */
public interface MenuMapper {
    List<MenuDTO> selectMenuByPrice(int maxPrice);

    List<MenuDTO> searchMenu(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuBySupCategory(SearchCriteria searchCriteria);

    /* 설명. 해당 메소드에는 전달인자가 없지만, 자바의 리플렉션 기능을 이용하여 다른 메소드를 찾아가 원하는 값을 받아올 수 있다. */
    List<MenuDTO> searchMenuByRandomMenuCode(List randomList);

    List<MenuDTO> searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuByNameOrCategory(Map<String, Object> criteria);

    int updateMenu(Map<String, Object> criteria);
}
