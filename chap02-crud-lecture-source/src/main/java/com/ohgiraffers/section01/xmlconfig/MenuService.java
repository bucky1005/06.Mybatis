package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section01.xmlconfig.Template.getSqlSession;

public class MenuService {
    private final MenuDAO menuDAO;

    public MenuService() {
        menuDAO = new MenuDAO();
    }

    public List<MenuDTO> findAllMenus() {
        SqlSession sqlSession = getSqlSession();

        List<MenuDTO> menuList = menuDAO.selectAllMenus(sqlSession);

        sqlSession.close();
        return menuList;
    }


    /* 메모. request 요청이 있을 때마다 해당 메소드가 실행되고, 새로운 sqlSession 객체가 생성됨 */
    public MenuDTO findMenuByMenuCode(int menuCode) {
        SqlSession sqlSession = getSqlSession();        // 요청시마다 해당 전역변수 새로 생성
        MenuDTO menu = menuDAO.selectMenuByMenuCode(sqlSession, menuCode);

        sqlSession.close();

        return menu;
    }

    public boolean registMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();

        /* 메모. menuDAO에서 DB에 메뉴 추가가 제대로 되었는지 성공 여부를 가져옴 */
        int result = menuDAO.insertMenu(sqlSession, menu);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();;

        return (result > 0)? true: false;
    }

    public boolean modifyMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();

        /* 메모. menuDAO에서 DB에 메뉴 추가가 제대로 되었는지 성공 여부를 가져옴 */
        int result = menuDAO.updateMenu(sqlSession, menu);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();;

        return (result > 0)? true: false;
    }

    public boolean removeMenu(int menuCode) {
        SqlSession sqlSession = getSqlSession();

        /* 메모. menuDAO에서 DB에 메뉴 추가가 제대로 되었는지 성공 여부를 가져옴 */
        int result = menuDAO.deleteMenu(sqlSession, menuCode);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();;

        return (result > 0)? true: false;
    }
}
