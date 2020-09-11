package com.example.gadsleaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SkillRecylerAdapter extends RecyclerView.Adapter<SkillRecylerAdapter.ViewHolder> {

    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    private int currentPosition;
    private ArrayList<SkillIQ> skillArrayList;

    public SkillRecylerAdapter(Context context, ArrayList<SkillIQ> data) {
        mContext = context;
        this.skillArrayList = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.list_item_skill, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        currentPosition = position;
        holder.name.setText(skillArrayList.get(position).getName());
        String mSubtitle = skillArrayList.get(position).getScore()+ " skillIQ score, " +
                skillArrayList.get(position).getCountry();
        holder.subtitle.setText(mSubtitle);
    }

    @Override
    public int getItemCount() {
        return skillArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView subtitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_title_skill);
            subtitle = itemView.findViewById(R.id.subtitle_skill);
        }
    }
}
