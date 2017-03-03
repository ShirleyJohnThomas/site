package com.blossom.site.shiro.web.method;

import java.lang.annotation.*;

import com.blossom.site.shiro.Constants;
/**
 * @Description:
 * @author Blossom
 * @time 2017年3月3日 下午2:52:48
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {

	 /**
     * 当前用户在request中的名字
     *
     * @return
     */
    String value() default Constants.CURRENT_USER;
	
}
