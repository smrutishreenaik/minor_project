package com.example.finalminorproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> implements Filterable {

    private List<ModelClass> userList;
    private Context context;
    ArrayList<ModelClass> backup;


    public Adapter(List<ModelClass> userList, Context context){

        this.userList=userList;
        this.context=context;
        this.backup=new ArrayList<>(userList);

    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        String resource=userList.get(position).getImageview1();
        String bigtitle=userList.get(position).getTitle();
        String vurls=userList.get(position).getVurl();


        holder.setData(resource,bigtitle,vurls);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context.getApplicationContext(),VidPlayer.class);
                intent.putExtra("vidurl",userList.get(position).getVurl());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.getApplicationContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();

    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence keyword) {

            ArrayList<ModelClass> filtereddata=new ArrayList<>();

            if (keyword.toString().isEmpty()){
                filtereddata.addAll(backup);
            }else {
                for (ModelClass obj: backup){
                    if (obj.getTitle().toLowerCase().contains(keyword.toString().toLowerCase())){
                        filtereddata.add(obj);
                    }
                }
            }

            FilterResults results= new FilterResults();
            results.values=filtereddata;
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {

            userList.clear();
            userList.addAll((ArrayList<ModelClass>)results.values);
            notifyDataSetChanged();

        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder {


        private ImageView imageView;
        private TextView textView;
        RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageview1);
            textView=itemView.findViewById(R.id.title);
            relativeLayout=itemView.findViewById(R.id.relative_layout);

        }

        public void setData(String resource, String bigtitle,String vurls) {


            Picasso.get().load(resource).into(imageView);
            textView.setText(bigtitle);



        }
    }


}
