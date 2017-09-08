package com.georgeren.mvpachitecture.utils.rx;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by georgeRen on 2017/9/4.
 * 任务调度
 */

public class AppSchedulerProvider implements SchedulerProvider {

    /**
     * 此调度器为RxAndroid特有，顾名思义，运行在Android UI线程上
     * @return
     */
    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }

    /**
     * 用于计算任务，如事件循环或和回调处理，不要用于IO操作(IO操作请使用Schedulers.io())；默认线程数等于处理器的数量
     * @return
     */
    @Override
    public Scheduler computation() {
        return Schedulers.computation();
    }

    /**
     * 用于IO密集型任务，如异步阻塞IO操作，这个调度器的线程池会根据需要增长；对于普通的计算任务，请使用
     * Schedulers.computation()；Schedulers.io( )默认是一个CachedThreadScheduler，很像一个有线程缓存的新线程调度器
     * @return
     */
    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

}

