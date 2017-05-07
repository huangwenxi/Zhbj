package com.example.administrator.zhbj;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/6.
 */

public class GuideActivity extends Activity {
    ViewPager mVp_guide;
    int[] mImageId =  new int[]{R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};
    ArrayList<ImageView> mImageList = new ArrayList<ImageView>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        mVp_guide = (ViewPager) findViewById(R.id.vp_guide);
        initData();
        mVp_guide.setAdapter(new GuidePager());
    }
    void initData(){
        for (int i=0; i < mImageId.length; i++){
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(mImageId[i]);
            mImageList.add(imageView);
        }

    }
    class GuidePager extends PagerAdapter{

        @Override
        public int getCount() {
            return mImageList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = mImageList.get(position);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
