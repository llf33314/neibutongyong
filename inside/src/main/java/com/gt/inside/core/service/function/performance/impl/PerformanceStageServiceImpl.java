package com.gt.inside.core.service.function.performance.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.gt.inside.api.dto.PageDTO;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.api.dto.UserDTO;
import com.gt.inside.api.enums.ResponseEnums;
import com.gt.inside.api.util.CommonUtil;
import com.gt.inside.api.util.DateTimeKit;
import com.gt.inside.api.util.excel.ExcelUtil;
import com.gt.inside.core.bean.function.performance.dto.ListOrganizeDTO;
import com.gt.inside.core.bean.function.performance.dto.ListOrganizeInfoDTO;
import com.gt.inside.core.bean.function.performance.dto.ListOrganizeTotalDTO;
import com.gt.inside.core.bean.function.performance.dto.PfmExcelDto;
import com.gt.inside.core.bean.function.performance.req.*;
import com.gt.inside.core.bean.function.performance.res.*;
import com.gt.inside.core.entity.dict.DictInfo;
import com.gt.inside.core.entity.function.performance.*;
import com.gt.inside.core.entity.organize.department.Department;
import com.gt.inside.core.entity.organize.staff.Staff;
import com.gt.inside.core.exception.function.performance.PerformanceException;
import com.gt.inside.core.service.dict.DictApiService;
import com.gt.inside.core.service.function.performance.*;
import com.gt.inside.core.service.organize.department.DepartmentApiService;
import com.gt.inside.core.service.organize.staff.StaffApiService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.*;

/**
 * Created by psr on 2017/10/31 0031.
 */
@Service
public class PerformanceStageServiceImpl implements PerformanceStageService {

    private static Logger logger = Logger.getLogger(PerformanceStageServiceImpl.class);

    @Autowired
    StaffPerformanceMonthService staffPerformanceMonthService;

    @Autowired
    StaffPerformanceTotalService staffPerformanceTotalService;

    @Autowired
    StaffPerformanceTotalOrgService staffPerformanceTotalOrgService;

    @Autowired
    StaffPerformanceOrganizeService staffPerformanceOrganizeService;

    @Autowired
    StaffPerformanceInfoService staffPerformanceInfoService;

    @Autowired
    StaffPerformanceInfoOrgService staffPerformanceInfoOrgService;

    @Autowired
    StaffApiService staffApiService;

    @Autowired
    DictApiService dictApiService;

    @Autowired
    DepartmentApiService departmentApiService;

    private static final Integer LevelDictCode = 1003; // 评分等级字典（K1）

    private static final Integer StaticInfoDictCode = 1002; // 评分静态信息字典

    private static final Integer StaffLevelDictCodeT = 1005; // 员工等级（对应字典1005 或 字典1006 或 字典 1007，P级或T级）

    private static final Integer StaffLevelDictCodeP = 1006; // 员工等级（对应字典1005 或 字典1006 或 字典 1007，P级或T级）

    private static final Integer StaffDutiesDictCode = 1008; // 员工职务（对应字典1008）

    private static Integer directlyCode = 1; // 直属领导代号

    private static Integer branchCode = 2; // 分管领导代号

    private static Integer levelRelease = 1; // 发布

    private static Integer typeT = 1; // 技术类type 1

    private static Integer typeP = 2; // 专业A类type 2

    /**
     * 获取绩效权限
     *
     * @param userDTO
     * @return
     */
    @Override
    public PowerRes getPower(UserDTO userDTO) {
        PowerRes powerRes = new PowerRes();
        if (userDTO.getRoleStatus().equals(1)) {
            powerRes.setOrganizeSetFlag(true);
        }
        Staff staff = staffApiService.getStaffByUserId(userDTO.getUserId());
        if (CommonUtil.isEmpty(staff)) {
            powerRes.setOwnFlag(false);
            return powerRes;
        }
        EntityWrapper<StaffPerformanceOrganize> entityWrapperDirectly = new EntityWrapper<>();
        entityWrapperDirectly.eq("staff_org_id", staff.getId());
        entityWrapperDirectly.eq("staff_org_code", directlyCode);
        int countDirectly = staffPerformanceOrganizeService.selectCount(entityWrapperDirectly);
        if (countDirectly > 0) {
            powerRes.setDirectlyFlag(true);
        }
        EntityWrapper<StaffPerformanceOrganize> entityWrapperBranch = new EntityWrapper<>();
        entityWrapperBranch.eq("staff_org_id", staff.getId());
        entityWrapperBranch.eq("staff_org_code", branchCode);
        int countBranch = staffPerformanceOrganizeService.selectCount(entityWrapperBranch);
        if (countBranch > 0) {
            powerRes.setBranchFlag(true);
        }
        return powerRes;
    }

