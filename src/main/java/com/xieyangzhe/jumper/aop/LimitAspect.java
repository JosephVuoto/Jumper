package com.xieyangzhe.jumper.aop;

import com.google.common.util.concurrent.RateLimiter;
import com.google.gson.Gson;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yangzhe Xie
 * @date 21/4/20
 */
@SuppressWarnings("UnstableApiUsage")
@Component
@Scope
@Aspect
public class LimitAspect {
    private static RateLimiter rateLimiter = RateLimiter.create(3.0);

    @Pointcut("@annotation(com.xieyangzhe.jumper.annotation.ServiceLimit)")
    public void ServiceAspect() {

    }

    @Around("ServiceAspect()")
    public Object around(ProceedingJoinPoint joinPoint) {
        boolean flag = rateLimiter.tryAcquire();
        Object obj = null;
        try {
            if (flag) {
                obj = joinPoint.proceed();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        if (obj == null) {
            Map<String, String> result = new HashMap<>();
            result.put("code", "-1");
            result.put("message", "请求频率过快，请稍后重试");
            return new Gson().toJson(result);
        }
        return obj;
    }
}
