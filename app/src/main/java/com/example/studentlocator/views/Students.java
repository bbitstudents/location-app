package com.example.studentlocator.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studentlocator.R;
import com.example.studentlocator.controller.SQLiteHelper;
import com.example.studentlocator.adapters.CustomListView;

import java.util.ArrayList;

public class Students extends AppCompatActivity {
    TextView Description;
    ImageView images;
ListView lst;
ArrayList<String> name;
ArrayList<String> regNo;
ArrayList<String> hostel;
ArrayList<String> roomNo;
//ArrayList<String> rank;
SQLiteHelper db;
private String hobby;
private Integer imageId;
//private BottomAppBar bottomAppBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);
        lst=findViewById(R.id.lisView);
        Description=findViewById(R.id.hobyDescriptions);
        images=findViewById(R.id.hobbyImage);
//        bottomAppBar=findViewById(R.id.bottom_app_bar);
        db=new SQLiteHelper(getApplicationContext(),"studentDB.sqlite",null,1);
        name=new ArrayList<>();
        regNo=new ArrayList<>();
        hostel=new ArrayList<>();
        roomNo=new ArrayList<>();
//        rank=new ArrayList<>();
        Intent receivedIntent=getIntent();
        hobby=receivedIntent.getStringExtra("hobby");
        imageId=receivedIntent.getIntExtra("imageId",0);
        images.setImageResource(imageId);
        Description.setText("The following are students good in " + hobby );
//        calling method to display student details
  viewStudentDetails();
//  setSupportActionBar(bottomAppBar);
  lstOnclick();
    }

    private void lstOnclick() {
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                long viewId=view.getId();

            }
        });
    }

    private void viewStudentDetails() {
        Cursor cursor=db.AllStudents(hobby);
        if (cursor.getCount() == 0){
            Toast.makeText(Students.this,"Currently there is no student in this hobby you have selected",Toast.LENGTH_LONG).show();
        }
        else {
            while (cursor.moveToNext()){
                name.add(cursor.getString(0)+"\t"+cursor.getString(1));
                regNo.add(cursor.getString(2));
                hostel.add(cursor.getString(6));
                roomNo.add(cursor.getString(7));
//                rank.add(cursor.getString(7));
            }
            CustomListView customListView=new CustomListView(Students.this,name,regNo,hostel,roomNo);
            lst.setAdapter(customListView);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

}