    /**
     * 获取绩效总览
     *
     * @param userDTO
     * @return
     */
    @Override
    public List<ListTotalRes> listTotal(UserDTO userDTO) {
        List<ListTotalRes> listPerformanceTotalResList = new ArrayList<>();
        Staff staff = staffApiService.getStaffByUserId(userDTO.getUserId());
        if (CommonUtil.isEmpty(staff)) {
            throw new PerformanceException(ResponseEnums.STAFF_NULL);
        }
        StaffPerformanceMonth staffPerformanceMonth = staffPerformanceMonthService.getNowMonth();
        if (CommonUtil.isEmpty(staffPerformanceMonth)) {
            staffPerformanceMonth = new StaffPerformanceMonth();
            staffPerformanceMonth.setCreateTime(new Date());
            staffPerformanceMonth.setMonthDate(new Date());
            staffPerformanceMonthService.insert(staffPerformanceMonth);
        }
        EntityWrapper<StaffPerformanceTotal> entityWrapperTotal = new EntityWrapper<>();
        entityWrapperTotal.eq("staff_id", staff.getId());
        entityWrapperTotal.eq("level_release", levelRelease);
        List<StaffPerformanceTotal> staffPerformanceTotalList = staffPerformanceTotalService.selectList(entityWrapperTotal);
        if (CommonUtil.isEmpty(staffPerformanceTotalList) || staffPerformanceTotalList.size() <= 0) {
            return listPerformanceTotalResList;
        }
        List<Integer> monthIds = new ArrayList<>();
        for (StaffPerformanceTotal staffPerformanceTotal : staffPerformanceTotalList) {
            monthIds.add(staffPerformanceTotal.getMonthId());
        }
        List<StaffPerformanceMonth> staffPerformanceMonthList = staffPerformanceMonthService.selectBatchIds(monthIds);
        Map<Integer, String> dictInfoMap = dictApiService.getDictInfoByDictCode(LevelDictCode);
        for (StaffPerformanceTotal staffPerformanceTotal : staffPerformanceTotalList) {
            ListTotalRes listPerformanceTotalRes = new ListTotalRes();
            Integer level = staffPerformanceTotal.getLevelCode();
            listPerformanceTotalRes.setLevel(dictInfoMap.get(level));
            listPerformanceTotalRes.setStaffName(staff.getStaffName());
            for (StaffPerformanceMonth spfm : staffPerformanceMonthList) {
                if (spfm.getId().equals(staffPerformanceTotal.getMonthId())) {
                    listPerformanceTotalRes.setMonthTime(spfm.getMonthDate());
                    break;
                }
            }
            listPerformanceTotalResList.add(listPerformanceTotalRes);
        }
        return listPerformanceTotalResList;
    }

    /**
     * 分页获取绩效组织关系
     *
     * @param userDTO
     * @param listOrganizeReq
     * @return
     */
    @Override
    public ResponseDTO<List<ListOrganizeRes>> listOrganizeByPage(UserDTO userDTO, ListOrganizeReq listOrganizeReq) {
        List<ListOrganizeRes> listOrganizeResList = new ArrayList<>();
        Page<Staff> staffPage = staffApiService.listStaffByPageWithDepart(listOrganizeReq.getCurrent(), listOrganizeReq.getSize(), listOrganizeReq.getDepartmentId());
        List<Department> departmentList = departmentApiService.listAllDepartment(); // 部门信息
        List<Integer> staffIdList = new ArrayList<>();
        for (Staff staff : staffPage.getRecords()) {
            staffIdList.add(staff.getId());
            ListOrganizeRes listOrganizeRes = new ListOrganizeRes();
            listOrganizeRes.setStaffId(staff.getId());
            listOrganizeRes.setStaffName(staff.getStaffName());
            for (Department department : departmentList) {
                if (department.getId().equals(staff.getDepId())) {
                    listOrganizeRes.setDepartmentName(department.getDepName());
                    break;
                }
            }
            listOrganizeResList.add(listOrganizeRes);
        }
        List<ListOrganizeDTO> directlyList = staffPerformanceOrganizeService.selectListByOrgCode(directlyCode, staffIdList);
        List<ListOrganizeDTO> branchList = staffPerformanceOrganizeService.selectListByOrgCode(branchCode, staffIdList);
        for (ListOrganizeRes lor : listOrganizeResList) {
            for (ListOrganizeDTO listOrganizeDTO : directlyList) {
                if (lor.getStaffId().equals(listOrganizeDTO.getStaffId())) {
                    lor.setDirectlyId(listOrganizeDTO.getStaffOrgId());
                    lor.setDirectlyName(listOrganizeDTO.getStaffName());
                    break;
                }
            }
            for (ListOrganizeDTO listOrganizeDTO : branchList) {
                if (lor.getStaffId().equals(listOrganizeDTO.getStaffId())) {
                    lor.setBranchId(listOrganizeDTO.getStaffOrgId());
                    lor.setBranchName(listOrganizeDTO.getStaffName());
                    break;
                }
            }
        }
        PageDTO pageDTO = new PageDTO(staffPage.getPages(), staffPage.getTotal());
        return ResponseDTO.createBySuccessPage("分页获取绩效组织关系成功", listOrganizeResList, pageDTO);
    }

    /**
     * 新增或修改直属领导
     *
     * @param addOrModifyOrganizeReq
     */
    @Override
    public void addOrModifyDirectly(AddOrModifyOrganizeReq addOrModifyOrganizeReq) {
        EntityWrapper<StaffPerformanceOrganize> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("staff_id", addOrModifyOrganizeReq.getStaffId());
        entityWrapper.eq("staff_org_code", 1);
        StaffPerformanceOrganize staffPerformanceOrganize = staffPerformanceOrganizeService.selectOne(entityWrapper);
        if (CommonUtil.isEmpty(staffPerformanceOrganize)) {
            staffPerformanceOrganize = new StaffPerformanceOrganize();
            staffPerformanceOrganize.setStaffId(addOrModifyOrganizeReq.getStaffId());
            staffPerformanceOrganize.setStaffOrgId(addOrModifyOrganizeReq.getStaffOrgId());
            staffPerformanceOrganize.setCreateTime(new Date());
            staffPerformanceOrganize.setStaffOrgCode(1);
            staffPerformanceOrganizeService.insert(staffPerformanceOrganize);
        } else {
            staffPerformanceOrganize.setStaffOrgId(addOrModifyOrganizeReq.getStaffOrgId());
            staffPerformanceOrganizeService.updateById(staffPerformanceOrganize);
        }
    }

