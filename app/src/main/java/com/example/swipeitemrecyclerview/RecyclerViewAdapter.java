package com.example.swipeitemrecyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.swipe.SimpleSwipeListener;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;


import java.util.List;

public class RecyclerViewAdapter extends RecyclerSwipeAdapter<RecyclerViewAdapter.SimpleViewHolder> {

    private Context mContext;
    private List<MyModel> modelList;

    public RecyclerViewAdapter( Context mContext, List<MyModel> modelList ) {
        this.mContext=mContext;
        this.modelList=modelList;
    }


    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        SwipeLayout swipeLayout;
        TextView textViewPos;
        TextView textViewData;
        ImageView imageLike;

        public SimpleViewHolder(View itemView) {
            super(itemView);
            swipeLayout = itemView.findViewById(R.id.swipe);
            textViewPos = itemView.findViewById(R.id.position);
            textViewData = itemView.findViewById(R.id.text_data);
            imageLike = itemView.findViewById ( R.id.trash );
        }
    }


    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SimpleViewHolder viewHolder, final int position) {
        MyModel myModel = modelList.get ( position );
        viewHolder.swipeLayout.setShowMode ( SwipeLayout.ShowMode.PullOut );
        viewHolder.swipeLayout.addDrag ( SwipeLayout.DragEdge.Right, viewHolder.swipeLayout.findViewById ( R.id.go ) );
        viewHolder.swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener () {
            @Override
            public void onStartOpen( SwipeLayout layout ) {

            }

            @Override
            public void onOpen(SwipeLayout layout) {
                viewHolder.imageLike.setImageResource ( R.drawable.ic_like );
            }

            @Override
            public void onStartClose( SwipeLayout layout ) {
                viewHolder.imageLike.setImageResource ( R.drawable.ic_unlike );
            }

            @Override
            public void onClose( SwipeLayout layout ) {

            }

            @Override
            public void onUpdate( SwipeLayout layout, int leftOffset, int topOffset ) {

            }

            @Override
            public void onHandRelease( SwipeLayout layout, float xvel, float yvel ) {

            }
        });

        viewHolder.textViewPos.setText((position + 1) + ".");
        viewHolder.textViewData.setText(myModel.name);
        mItemManger.bindView (viewHolder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }
}
