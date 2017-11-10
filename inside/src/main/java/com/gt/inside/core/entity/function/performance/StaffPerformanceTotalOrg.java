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
 * 员工绩效汇总-关系汇总表
 * </p>
 *
 * @author psr
 * @since 2017-10-31
 */
@Data
@Accessors(chain = true)
@TableName("t_staff_performance_total_org")
public class StaffPerformanceTotalOrg extends Model<StaffPerformanceTotalOrg> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 绩效评分汇总ID
     */
	private Integer pfmTotalId;
    /**
     * 组织关系代码（对应字典表）
     */
	private Integer staffOrgCode;
    /**
     * 关系员工id
     */
	private Integer staffOrgId;
	/**
	 * 组织关系评分
	 */
	private Integer staffOrgTotal;
    /**
     * 创建时间
     */
	private Date createTime;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPfmTotalId() {
		return pfmTotalId;
	}

	public void setPfmTotalId(Integer pfmTotalId) {
		this.pfmTotalId = pfmTotalId;
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

	public Integer getStaffOrgTotal() {
		return staffOrgTotal;
	}

	public void setStaffOrgTotal(Integer staffOrgTotal) {
		this.staffOrgTotal = staffOrgTotal;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
