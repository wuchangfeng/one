### One

该应用内容灵感来源于 One 应用。界面设计为自己所构思,遵循 Materfial Design 风格。App 端项目的主体架构为 MVP + Dagger2 , 用 Realm 作为本地数据库存储。后台数据是来自于 One 官方网站以及素锦网站,用 Python 爬虫爬取存储在 LeanCloud 后台。

### Crawler

* [爬取 One 问答和图片](https://github.com/wuchangfeng/Crawler/blob/master/ReadMe-One.md)

* [爬取 SuJIn 精彩文章](https://github.com/wuchangfeng/Crawler/blob/master/ReadMe-Sujin.md)

### Sample

### ScreenShot

### contribution

由于自己实习的不是 Android 开发这块。所以并不能把大量时间花在这上面。项目虽然主体架构以及主要功能完成,但是可以扩展的地方蛮多的:

* 夜间模式以及主体换肤,这一块可能稍微麻烦点，因为要配置一些暗黑图标字体等。[AppCompat v23.2 - 夜间模式最佳实践](https://kingideayou.github.io/2016/03/07/appcompat_23.2_day_night/)

* 问答界面的优化设计。主要要做的就是加上评论以及点赞功能。这个比较简单,具体你可以参考文章界面的对应功能实现。

* 分享选项以及保存功能。这些也是比较简单的功能。

### Open source library

* EasyRecyclerView 替代 RV 来实现高度解耦简洁 
* Glide 图片加载库
* Dagger2 实现依赖注入
* Realm 轻量级数据库
* SwipeBackHelper实现类微信的侧滑返回效果
* Bugly 腾讯的远程 Bugly 统计,实时监控你的应用异常信息

