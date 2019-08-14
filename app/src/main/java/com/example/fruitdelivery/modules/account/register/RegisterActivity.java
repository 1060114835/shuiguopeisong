package com.example.fruitdelivery.modules.account.register;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.modules.account.login.LoginActivity;



public class RegisterActivity extends AppCompatActivity {
    private ScrollView mRootScrollView;
    private EditText input;
    private Handler mhandler=new Handler();
    private Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        button=findViewById(R.id.bt_register);
        mRootScrollView=findViewById(R.id.scrollView);
        input = findViewById(R.id.et_account);
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mhandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRootScrollView.fullScroll(View.FOCUS_DOWN);
                    }
                },100);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}
