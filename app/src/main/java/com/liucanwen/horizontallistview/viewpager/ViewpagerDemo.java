package com.liucanwen.horizontallistview.viewpager;

import android.content.Context;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.liucanwen.horizontallistview.R;

import java.util.ArrayList;

public class ViewpagerDemo extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        initViewPager();
    }

    //viewPager
    private void initViewPager() {
        Integer[] imageViews = {R.drawable.ic_launcher,R.drawable.splash,R.drawable.ic_launcher};
        ViewPagerAdapter adapter = new ViewPagerAdapter(this,imageViews);
        viewPager.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        // pageCount设置红缓存的页面数
        viewPager.setOffscreenPageLimit(3);
        // 设置2张图之前的间距。
        viewPager.setPageMargin(49);
    }

    public class ViewPagerAdapter extends PagerAdapter {

        public Object imageUrls;

        private Context context;

        public ViewPagerAdapter(Context context, Object urls) {
            this.imageUrls = urls;
            this.context = context;
        }

        @Override
        public int getCount() {
            int ret = 0;
            //返回最大值   表明   方便以后  循环滑动
            if(imageUrls instanceof Integer[]){
                ret = ((Integer[]) imageUrls).length;
            }else{
                ret = ((ArrayList<String>) imageUrls).size();
            }
            return ret;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = LayoutInflater.from(ViewpagerDemo.this).inflate(R.layout.listview_item,null);
            ImageView imageView = (ImageView) view.findViewById(R.id.screenshot_image);
            //这个必须取余数，不然会下标越界
            //数组
            if(imageUrls instanceof Integer[]){
                position = position % ((Integer[]) imageUrls).length;
                imageView.setImageResource(((Integer[]) imageUrls)[position]);
            }else{
//                //list集合
//                position = position % ((ArrayList<String>) imageUrls).size();
//                //网路获取
//                imageView.setImageDrawable(getResources().getDrawable(R.drawable.splash));
            }
            container.addView(imageView);
            return imageView;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }


}
