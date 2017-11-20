package com.gt.inside.core.service.function.performance;

import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.api.dto.UserDTO;
import com.gt.inside.core.bean.function.performance.req.*;
import com.gt.inside.core.bean.function.performance.res.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author psr
 * Created by psr on 2017/10/31 0031.
 */
public interface PerformanceStageService {

    /**
     * 获取绩效总览
     * @param userDTO
     * @return
     */
    List<ListTotalRes> listTotal(UserDTO userDTO);

    /**
     * 分页获取绩效组织关系
     * @param userDTO
     * @param listOrganizeReq
     * @return
     */
    ResponseDTO<List<ListOrganizeRes>> listOrganizeByPage(UserDTO userDTO, ListOrganizeReq listOrganizeReq);

    /**
     * 新增或修改直属领导
     * @param addOrModifyOrganizeReq
     */
    void addOrModifyDirectly(AddOrModifyOrganizeReq addOrModifyOrganizeReq);

    /**
     * 新增或修改分管领导
     * @param addOrModifyOrganizeReq
     */
    void addOrModifyBranch(AddOrModifyOrganizeReq addOrModifyOrganizeReq);

    /**
     * 获取静态信息
     * @return
     */
    List<ListStaticInfoRes> listStaticInfo();

    /**
     * 新增自评分
     * @param userDTO
     * @param addOwnReqs
     */
    void addOwn(UserDTO userDTO, List<AddOwnReq> addOwnReqs);

    /**
     * 查询是否已经自评分
     * @return
     */
    CheckOwnInfoRes checkOwnInfo(UserDTO userDTO);

    /**
     * 查询已评分信息
     * @param userDTO
     * @return
     */
    List<ListOwnInfoRes> listOwnInfo(UserDTO userDTO);

    /**
     * 直属领导查询所属员工列表
     * @param userDTO
     * @param listDirectlyStaffReq
     * @return
     */
    ResponseDTO<List<ListDirectlyStaffRes>> listDirectlyStaffByPage(UserDTO userDTO, ListDirectlyStaffReq listDirectlyStaffReq);

    /**
     * 根据员工id获取直属领导评分详情
     * @param userDTO
     * @param listDirectlyInfoReq
     * @return
     */
    List<ListDirectlyInfoRes> listDirectlyInfoByStaffId(UserDTO userDTO, ListDirectlyInfoReq listDirectlyInfoReq);

    /**
     * 直属领导评分
     * @param userDTO
     * @param addDirectlyInfoReq
     */
    void addDirectly(UserDTO userDTO, AddDirectlyInfoReq addDirectlyInfoReq);

    /**
     * 分页获取分管领导员工
     * @param userDTO
     * @param listBranchStaffReq
     * @return
     */
    ResponseDTO<List<ListBranchStaffRes>> listBranchStaffByPage(UserDTO userDTO, ListBranchStaffReq listBranchStaffReq);

    /**
     * 获取等级字典信息
     * @param userDTO
     * @return
     */
    List<ListLevelDictRes> listLevelDict(UserDTO userDTO);

    /**
     * 新增等级
     * @param userDTO
     * @param addLevelReq
     */
    void addLevel(UserDTO userDTO, AddLevelReq addLevelReq);

    /**
     * 判断是否可发布评级
     * @param userDTO
     * @return true：可发布，false：不可发布
     */
    boolean checkReleaseLevel(UserDTO userDTO);

    /**
     * 发布评级
     * @param userDTO
     */
    void releaseLevel(UserDTO userDTO);

    /**
     * 获取绩效权限
     * @param userDTO
     * @return
     */
    PowerRes getPower(UserDTO userDTO);

    /**
     * 导出Excel
     * @param userDTO
     * @param response
     */
    void exportExcel(UserDTO userDTO, HttpServletResponse response) throws Exception;
}
