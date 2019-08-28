package com.example.tugas_pwpb2_limassegitiga;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static android.app.Activity.RESULT_OK;

public class Volume extends AppCompatActivity implements View.OnClickListener{
    private EditText eAlas;
    private EditText etsegitiga;
    private EditText etlimas;
    private TextView tHasilE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume_limas_segitiga);

        eAlas = findViewById(R.id.idalas);
        etsegitiga = findViewById(R.id.idtinggi);
        etlimas = findViewById(R.id.idtinggilimas);
        Button bHitung = findViewById(R.id.idhitung);
        tHasilE = findViewById(R.id.idhasil);

        bHitung.setOnClickListener(this);
        if (savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
        }
    }

    @Override
    public void onClick(View v){
        Intent data = new Intent();
        if (v.getId() == R.id.idhitung) {
            String inputalas = eAlas.getText().toString().trim();
            String inputtsegitiga = etsegitiga.getText().toString().trim();
            String inputtlimas = etlimas.getText().toString().trim();

            boolean isInvalidDouble = false;

            Double alas = toDouble(inputalas);
            Double tsegitiga = toDouble(inputtsegitiga);
            Double tlimas = toDouble(inputtlimas);

            if (alas == null) {
                isInvalidDouble = true;
                eAlas.setError("Nomor harus sesuai");
            }
            if (tsegitiga == null) {
                isInvalidDouble = true;
                etsegitiga.setError("Nomor harus sesuai");
            }
            if (tlimas == null) {
                isInvalidDouble = true;
                etlimas.setError("Nomor harus sesuai");
            }
            if (!isInvalidDouble) {
                double volume =  alas * tsegitiga * tlimas /6;
                tHasilE.setText(String.valueOf(volume));
            }
        }
        data.setData(Uri.parse(tHasilE.getText().toString()));
        setResult(RESULT_OK, data);
        finish();
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
        outState.putString(STATE_RESULT, tHasilE.getText().toString());
    }
}
