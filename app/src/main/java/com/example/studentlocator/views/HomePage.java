package com.example.studentlocator.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.studentlocator.R;
import com.example.studentlocator.adapters.MyListAdapter;
import com.example.studentlocator.model.MyListData;

public class HomePage extends AppCompatActivity {
RecyclerView recyclerView;
private Toolbar mtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        mtoolbar=findViewById(R.id.main_toolbar);
        setSupportActionBar(mtoolbar);
        MyListData[] myListData=new  MyListData[]{
                new MyListData("Dancing",R.drawable.dancing),
                new MyListData("Football",R.drawable.footbal),
                new MyListData("Programming",R.drawable.programming),
                new MyListData("Swimming",R.drawable.swimming),
                new MyListData("singing",R.drawable.singers),
                new MyListData("Drawing",R.drawable.drawings),
                new MyListData("Skating",R.drawable.skating)
        };
        recyclerView=findViewById(R.id.recyclerView);
        MyListAdapter adapter=new MyListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                Toast.makeText(this,"You are about to close this app",Toast.LENGTH_LONG).show();
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);


        }
    }
}
