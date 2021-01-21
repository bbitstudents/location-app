package com.example.studentlocator.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.studentlocator.R;

public class Signup extends AppCompatActivity {
Button nextPage;
EditText firstName,lastName,regNo,school,department,course;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nextPage=findViewById(R.id.next);
        firstName=findViewById(R.id.firstName);
        lastName=findViewById(R.id.laststName);
        regNo=findViewById(R.id.registrationNumber);
        school=findViewById(R.id.Schools);
        department=findViewById(R.id.departments);
        course=findViewById(R.id.courses);
        nextPages();
    }

    private void nextPages() {
//        gettinkg text from the textfields
        String s1=firstName.getText().toString();
        String s2=lastName.getText().toString();
        String s3=regNo.getText().toString();
        String s4=school.getText().toString();
        String s5=department.getText().toString();
        String s6=course.getText().toString();
//        function to pass data above to the next page
        Intent intent=new Intent(Signup.this,next.class);
        intent.putExtra("firstName",s1);
        intent.putExtra("lastName",s2);
        intent.putExtra("regNo",s3);
        intent.putExtra("school",s4);
        intent.putExtra("department",s5);
        intent.putExtra("course",s6);
        startActivity(intent);
    }
}
