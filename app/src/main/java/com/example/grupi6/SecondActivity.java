package com.example.grupi6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.textView2);

        if (getIntent().getExtras() != null){
            String vlera = getIntent().getStringExtra("celesi");
            textView.setText(vlera);
        }else {
            Toast.makeText(this, "Extras are null", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        Intent intent = getIntent();
        intent.putExtra("key","Cacttus Education");
        setResult(RESULT_OK,intent);
        finish();

    }
}
