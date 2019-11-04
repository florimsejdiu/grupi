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

    Button button3, button4;

    Colors color = new Colors();
    public static boolean btnClicked = false;

    public static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.textView2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        final String vlera = getIntent().getStringExtra("celesi");
        if (getIntent().getExtras() != null){
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
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.putExtra("teksti",vlera);
                startActivityForResult(intent,REQUEST_CODE);
                btnClicked = true;
            }

        });

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        Intent intent = getIntent();
        intent.putExtra("key","onActivityResult was performed successfully!");
        setResult(RESULT_OK,intent);
        finish();

    }
}
