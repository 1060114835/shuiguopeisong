package com.example.fruitdelivery.modules.account.register;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.base.BaseActivity;
import com.example.fruitdelivery.modules.home.shell.ShellActivity;


public class RegisterActivity extends BaseActivity<RegisterPresenter> implements View.OnClickListener,RegisterView {
    private ScrollView mRootScrollView;
    private Handler mhandler=new Handler();

    @Override
    protected int getContentLayoutId() {
      return R.layout.activity_register;
    }

    @Override
    protected RegisterPresenter createPresenter() {
     return new RegisterPresenter();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        ImageView imageView = findViewById(R.id.iv_register_back);
        Button button = findViewById(R.id.bt_register);
        mRootScrollView=findViewById(R.id.scrollView);
        EditText input = findViewById(R.id.et_account);
        button.setOnClickListener(this);
        input.setOnClickListener(this);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_register:
                break;
            case R.id.iv_register_back:
                Intent intent1=new Intent(this,ShellActivity.class);
                startActivity(intent1);
                break;
            case R.id.et_account:
                mhandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRootScrollView.fullScroll(View.FOCUS_DOWN);
                    }
                },100);
                default:
                    break;
        }
    }
}
