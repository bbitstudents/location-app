package com.example.studentlocator.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.studentlocator.R;
import com.example.studentlocator.controller.SQLiteHelper;

public class next extends AppCompatActivity { EditText hostel,roomNo,hobby,password,cpassword;
Button submit;
private String firstName;
private  String lastName;
private  String regNo;
private String school;
private  String department;
private  String course;
public  static SQLiteHelper sqLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        submit=findViewById(R.id.submit);
        hostel=findViewById(R.id.hostel);
        roomNo=findViewById(R.id.roomNo);
        hobby=findViewById(R.id.hobby);
        password=findViewById(R.id.password);
        cpassword=findViewById(R.id.password);
//        creating the database object using sqliteHelper class
        sqLiteHelper=new SQLiteHelper(getApplicationContext(),"studentDB.sqlite",null,1);
        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS student (firstName VARCHAR,lastName VARCHAR,regNo VARCHAR,school VARCHAR,department VARCHAR,course VARCHAR,hostel VARCHAR,roomNo VARCHAR,hobby VARCHAR,password VARCHAR)");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                function for receiving values sent from the previous page via the intents
                receivedIntents();
                String s1=hostel.getText().toString();
                String s2=roomNo.getText().toString();
                String s3=hobby.getText().toString();
                String s4=password.getText().toString();
                String s5=cpassword.getText().toString();
                if (s4 !="" || s5 != "" || s4==s5){
                    try {
                        sqLiteHelper.insertStudent(firstName.trim(),lastName.trim(),regNo.trim(),department.trim(),school.trim(),course.trim(),s1.trim(),s2.trim(),s3.trim(),s4.trim());
                        Toast.makeText(next.this,"Student details submitted successfully",Toast.LENGTH_LONG).show();
                    }
                    catch (Exception e){
                        Toast.makeText(next.this,"Error occured while inserting students details into thne database",Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(next.this,"the two passwords does't math please retry",Toast.LENGTH_LONG).show();
                }
//                inserting data received from the intents into the data base and somme from this page
            }
        });
    }


    private void receivedIntents() {
        Intent receivedIntent=getIntent();
        firstName=receivedIntent.getStringExtra("firstName");
        lastName=receivedIntent.getStringExtra("lastName");
        regNo=receivedIntent.getStringExtra("regNo");
        school=receivedIntent.getStringExtra("school");
        department=receivedIntent.getStringExtra("department");
        course=receivedIntent.getStringExtra("course");
    }
}
