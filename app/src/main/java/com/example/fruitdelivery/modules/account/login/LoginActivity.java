package com.example.fruitdelivery.modules.account.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.fruitdelivery.R;
import com.example.fruitdelivery.modules.home.shell.ShellActivity;

public class LoginActivity extends AppCompatActivity {
    ImageView iv_login_back;
    Button btn_login,btn_register;
    Spinner spinner;
    EditText username;
    EditText password;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iv_login_back = findViewById(R.id.iv_login_back);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);
        username = findViewById(R.id.edt_user_account);
        password = findViewById(R.id.edt_pass_word);
        spinner = findViewById(R.id.spinner);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("123456")) {
                    Intent intent_back = new Intent(LoginActivity.this, ShellActivity.class);
                    startActivity(intent_back);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "账号名或密码错误，请重视", Toast.LENGTH_SHORT).show();
                }
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {

                String[] languages = getResources().getStringArray(R.array.week);
                Toast.makeText(LoginActivity.this, "你点击的是:"+languages[pos], Toast.LENGTH_SHORT).show();
                SharedPreferences sharedPreferences = getSharedPreferences("week",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("week", languages[pos]);
                editor.apply();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
    }

}
