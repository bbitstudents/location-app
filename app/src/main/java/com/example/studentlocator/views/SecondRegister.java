package com.example.studentlocator.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studentlocator.R;
import com.example.studentlocator.controller.SQLiteHelper;

public class SecondRegister extends AppCompatActivity {
String firstName;
String lastName;
String regNo;
String school;
String department;
EditText course,hostel,roomNumber,hobby,password,cpassword;
AutoCompleteTextView hosteldropdown,hobbyDropdown;
Button Submit;
public  static SQLiteHelper sqLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_register);
        hosteldropdown=findViewById(R.id.hostel);
        hobbyDropdown=findViewById(R.id.hobby);
        hostel=findViewById(R.id.hostel);
        roomNumber=findViewById(R.id.roomNo);
        hobby=findViewById(R.id.hobby);
        course=findViewById(R.id.courses);
        password=findViewById(R.id.password);
        cpassword=findViewById(R.id.rePassword);
        Submit=findViewById(R.id.submit);
        //        creating the database object using sqliteHelper class
        sqLiteHelper=new SQLiteHelper(getApplicationContext(),"studentDB.sqlite",null,1);
        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS student (firstName VARCHAR,lastName VARCHAR," +
                "regNo VARCHAR,school VARCHAR,department VARCHAR,course VARCHAR," +
                "hostel VARCHAR,roomNo VARCHAR,hobby VARCHAR,password VARCHAR)");
//        calling function to display dropdown menu for textfields with dropdown
        displayDropdownMenus();
//calling function for submitting users data
        submitData();

    }
//function to display dropdown menus
    private void displayDropdownMenus() {
        //        drop down items for departments
        String [] hostels=new String[]{
                "Mekatilili",
                "Mwangeka",
                "Runda",
                "BLOCK A",
                "BLOCK B",
                "BLOCK C",
                "BLOCK E",
                "BLOCK F"
        };
        ArrayAdapter<String> hostel_adapter=new ArrayAdapter<>(SecondRegister.this,
                R.layout.dropdown_item,hostels);
        hosteldropdown.setAdapter(hostel_adapter);
        //        drop down items for departments
        String [] hobbies=new String[]{
                "Dancing",
                "Football",
                "Programming",
                "Swimming",
                "singing",
                "Drawing",
                "Skating"
        };
        ArrayAdapter<String> hobbies_adapter=new ArrayAdapter<>(SecondRegister.this,
                R.layout.dropdown_item,hobbies);
        hobbyDropdown.setAdapter(hobbies_adapter);
    }

    //function to submit data
    private void submitData() {
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  calling function for receiving intents
                receivedIntents();
                String s1=course.getText().toString();
                String s2=hostel.getText().toString();
                String s3=roomNumber.getText().toString();
                String s4=hobby.getText().toString();
                String s5=password.getText().toString();
                String s6=cpassword.getText().toString();
                if (s4 !="" || s5 != "" || s5 == s6){
                    try {
                        sqLiteHelper.insertStudent(firstName.trim(),lastName.trim(),regNo.trim(),school.trim(),department.trim(),s1.trim(),s2.trim(),s3.trim(),s4.trim(),s5.trim());

                        Toast.makeText(SecondRegister.this,"Student details submitted successfully",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(SecondRegister.this, HomePage.class);
                        startActivity(intent);
                    }
                    catch (Exception e){
                        Toast.makeText(SecondRegister.this,"Error occured while inserting students details into thne database",Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(SecondRegister.this,"the two passwords does't math please retry",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
//method for receiving intents
    private void receivedIntents() {
        Intent receivedIntent=getIntent();
        firstName=receivedIntent.getStringExtra("firstName");
        lastName=receivedIntent.getStringExtra("lastName");
        regNo=receivedIntent.getStringExtra("regNo");
        school=receivedIntent.getStringExtra("school");
        department=receivedIntent.getStringExtra("department");
    }
}
