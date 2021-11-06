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

public class Bollywood extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass> userList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bollywood);

        initData();
        initRecyclerView();

    }

    private void initData() {

        userList = new ArrayList<>();
        userList.add(new ModelClass("https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/images%2FBollywood%2Fshershaah.jpg?alt=media&token=b5264eda-4fc6-4fd8-9134-43eea8e88c57","Shershaah","https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/videos%2Fkids%2Ffrozen2video.mp4?alt=media&token=0675c75f-9320-4dc0-a7eb-a817a75e3939"));
        userList.add(new ModelClass("https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/images%2FBollywood%2Fsanju.jpeg?alt=media&token=e4912a28-57e5-4971-a378-b0b047820993","Sanju","https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/videos%2Fkids%2Fharrypottervidep.mp4?alt=media&token=9db5b586-8bde-40e5-84fe-4ccab0b253ad"));
        userList.add(new ModelClass("https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/images%2FBollywood%2Fqueen.jpg?alt=media&token=5a1f8a9d-949f-4815-8e09-05bf9bb66a9d","Queen","https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/videos%2Fkids%2Finsideoutvideo.mp4?alt=media&token=064d5add-1989-46c5-a139-fe0b7ba11161"));
        userList.add(new ModelClass("https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/images%2FBollywood%2Fwar.jpg?alt=media&token=8d02216f-e0bd-4391-a24d-c2ed222d2b42","War","https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/videos%2Fkids%2Frayavideo.mp4?alt=media&token=d2afaf79-2605-4f15-957d-9d0cebe7fb6e"));
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