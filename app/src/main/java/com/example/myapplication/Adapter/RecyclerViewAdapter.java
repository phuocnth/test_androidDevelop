package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DetailsActivity;
import com.example.myapplication.Model.Employee;
import com.example.myapplication.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private ArrayList<Employee> dataList;
    int layout;
    Context context;

    public RecyclerViewAdapter(ArrayList<Employee> dataList, int layout, Context context) {
        this.dataList = dataList;
        this.layout = layout;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(layout, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        holder.bindData();
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvName, tvAge;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
        }

        public void bindData() {
            tvId.setText("" + (dataList.get(getAdapterPosition()).getId()));
            tvName.setText(dataList.get(getAdapterPosition()).getName());
            tvAge.setText(dataList.get(getAdapterPosition()).getAge());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, DetailsActivity.class);
                    i.putExtra("name", dataList.get(getAdapterPosition()).getName());
                    i.putExtra("age", dataList.get(getAdapterPosition()).getAge());
                    i.putExtra("salary", dataList.get(getAdapterPosition()).getSalary());
                    i.putExtra("img", dataList.get(getAdapterPosition()).getImg());
                    context.startActivity(i);
                }
            });
        }
    }
}
