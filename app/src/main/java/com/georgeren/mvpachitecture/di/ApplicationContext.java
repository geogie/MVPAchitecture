package com.georgeren.mvpachitecture.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by georgeRen on 2017/9/1.
 * 自定义注解，运行时注解 Retention RetentionPolicy.RUNTIME
 * http://blog.csdn.net/github_35180164/article/details/52118286
 * 自定义注解：
 * dagger： Qualifier 解决依赖注入迷失问题
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationContext {
}
