package com.zzw.parent.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 功能描述：TODO
 *
 * @author by 周梓武
 * @package com.zzw.parent.entity
 * @since 2020/2/28
 */
@Data
@TableName("parent")
@EqualsAndHashCode(callSuper = false)
public class ParentEntity extends Model<ParentEntity> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("id")
    private String id;

    /**
     * all_user的外键
     */
    @TableField("all_user_id")
    private String allUserId;
}