    /**
     * 新增或修改分管领导
     *
     * @param addOrModifyOrganizeReq
     */
    @Override
    public void addOrModifyBranch(AddOrModifyOrganizeReq addOrModifyOrganizeReq) {
        EntityWrapper<StaffPerformanceOrganize> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("staff_id", addOrModifyOrganizeReq.getStaffId());
        entityWrapper.eq("staff_org_code", 2);
        StaffPerformanceOrganize staffPerformanceOrganize = staffPerformanceOrganizeService.selectOne(entityWrapper);
        if (CommonUtil.isEmpty(staffPerformanceOrganize)) {
            staffPerformanceOrganize = new StaffPerformanceOrganize();
            staffPerformanceOrganize.setStaffId(addOrModifyOrganizeReq.getStaffId());
            staffPerformanceOrganize.setStaffOrgId(addOrModifyOrganizeReq.getStaffOrgId());
            staffPerformanceOrganize.setCreateTime(new Date());
            staffPerformanceOrganize.setStaffOrgCode(2);
            staffPerformanceOrganizeService.insert(staffPerformanceOrganize);
        } else {
            staffPerformanceOrganize.setStaffOrgId(addOrModifyOrganizeReq.getStaffOrgId());
            staffPerformanceOrganizeService.updateById(staffPerformanceOrganize);
        }
    }

    /**
     * 查询是否已经自评分
     *
     * @return
     */
    @Override
    public CheckOwnInfoRes checkOwnInfo(UserDTO userDTO) {
        CheckOwnInfoRes checkOwnInfoRes = new CheckOwnInfoRes();
        Staff staff = staffApiService.getStaffByUserId(userDTO.getUserId());
        if (CommonUtil.isEmpty(staff)) {
            throw new PerformanceException(ResponseEnums.STAFF_NULL);
        }
        StaffPerformanceMonth staffPerformanceMonth = staffPerformanceMonthService.getNowMonth();
        EntityWrapper<StaffPerformanceInfo> checkEntityWrapper = new EntityWrapper<>();
        checkEntityWrapper.eq("staff_id", staff.getId());
        checkEntityWrapper.eq("month_id", staffPerformanceMonth.getId());
        List<StaffPerformanceInfo> staffPerformanceInfoCheckList = staffPerformanceInfoService.selectList(checkEntityWrapper);
        if (CommonUtil.isEmpty(staffPerformanceInfoCheckList) || staffPerformanceInfoCheckList.size() <= 0) {
            checkOwnInfoRes.setCheckOwnInfoBoolean(false);
        }
        checkOwnInfoRes.setUserName(userDTO.getUserName());
        checkOwnInfoRes.setMonthDate(DateTimeKit.formatTimeUntilMonth(staffPerformanceMonth.getMonthDate()));
        return checkOwnInfoRes;
    }

    /**
     * 查询已评分信息
     *
     * @param userDTO
     * @return
     */
    @Override
    public List<ListOwnInfoRes> listOwnInfo(UserDTO userDTO) {
        Staff staff = staffApiService.getStaffByUserId(userDTO.getUserId());
        if (CommonUtil.isEmpty(staff)) {
            throw new PerformanceException(ResponseEnums.STAFF_NULL);
        }
        StaffPerformanceMonth staffPerformanceMonth = staffPerformanceMonthService.getNowMonth();
        List<StaffPerformanceInfo> staffPerformanceInfoList = staffPerformanceInfoService.selectListByStaffIdAndMonthId(staff.getId(), staffPerformanceMonth.getId());
        if (CommonUtil.isEmpty(staffPerformanceInfoList) && staffPerformanceInfoList.size() <= 0) {
            throw new PerformanceException(ResponseEnums.PERFOMANCE_INFO_NULL);
        }
        List<ListOwnInfoRes> listOwnInfoResList = new ArrayList<>();
        for (StaffPerformanceInfo staffPerformanceInfo : staffPerformanceInfoList) {
            ListOwnInfoRes listOwnInfoRes = new ListOwnInfoRes();
            listOwnInfoRes.setId(staffPerformanceInfo.getId());
            listOwnInfoRes.setOwnScore(staffPerformanceInfo.getPfmOwnScore());
            listOwnInfoRes.setPerformanceContent(staffPerformanceInfo.getPfmContent());
            listOwnInfoRes.setPerformanceName(staffPerformanceInfo.getPfmName());
            listOwnInfoRes.setPerformanceScore(staffPerformanceInfo.getPfmStandardScore());
            listOwnInfoRes.setStatus(1);
            listOwnInfoResList.add(listOwnInfoRes);
        }
        return listOwnInfoResList;
    }

    /**
     * 获取静态信息
     *
     * @return
     */
    @Override
    public List<ListStaticInfoRes> listStaticInfo() {
        List<ListStaticInfoRes> listStaticInfoResList = new ArrayList<>();
        List<DictInfo> dictInfoList = dictApiService.listDictInfoByDictCode(StaticInfoDictCode);
        for (DictInfo dictInfo : dictInfoList) {
            ListStaticInfoRes listStaticInfoRes = new ListStaticInfoRes();
            listStaticInfoRes.setStatus(1);
            listStaticInfoRes.setPerformanceCode(dictInfo.getInfoCode());
            String content = dictInfo.getInfoContent();
            listStaticInfoRes.setPerformanceName(content);
            listStaticInfoRes.setPerformanceContent(dictInfo.getInfoRemark());
            Integer score = Integer.valueOf(content.substring(content.indexOf("（") + 1, content.lastIndexOf("分）")));
            listStaticInfoRes.setPerformanceScore(score);
            listStaticInfoResList.add(listStaticInfoRes);
        }
        return listStaticInfoResList;
    }

