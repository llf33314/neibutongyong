package com.gt.inside.core.entity.organize.staff;

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
 * 员工表
 * </p>
 *
 * @author psr
 * @since 2017-10-26
 */
@Data
@Accessors(chain = true)
@TableName("t_staff")
public class Staff extends Model<Staff> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 用户ID
     */
	private Integer userId;
    /**
     * 部门id
     */
	private Integer depId;
    /**
     * 员工编号
     */
	private String staffCode;
    /**
     * 员工姓名
     */
	private String staffName;
    /**
     * 入职时间
     */
	private Date staffJoinTime;
    /**
     * 员工状态（0：正常，1：离职停用）
     */
	private Integer staffStatus;
    /**
     * 员工电话
     */
	private String staffPhone;
    /**
     * 创建时间
     */
	private Date createTime;
    /**
     * 创建人
     */
	private String createUser;
    /**
     * 删除状态（0：正常，1：删除）
     */
	private Integer deleteFlag;


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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public Date getStaffJoinTime() {
		return staffJoinTime;
	}

	public void setStaffJoinTime(Date staffJoinTime) {
		this.staffJoinTime = staffJoinTime;
	}

	public Integer getStaffStatus() {
		return staffStatus;
	}

	public void setStaffStatus(Integer staffStatus) {
		this.staffStatus = staffStatus;
	}

	public String getStaffPhone() {
		return staffPhone;
	}

	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
}
