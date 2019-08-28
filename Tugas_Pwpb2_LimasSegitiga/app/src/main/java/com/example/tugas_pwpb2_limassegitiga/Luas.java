package com.example.tugas_pwpb2_limassegitiga;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Luas  extends AppCompatActivity implements View.OnClickListener {
    private EditText esisi1;
    private EditText esisi2;
    private Button bHitung;
    private TextView tHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luas_limas_segitiga);

        Button btnhasil = findViewById(R.id.idhitung);
        btnhasil.setOnClickListener(this);

        esisi1 = findViewById(R.id.idsisi1);
        esisi2 = findViewById(R.id.idsisi2);
        bHitung = findViewById(R.id.idhitung);
        tHasil = findViewById(R.id.idhasil);

        bHitung.setOnClickListener(this);
        if (savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
        }
    }

    @Override
    public void onClick(View v){
        Intent data = new Intent();
        if (v.getId() == R.id.idhitung);
        String inputsisi1 =esisi1.getText().toString().trim();
        String inputsisi2 = esisi2.getText().toString().trim();

        boolean isEmptyFields = false;
        boolean isInvalidDouble = false;

        if (TextUtils.isEmpty(inputsisi1)){
            isEmptyFields = true;
            esisi1.setError("Tidak Boleh Kosong");
        } if (TextUtils.isEmpty(inputsisi2)){
            isEmptyFields = true;
            esisi2.setError("Tidak Boleh Kosong");
        }

        Double sisi1 = toDouble(inputsisi1);
        Double sisi2 = toDouble(inputsisi2);

        if (sisi1 == null){
            isInvalidDouble = true;
            esisi1.setError("Nomor harus sesuai");
        } if (sisi2 == null){
            isInvalidDouble = true;
            esisi2.setError("Nomor harus sesuai");
        } if (!isEmptyFields && !isInvalidDouble){
            double volume = sisi1 * sisi2;
            tHasil.setText(String.valueOf(volume));
        }
    }


    private Double toDouble(String str){
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e){
            return null;
        }
    }

    private static final String STATE_RESULT = "state_result";
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tHasil.getText().toString());
    }
}