    /**
     * 新增自评分
     *
     * @param addOwnReqs
     */
    @Override
    public void addOwn(UserDTO userDTO, List<AddOwnReq> addOwnReqs) {
        Staff staff = staffApiService.getStaffByUserId(userDTO.getUserId());
        if (CommonUtil.isEmpty(staff)) {
            throw new PerformanceException(ResponseEnums.STAFF_NULL);
        }
        StaffPerformanceMonth staffPerformanceMonth = staffPerformanceMonthService.getNowMonth();
        EntityWrapper<StaffPerformanceInfo> checkEntityWrapper = new EntityWrapper<>();
        checkEntityWrapper.eq("staff_id", staff.getId());
        checkEntityWrapper.eq("month_id", staffPerformanceMonth.getId());
        List<StaffPerformanceInfo> staffPerformanceInfoCheckList = staffPerformanceInfoService.selectList(checkEntityWrapper);
        if (CommonUtil.isNotEmpty(staffPerformanceInfoCheckList) && staffPerformanceInfoCheckList.size() > 0) {
            throw new PerformanceException(ResponseEnums.PERFOMANCE_INFO_HAS);
        }
        List<StaffPerformanceInfo> staffPerformanceInfoList = new ArrayList<>();
        int ownTotal = 0;
        for (AddOwnReq addOwnReq : addOwnReqs) {
            StaffPerformanceInfo staffPerformanceInfo = new StaffPerformanceInfo();
            staffPerformanceInfo.setCreateTime(new Date());
            staffPerformanceInfo.setMonthId(staffPerformanceMonth.getId());
            staffPerformanceInfo.setStaffId(staff.getId());
            staffPerformanceInfo.setPfmContent(addOwnReq.getPerformanceContent());
            staffPerformanceInfo.setPfmOwnScore(addOwnReq.getOwnScore());
            staffPerformanceInfo.setPfmName(addOwnReq.getPerformanceName());
            staffPerformanceInfo.setPfmStandardScore(addOwnReq.getPerformanceScore());
            staffPerformanceInfo.setPfmCode(addOwnReq.getPerformanceCode());
            staffPerformanceInfoList.add(staffPerformanceInfo);
            ownTotal += addOwnReq.getOwnScore(); // 增加总分
        }
        if (ownTotal > 100) {
            throw new PerformanceException(ResponseEnums.INFONULL);
        }
        staffPerformanceInfoService.insertBatch(staffPerformanceInfoList);
        StaffPerformanceTotal staffPerformanceTotal = new StaffPerformanceTotal();
        staffPerformanceTotal.setCreateTime(new Date());
        staffPerformanceTotal.setMonthId(staffPerformanceMonth.getId());
        staffPerformanceTotal.setStaffId(staff.getId());
        staffPerformanceTotal.setOwnTotal(ownTotal);
        staffPerformanceTotalService.insert(staffPerformanceTotal);
    }

    /**
     * 直属领导查询所属员工列表
     *
     * @param userDTO
     * @param listDirectlyStaffReq
     * @return
     */
    @Override
    public ResponseDTO<List<ListDirectlyStaffRes>> listDirectlyStaffByPage(UserDTO userDTO, ListDirectlyStaffReq listDirectlyStaffReq) {
        List<ListDirectlyStaffRes> listDirectlyStaffResList = new ArrayList<>();
        Staff staff = staffApiService.getStaffByUserId(userDTO.getUserId());
        if (CommonUtil.isEmpty(staff)) {
            throw new PerformanceException(ResponseEnums.STAFF_NULL);
        }
        Page<ListOrganizeDTO> page = new Page<>(listDirectlyStaffReq.getCurrent(), listDirectlyStaffReq.getSize());
        Integer staffOrgId = staff.getId();
        Integer code = directlyCode;
        List<ListOrganizeDTO> listOrganizeDTOPage = staffPerformanceOrganizeService.selectPageByOrgIdAndCode(page, staffOrgId, code);
        PageDTO pageDTO = new PageDTO(page.getPages(), page.getTotal());
        List<Integer> staffIds = new ArrayList<>();
        if (CommonUtil.isEmpty(listOrganizeDTOPage) || listOrganizeDTOPage.size() <= 0) {
            return ResponseDTO.createBySuccessPage("获取直属员工列表成功", listDirectlyStaffResList, pageDTO);
        }
        for (ListOrganizeDTO listOrganizeDTO : listOrganizeDTOPage) {
            staffIds.add(listOrganizeDTO.getStaffId());
            ListDirectlyStaffRes listDirectlyStaffRes = new ListDirectlyStaffRes();
            listDirectlyStaffRes.setStaffId(listOrganizeDTO.getStaffId());
            listDirectlyStaffRes.setStaffName(listOrganizeDTO.getStaffName());
            listDirectlyStaffRes.setStaffCode(listOrganizeDTO.getStaffCode());
            listDirectlyStaffResList.add(listDirectlyStaffRes);
        }
        StaffPerformanceMonth staffPerformanceMonth = staffPerformanceMonthService.getNowMonth();
        if (CommonUtil.isEmpty(staffPerformanceMonth)) {
            throw new PerformanceException(ResponseEnums.PERFOMANCE_MONTH_NULL);
        }
        Integer monthId = staffPerformanceMonth.getId();
        List<ListOrganizeTotalDTO> listOrganizeTotalDTOList = staffPerformanceTotalService.selectListByMonIdWithOrgCode(staffIds, code, staffOrgId, monthId);
        for (ListOrganizeTotalDTO listOrganizeTotalDTO : listOrganizeTotalDTOList) {
            for (ListDirectlyStaffRes listDirectlyStaffRes : listDirectlyStaffResList) {
                if (listOrganizeTotalDTO.getStaffId().equals(listDirectlyStaffRes.getStaffId())) {
                    listDirectlyStaffRes.setOwnTotal(listOrganizeTotalDTO.getOwnTotal());
                    if (CommonUtil.isNotEmpty(listOrganizeTotalDTO.getOrgTotal())) {
                        listDirectlyStaffRes.setDirectlyTotal(listOrganizeTotalDTO.getOrgTotal());
                        listDirectlyStaffRes.setDirectlyBoolean(true);
                    }
                }
            }
        }
        return ResponseDTO.createBySuccessPage("获取直属员工列表成功", listDirectlyStaffResList, pageDTO);
    }

