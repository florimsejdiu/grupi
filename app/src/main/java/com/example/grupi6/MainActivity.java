package com.example.grupi6;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.grupi6.Colors;

import static android.os.Build.VERSION_CODES.P;


public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button1;
    Button button2;
    RelativeLayout relativeLayout;
    TextView textView;

    Colors color = new Colors();

    public static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("metoda e thirrur eshte onCreate");

        editText = findViewById(R.id.editText);
        button1 = findViewById(R.id.button);
        relativeLayout = findViewById(R.id.relativeLayout);
        button2 = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().length() > 0) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    String text = editText.getText().toString();
                    intent.putExtra("celesi", text);
                    startActivityForResult(intent, REQUEST_CODE);
                } else {
                    Toast.makeText(MainActivity.this, "Write input first!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();


            }
        });

        if (SecondActivity.btnClicked) {

            final String vlera = getIntent().getStringExtra("teksti");
            if (getIntent().getExtras() != null) {
                textView.setText(vlera);
                textView.setTextColor(Color.BLACK);
                textView.setTextSize(30);
                textView.setBackgroundColor(Color.GREEN);
            } else {
                Toast.makeText(this, "Extras are null", Toast.LENGTH_SHORT).show();
            }
            SecondActivity.btnClicked = false;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data == null){
            Toast.makeText(this, "Data are null", Toast.LENGTH_SHORT).show();
            return;
        }

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK ){

            String result = data.getStringExtra("key");
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();


        }

    }

    private void showAlertDialog() {

        final Toast toast = Toast.makeText(this, "Color was changed successfully!", Toast.LENGTH_SHORT);


        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Change color");
        alertDialogBuilder.setMessage("Do you want to change background color?");
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                relativeLayout.setBackgroundColor(color.getColor());

                toast.show();
              //  finish();
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });


        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("metoda e thirrur eshte onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("metoda e thirrur eshte onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("metoda e thirrur eshte onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("metoda e thirrur eshte onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("metoda e thirrur eshte onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("metoda e thirrur eshte onDestroy");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.out.println("metoda e thirrur eshte onBackPressed");
    }


}
