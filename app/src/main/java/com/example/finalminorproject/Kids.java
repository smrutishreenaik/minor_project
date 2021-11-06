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

public class Kids extends AppCompatActivity {


    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass> userList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids);

        initData();
        initRecyclerView();

    }

    private void initData() {

        userList = new ArrayList<>();
        userList.add(new ModelClass("https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/images%2Fkids%2Fraya.jpg?alt=media&token=f426e9d9-973d-4ef3-ad8f-44ef3b160325","Raya and the Last Dragon","https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/videos%2Fkids%2Frayavideo.mp4?alt=media&token=d2afaf79-2605-4f15-957d-9d0cebe7fb6e"));
        userList.add(new ModelClass("https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/images%2Fkids%2Ffrozen2.jpg?alt=media&token=b0f610ae-0be4-4947-8134-8e0501e1f0af","Frozen 2","https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/videos%2Fkids%2Ffrozen2video.mp4?alt=media&token=0675c75f-9320-4dc0-a7eb-a817a75e3939"));
        userList.add(new ModelClass("https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/images%2Fkids%2Finsideout.jfif?alt=media&token=e4cb17c7-236e-442f-8175-f8c93c9eb10c","Inside Out","https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/videos%2Fkids%2Finsideoutvideo.mp4?alt=media&token=064d5add-1989-46c5-a139-fe0b7ba11161"));
        userList.add(new ModelClass("https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/images%2Fkids%2Fharrypotter.jpg?alt=media&token=e608c697-6254-4a48-ac57-cf28c2e231b6","Harry Potter and the Philosopher's Stone","https://firebasestorage.googleapis.com/v0/b/finalstreamingapp.appspot.com/o/videos%2Fkids%2Fharrypottervidep.mp4?alt=media&token=9db5b586-8bde-40e5-84fe-4ccab0b253ad"));
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