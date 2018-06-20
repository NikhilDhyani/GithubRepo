package com.example.nikhil.githubrepo.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nikhil.githubrepo.Data.Response;
import com.example.nikhil.githubrepo.Datas.Responsess;
import com.example.nikhil.githubrepo.R;

import java.util.List;

/**
 * Created by NIKHIL on 21-06-2018.
 */

public class GithubRepoAdapter extends RecyclerView.Adapter<GithubRepoAdapter.GithubViewHolder> {

    Context mcontext;
    List<Responsess> repos;

    public GithubRepoAdapter(Context mcontext, List<Responsess> repos) {
        this.mcontext = mcontext;
        this.repos = repos;
    }

    @Override
    public GithubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mcontext);
        View view = inflater.inflate(R.layout.card_view,null,false);

        return new GithubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GithubViewHolder holder, int position) {


        Responsess response = repos.get(position);
        holder.textView.setText(response.getName());
        holder.num.setText(String.valueOf(position+1));

    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    public class GithubViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView,num;

        public GithubViewHolder(View itemView) {
            super(itemView);

            num = itemView.findViewById(R.id.c_tv_numb);
            textView = itemView.findViewById(R.id.c_tv);
        }
    }
}
