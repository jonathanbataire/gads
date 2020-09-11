package com.example.gadsleaderboard;

import android.os.Bundle;
import android.util.Log;
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
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class LearningLeadersFragment extends Fragment {

    private PerformanceRecyclerAdapter adapter;
    public static final String BASE_URL = "https://gadsapi.herokuapp.com/";
    private ArrayList<Leader> data;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.learning_leaders, container, false);;
        //Toast.makeText(view.getContext(),"hey.....", Toast.LENGTH_LONG).show();
        return view;
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
                //Toast.makeText(view.getContext(),response.body().toString(), Toast.LENGTH_LONG).show();
                JsonArray jsonResponse = response.body();
                //assert jsonResponse != null;
                Gson gson = new Gson();

                Type userListType = new TypeToken<ArrayList<Leader>>(){}.getType();

                ArrayList<Leader> userArray = gson.fromJson(jsonResponse, userListType);
                //data = new ArrayList<>(Arrays.asList(userArray));

                RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                adapter = new PerformanceRecyclerAdapter(getActivity(), userArray);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Toast.makeText(view.getContext(),"nope"+ t, Toast.LENGTH_LONG).show();
            }
        });
    }

    public interface GetAPIService {
        @GET("/api/hours")
        Call<JsonArray> getContacts();
    }

}