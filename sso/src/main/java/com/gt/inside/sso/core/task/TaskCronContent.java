package com.gt.inside.sso.core.task;

/**
 * Created by psr on 2017/11/14 0014.
 */
public class TaskCronContent {

    private TaskCronContent(){}

    /**
     * 业务：清除用户缓存定时器
     * 频率：每10分钟进行一次
     * 数据库操作：select
     */
    public static final String userCacheClearCorn = "0 0/10 * * * ?";

}
