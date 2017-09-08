package com.georgeren.mvpachitecture.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by georgeRen on 2017/9/1.
 * Scope 自定义注解：局部单例模式，共享
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
