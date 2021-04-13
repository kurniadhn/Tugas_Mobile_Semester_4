package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        }


        public void Button01 (View view){
            Intent intent = new Intent(MainActivity.this, linear_layout.class);
            startActivity(intent);
        }

        public void Button02(View view) {
        Intent intent = new Intent(MainActivity.this, relative_layout.class);
        startActivity(intent);
         }

        public void Button03(View view) {
        Intent intent = new Intent(MainActivity.this, constraint_layout.class);
        startActivity(intent);
        }

        public void Button04(View view) {
            Intent intent = new Intent(MainActivity.this, frame_layout.class);
            startActivity(intent);
         }

        public void Button05(View view) {
        Intent intent = new Intent(MainActivity.this, tabel_layout.class);
        startActivity(intent);
         }

       // public void Button06(View view) {
       //Intent intent = new Intent(MainActivity.this, material_design.class);
       //startActivity(intent);
        //}

        //public void Button07(View view) {
        //Intent intent = new Intent(MainActivity.this, scroll_view.class);
        //startActivity(intent);
        //}

        //public void Button08(View view) {
        //Intent intent = new Intent(MainActivity.this, scroll_view_horizontal.class);
        //startActivity(intent);
    //}


}