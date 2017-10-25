package com.gt.inside.core.entity.dict;

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
 * 字典详情表
 * </p>
 *
 * @author psr
 * @since 2017-10-25
 */
@Data
@Accessors(chain = true)
@TableName("t_dict_info")
public class DictInfo extends Model<DictInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 字典表ID
     */
	private Integer dictId;
    /**
     * 字典详情代号
     */
	private Integer infoCode;
    /**
     * 字典详情内容
     */
	private String infoContent;
    /**
     * 字典详情描述
     */
	private String infoRemark;
    /**
     * 创建时间
     */
	private Date createTime;
    /**
     * 删除标识（0：正常，1：删除）
     */
	private Integer deleteFlag;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
