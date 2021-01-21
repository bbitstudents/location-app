package com.example.studentlocator.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.studentlocator.views.Map;
import com.example.studentlocator.R;

import java.util.ArrayList;

public class CustomListView extends ArrayAdapter<String> {
    private String [] name;
    private String [] regNo;
    private String [] hostel;
    private String [] roomNo;
//    private String [] rank;
    private Activity context;

    public CustomListView(@NonNull Context context, ArrayList<String> name, ArrayList<String> regNo, ArrayList<String> hostel, ArrayList<String> roomNo) {
        super(context, R.layout.list_view_layout,name);
        this.name = name.toArray(new String[0]);
        this.regNo= regNo.toArray(new String[0]);
        this.hostel= hostel.toArray(new String[0]);
        this.roomNo= roomNo.toArray(new String[0]);
//        this.rank=rank.toArray(new String[0]);
        this.context = (Activity) context;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r= convertView;
        ViewHolder viewHolder=null;
        if (r==null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.list_view_layout,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) r.getTag();
        }
        viewHolder.studentName.setText("name:\t"+name[position]);
        viewHolder.registrationNumber.setText("Reg No:\t"+regNo[position]);
        viewHolder.hostel.setText("Hostel:\t"+hostel[position]);
        viewHolder.roomNo.setText("Room No:\t"+roomNo[position]);
//        viewHolder.rank.setText("Rank:\t"+rank[position]);
        final ViewHolder finalViewHolder = viewHolder;
        viewHolder.locateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Map.class);
                intent.putExtra("student",name[position]);
                intent.putExtra("hostelName",hostel[position]);
                finalViewHolder.context.startActivity(intent);
            }
        });
//        setting on click listener for select button in listview
//        viewHolder.selectB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ((ListView) parent).performItemClick(v,position,0);
//                Object y=((ListView) parent).getItemAtPosition(position);
//                Toast.makeText(getContext(),"selected\n"+y.toString(),Toast.LENGTH_LONG).show();
//            }
//        });
        return r;
    }
    class ViewHolder{
        TextView studentName;
        TextView registrationNumber;
        TextView hostel;
        TextView roomNo;
        TextView rank;
        Button locateButton;
        private final Context context;
        public ViewHolder(View views){
            context=views.getContext();
            studentName=views.findViewById(R.id.studentName);
            registrationNumber=views.findViewById(R.id.studentReg);
            hostel=views.findViewById(R.id.hostel);
            roomNo=views.findViewById(R.id.room);
            rank=views.findViewById(R.id.Rank);
            locateButton=views.findViewById(R.id.locate);
        }

    }
}
