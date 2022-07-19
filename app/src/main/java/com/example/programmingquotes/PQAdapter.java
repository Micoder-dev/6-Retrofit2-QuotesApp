package com.example.programmingquotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PQAdapter extends RecyclerView.Adapter<PQViewHolder> {

    private Context mContext;
    private List<ProgrammingQuote> mProgrammingQuotes;


    public PQAdapter(Context context, List<ProgrammingQuote> programmingQuotes) {

        mContext = context;
        mProgrammingQuotes = programmingQuotes;

    }

    @NonNull
    @Override
    public PQViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.pq_item, parent, false);

        return new PQViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull PQViewHolder holder, int position) {

        ProgrammingQuote programmingQuote = mProgrammingQuotes.get(position);
        holder.getTxtPQ().setText(programmingQuote.getEn());
        holder.getTxtPQA().setText(programmingQuote.getAuthor());

    }

    @Override
    public int getItemCount() {
        return mProgrammingQuotes.size();
    }

}
