package com.example.nikhil.githubrepo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nikhil.githubrepo.APIs.GithubClient;
import com.example.nikhil.githubrepo.Adapters.GithubRepoAdapter;
import com.example.nikhil.githubrepo.Datas.Responsess;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView mtv;
    Button mbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbtn = findViewById(R.id.main_btn);
        mtv = findViewById(R.id.main_tv);



        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendIntent();

            }
        });


    }

    private void sendIntent() {

        Intent intent = new Intent(this,ViewRecycler.class);
        String name = mtv.getText().toString();
        if (name != null) {
            intent.putExtra("Name", name);
            startActivity(intent);

        }
        else
            {
                Toast.makeText(getApplicationContext(),"Please enter name",Toast.LENGTH_LONG).show();
            }
        }

    /*

    private void initViews() {

        recyclerView = findViewById(R.id.rv_id);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        //recyclerView.setAdapter(getApplicationContext(),userr);
        loadJson();
    }

    private void loadJson() {

        //todo 5: Retrofit instance

        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(GithubClient.base_url)
                .addConverterFactory(GsonConverterFactory.create()).build();

        //todo 6: API

        GithubClient api = retrofit.create(GithubClient.class);

        //todo  7: Call method

        String name  = mtv.getText().toString();

        Call<List<Responsess>> call = api.reposForUder(name);

        //todo 8 : Calling our api

        call.enqueue(new Callback<List<Responsess>>() {
            @Override
            public void onResponse(Call<List<Responsess>> call, Response<List<Responsess>> response) {

                //todo 9: This is our userr object

                List<Responsess> userr  = response.body();


             //   recyclerView.setAdapter(new GithubRepoAdapter(getApplicationContext(),userr));

                GithubRepoAdapter adapter = new GithubRepoAdapter(getApplicationContext(),userr);
                 recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Responsess>> call, Throwable t) {

            }
        });

    }
    */
}
