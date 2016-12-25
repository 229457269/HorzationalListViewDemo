package com.liucanwen.horizontallistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.liucanwen.horizontallistview.listviewdeno.HorzationalListViewActivity;
import com.liucanwen.horizontallistview.viewpager.ViewpagerDemo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	private Button listview;

	private Button viewpager;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listview = (Button) findViewById(R.id.btn_listView);
		viewpager = (Button) findViewById(R.id.btn_viewpager);

		listview.setOnClickListener(this);
		viewpager.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){

			case R.id.btn_listView:

				startActivity(new Intent(this, HorzationalListViewActivity.class));

				break;

			case R.id.btn_viewpager:

				startActivity(new Intent(this, ViewpagerDemo.class));

				break;

			default:break;
		}
	}

}
