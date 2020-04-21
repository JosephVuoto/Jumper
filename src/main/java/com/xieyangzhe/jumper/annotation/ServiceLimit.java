package com.xieyangzhe.jumper.annotation;

import java.lang.annotation.*;

/**
 * @author Yangzhe Xie
 * @date 21/4/20
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceLimit {

}
