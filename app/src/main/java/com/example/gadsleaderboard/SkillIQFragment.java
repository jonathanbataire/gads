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

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class SkillIQFragment extends Fragment {

    private SkillRecylerAdapter adapter;
    public static final String BASE_URL = "https://gadsapi.herokuapp.com/";
    private ArrayList<Leader> data;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.skill_iq, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        getData(view);
    }

    public void getData (final View view){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetAPIService service = retrofit.create(GetAPIService.class);
        Call<JsonArray> jsonCall = service.getContacts();
        jsonCall.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                JsonArray jsonResponse = response.body();
                Gson gson = new Gson();

                Type userListType = new TypeToken<ArrayList<SkillIQ>>(){}.getType();

                ArrayList<SkillIQ> userArray = gson.fromJson(jsonResponse, userListType);

                RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                adapter = new SkillRecylerAdapter(getActivity(), userArray);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Toast.makeText(view.getContext(),"nope"+ t, Toast.LENGTH_LONG).show();
            }
        });
    }

    public interface GetAPIService {
        @GET("/api/skilliq")
        Call<JsonArray> getContacts();
    }
}