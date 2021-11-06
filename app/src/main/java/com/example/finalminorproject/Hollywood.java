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

public class Hollywood extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass> userList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hollywood);

        initData();
        initRecyclerView();

    }

    private void initData() {

        userList = new ArrayList<>();
        userList.add(new ModelClass("https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/images%2FHollywood%2Fstarwars.jpg?alt=media&token=b541f761-e37c-4eed-bfa9-60d1a8a18604","Star Wars","https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/videos%2FHollywood%2Fstarwarsvideo.mp4?alt=media&token=b3f159a8-3cd2-44cb-a49c-1cac934b38d3"));
        userList.add(new ModelClass("https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/images%2FHollywood%2Ftheoryofeverything.png?alt=media&token=1a230367-9a1f-47e5-b19e-fa74982fb522","Theory of Everything","https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/videos%2FHollywood%2Ftheoryofeverythingvideo.mp4?alt=media&token=5c073708-86fe-4517-85fc-908b4627b432"));
        userList.add(new ModelClass("https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/images%2FHollywood%2Fgladiator.jpg?alt=media&token=67aea5cb-8e7b-4945-86b1-bb2c35268d45","Gladiator","https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/videos%2FHollywood%2Fstarwarsvideo.mp4?alt=media&token=b3f159a8-3cd2-44cb-a49c-1cac934b38d3"));
        userList.add(new ModelClass("https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/images%2FHollywood%2Fthedarkknight.jpeg?alt=media&token=d35c755b-1f1b-478b-9e9d-cadffea22e90","The Dark Knight","https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/videos%2FHollywood%2Ftheoryofeverythingvideo.mp4?alt=media&token=5c073708-86fe-4517-85fc-908b4627b432"));



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
