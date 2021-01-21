package com.example.studentlocator.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentlocator.model.MyListData;
import com.example.studentlocator.R;
import com.example.studentlocator.views.Students;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
private  MyListData[] listData;
//RecyclerView
    public MyListAdapter(MyListData[] listData){
        this.listData=listData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        final View listItem=layoutInflater.inflate(R.layout.list_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final String s1= String.valueOf(holder.textView.getText());
      final MyListData myListData=listData[position];
      holder.textView.setText(listData[position].getDescription());
      holder.deschobby.setText("Check your colleagues who are good in "+ listData[position].getDescription());
      holder.imageView.setImageResource(listData[position].getImgId());
      holder.detailsButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              final Intent intent=new Intent(v.getContext(), Students.class);
              intent.putExtra("hobby",listData[position].getDescription());
              intent.putExtra("imageId",listData[position].getImgId());
              holder.context.startActivity(intent);
          }
      });
      holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Toast.makeText(v.getContext(),"clicked on item"+myListData.getDescription(),Toast.LENGTH_LONG).show();

          }
      });
    }

    @Override
    public int getItemCount() {
        return listData.length;
    }
    public static  class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;
        public TextView deschobby;
        public Button detailsButton;
        public LinearLayout relativeLayout;
        private final Context context;
        public ViewHolder(View itemView){
            super(itemView);
            context=itemView.getContext();
            this.imageView=itemView.findViewById(R.id.imageView);
            this.textView=itemView.findViewById(R.id.textView);
            this.deschobby=itemView.findViewById(R.id.hobbyDetails);
            relativeLayout=itemView.findViewById(R.id.relativeLayout);
            detailsButton=itemView.findViewById(R.id.check_students);
        }
    }
}
