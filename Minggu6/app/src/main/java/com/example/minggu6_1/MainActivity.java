package com.example.minggu6_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnPindahActivity, btnPindahData, btnDial, btnMaps, btnShareText, btnSms,  btnResult;
    private static final int REQUEST_CODE = 75;
    private static final int PICK_CONTACT_REQUEST = 1;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPindahActivity = findViewById(R.id.btn_pindah_activity);
        btnPindahActivity.setOnClickListener(this);

        btnPindahData = findViewById(R.id.btn_pindah_activity_data);
        btnPindahData.setOnClickListener(this);

        btnDial = findViewById(R.id.btn_dial);
        btnDial.setOnClickListener(this);

        btnMaps = findViewById(R.id.btn_maps);
        btnMaps.setOnClickListener(this);

        btnShareText = findViewById(R.id.btn_share_text);
        btnShareText.setOnClickListener(this);

        btnSms = findViewById(R.id.btn_sms);
        btnSms.setOnClickListener(this);

        btnResult = findViewById(R.id.btn_activity_result);
        btnResult.setOnClickListener(this);

        textViewResult = findViewById(R.id.textViewResult);


    }


    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_pindah_activity:
                Intent intentPindahActivity = new Intent(this, PindahActivity.class);
                startActivity(intentPindahActivity);
                break;
            case R.id.btn_pindah_activity_data:
                Intent moveWithDataIntent = new Intent(this, PindahDenganData.class);
                moveWithDataIntent.putExtra("extra_name", "Satsa Ratri Hastutik");
                moveWithDataIntent.putExtra("NIM", "E41191795");
                startActivity(moveWithDataIntent);
                break;

            case R.id.btn_dial:
                String phoneNumber = "081339011430";
                Intent dialphone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialphone);
                break;
            case R.id.btn_maps:
                Intent intentmaps = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-8.2755701,113.6407981"));
                intentmaps.setPackage("com.google.android.apps.maps");
                startActivity(intentmaps);
                break;
            case R.id.btn_share_text:
                Intent share = new Intent(Intent.ACTION_SEND);
                share.putExtra(Intent.EXTRA_TEXT, "Mari Belajar Implicit dan Explicit ");
                share.setType("text/plain");
                startActivity(Intent.createChooser(share, "share link"));
                break;
            case R.id.btn_sms:
                Intent sms = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto: 081339011430"));
                sms.putExtra("sms_body", "Mari Belajar Implicit dan Explicit ");
                startActivity(sms);
                break;

            case R.id.btn_activity_result:
                Intent moveForResultIntent = new Intent(this, com.example.minggu6_1.PindahForResult.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_CONTACT_REQUEST){
            if (resultCode == RESULT_OK){
                Uri contactUri = data.getData();
                String []projection = {ContactsContract.CommonDataKinds.Phone.NUMBER};

                Cursor cursor = getContentResolver().query(contactUri, projection, null, null, null);
                cursor.moveToFirst();

                int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String number = cursor.getString(column);
                textViewResult.setText(number);
            }
        }
        if (requestCode == REQUEST_CODE){
            if (resultCode == com.example.minggu6_1.PindahForResult.RESULT_CODE){
                int selectedValue = data.getIntExtra(com.example.minggu6_1.PindahForResult.EXTRA_VALUE, 0);
                textViewResult.setText("Hasil: "+selectedValue);
            }
        }
    }
}