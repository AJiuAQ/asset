package com.wjhwjh.asset.common.utils;

import com.wjhwjh.asset.entity.User;
import com.wjhwjh.asset.repository.AssetUserRepository;
import com.wjhwjh.asset.repository.UserRepository;

/**
 * @author wjhwjh
 * @description 用户工具类
 * Created in 16:11 2019/8/23
 */
public class UserUtils {


    private static UserRepository userRepository = SpringContextHolder.getBean(UserRepository.class);

    private static JWTUtils jwtUtils = SpringContextHolder.getBean(JWTUtils.class);

//    public static final String USER_CACHE = "userCache";
//    public static final String USER_CACHE_ID_ = "id_";
//    public static final String USER_CACHE_LOGIN_NAME_ = "ln";
//    public static final String USER_CACHE_LIST_BY_OFFICE_ID_ = "oid_";

    public static User getUser() {
        //判断请求头是否有token，如果没有返回空
        if (jwtUtils.getUserId() == null) {
            return null;
        }
        Long userId = Long.valueOf(jwtUtils.getUserId());
        if (0 != userId) {
            return get(userId);
        }
        return null;
    }


    /**
     * 根据ID获取用户
     *
     * @param id
     * @return 取不到返回null
     */
    public static User get(Long id) {
        User user = null;
        if (user == null) {
            user = userRepository.getOne(id);
            if (user == null) {
                return null;
            }
//            user.setRoleList(roleDao.findList(new Role(user)));
//            if ("4".equals(user.getUserType()) && !user.getRoleIdList().contains("02f3d2ea64b34b709626714b354499c6")) {
//                user.getRoleList().add(new Role("02f3d2ea64b34b709626714b354499c6"));
//            }
//            CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
//            CacheUtils.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getLoginName(), user);
        }
        return user;
    }

    public static User findByLoginName(String loginName) {
        User user = null;
        if (user == null) {
            user = userRepository.findByLoginName(loginName);
            if (user == null) {
                return null;
            }
//            CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
//            CacheUtils.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getLoginName(), user);
        }
        return user;
    }
}
