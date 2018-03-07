package com.zyl_android.generalutil;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.zyl_android.generalutils.BannerUtils;
import com.zyl_android.generalutils.coustomview.MyViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	private MyViewPager viewpager;
	private LinearLayout point_group;
	private List<String> bannerList=new ArrayList<>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		viewpager=(MyViewPager)findViewById(R.id.viewpager);
		point_group=(LinearLayout)findViewById(R.id.group_contain);
		bannerList.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2639088341,2223755776&fm=27&gp=0.jpg");
		bannerList.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2639088341,2223755776&fm=27&gp=0.jpg");
		bannerList.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2639088341,2223755776&fm=27&gp=0.jpg");
		bannerList.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2639088341,2223755776&fm=27&gp=0.jpg");
		bannerList.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2639088341,2223755776&fm=27&gp=0.jpg");
		BannerUtils bannerUtils=new BannerUtils(this,viewpager,point_group,bannerList);
		bannerUtils.startPlayBanner();
		bannerUtils.setBannerOnerror(R.mipmap.ic_launcher);
		bannerUtils.setBannerOnclickListioner(new BannerUtils.BannerOnclickListioner() {
			@Override
			public void onBannerClick(int position) {
				Toast.makeText(MainActivity.this,position+"",Toast.LENGTH_SHORT).show();
			}
		});
	}
}
