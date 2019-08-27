package com.wjhwjh.asset.common.persistence;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wjhwjh.asset.common.utils.SnowFlake;
import com.wjhwjh.asset.common.utils.UserUtils;
import com.wjhwjh.asset.entity.User;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * @author wjhwjh
 * @description 数据类Entity
 * Created in 15:53 2019/8/23
 */
@Data
@MappedSuperclass
public abstract class DataEntity<T> extends BaseEntity<T> {

    private static final long serialVersionUID = 1L;

    //name
    protected String name;

    //备注
    protected String remarks;

    //创建者
    @OneToOne
    @JoinColumn(name = "create_by")
    protected User createBy;

    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    protected Date createDate;

    //更新者
    @OneToOne
    @JoinColumn(name = "update_by")
    protected User updateBy;

    //更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    protected Date updateDate;

    @JsonIgnore
    protected int del_flag;

    public DataEntity() {
        super();
        this.del_flag = DEL_FLAG_NORMAL;
    }

    public DataEntity(Long id) {
        super(id);
    }

    /**
     * 新增数据之前执行的方法
     */
    @Override
    public void preInsert() {
// 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
        if (!this.isNewRecord) {
            Long id = SnowFlake.nextId();
            setId(id);
            System.out.println("------------------id" + id);
        }
        User user = UserUtils.getUser();
//        User user = new User();
        if (0 != user.getId()) {
            this.updateBy = user;
            this.createBy = user;
        }
        this.updateDate = new Date();
        this.createDate = this.updateDate;
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    @Override
    public void preUpdate() {
        User user = UserUtils.getUser();
//        User user = new User();
        if (0 == user.getId()) {
            this.updateBy = user;
        }
        this.updateDate = new Date();
    }
}
