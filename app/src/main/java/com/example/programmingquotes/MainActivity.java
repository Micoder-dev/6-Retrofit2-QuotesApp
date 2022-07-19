package com.example.programmingquotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private List<ProgrammingQuote> mProgrammingQuotes = new ArrayList<>();
    private PQAdapter mPQAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.pqrv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mPQAdapter = new PQAdapter(this, mProgrammingQuotes);
        mRecyclerView.setAdapter(mPQAdapter);


        requestQuotes();

    }


    private void requestQuotes() {

        QuotesInterface quotesInterface = RetrofitServiceGenerator.createRetrofitService(QuotesInterface.class);

        Call<List<ProgrammingQuote>> call = quotesInterface.getQuotes();


        call.enqueue(new Callback<List<ProgrammingQuote>>() {
            @Override
            public void onResponse(Call<List<ProgrammingQuote>> call, Response<List<ProgrammingQuote>> response) {

                if (response.isSuccessful()) {

                    for (ProgrammingQuote quote : response.body()) {
                        mProgrammingQuotes.add(quote);
                    }
                    mPQAdapter.notifyDataSetChanged();
                } else {

                    Log.e(TAG, response.message());

                }
            }

            @Override
            public void onFailure(Call<List<ProgrammingQuote>> call, Throwable t) {
                Log.e(TAG, t.getMessage());

            }
        });

    }


}