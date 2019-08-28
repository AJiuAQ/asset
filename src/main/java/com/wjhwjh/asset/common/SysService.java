package com.wjhwjh.asset.common;

import com.wjhwjh.asset.common.utils.UserUtils;
import com.wjhwjh.asset.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wjhwjh
 * @description 系统管理，安全相关实体的管理类,包括用户、角色、菜单.
 * Created in 15:36 2019/8/26
 */
@Service
@Transactional(readOnly = true)
public class SysService {

    @Transactional
    public User passwordLogin(String loginName, String password) {
        User user = UserUtils.findByLoginName(loginName);
        return user;
    }
}