    /**
     * 根据员工id获取直属领导评分详情
     *
     * @param userDTO
     * @param listDirectlyInfoReq
     * @return
     */
    @Override
    public List<ListDirectlyInfoRes> listDirectlyInfoByStaffId(UserDTO userDTO, ListDirectlyInfoReq listDirectlyInfoReq) {
        List<ListDirectlyInfoRes> listDirectlyInfoResList = new ArrayList<>();
        Integer staffId = listDirectlyInfoReq.getStaffId();
        Integer monthId = staffPerformanceMonthService.getNowMonth().getId();
        Integer orgId = userDTO.getUserId();
        Integer code = directlyCode;
        List<ListOrganizeInfoDTO> listOrganizeInfoDTOList = staffPerformanceInfoService.selectOrganizeListByStaffIdAndMonthIdAndOrgId(staffId, monthId, orgId, code);
        for (ListOrganizeInfoDTO listOrganizeInfoDTO : listOrganizeInfoDTOList) {
            ListDirectlyInfoRes listDirectlyInfoRes = new ListDirectlyInfoRes();
            listDirectlyInfoRes.setId(listOrganizeInfoDTO.getId());
            listDirectlyInfoRes.setPerformanceName(listOrganizeInfoDTO.getPerformanceName());
            listDirectlyInfoRes.setPerformanceContent(listOrganizeInfoDTO.getPerformanceContent());
            listDirectlyInfoRes.setPerformanceScore(listOrganizeInfoDTO.getPerformanceScore());
            listDirectlyInfoRes.setOwnScore(listOrganizeInfoDTO.getOwnScore());
            listDirectlyInfoRes.setDirectlyScore(listOrganizeInfoDTO.getOrgScore());
            int status = listOrganizeInfoDTO.getOrgScoreStatus() == 0 ? 1 : 0;
            listDirectlyInfoRes.setStatus(status);
            listDirectlyInfoResList.add(listDirectlyInfoRes);
        }
        return listDirectlyInfoResList;
    }

    /**
     * 直属领导评分
     *
     * @param userDTO
     * @param addDirectlyInfoReq
     */
    @Override
    public void addDirectly(UserDTO userDTO, AddDirectlyInfoReq addDirectlyInfoReq) {
        Staff staff = staffApiService.getStaffByUserId(userDTO.getUserId());
        if (CommonUtil.isEmpty(staff)) {
            throw new PerformanceException(ResponseEnums.STAFF_NULL);
        }
        StaffPerformanceMonth staffPerformanceMonth = staffPerformanceMonthService.getNowMonth();
        if (CommonUtil.isEmpty(staffPerformanceMonth)) {
            throw new PerformanceException(ResponseEnums.PERFOMANCE_MONTH_NULL);
        }
        EntityWrapper<StaffPerformanceTotal> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("staff_id", addDirectlyInfoReq.getStaffId());
        entityWrapper.eq("month_id", staffPerformanceMonth.getId());
        StaffPerformanceTotal staffPerformanceTotal = staffPerformanceTotalService.selectOne(entityWrapper);
        if (CommonUtil.isEmpty(staffPerformanceTotal)) {
            throw new PerformanceException(ResponseEnums.PERFOMANCE_INFO_NULL);
        }
        EntityWrapper<StaffPerformanceTotalOrg> entityWrapperTotalOrg = new EntityWrapper<>();
        entityWrapperTotalOrg.eq("staff_org_code", directlyCode);
        entityWrapperTotalOrg.eq("pfm_total_id", staffPerformanceTotal.getId());
        entityWrapperTotalOrg.eq("staff_org_id", staff.getId());
        StaffPerformanceTotalOrg staffPerformanceTotalOrgCheck = staffPerformanceTotalOrgService.selectOne(entityWrapperTotalOrg);
        if (CommonUtil.isNotEmpty(staffPerformanceTotalOrgCheck)) {
            throw new PerformanceException(ResponseEnums.PERFOMANCE_INFO_HAS);
        }
        List<StaffPerformanceInfoOrg> staffPerformanceInfoOrgList = new ArrayList<>();
        List<AddDirectlyReq> addDirectlyReqList = addDirectlyInfoReq.getAddDirectlyReqList();
        int orgTotal = 0;
        for (AddDirectlyReq addDirectlyReq : addDirectlyReqList) {
            StaffPerformanceInfoOrg staffPerformanceInfoOrg = new StaffPerformanceInfoOrg();
            staffPerformanceInfoOrg.setCreateTime(new Date());
            staffPerformanceInfoOrg.setPfmInfoId(addDirectlyReq.getId());
            staffPerformanceInfoOrg.setStaffOrgCode(directlyCode);
            staffPerformanceInfoOrg.setStaffOrgId(staff.getId());
            orgTotal += addDirectlyReq.getDirectlyScore();
            staffPerformanceInfoOrg.setStaffOrgScore(addDirectlyReq.getDirectlyScore());
            staffPerformanceInfoOrgList.add(staffPerformanceInfoOrg);
        }
        staffPerformanceInfoOrgService.insertBatch(staffPerformanceInfoOrgList);
        StaffPerformanceTotalOrg staffPerformanceTotalOrg = new StaffPerformanceTotalOrg();
        staffPerformanceTotalOrg.setCreateTime(new Date());
        staffPerformanceTotalOrg.setPfmTotalId(staffPerformanceTotal.getId());
        staffPerformanceTotalOrg.setStaffOrgCode(directlyCode);
        staffPerformanceTotalOrg.setStaffOrgId(staff.getId());
        staffPerformanceTotalOrg.setStaffOrgTotal(orgTotal);
        staffPerformanceTotalOrgService.insert(staffPerformanceTotalOrg);
    }

