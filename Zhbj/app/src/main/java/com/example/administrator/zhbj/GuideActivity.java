package com.example.administrator.zhbj;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/6.
 */

public class GuideActivity extends Activity {
    ViewPager mVp_guide;
    int mPointDis;
    int[] mImageId =  new int[]{R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};
    ArrayList<ImageView> mImageList = new ArrayList<ImageView>();
    LinearLayout llcontainer;
    ImageView iv_redpoint;
    int mRedMoveDis;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        mVp_guide = (ViewPager) findViewById(R.id.vp_guide);
        llcontainer = (LinearLayout) findViewById(R.id.llcontainer);
        iv_redpoint = (ImageView) findViewById(R.id.iv_red_point);
        initData();
        mVp_guide.setAdapter(new GuidePager());
        mVp_guide.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //当页面的滑动过程中的回调 positionOffset 是移动的百分比，position是Item的位置,从0开始
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //更新小红点的距离等于两个圆点的距离x移动的百分比
                mPointDis = llcontainer.getChildAt(1).getLeft() - llcontainer.getChildAt(0).getLeft();
                mRedMoveDis = (int) (position*mPointDis+positionOffset*mPointDis);
                //iv_redpoint的父控件是RelativeLayout
                RelativeLayout.LayoutParams red_point_param = (RelativeLayout.LayoutParams) iv_redpoint.getLayoutParams();
                red_point_param.leftMargin = mRedMoveDis;


            }
            //某个页面被选中
            @Override
            public void onPageSelected(int position) {

            }
            //页面状态改变，从滑动-》不滑动，不滑动-》滑动
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //计算两个圆点的距离，移动的距离=第一个圆点的left值-第二个圆点的left值

    }
    void initData(){
        for (int i=0; i < mImageId.length; i++){
            ImageView imageView = new ImageView(this);
            ImageView imageShape = new ImageView(this);
            imageView.setBackgroundResource(mImageId[i]);//通过设置背景，可以让图片填充父窗体
            mImageList.add(imageView);
            //设置布局参数，宽高包裹父窗体，规定：父控件是谁，就是谁申明的布局参数，在这里父控件是LinearLayout
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            if (i>0){
                layoutParams.leftMargin =  10;
            }
            imageShape.setLayoutParams(layoutParams);

            imageShape.setImageResource(R.drawable.shape_point_gray);//设置图片资源，不会填充父布局
            llcontainer.addView(imageShape);
        }



    }
    class GuidePager extends PagerAdapter{

        @Override
        public int getCount() {
            return mImageList.size();
        }

        //判断view 是不是来自一个对象
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        //实例化一个Item
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = mImageList.get(position);
            container.addView(imageView);
            return imageView;
        }
        //销毁一个Item
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
