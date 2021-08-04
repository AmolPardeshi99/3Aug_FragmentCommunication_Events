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

public class EventDetailsFragment extends Fragment {

    private EditText mEtEventName, mEtEventDesc;
    private Button mBtnNextTime;
    private FragmentCommunicationListener listener ;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (FragmentCommunicationListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mEtEventDesc = view.findViewById(R.id.etEventDescription);
        mEtEventName = view.findViewById(R.id.etEventTitle);
        mBtnNextTime = view.findViewById(R.id.btnNextTime);
        mBtnNextTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String EventTitle = mEtEventName.getText().toString();
                String EventDisc = mEtEventDesc.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("EventTitle",EventTitle);
                bundle.putString("EventDesc",EventDisc);
                listener.dataFromEventDetails(bundle);
            }
        });
    }
}