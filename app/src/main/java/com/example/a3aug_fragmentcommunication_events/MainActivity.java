package com.example.a3aug_fragmentcommunication_events;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentCommunicationListener{

    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.flcontainer, new EventDetailsFragment())
                .commit();
    }

    @Override
    public void dataFromEventDetails(Bundle bundle) {
        TimeAndDateFragment timeAndDateFragment = new TimeAndDateFragment();
        timeAndDateFragment.setArguments(bundle);
        fragmentManager.beginTransaction()
                .replace(R.id.flcontainer,timeAndDateFragment)
                .commit();

    }

    @Override
    public void dataFromTimeDetails(Bundle bundle) {
        PriceDetailsFragment priceDetailsFragment = new PriceDetailsFragment();
        priceDetailsFragment.setArguments(bundle);
        fragmentManager.beginTransaction()
                .replace(R.id.flcontainer,priceDetailsFragment)
                .commit();
    }

    @Override
    public void dataFromPrisePage(Bundle bundle) {
        Intent intent = new Intent(MainActivity.this,PreviewActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}