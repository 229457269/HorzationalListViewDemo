package com.liucanwen.horizontallistview.listviewdeno;

import android.content.Context;
import android.print.PrintAttributes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.liucanwen.horizontallistview.R;

public class HorzationalListViewActivity extends ActionBarActivity {

    private HorizontalListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horzational_list_view);

        initializeViews();
    }

    private void initializeViews()
    {
        listview = (HorizontalListView) findViewById(R.id.listview);
        listview.setAdapter(new MyAdapter());

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(HorzationalListViewActivity.this,l+"----"+i,Toast.LENGTH_LONG).show();
            }
        });
    }

    class MyAdapter extends BaseAdapter
    {

        @Override
        public int getCount()
        {
            return 2;
        }

        @Override
        public Object getItem(int position)
        {
            return 0;
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent)
        {
            View view =  LayoutInflater.from(HorzationalListViewActivity.this).inflate(R.layout.listview_item,parent,false);

            //获取  屏幕宽度
            WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
            int width = windowManager.getDefaultDisplay().getWidth();
            //计算移动位置    当只有一个时  居中
            if(getCount() ==1){
                view.setTranslationX(width/3);
            }
            //两个时  依然居中
            if(getCount() ==2){
                view.setTranslationX(width/6);
            }
            return view;
        }
    }


}
