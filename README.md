# Android MVP Practice Architecture: Sample App,个人理解

 1. MVP的理解：base部分抽出m、v、p。抽出共同特性，字体，范型
 2. 模块划分：根据activity页面（功能），具体m、v、p部分。
 3. DataManager: db、pre、api综合管理
 4. greenDao: 根据Bean生成BeanDao，全局单例
 5. tooBar的返回和android的底部返回区别：parentActivityName使用，解决不通意义上的返回
 6. TextView属性：android:autoLink="web"属性，简单实现了url的浏览
 7. svg:动画Drawable，彩色图案rabbit.
 8. fragmentDialog: google推荐使用的dialog，可以适应横竖屏paid
 9. 自定义字体：CalligraphyContextWrapper，asset/font字体源。
 10. rxJava2: 任务调度，ui\io\com切换。com在这个demo中没有体现作用
 11. glide: 感觉随调随用挺好,对含特殊符号url没有处理是无法拿到图片的。需要urlDecode
 12. dagger2：全局单例appModule+appComponent、局部单例activityModule+activityComponent,module中提供provide和控制作用域，component负责注入到什么模块，通过module和provide链接了依赖和目标的关系桥梁
 13. APPLog：虽然是自己封装用了BuildConfig，release后不会log，但是反编译后还是会catch到的。哈哈
 14. assets中json文件的读取，数据结构 + 字符串 = list集合,$Gson$Types使用
 15. 补充中...
 
 # 参考博客：[原地址](https://github.com/MindorksOpenSource/android-mvp-architecture)


