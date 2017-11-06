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
 * 员工绩效汇总表
 * </p>
 *
 * @author psr
 * @since 2017-10-31
 */
@Data
@Accessors(chain = true)
@TableName("t_staff_performance_total")
public class StaffPerformanceTotal extends Model<StaffPerformanceTotal> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 员工ID
     */
	private Integer staffId;
    /**
     * 月份id
     */
	private Integer monthId;
    /**
     * 自评总分
     */
	private Integer ownTotal;
    /**
     * 级别编码（对应字典）
     */
	private Integer levelCode;
	/**
	 * 评级发布（0：未发布，1：发布）
	 */
	private Integer levelRelease;
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

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Integer getMonthId() {
		return monthId;
	}

	public void setMonthId(Integer monthId) {
		this.monthId = monthId;
	}

	public Integer getOwnTotal() {
		return ownTotal;
	}

	public void setOwnTotal(Integer ownTotal) {
		this.ownTotal = ownTotal;
	}

	public Integer getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(Integer levelCode) {
		this.levelCode = levelCode;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	public Integer getLevelRelease() {
		return levelRelease;
	}

	public void setLevelRelease(Integer levelRelease) {
		this.levelRelease = levelRelease;
	}
}
