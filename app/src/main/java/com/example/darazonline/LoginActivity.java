package com.example.darazonline;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class LoginActivity extends AppCompatActivity {
    Random r = new Random();
    EditText code;
    Button btnlog;
    ProgressDialog progress;
    int i1 = r.nextInt(1245667 - 1223) + 28;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnlog=findViewById(R.id.button2);
        EditText myEditText = (EditText) findViewById(R.id.etnumer);
         code = findViewById(R.id.etcode);
        InputFilter[] filters = new InputFilter[1];
        filters[0] = new InputFilter.LengthFilter(10); //Filter to 10 characters
        myEditText .setFilters(filters);
        progress = new ProgressDialog(this);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                code.setText(i1+"");
            }
        },9000);

        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress.setTitle("Please Wait!!");
                progress.setMessage("Wait!!");
                progress.setCancelable(true);
                progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progress.show();
                Handler hnds=new Handler();
                hnds.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progress.dismiss();
                       Intent intent=new Intent(LoginActivity.this,Dashboard.class);
                       startActivity(intent);
                       finish();
                    }
                },2000);
            }
        });







    }
}
