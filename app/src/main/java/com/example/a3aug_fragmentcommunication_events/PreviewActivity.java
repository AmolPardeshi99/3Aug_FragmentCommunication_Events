package com.example.a3aug_fragmentcommunication_events;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PreviewActivity extends AppCompatActivity {

    private TextView mTvTitle, mTvDisc, mTVStartDate, mTvPrise,
            mTvStartTime, mTvEndDate, mTvEndTime, mTvCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        initView();
        setData(getIntent());
    }

    private void setData(Intent intent) {
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            //mTvCurrency.setText(bundle.getString("Currency"));
            mTvTitle.setText(bundle.getString("EventTitle"));
            mTvDisc.setText(bundle.getString("EventDesc"));
            mTvStartTime.setText(bundle.getString("StartTime"));
            mTVStartDate.setText(bundle.getString("StartDate"));
            mTvEndDate.setText(bundle.getString("EndDate"));
            mTvEndTime.setText(bundle.getString("EndTime"));
            //String currency = mTvCurrency.getText().12    1211toString();
            mTvPrise.setText(bundle.getString("Prise"));
        }

    }

    private void initView() {
        mTvTitle = findViewById(R.id.tvEventTitle);
        mTvDisc = findViewById(R.id.tvEventDesc);
        mTVStartDate = findViewById(R.id.tvEventStartDate);
        mTvStartTime = findViewById(R.id.tvEventStartTime);
        mTvEndDate = findViewById(R.id.tvEventEndDate);
        mTvEndTime = findViewById(R.id.tvEventEndTime);
        mTvPrise = findViewById(R.id.tvPrice);
    }
}