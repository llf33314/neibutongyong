package com.gt.inside.sso.core.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gt.inside.api.dto.MenuDTO;
import com.gt.inside.sso.core.dao.MenuDAO;
import com.gt.inside.sso.core.entity.Menu;
import com.gt.inside.sso.core.service.MenuService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author psr
 * @since 2017-10-19
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuDAO, Menu> implements MenuService {

    private static Logger logger = Logger.getLogger(MenuServiceImpl.class);

    @Autowired
    MenuDAO menuDAO;

    /**
     * 根据用户角色获取相应的菜单
     *
     * @param userId
     * @return
     */
    @Override
    public List<MenuDTO> selectListUserRoleMenuDTO(int userId) {
        return arrangeMenuList(menuDAO.selectListUserRoleMenuDTO(userId));
    }

    /**
     * 获取所有菜单
     *
     * @return
     */
    @Override
    public List<MenuDTO> selectListAllMenuDTO() {
        return arrangeMenuList(menuDAO.selectListAllMenuDTO());
    }

    /**
     * 仅支持二级菜单
     * @param menuDTOArrangeList
     * @return
     */
    private List<MenuDTO> arrangeMenuList(List<MenuDTO> menuDTOArrangeList){
        logger.debug(menuDTOArrangeList.size());
        List<MenuDTO> menuDTOList = new ArrayList<>();
        Map<Integer, List<MenuDTO>> menuDTOMap = new HashMap<>();
        for (MenuDTO menuDTO : menuDTOArrangeList){
            Integer pId = menuDTO.getpId();
            if (pId.equals(0)){
                menuDTOList.add(menuDTO);
            }else{
                if (menuDTOMap.containsKey(pId)){
                    menuDTOMap.get(pId).add(menuDTO);
                }else{
                    List<MenuDTO> menuDTOListMap = new ArrayList<>();
                    menuDTOListMap.add(menuDTO);
                    menuDTOMap.put(pId, menuDTOListMap);
                }
            }
        }
        for (int i = 0; i < menuDTOList.size(); i++){
            Integer id = menuDTOList.get(i).getId();
            if (menuDTOMap.containsKey(id)){
                menuDTOList.get(i).setSubMenuList(menuDTOMap.get(id));
            }
        }
        return menuDTOList;
    }
}
