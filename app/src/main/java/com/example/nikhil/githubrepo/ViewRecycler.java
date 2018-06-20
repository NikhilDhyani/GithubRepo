package com.example.nikhil.githubrepo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nikhil.githubrepo.APIs.GithubClient;
import com.example.nikhil.githubrepo.Adapters.GithubRepoAdapter;
import com.example.nikhil.githubrepo.Datas.Responsess;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by NIKHIL on 21-06-2018.
 */

public class ViewRecycler extends Activity {

    String name;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        recyclerView = findViewById(R.id.rv_id);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Intent intent = getIntent();

         name = intent.getExtras().getString("Name");

        if (name!= null) {
            //recyclerView.setAdapter(getApplicationContext(),userr);
            loadJson();
        }

    }

    private void loadJson() {

        //todo 5: Retrofit instance

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GithubClient.base_url)
                .addConverterFactory(GsonConverterFactory.create()).build();

        //todo 6: API

        GithubClient api = retrofit.create(GithubClient.class);

        //todo  7: Call method

        //  String name  = mtv.getText().toString();

        Call<List<Responsess>> call = api.reposForUder(name);

        //todo 8 : Calling our api

        call.enqueue(new Callback<List<Responsess>>() {
            @Override
            public void onResponse(Call<List<Responsess>> call, Response<List<Responsess>> response) {

                //todo 9: This is our userr object

                List<Responsess> userr = response.body();


                //   recyclerView.setAdapter(new GithubRepoAdapter(getApplicationContext(),userr));

                GithubRepoAdapter adapter = new GithubRepoAdapter(getApplicationContext(), userr);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Responsess>> call, Throwable t) {

            }
        });

    }
}
