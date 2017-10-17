package com.gt.inside.entity;

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
 * 研发项目表
 * </p>
 *
 * @author psr
 * @since 2017-10-10
 */
@Data
@Accessors(chain = true)
@TableName("t_dev_project")
public class DevProject extends Model<DevProject> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 项目名
     */
	private String projectName;
    /**
     * 项目时间
     */
	private Date projectTime;
    /**
     * 项目状态（0：进行中，1：已完成）
     */
	private Integer projectStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getProjectTime() {
		return projectTime;
	}

	public void setProjectTime(Date projectTime) {
		this.projectTime = projectTime;
	}

	public Integer getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(Integer projectStatus) {
		this.projectStatus = projectStatus;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
