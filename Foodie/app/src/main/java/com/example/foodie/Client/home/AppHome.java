package com.example.foodie.Client.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.foodie.Client.ClientAdapters.RestroHomeListAdapter;
import com.example.foodie.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppHome extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_home);

        RecyclerView restroListView = (RecyclerView) findViewById(R.id.home_restro_list);
        restroListView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<List<String>> title = new ArrayList<List<String>>();
        String data[] = {"Hello", "There"};
        List<String> data1 = Arrays.asList(data);
        title.add(data1);
        data = new String[]{"Me", "You"};
        List<String> data2 = Arrays.asList(data);;
        title.add(data2);
        data = new String[]{"Them", "Rheaaa"};
        List<String> data3 = Arrays.asList(data);
        title.add(data3);
        data = new String[]{"Hi", "Fukka"};
        List<String> data4 = Arrays.asList(data);
        title.add(data4);
        restroListView.setAdapter(new RestroHomeListAdapter(title));


    }
}
