package com.example.grupi6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    TextView textView;

    Button button3;
    Colors color = new Colors();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.textView2);
        button3 = findViewById(R.id.button3);

        if (getIntent().getExtras() != null){
            String vlera = getIntent().getStringExtra("celesi");
            textView.setText(vlera);
        }else {
            Toast.makeText(this, "Extras are null", Toast.LENGTH_SHORT).show();
        }

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setTextColor(color.getColor());
            }
        });

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
