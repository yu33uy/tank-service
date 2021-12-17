package com.github.w4o.manage.common.cache;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;

/**
 * @author frank
 */
public class CaptchaCache {

    public static final TimedCache<String, String> TIMED_CACHE;

    static {
        TIMED_CACHE = CacheUtil.newTimedCache(30 * 60 * 100);
        TIMED_CACHE.schedulePrune(60 * 100);
    }
}
