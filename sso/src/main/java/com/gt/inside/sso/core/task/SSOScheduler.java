package com.gt.inside.sso.core.task;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.gt.inside.sso.common.filter.ApiFilter;
import com.gt.inside.sso.core.service.UserCacheService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * sso定时器
 * Created by psr on 2017/10/20 0020.
 */
@Component
public class SSOScheduler {

    private static Logger logger = Logger.getLogger(SSOScheduler.class);

    @Value("${sso.task.over_time}")
    private int overTime;

    @Autowired
    UserCacheService userCacheService;

    /**
     * 清除userCache（用户登录缓存）
     * 每10分钟清除一次
     */
    @Scheduled(cron = TaskCronContent.userCacheClearCorn)
    public void userCacheClear(){
        logger.debug("userCacheClear start --> over_time : " + overTime);
        try {
            int count = userCacheService.deleteOverToken(overTime);
            logger.debug("userCacheClear end --> count : " + count);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
