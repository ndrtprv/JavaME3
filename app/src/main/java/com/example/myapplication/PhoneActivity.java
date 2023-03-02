package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PhoneActivity extends Activity implements View.OnClickListener{

    Button btn;
    EditText enterNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone);

        btn = findViewById(R.id.btn2);
        enterNumber = findViewById(R.id.enterPhoneNumber);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:" + enterNumber.getText().toString()));
        startActivity(intent);
    }
}