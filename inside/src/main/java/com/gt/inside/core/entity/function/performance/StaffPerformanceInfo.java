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
 * 员工绩效评分详情表
 * </p>
 *
 * @author psr
 * @since 2017-10-31
 */
@Data
@Accessors(chain = true)
@TableName("t_staff_performance_info")
public class StaffPerformanceInfo extends Model<StaffPerformanceInfo> {

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
	 * 评分码，对应字典1002详情code
	 */
	private Integer pfmCode;
	/**
	 * 绩效名称
	 */
	private String pfmName;
    /**
     * 绩效内容
     */
	private String pfmContent;
	/**
	 * 标准分
	 */
	private Integer pfmStandardScore;
    /**
     * 绩效自评分数
     */
	private Integer pfmOwnScore;
    /**
     * 绩效月份id
     */
	private Integer monthId;
    /**
     * 创建日期
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

	public String getPfmContent() {
		return pfmContent;
	}

	public void setPfmContent(String pfmContent) {
		this.pfmContent = pfmContent;
	}

	public Integer getPfmOwnScore() {
		return pfmOwnScore;
	}

	public void setPfmOwnScore(Integer pfmOwnScore) {
		this.pfmOwnScore = pfmOwnScore;
	}

	public Integer getMonthId() {
		return monthId;
	}

	public void setMonthId(Integer monthId) {
		this.monthId = monthId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getPfmName() {
		return pfmName;
	}

	public void setPfmName(String pfmName) {
		this.pfmName = pfmName;
	}

	public Integer getPfmStandardScore() {
		return pfmStandardScore;
	}

	public void setPfmStandardScore(Integer pfmStandardScore) {
		this.pfmStandardScore = pfmStandardScore;
	}

	public Integer getPfmCode() {
		return pfmCode;
	}

	public void setPfmCode(Integer pfmCode) {
		this.pfmCode = pfmCode;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
