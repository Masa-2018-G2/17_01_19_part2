package com.sheygam.masa_2018_g2_17_01_19_part2;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmailActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText inputEmail;
    private Button backBtn, nextBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        inputEmail = findViewById(R.id.input_email);
        backBtn = findViewById(R.id.back_btn);
        nextBtn = findViewById(R.id.next_btn);

        backBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.back_btn){
            finish();
        }else if(v.getId() == R.id.next_btn){
            Intent intent = new Intent(this, PasswordActivity.class);
            String email = inputEmail.getText().toString();
            intent.putExtra("EMAIL",email);
            startActivityForResult(intent,1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK && requestCode == 1){
            setResult(RESULT_OK,data);
            finish();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
