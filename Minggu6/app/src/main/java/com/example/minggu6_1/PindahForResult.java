package com.example.minggu6_1;

import com.example.minggu6_1.R;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class PindahForResult extends AppCompatActivity implements View.OnClickListener {

    public static final int RESULT_CODE = 110;
    public static final String EXTRA_VALUE = "EXTRA_VALUE";
    private Button buttonSubmit;
    private RadioGroup radioGroupAngka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pindah_for_result);

        radioGroupAngka = findViewById(R.id.radioGroupAngka);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(this);
    }

   @Override
    public void onClick (View view){
        if (radioGroupAngka.getCheckedRadioButtonId()!=0){
            int value = 0;
            switch (radioGroupAngka.getCheckedRadioButtonId()){
                case R.id.radioButton1:
                    value = 1999;
                    break;
                case R.id.radioButton2:
                    value = 2000;
                    break;
                case R.id.radioButton3:
                    value = 2001;
                    break;
            }

            Intent resultIntent = new Intent();
            resultIntent.putExtra(EXTRA_VALUE, value);
            setResult(RESULT_CODE, resultIntent);
            finish();
        }
    }
}