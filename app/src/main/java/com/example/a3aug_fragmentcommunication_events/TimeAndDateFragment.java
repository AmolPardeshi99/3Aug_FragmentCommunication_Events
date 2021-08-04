package com.example.a3aug_fragmentcommunication_events;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class TimeAndDateFragment extends Fragment {

    private EditText mEtStartDate, mEtEndDate, mETStartTime, mETEndTime;
    private Button mBtnNextPrise;
    private FragmentCommunicationListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (FragmentCommunicationListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time_and_date, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mEtEndDate = view.findViewById(R.id.etEventEndDate);
        mETEndTime = view.findViewById(R.id.etEventEndTime);
        mEtStartDate = view.findViewById(R.id.etEventStartDate);
        mETStartTime = view.findViewById(R.id.etEventStartTime);
        mBtnNextPrise = view.findViewById(R.id.btnNextPrise);
        mBtnNextPrise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getArguments() != null){
                    Bundle bundle = getArguments();

                    String StartDate = mEtStartDate.getText().toString();
                    String StartTime = mETStartTime.getText().toString();
                    String EndDate = mEtEndDate.getText().toString();
                    String EndTime = mETEndTime.getText().toString();

                    bundle.putString("StartDate",StartDate);
                    bundle.putString("EndDate",EndDate);
                    bundle.putString("StartTime",StartTime);
                    bundle.putString("EndTime",EndTime);

                    listener.dataFromTimeDetails(bundle);
                }
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}