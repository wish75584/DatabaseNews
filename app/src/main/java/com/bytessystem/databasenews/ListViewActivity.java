package com.bytessystem.databasenews;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ListViewActivity extends AppCompatActivity {


    ListView lv;

    ArrayList<Post> postlist;

    ArrayAdapter<Post> adp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lv = findViewById(R.id.lv);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override//here i is a position of item
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {

                Intent intent = new Intent(ListViewActivity.this, FullPostActivity.class);
                Post p = postlist.get(i);
                intent.putExtra("did", p.getId());
                intent.putExtra("dsub", p.getSub());
                intent.putExtra("ddesc", p.getDesc());
                intent.putExtra("ddate", p.getDate());
                intent.putExtra("dcounter", p.getCounter());
                startActivity(intent);
            }
        });
    }

    //this method is for whenever we go back it will refresh the activity or database
    @Override
    protected void onPostResume() {
        super.onPostResume();

        //fetching data through database select query
        DbHelper mdbHelper = new DbHelper(this);

        SQLiteDatabase db = mdbHelper.getReadableDatabase();

        String[] cols = {"pid", "psub", "pdesc", "pdate", "pcounter"};

        Cursor cursor = db.query("POST", cols, "", null, "", "", "");
        postlist = new ArrayList<Post>();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("pid"));
            String sub = cursor.getString(cursor.getColumnIndexOrThrow("psub"));
            String desc = cursor.getString(cursor.getColumnIndexOrThrow("pdesc"));
            String date = cursor.getString(cursor.getColumnIndexOrThrow("pdate"));
            int counter = cursor.getInt(cursor.getColumnIndexOrThrow("pcounter"));

            Post p1 = new Post("" + id, "" + sub, "" + desc, "" + date, "" + counter);

            postlist.add(p1);

        }
        cursor.close();
        adp = new PostAdapter(this, postlist);
        lv.setAdapter(adp);

    }
}
