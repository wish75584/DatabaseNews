package com.bytessystem.databasenews;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class CreatePostActivity extends AppCompatActivity implements View.OnClickListener {


    EditText sub, desc;
    CalendarView date;
    Button submit;
    int pcounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        sub = findViewById(R.id.sub);
        desc = findViewById(R.id.desc);
        submit = findViewById(R.id.submit);
        date = findViewById(R.id.date);

        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == submit) {

            DbHelper mdbHelper = new DbHelper(this);
            SQLiteDatabase db = mdbHelper.getWritableDatabase();

            String psub = sub.getText().toString();
            String pdesc = desc.getText().toString();


            Date dt = new Date();
            dt.setTime(date.getDate());

            String pdate = dt.getDate() + "-" + dt.getMonth() + "-" + dt.getYear();

            ContentValues values = new ContentValues();
            values.put("psub", psub);
            values.put("pdesc", pdesc);
            values.put("pdate", pdate);
            values.put("pcounter", pcounter);

            long newRowId = db.insert("POST", null, values);

            Log.e("newRowId", newRowId + "");

            Toast.makeText(this, "RECORD INSERTED", Toast.LENGTH_LONG).show();
        }
    }
}
























