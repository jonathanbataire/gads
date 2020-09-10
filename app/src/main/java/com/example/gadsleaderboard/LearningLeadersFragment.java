package com.example.gadsleaderboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LearningLeadersFragment extends Fragment {

    private PerformanceRecyclerAdapter adapter;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.learning_leaders, container, false);;
        //Toast.makeText(view.getContext(),"hey.....", Toast.LENGTH_LONG).show();
        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        ArrayList<String> Names = new ArrayList<>();
        Names.add("Horse");
        Names.add("Cow");
        Names.add("meat");
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new PerformanceRecyclerAdapter(getActivity(), Names);
        recyclerView.setAdapter(adapter);
    }
}