package com.example.finalminorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{


    private ListView listView;
    private String[] names ={"Hollywood","Bollywood", "Kids", "Asian"};
    private int [] images = {R.drawable.hollywoodimage, R.drawable.bollywoodimage, R.drawable.kidsimage, R.drawable.asianimage };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);

        Myadapter myadapter= new Myadapter();
        listView.setAdapter(myadapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Intent intent=new Intent(view.getContext(),Hollywood.class);
                    startActivity(intent);
                }
                if(i==1){
                    Intent intent=new Intent(view.getContext(),Bollywood.class);
                    startActivity(intent);
                }
                if(i==2){
                    Intent intent=new Intent(view.getContext(),Kids.class);
                    startActivity(intent);
                }
                if(i==3){
                    Intent intent=new Intent(view.getContext(),Asian.class);
                    startActivity(intent);
                }
            }
        });

    }


    public class Myadapter extends BaseAdapter{

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view = getLayoutInflater().inflate(R.layout.frontcard , viewGroup, false );
            ImageView imageView=view.findViewById(R.id.imageview);
            TextView textView=view.findViewById(R.id.textview);

            textView.setText(names[i]);
            imageView.setImageResource(images[i]);


            return view;
        }

    }
}