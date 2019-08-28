package com.example.tugas_pwpb2_limassegitiga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends  AppCompatActivity implements View.OnClickListener {
    int req_code = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnVolumeA = findViewById(R.id.idvolume);
        btnVolumeA.setOnClickListener(this);

        Button btnLuasA = findViewById(R.id.idluas);
        btnLuasA.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.idvolume:
                Intent data = new Intent(MainActivity.this, Volume.class);
                startActivityForResult(data, req_code);
                break;
            case R.id.idluas:
                Intent moveIntentA = new Intent(MainActivity.this, Luas.class);
                startActivity(moveIntentA);
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == req_code){
            if (resultCode == RESULT_OK){
                TextView hasilnama = findViewById(R.id.view1);
                hasilnama.setText(data.getData().toString());
            }
        }
    }
}