    /**
     * 分页获取分管领导员工
     *
     * @param userDTO
     * @param listBranchStaffReq
     * @return
     */
    @Override
    public ResponseDTO<List<ListBranchStaffRes>> listBranchStaffByPage(UserDTO userDTO, ListBranchStaffReq listBranchStaffReq) {
        List<ListBranchStaffRes> listBranchStaffResList = new ArrayList<>();
        Staff staff = staffApiService.getStaffByUserId(userDTO.getUserId());
        if (CommonUtil.isEmpty(staff)) {
            throw new PerformanceException(ResponseEnums.STAFF_NULL);
        }
        Page<ListOrganizeDTO> page = new Page<>(listBranchStaffReq.getCurrent(), listBranchStaffReq.getSize());
        Integer staffOrgId = staff.getId();
        Integer code = branchCode;
        List<ListOrganizeDTO> listOrganizeDTOPage = staffPerformanceOrganizeService.selectPageByOrgIdAndCode(page, staffOrgId, code);
        PageDTO pageDTO = new PageDTO(page.getPages(), page.getTotal());
        List<Integer> staffIds = new ArrayList<>();
        if (CommonUtil.isEmpty(listOrganizeDTOPage) || listOrganizeDTOPage.size() <= 0) {
            return ResponseDTO.createBySuccessPage("分页获取分管员工列表成功", listBranchStaffResList, pageDTO);
        }
        // 获取员工职位
        Map<Integer, String> dutiesDictMap = dictApiService.getDictInfoByDictCode(StaffDutiesDictCode);
        for (ListOrganizeDTO listOrganizeDTO : listOrganizeDTOPage) {
            staffIds.add(listOrganizeDTO.getStaffId());
            ListBranchStaffRes listBranchStaffRes = new ListBranchStaffRes();
            listBranchStaffRes.setStaffId(listOrganizeDTO.getStaffId());
            listBranchStaffRes.setStaffName(listOrganizeDTO.getStaffName());
            listBranchStaffRes.setStaffCode(listOrganizeDTO.getStaffCode());
            listBranchStaffRes.setStaffDuties(dutiesDictMap.get(listOrganizeDTO.getStaffDuties()));
            listBranchStaffResList.add(listBranchStaffRes);
        }
        StaffPerformanceMonth staffPerformanceMonth = staffPerformanceMonthService.getNowMonth();
        if (CommonUtil.isEmpty(staffPerformanceMonth)) {
            throw new PerformanceException(ResponseEnums.PERFOMANCE_MONTH_NULL);
        }
        Integer monthId = staffPerformanceMonth.getId();
        List<ListOrganizeTotalDTO> listOrganizeTotalDTOList = staffPerformanceTotalService.selectListAllByMonIdWithOrgCode(staffIds, directlyCode, monthId);
        Map<Integer, String> dictInfoMap = dictApiService.getDictInfoByDictCode(LevelDictCode);
        for (ListOrganizeTotalDTO listOrganizeTotalDTO : listOrganizeTotalDTOList) {
            for (ListBranchStaffRes listBranchStaffRes : listBranchStaffResList) {
                if (listOrganizeTotalDTO.getStaffId().equals(listBranchStaffRes.getStaffId())) {
                    listBranchStaffRes.setOwnTotal(listOrganizeTotalDTO.getOwnTotal());
                    listBranchStaffRes.setDirectlyTotal(listOrganizeTotalDTO.getOrgTotal());
                    if (CommonUtil.isNotEmpty(listOrganizeTotalDTO.getLevelCode())) {
                        String level = dictInfoMap.get(listOrganizeTotalDTO.getLevelCode());
                        listBranchStaffRes.setLevel(level);
                    }
                    if (levelRelease.equals(listOrganizeTotalDTO.getLevelRelease())) {
                        listBranchStaffRes.setLevelBoolean(true);
                    }
                }
            }
        }
        return ResponseDTO.createBySuccessPage("分页获取分管员工列表成功", listBranchStaffResList, pageDTO);
    }

    /**
     * 获取等级字典信息
     *
     * @param userDTO
     * @return
     */
    @Override
    public List<ListLevelDictRes> listLevelDict(UserDTO userDTO) {
        List<ListLevelDictRes> listLevelDictResList = new ArrayList<>();
        List<DictInfo> dictInfoList = dictApiService.listDictInfoByDictCode(LevelDictCode);
        for (DictInfo dictInfo : dictInfoList) {
            ListLevelDictRes listLevelDictRes = new ListLevelDictRes();
            listLevelDictRes.setLevelCode(dictInfo.getInfoCode());
            listLevelDictRes.setLevelName(dictInfo.getInfoContent());
            listLevelDictResList.add(listLevelDictRes);
        }
        return listLevelDictResList;
    }

    /**
     * 新增等级
     *
     * @param userDTO
     * @param addLevelReq
     */
    @Override
    public void addLevel(UserDTO userDTO, AddLevelReq addLevelReq) {
        StaffPerformanceMonth staffPerformanceMonth = staffPerformanceMonthService.getNowMonth();
        if (CommonUtil.isEmpty(staffPerformanceMonth)) {
            throw new PerformanceException(ResponseEnums.PERFOMANCE_MONTH_NULL);
        }
        EntityWrapper<StaffPerformanceTotal> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("month_id", staffPerformanceMonth.getId());
        entityWrapper.eq("staff_id", addLevelReq.getStaffId());
        StaffPerformanceTotal staffPerformanceTotal = staffPerformanceTotalService.selectOne(entityWrapper);
        if (CommonUtil.isEmpty(staffPerformanceTotal)) {
            throw new PerformanceException(ResponseEnums.MODIFY_NULL);
        }
        staffPerformanceTotal.setLevelCode(addLevelReq.getLevel());
        staffPerformanceTotalService.updateById(staffPerformanceTotal);
    }

