package com.gt.inside.core.entity.function.performance;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 员工绩效评分详情-关系评分表
 * </p>
 *
 * @author psr
 * @since 2017-10-31
 */
@Data
@Accessors(chain = true)
@TableName("t_staff_performance_info_org")
public class StaffPerformanceInfoOrg extends Model<StaffPerformanceInfoOrg> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 绩效评分详情ID
     */
	private Integer pfmInfoId;
    /**
     * 组织关系代码（对应字典表）
     */
	private Integer staffOrgCode;
    /**
     * 关系员工id
     */
	private Integer staffOrgId;
	/**
	 * 组织评分
	 */
	private Integer staffOrgScore;
    /**
     * 创建时间
     */
	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPfmInfoId() {
		return pfmInfoId;
	}

	public void setPfmInfoId(Integer pfmInfoId) {
		this.pfmInfoId = pfmInfoId;
	}

	public Integer getStaffOrgCode() {
		return staffOrgCode;
	}

	public void setStaffOrgCode(Integer staffOrgCode) {
		this.staffOrgCode = staffOrgCode;
	}

	public Integer getStaffOrgId() {
		return staffOrgId;
	}

	public void setStaffOrgId(Integer staffOrgId) {
		this.staffOrgId = staffOrgId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getStaffOrgScore() {
		return staffOrgScore;
	}

	public void setStaffOrgScore(Integer staffOrgScore) {
		this.staffOrgScore = staffOrgScore;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
