package com.example.gadsleaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PerformanceRecyclerAdapter extends RecyclerView.Adapter<PerformanceRecyclerAdapter.ViewHolder> {

    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    private int currentPosition;
    private List<String> mData;
    private ArrayList<Leader> leaderArrayList;

    public PerformanceRecyclerAdapter(Context context, ArrayList<Leader> data) {
        mContext = context;
        this.leaderArrayList = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.list_item_leader, parent, false);
        //Toast.makeText(mContext,"here.....", Toast.LENGTH_LONG).show();
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        currentPosition = position;
        holder.name.setText(leaderArrayList.get(position).getName());
        String mSubtitle = leaderArrayList.get(position).getHours()+ " learning hours, " +
                leaderArrayList.get(position).getCountry();
        holder.subtitle.setText(mSubtitle);

    }

    @Override
    public int getItemCount() {
        return leaderArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView subtitle;
        private final TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_title);
            subtitle = itemView.findViewById(R.id.subtitle);
        }
    }
}
