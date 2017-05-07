package com.example.administrator.zhbj;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.example.administrator.zhbj.Utils.PrefUtils;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl_root);
        /*
        //旋转动画
        RotateAnimation ra =  new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        ra.setDuration(1000);
        ra.setFillAfter(true);//动画结束后保持
        //缩放动画
        ScaleAnimation sa =  new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        sa.setDuration(1000);
        sa.setFillAfter(true);
        //渐变动画
        AlphaAnimation aa = new AlphaAnimation(0, 1);
        aa.setDuration(2000);
        aa.setFillAfter(true);
        //动画集合
        AnimationSet as = new AnimationSet(true);
        as.addAnimation(ra);
        as.addAnimation(sa);
        as.addAnimation(aa);
        */
        // 旋转动画
        RotateAnimation animRotate = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        animRotate.setDuration(1000);// 动画时间
        animRotate.setFillAfter(true);// 保持动画结束状态

        // 缩放动画
        ScaleAnimation animScale = new ScaleAnimation(0, 1, 0, 1,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        animScale.setDuration(1000);
        animScale.setFillAfter(true);// 保持动画结束状态

        // 渐变动画
        AlphaAnimation animAlpha = new AlphaAnimation(0, 1);
        animAlpha.setDuration(2000);// 动画时间
        animAlpha.setFillAfter(true);// 保持动画结束状态

        // 动画集合
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(animRotate);
        set.addAnimation(animScale);
        set.addAnimation(animAlpha);
        rl.startAnimation(set);


        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                boolean firstin = PrefUtils.getBoolean(getApplicationContext(), "firstin", true);
                if(firstin == true){
                    Intent intent = new Intent(SplashActivity.this, GuideActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                }
               // PrefUtils.setBoolean(getApplicationContext(),"firstin", false);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {


            }
        });

    }
}
