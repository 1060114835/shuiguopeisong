package com.example.fruitdelivery.modules.home.self.myUtil;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;

public class MyInterpolater {
    private volatile static AnimatorSet commonSet;
    private volatile static BounceInterpolator bounceInterpolator;
    private volatile static AnticipateInterpolator anticipateInterpolator;
    private volatile static OvershootInterpolator overshootInterpolator;
    public static OvershootInterpolator getOvershootInterpolator() {
        if (overshootInterpolator==null){
            overshootInterpolator = new OvershootInterpolator();
        }
        return overshootInterpolator;
    }

    public static AnticipateInterpolator getAnticipateInterpolator(){
        if(anticipateInterpolator==null){
            anticipateInterpolator = new AnticipateInterpolator();
        }
        return anticipateInterpolator;
    }

    public static BounceInterpolator getBounceInterpolator(){
        if(bounceInterpolator==null){
            bounceInterpolator = new BounceInterpolator();
        }
        return bounceInterpolator;
    }

    public static AnimatorSet getAnimatorSet(){
        if(commonSet==null){
            commonSet = new AnimatorSet();
        }
        return commonSet;
    }
}
