package com.sheygam.masa_2018_g2_17_01_19_part2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView emailTxt, passwordTxt;
    private Button loginBtn, saveBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailTxt = findViewById(R.id.email_txt);
        passwordTxt = findViewById(R.id.password_txt);
        saveBtn = findViewById(R.id.save_btn);
        loginBtn = findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(this);
        saveBtn.setOnClickListener(this);
        load();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.login_btn){
            Intent intent = new Intent(this,EmailActivity.class);
            startActivityForResult(intent,1);
        }else if(v.getId() == R.id.save_btn){
            save();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK && requestCode == 1){
            emailTxt.setText(data.getStringExtra("EMAIL"));
            passwordTxt.setText(data.getStringExtra("PASSWORD"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void save(){
        String email = emailTxt.getText().toString();
        String password = passwordTxt.getText().toString();
        SharedPreferences sp = getSharedPreferences("DATA", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("EMAIL",email);
        editor.putString("PASSWORD",password);
        editor.apply();
    }

    private void load(){
        SharedPreferences sp = getSharedPreferences("DATA",MODE_PRIVATE);
        String email = sp.getString("EMAIL","");
        String password = sp.getString("PASSWORD","");
        emailTxt.setText(email);
        passwordTxt.setText(password);
    }
}
