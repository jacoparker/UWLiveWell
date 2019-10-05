package com.example.uwlivewell;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UWLAdapter extends RecyclerView.Adapter<UWLAdapter.MyViewHolder> {
    private ArrayList<ViewModel> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View view;
        public MyViewHolder(View v) {
            super(v);
            this.view = v;
        }

        public void bindData(ViewModel viewModel) {
            // TODO
            System.out.println("Not Implemented");
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public UWLAdapter(ArrayList<ViewModel> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public UWLAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindData(mDataset.get(position));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