    /**
     * 判断是否可发布评级
     *
     * @param userDTO
     * @return true：可发布，false：不可发布
     */
    @Override
    public boolean checkReleaseLevel(UserDTO userDTO) {
        List<StaffPerformanceTotal> staffPerformanceTotalList = getReleaseLevelTotalIds(userDTO);
        if (CommonUtil.isEmpty(staffPerformanceTotalList) || staffPerformanceTotalList.size() <= 0) {
            return false;
        }
        return true;
    }

    /**
     * 获取可发布的列表
     *
     * @param userDTO
     * @return
     */
    private List<StaffPerformanceTotal> getReleaseLevelTotalIds(UserDTO userDTO) {
        Staff staff = staffApiService.getStaffByUserId(userDTO.getUserId());
        if (CommonUtil.isEmpty(staff)) {
            throw new PerformanceException(ResponseEnums.STAFF_NULL);
        }
        StaffPerformanceMonth staffPerformanceMonth = staffPerformanceMonthService.getNowMonth();
        if (CommonUtil.isEmpty(staffPerformanceMonth)) {
            throw new PerformanceException(ResponseEnums.PERFOMANCE_MONTH_NULL);
        }
        EntityWrapper<StaffPerformanceOrganize> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("staff_org_id", staff.getId());
        entityWrapper.eq("staff_org_code", branchCode);
        List<StaffPerformanceOrganize> staffPerformanceOrganizeList = staffPerformanceOrganizeService.selectList(entityWrapper);
        if (CommonUtil.isEmpty(staffPerformanceOrganizeList)) {
            return null;
        }
        List<Integer> staffIdList = new ArrayList<>();
        for (StaffPerformanceOrganize staffPerformanceOrganize : staffPerformanceOrganizeList) {
            staffIdList.add(staffPerformanceOrganize.getStaffId());
        }
        EntityWrapper<StaffPerformanceTotal> totalEntityWrapper = new EntityWrapper<>();
        totalEntityWrapper.in("staff_id", staffIdList);
        totalEntityWrapper.eq("month_id", staffPerformanceMonth.getId());
        List<StaffPerformanceTotal> staffPerformanceTotalList = staffPerformanceTotalService.selectList(totalEntityWrapper);
        if (CommonUtil.isEmpty(staffPerformanceTotalList)) {
            return null;
        }
        if (staffPerformanceOrganizeList.size() != staffPerformanceTotalList.size()) {
            return null;
        }
        for (StaffPerformanceTotal staffPerformanceTotal : staffPerformanceTotalList) {
            if (CommonUtil.isEmpty(staffPerformanceTotal.getLevelCode())) {
                return null;
            }
            if (levelRelease.equals(staffPerformanceTotal.getLevelRelease())) {
                return null;
            }
            staffPerformanceTotal.setLevelRelease(levelRelease);
        }
        return staffPerformanceTotalList;
    }

    /**
     * 发布评级
     *
     * @param userDTO
     */
    @Override
    public void releaseLevel(UserDTO userDTO) {
        List<StaffPerformanceTotal> staffPerformanceTotalList = getReleaseLevelTotalIds(userDTO);
        if (CommonUtil.isEmpty(staffPerformanceTotalList) || staffPerformanceTotalList.size() <= 0) {
            throw new PerformanceException(ResponseEnums.PERFOMANCE_NO_RELEASE);
        }
        staffPerformanceTotalService.updateBatchById(staffPerformanceTotalList);
    }

