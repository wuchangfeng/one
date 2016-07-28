### One

* 该应用内容灵感来源于 One 应用。界面设计为自己所构思,遵循 Materfial Design 风格。App 端项目的主体架构为 MVP + Dagger2, 用 Realm 作为本地数据库存储。后台数据是来自于 One 官方网站以及素锦网站,用 Python 爬虫爬取存储在 LeanCloud 后台。
* 如果你有兴趣 Clone 代码,需要注册申请 LeanCloud 的 ID 和 Key 以及 Bugly 的 ID 填入到 AppConstant 中。当然 Python 爬虫代码也需要填入 key 和 ID 。
* 项目是我实习期间,每天下班自己利用晚上休息时间写一点。但是后来越来越控制不住,越写越多。所以将其开源出来。
* 应用内集成了 Bugly 还是很好用的,我会及时将其贴到 issue 中的。

### Crawler
爬虫代码你可以在这里看到:
* [爬取 One 问答和图片](https://github.com/wuchangfeng/Crawler/blob/master/ReadMe-One.md)
* [爬取 SuJin 精彩文章](https://github.com/wuchangfeng/Crawler/blob/master/ReadMe-Sujin.md)

### Sample
[戳这里体验一下](http://fir.im/MyOne)

### Contribution
由于自己暑期实习不是 Android 开发这块。所以并不能把大量时间花在这上面。项目虽然主体架构以及主要功能完成,但是可以扩展的地方蛮多的:

* 夜间模式以及主体换肤,这一块可能稍微麻烦点,因为要配置一些暗黑图标字体等。[AppCompat v23.2 - 夜间模式最佳实践](https://kingideayou.github.io/2016/03/07/appcompat_23.2_day_night/)
* 问答界面的优化设计。主要要做的就是加上评论以及点赞功能。这个比较简单,具体你可以参考文章界面的对应功能实现。
* 利用 LeanCloud 提供的登录注册功能。实现不同用户使用,评论,点赞等功能。
* 分享选项以及保存功能。这些也是比较简单的功能。
* 适配问题一直很麻烦。个人用腾讯的云测试了很多机型,发现适配还是一个问题。
* 最后,如果你嫌数据获取麻烦,你可以联系我。我将云端数据导出来给你 联系方式邮件或者 qq 即可。

### Open source library

* EasyRecyclerView 替代 RV 来实现高度解耦简洁。
* Glide 图片加载库。
* Dagger2 实现依赖注入。
* Realm 轻量级数据库。
* SwipeBackHelper 实现类微信的侧滑返回效果。
* Bugly 腾讯的远程 Bugly 统计,实时监控你的应用异常信息。

### ScreenShot

![](http://ww4.sinaimg.cn/large/b10d1ea5gw1f668agtzr0j206z0dx75c.jpg)
![](http://ww2.sinaimg.cn/large/b10d1ea5gw1f668bhb75hj20730dv75b.jpg)
![](http://ww3.sinaimg.cn/large/b10d1ea5gw1f668o5bgkpj20710dwjsb.jpg)
![](http://ww1.sinaimg.cn/large/b10d1ea5gw1f668cesawpj20700dut9x.jpg)
![](http://ww4.sinaimg.cn/large/b10d1ea5gw1f668e6mmiwj20740dtgmk.jpg)
![](http://ww2.sinaimg.cn/large/b10d1ea5gw1f668d1p3jqj20700dyjs3.jpg)
![](http://ww4.sinaimg.cn/large/b10d1ea5gw1f6697lrq7qj206y0dv0tz.jpg)
![](http://ww4.sinaimg.cn/large/b10d1ea5gw1f668nq8bqyj20700dx75j.jpg)
![](http://ww2.sinaimg.cn/large/b10d1ea5gw1f668crn4byj20720dxdgf.jpg)


