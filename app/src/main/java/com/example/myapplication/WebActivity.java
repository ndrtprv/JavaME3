package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WebActivity extends Activity implements View.OnClickListener{

    Button btn;
    EditText enterLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);

        btn = findViewById(R.id.btn1);
        enterLink = findViewById(R.id.enterLink);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://" + enterLink.getText().toString()));
        startActivity(intent);
    }
}