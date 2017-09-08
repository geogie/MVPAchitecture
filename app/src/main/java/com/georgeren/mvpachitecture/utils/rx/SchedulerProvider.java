package com.georgeren.mvpachitecture.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by georgeRen on 2017/9/4.
 */

public interface SchedulerProvider {
    Scheduler ui();

    Scheduler computation();

    Scheduler io();
}
