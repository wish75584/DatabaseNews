package com.bytessystem.databasenews;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FullPostActivity extends AppCompatActivity {


    TextView sub, date, counter, desc;
    Button dlt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_post);


        sub = findViewById(R.id.sub);
        date = findViewById(R.id.date);
        counter = findViewById(R.id.counter);
        desc = findViewById(R.id.desc);
        dlt = findViewById(R.id.dlt);


        Bundle bundle = getIntent().getExtras();

        final String id1 = bundle.getString("did");
        String sub1 = bundle.getString("dsub");
        String desc1 = bundle.getString("ddesc");
        String date1 = bundle.getString("ddate");
        String dcounter = bundle.getString("dcounter");

        desc.setText(desc1);
        counter.setText(dcounter);


        DbHelper mdbHelper = new DbHelper(this);
       final SQLiteDatabase db = mdbHelper.getWritableDatabase();

        String SQL_UPDATE_COUNTER = "UPDATE POST SET pcounter = pcounter+1 WHERE pid = "+id1;
        db.execSQL(SQL_UPDATE_COUNTER);



        Toast.makeText(this, "Record updated", Toast.LENGTH_LONG).show();


        sub.setText(sub1);
        date.setText(date1);
        counter.setText(dcounter);


        dlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String SQL_DELETE_POST ="DELETE FROM POST WHERE pid = "+id1;
                    db.execSQL(SQL_DELETE_POST);
                    Intent intent = new Intent(FullPostActivity.this, ListViewActivity.class);
                       startActivity(intent);
                       finish();//to go back from this activity//original format
                            }
        });

        }
    }
