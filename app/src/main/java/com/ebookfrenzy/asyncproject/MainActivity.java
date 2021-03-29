package com.ebookfrenzy.asyncproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Data names = new Data();
    RecyclerAdapter adapter;
    RecyclerView recyclerView;
    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.editText1);
        setRecycler();

    }

    private void setRecycler() {
        recyclerView = findViewById(R.id.recycler);
        adapter = new RecyclerAdapter(names.getList());
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    public void clearButton(View view) {
        adapter.clearList();

    }

    public void addButton(View view) {
        MyTask task1 = new MyTask();
        task1.execute(editText1.getText().toString());
    }


    class MyTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            editText1.setText("");
        }

        @Override
        protected String doInBackground(String... strings) {

            Random r = new Random();
            int num = r.nextInt(10);
            String s = " ";
            try {
                Thread.sleep(num * 1000);
                if (num > 1 || num == 0) {
                    s = "The name is " + strings[0] + ". The time it took was " + num + " seconds. ";
                } else {
                    s = "The name is " + strings[0] + ". The time it took was " + num + " second. ";
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return s;
        }

        @Override
        protected void onPostExecute(String s) {

            names.addName(s);
            adapter.notifyDataSetChanged();

        }

    }
}