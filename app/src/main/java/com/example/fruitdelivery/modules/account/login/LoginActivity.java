package com.example.fruitdelivery.modules.account.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.modules.home.shell.ShellActivity;

public class LoginActivity extends AppCompatActivity {
    ImageView iv_login_back;
    Button btn_login,btn_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iv_login_back = findViewById(R.id.iv_login_back);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);
        iv_login_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_back = new Intent(LoginActivity.this, ShellActivity.class);
                startActivity(intent_back);
            }
        });

    }
}
