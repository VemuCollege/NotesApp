package com.mani.notesappdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText etContent;
    Button btnSave;

    Calendar mCalendar;

    DBHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new DBHelper(MainActivity.this);

        mCalendar = Calendar.getInstance();

        etContent = findViewById(R.id.etNotesContent);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String notesContent = etContent.getText().toString();
        String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        Toast.makeText(MainActivity.this,"Date : "+timeStamp,Toast.LENGTH_SHORT).show();
        long id = mDbHelper.insertNotesContentData(notesContent,timeStamp);

        if (id!=-1){
            Toast.makeText(this,"Record is Saved ",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Record is Not Saved ",Toast.LENGTH_SHORT).show();

        }


    }
}