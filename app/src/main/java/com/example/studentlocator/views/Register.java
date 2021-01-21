package com.example.studentlocator.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.studentlocator.R;
import com.google.android.material.textfield.TextInputLayout;

public class Register extends AppCompatActivity {
    private TextInputLayout textInputLayout;
    private AutoCompleteTextView dropdowntext,departmentDropdown;
//    Button uploadButton;
Button nextPage;
    EditText firstName,lastName,regNo,school,department,course;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        textInputLayout=findViewById(R.id.text_input_layout);
        dropdowntext=findViewById(R.id.Schools);
        departmentDropdown=findViewById(R.id.departments);
        nextPage=findViewById(R.id.next);
        firstName=findViewById(R.id.firstName);
        lastName=findViewById(R.id.laststName);
        regNo=findViewById(R.id.RegNo);
        school=findViewById(R.id.Schools);
        department=findViewById(R.id.departments);
//        upload button
//        uploadButton=findViewById(R.id.uploadButton);
//        uploadButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
//                intent.setType("image/jpeg");
//                intent.putExtra(Intent.EXTRA_LOCAL_ONLY,true);
//                startActivityForResult(Intent.createChooser(intent,
//                        "insert picture"),42);
//            }
//        });
//calling method for displaying dropdown items for textfields with dropdown items
        displayDropdownItems();
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Register.this,SecondRegister.class);
                intent.putExtra("firstName",firstName.getText().toString());
                intent.putExtra("lastName",lastName.getText().toString());
                intent.putExtra("regNo",regNo.getText().toString());
                intent.putExtra("school",school.getText().toString());
                intent.putExtra("department",department.getText().toString());
                startActivity(intent);
            }
        });
    }
//method to display dropdown
    private void displayDropdownItems() {
        //        drop down items
        String [] schools=new String[]{
                "School of Business, Economics & Social Sciences",
                "School of Mines & Engineering",
                "School of Science & Informatics",
                "School of Agricultural, Earth & Environmental Sciences"
        };
        ArrayAdapter<String> adapter=new ArrayAdapter<>(Register.this,R.layout.dropdown_item,schools);
        dropdowntext.setAdapter(adapter);
        //        drop down items for departments
        String [] department=new String[]{
                "Mining & Minerals Processing Engineering",
                "Mathematics, Statistics and Physical Sciences",
                "Informatics and Computing ",
                "Education",
                "Horticulture",
                "Economics, Entrepreneurship and Social Sciences",
                "Business and Management Sciences"
        };
        ArrayAdapter<String> deparment_adapter=new ArrayAdapter<>(Register.this,
                R.layout.dropdown_item,department);
        departmentDropdown.setAdapter(deparment_adapter);
    }
}
