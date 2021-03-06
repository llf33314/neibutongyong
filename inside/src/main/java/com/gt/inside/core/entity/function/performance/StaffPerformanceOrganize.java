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
 * 员工绩效评分组织关系表
 * </p>
 *
 * @author psr
 * @since 2017-10-31
 */
@Data
@Accessors(chain = true)
@TableName("t_staff_performance_organize")
public class StaffPerformanceOrganize extends Model<StaffPerformanceOrganize> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 员工id
     */
	private Integer staffId;
    /**
     * 员工组织人id（对应员工表）
     */
	private Integer staffOrgId;
    /**
     * 组织关系代码（对应字典表）
     */
	private Integer staffOrgCode;
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

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Integer getStaffOrgId() {
		return staffOrgId;
	}

	public void setStaffOrgId(Integer staffOrgId) {
		this.staffOrgId = staffOrgId;
	}

	public Integer getStaffOrgCode() {
		return staffOrgCode;
	}

	public void setStaffOrgCode(Integer staffOrgCode) {
		this.staffOrgCode = staffOrgCode;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
