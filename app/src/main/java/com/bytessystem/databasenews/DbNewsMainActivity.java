package com.bytessystem.databasenews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DbNewsMainActivity extends AppCompatActivity {

    Button create,show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_news_main);
                create = findViewById(R.id.create);
                show = findViewById(R.id.show);

                create.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent (DbNewsMainActivity.this,CreatePostActivity.class);
                         startActivity(intent);
                    }
                });



                show.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(DbNewsMainActivity.this,ListViewActivity.class);
                        startActivity(intent);
                    }
                });

    }



}
