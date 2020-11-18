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


    private ImageView imageLike;
    private SwipeLayout ornek1;
    private RecyclerView recyclerView;
    private List<MyModel> modelList;
    private RecyclerViewAdapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        ornek1 = findViewById ( R.id.ornek1 );
        imageLike = findViewById ( R.id.imageLike );

        modelList = new ArrayList<> ();
        modelList.add ( new MyModel ( "Hello", R.drawable.ic_launcher_background ) );
        modelList.add ( new MyModel ( "Hello", R.drawable.ic_launcher_background ) );
        modelList.add ( new MyModel ( "Hello", R.drawable.ic_launcher_background ) );
        modelList.add ( new MyModel ( "Hello", R.drawable.ic_launcher_background ) );

        recyclerView = findViewById ( R.id.recyclerView );
        myAdapter = new RecyclerViewAdapter ( this, modelList, imageLike );
        layoutManager = new LinearLayoutManager ( this );
        recyclerView.setLayoutManager ( layoutManager );
        recyclerView.setHasFixedSize ( true );
        recyclerView.setAdapter ( myAdapter );





//        ornek1.setShowMode ( SwipeLayout.ShowMode.PullOut );
//        ornek1.addDrag ( SwipeLayout.DragEdge.Right, ornek1.findViewById ( R.id.linear_sag ) );

//        ornek1.addSwipeListener ( new SwipeLayout.SwipeListener () {
//            @Override
//            public void onStartOpen( SwipeLayout layout ) {
//
//
//            }
//
//            @Override
//            public void onOpen( SwipeLayout layout ) {
//                imageLike.setImageResource ( R.drawable.ic_like );
//            }
//
//            @Override
//            public void onStartClose( SwipeLayout layout ) {
//
//            }
//
//            @Override
//            public void onClose( SwipeLayout layout ) {
//                imageLike.setImageResource ( R.drawable.ic_unlike );
//            }
//
//            @Override
//            public void onUpdate( SwipeLayout layout, int leftOffset, int topOffset ) {
//
//            }
//
//            @Override
//            public void onHandRelease( SwipeLayout layout, float xvel, float yvel ) {
//
//            }
//        } );

//        ornek1.findViewById ( R.id.star ).setOnClickListener ( new View.OnClickListener () {
//            @Override
//            public void onClick( View v ) {
//                Toast.makeText ( MainActivity.this, "Star", Toast.LENGTH_SHORT ).show ();
//            }
//        } );

    }
}