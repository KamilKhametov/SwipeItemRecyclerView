package com.example.swipeitemrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.daimajia.swipe.SwipeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<MyModel> modelList;
    private RecyclerViewAdapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        modelList = new ArrayList<> ();
        modelList.add ( new MyModel ( "Hello", R.drawable.ic_launcher_background ) );
        modelList.add ( new MyModel ( "Hello", R.drawable.ic_launcher_background ) );
        modelList.add ( new MyModel ( "Hello", R.drawable.ic_launcher_background ) );
        modelList.add ( new MyModel ( "Hello", R.drawable.ic_launcher_background ) );

        recyclerView = findViewById ( R.id.recyclerView );
        myAdapter = new RecyclerViewAdapter ( this, modelList );
        layoutManager = new LinearLayoutManager ( this );
        recyclerView.setLayoutManager ( layoutManager );
        recyclerView.setHasFixedSize ( true );
        recyclerView.setAdapter ( myAdapter );
    }
}