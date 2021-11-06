package com.example.finalminorproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Asian extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass> userList;
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asian);

        initData();
        initRecyclerView();

    }

    private void initData() {

        userList = new ArrayList<>();
        userList.add(new ModelClass("https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/images%2FAsian%2Fparasite.jpg?alt=media&token=24ac9341-a1d0-4bd2-aaff-496363515403","Parasite","https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/videos%2Fkids%2Ffrozen2video.mp4?alt=media&token=0675c75f-9320-4dc0-a7eb-a817a75e3939"));
        userList.add(new ModelClass("https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/images%2FAsian%2Fredcliff.jpg?alt=media&token=84d9ad2c-f4d1-4963-af3c-af2e2679036d","Red Cliff","https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/videos%2Fkids%2Fharrypottervidep.mp4?alt=media&token=9db5b586-8bde-40e5-84fe-4ccab0b253ad"));
        userList.add(new ModelClass("https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/images%2FAsian%2Ftraintobusan.jpg?alt=media&token=0524e497-40db-43da-8c94-377161e708c1","Train to Busan","https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/videos%2Fkids%2Finsideoutvideo.mp4?alt=media&token=064d5add-1989-46c5-a139-fe0b7ba11161"));
        userList.add(new ModelClass("https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/images%2FAsian%2Fisawthedevil.jpg?alt=media&token=76916043-0486-45d2-8952-a71e44fe0776","I Saw the Devil","https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/videos%2Fkids%2Frayavideo.mp4?alt=media&token=d2afaf79-2605-4f15-957d-9d0cebe7fb6e"));
    }

    private void initRecyclerView() {
        recyclerView=findViewById(R.id.recyclerview);
        layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new Adapter(userList,this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item= menu.findItem(R.id.action_search);
        SearchView searchView= (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);

    }
}