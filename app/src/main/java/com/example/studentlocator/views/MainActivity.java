package com.example.studentlocator.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studentlocator.R;
import com.example.studentlocator.controller.SQLiteHelper;

public class MainActivity extends AppCompatActivity {
Button signUp,SignIn;
EditText registrationNumber,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signUp=findViewById(R.id.SignUp);
        SignIn=findViewById(R.id.login);
        registrationNumber=findViewById(R.id.registrationNumber);
        password=findViewById(R.id.passwords);
//        calling login process method
        login();
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });
    }

    private void login() {
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteHelper shp=new SQLiteHelper(getApplicationContext(),"studentDB.sqlite",null,1);
                SQLiteDatabase db=shp.getReadableDatabase();
                String[] cols={"regNo ","password"};
                String[] vals={registrationNumber.getText().toString(),password.getText().toString()};
                Cursor cursor=db.query("student",cols,"regNo=? AND password=?",vals,null,null,null);
                if (cursor !=null){
                    if (cursor.moveToFirst()){
                        Intent intent = new Intent(MainActivity.this, HomePage.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this,"Failed to login",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