    /**
     * 导出Excel
     *
     * @param userDTO
     */
    @Override
    public void exportExcel(UserDTO userDTO, HttpServletResponse response) throws Exception {
        // 定义导出名
        response.setContentType("application/octet-stream");
        // 获取分管领导信息
        Staff staff = staffApiService.getStaffByUserId(userDTO.getUserId());
        if (CommonUtil.isEmpty(staff)) {
            throw new PerformanceException(ResponseEnums.STAFF_NULL);
        }
        // 获取月份
        StaffPerformanceMonth staffPerformanceMonth = staffPerformanceMonthService.getNowMonth();
        if (CommonUtil.isEmpty(staffPerformanceMonth)) {
            throw new PerformanceException(ResponseEnums.PERFOMANCE_MONTH_NULL);
        }
        // 获取部门
        Department department = departmentApiService.selectDepartmentById(staff.getDepId());
        // 获取分管领导下属员工id
        EntityWrapper<StaffPerformanceOrganize> entityWrapperOrg = new EntityWrapper<>();
        entityWrapperOrg.eq("staff_org_code", branchCode);
        entityWrapperOrg.eq("staff_org_id", staff.getId());
        List<StaffPerformanceOrganize> staffPerformanceOrganizeList = staffPerformanceOrganizeService.selectList(entityWrapperOrg);
        List<Integer> staffIds = new ArrayList<>();
        for (StaffPerformanceOrganize staffPerformanceOrganize : staffPerformanceOrganizeList) {
            staffIds.add(staffPerformanceOrganize.getStaffId());
        }
        // 获取分管领导下属员工信息
        List<Staff> staffList = staffApiService.getStaffByIds(staffIds);
        // 获取直属领导评分信息
        List<ListOrganizeInfoDTO> listOrganizeInfoDTOList = staffPerformanceInfoService.selectListByStaffIdsAndMonthIdAndOrgCode(staffIds, staffPerformanceMonth.getId(), directlyCode);
        // 获取总评分信息
        List<ListOrganizeTotalDTO> listOrganizeTotalDTOList = staffPerformanceTotalService.selectListByMonIdWithOrgCode(staffIds, directlyCode, null, staffPerformanceMonth.getId());
        // 获取员工职位
        Map<Integer, String> dutiesDictMap = dictApiService.getDictInfoByDictCode(StaffDutiesDictCode);
        // 获取技术类
        Map<Integer, String> levelTDictMap = dictApiService.getDictInfoByDictCode(StaffLevelDictCodeT);
        // 获取专业类
        Map<Integer, String> levelPDictMap = dictApiService.getDictInfoByDictCode(StaffDutiesDictCode);
        // 评级等级
        Map<Integer, String> levelDictMap = dictApiService.getDictInfoByDictCode(LevelDictCode);

        // 统计信息
        Map<String, String> map = new HashMap<String, String>();
        String month = DateTimeKit.formatTime("yyyy年MM月", staffPerformanceMonth.getMonthDate());
        map.put("title", "技术/专业类员工" + month + "份绩效评定表");
        map.put("department", department.getDepName());

        int devNum = 0; // 技术类参评人数
        int devK1Num = 0; // 技术类评K1人数
        int devK2Num = 0; // 技术类参K2人数
        int devK3Num = 0; // 技术类参K3人数
        int devK4Num = 0; // 技术类参K4人数

        int majorNum = 0; // 专业类参评人数
        int majorK1Num = 0; // 专业类评K1人数
        int majorK2Num = 0; // 专业类评K2人数
        int majorK3Num = 0; // 专业类评K3人数
        int majorK4Num = 0; // 专业类评K4人数

        // 评分信息
        List<PfmExcelDto> pfmExcelDtoList = new ArrayList<>();
        for (int i = 0; i < staffList.size(); i++) {
            Staff staffOne = staffList.get(i);
            PfmExcelDto pfmExcelDto = new PfmExcelDto();
            pfmExcelDto.setIndex(i + 1);
            pfmExcelDto.setName(staffOne.getStaffName());
            pfmExcelDto.setDuties(dutiesDictMap.get(staffOne.getStaffDuties()));
            Integer type = staffOne.getStaffType();
            if (typeT.equals(type)) {
                pfmExcelDto.setpLevel(levelTDictMap.get(staffOne.getStaffLevel()));
            } else if (typeP.equals(type)) {
                pfmExcelDto.setpLevel(levelPDictMap.get(staffOne.getStaffLevel()));
            }
            // 循环直属领导评分信息
            for (ListOrganizeInfoDTO listOrganizeInfoDTO : listOrganizeInfoDTOList) {
                if (staffOne.getId().equals(listOrganizeInfoDTO.getStaffId())) {
                    Integer pfmCode = listOrganizeInfoDTO.getPerformanceCode();
                    switch (pfmCode) {
                        case 1: // 责任感
                            pfmExcelDto.setDuty(listOrganizeInfoDTO.getOrgScore());
                            break;
                        case 2: // 积极性
                            pfmExcelDto.setActive(listOrganizeInfoDTO.getOrgScore());
                            break;
                        case 3: // 协作性
                            pfmExcelDto.setCooperation(listOrganizeInfoDTO.getOrgScore());
                            break;
                        case 4: // 执行力
                            pfmExcelDto.setExecute(listOrganizeInfoDTO.getOrgScore());
                            break;
                        case 5: // 学习发展能力
                            pfmExcelDto.setStudy(listOrganizeInfoDTO.getOrgScore());
                            break;
                        case 6: // 专业知识与技能
                            pfmExcelDto.setKnowledge(listOrganizeInfoDTO.getOrgScore());
                            break;
                        default:
                            pfmExcelDto.setWorkContent(listOrganizeInfoDTO.getPerformanceContent());
                            pfmExcelDto.setWorkScore(listOrganizeInfoDTO.getOrgScore());
                            break;
                    }
//                    listOrganizeInfoDTOList.remove(listOrganizeInfoDTO);
                }
            }
            Integer kType = 0; // 等级
            // 循环直属领导总评分，分管领导评级
            for (ListOrganizeTotalDTO listOrganizeTotalDTO : listOrganizeTotalDTOList) {
                if (staffOne.getId().equals(listOrganizeTotalDTO.getStaffId())) {
                    kType = listOrganizeTotalDTO.getLevelCode();
                    pfmExcelDto.setTotalScre(listOrganizeTotalDTO.getOrgTotal());
                    pfmExcelDto.setLevel(levelDictMap.get(kType));
//                    listOrganizeTotalDTOList.remove(listOrganizeTotalDTO);
                }
            }
            pfmExcelDtoList.add(pfmExcelDto);

            // 统计信息
            if (typeT.equals(type)) {
                devNum += 1;
                if (kType.equals(1)) {
                    devK1Num += 1;
                } else if (kType.equals(2)) {
                    devK2Num += 1;
                } else if (kType.equals(3)) {
                    devK3Num += 1;
                } else if (kType.equals(4)) {
                    devK4Num += 1;
                }
            } else if (typeP.equals(type)) {
                majorNum += 1;
                if (kType.equals(1)) {
                    majorK1Num += 1;
                } else if (kType.equals(2)) {
                    majorK2Num += 1;
                } else if (kType.equals(3)) {
                    majorK3Num += 1;
                } else if (kType.equals(4)) {
                    majorK4Num += 1;
                }
            }
        }

        map.put("devNum", devNum + "");
        map.put("devK1Num", devK1Num + "");
        map.put("devK2Num", devK2Num + "");
        map.put("devK3Num", devK3Num + "");
        map.put("devK4Num", devK4Num + "");

        map.put("majorNum", majorNum + "");
        map.put("majorK1Num", majorK1Num + "");
        map.put("majorK2Num", majorK2Num + "");
        map.put("majorK3Num", majorK3Num + "");
        map.put("majorK4Num", majorK4Num + "");

        OutputStream stream = response.getOutputStream();
        ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, "performance-template.xls", stream,
                pfmExcelDtoList, PfmExcelDto.class, true);
    }

}
