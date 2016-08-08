### One

* 该应用内容灵感来源于 One 应用。界面设计为自己所构思,遵循 Materfial Design 风格。App 端项目的主体架构为 MVP + Dagger2, 用 Realm 作为本地数据库存储。后台数据是来自于 One 官方网站以及素锦网站,用 Python 爬虫爬取存储在 LeanCloud 后台。
* 如果你有兴趣 Clone 代码,需要注册申请 LeanCloud 的 ID 和 Key 以及 Bugly 的 ID 填入到 AppConstant 中。当然 Python 爬虫代码也需要填入 key 和 ID .
* 项目是我实习期间,每天下班自己利用晚上休息时间写一点。后续会继续完善该 App.
* 应用内集成了 Bugly 还是很好用的,我会及时将其贴到 issue 中的。

### Crawler for Data

* [爬取 One 问答和图片](https://github.com/wuchangfeng/Crawler/blob/master/ReadMe-One.md)
* [爬取 SuJin 精彩文章](https://github.com/wuchangfeng/Crawler/blob/master/ReadMe-Sujin.md)
* [爬取 DouBan Top250 图书](https://github.com/wuchangfeng/Crawler)

### Sample

[戳这里体验一下](http://fir.im/MyOne)

### Contribution

* 夜间模式以及主体换肤,这一块可能稍微麻烦点,因为要配置一些暗黑图标字体等。[AppCompat v23.2 - 夜间模式最佳实践](https://kingideayou.github.io/2016/03/07/appcompat_23.2_day_night/)
* 利用 LeanCloud 提供的登录注册功能。实现不同用户使用,评论,点赞等功能。
* 适配问题一直很麻烦。个人用腾讯的云测试了很多机型,发现适配还是一个问题。
* 已经将豆瓣书籍的数据爬取完毕，存储在云端。你也可以再加一个页面,做豆瓣书籍推荐。
* 新版本已经将各种 key 置于源码中,希望一起完善。

### Open source library

* EasyRecyclerView 替代 RV 来实现高度解耦简洁。
* Glide 图片加载库。
* Dagger2 实现依赖注入。
* Realm 轻量级数据库。
* SwipeBackHelper 实现类微信的侧滑返回效果。
* Bugly 腾讯的远程 Bugly 统计,实时监控你的应用异常信息。

### Change Log

[点击这里查看更新历史](https://github.com/wuchangfeng/One/wiki)

### ScreenShot

![](http://ww1.sinaimg.cn/large/b10d1ea5gw1f6j59ignonj20870g5dhu.jpg)
![](http://ww4.sinaimg.cn/large/b10d1ea5gw1f6j5a513y4j20880g5tal.jpg)
![](http://ww4.sinaimg.cn/large/b10d1ea5gw1f6j5ad1y0kj20890g7mxy.jpg)
![](http://ww2.sinaimg.cn/large/b10d1ea5gw1f6j5alhddzj20880g60ud.jpg)
![](http://ww4.sinaimg.cn/large/b10d1ea5gw1f6j5at0d5aj20890g5gmq.jpg)
![](http://ww4.sinaimg.cn/large/b10d1ea5gw1f6j5b00rd8j20870g6q49.jpg)
![](http://ww3.sinaimg.cn/large/b10d1ea5gw1f6j5b6y6x2j20880g43zh.jpg)
![](http://ww4.sinaimg.cn/large/b10d1ea5gw1f6j5bjkawmj20890g6mys.jpg)





