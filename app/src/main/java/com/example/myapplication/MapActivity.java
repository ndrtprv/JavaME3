package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MapActivity extends Activity implements View.OnClickListener{

    Button btn;
    EditText editCoordinates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        btn = findViewById(R.id.btn);
        editCoordinates = findViewById(R.id.editCoordinates);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("geo:" + editCoordinates.getText().toString()));
        startActivity(intent);
    }
}