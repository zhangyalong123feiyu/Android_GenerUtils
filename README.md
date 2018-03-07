# GeneralUtils
工具类</br>
============
使用通用工具类只需要以下简单的两步操作就可以：</br>
Step 1.Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.zhangyalong123feiyu:GeneralUtils:v1.3'
	}

目前该库支持的工具类有：
---------------------
</br>BannerUitls,DensityUtils,DialogUils,NetworkUtils(网络),PhoneNumberUtils(电话号码)
,</br>ScreenShotUtils(屏幕裁剪),StatusBarUtils(状态栏),WaitUtils(等待进度条)</br>

例如电话,邮箱工具类使用如下：
------------------------
 PhoneNumberUtils.isMobileNumber("");
 </br>PhoneNumberUtils.isEmail("")；
 
目前该库也支持常规轮播图：
--------------------------------
使用是只需要new 一个bannerUtils,然后使用相关的方法，另外该库需要使用自己库中的自定义viewpager，及指示器。
