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

public class PriceDetailsFragment extends Fragment {
    private EditText mEtPrise,mEtCurrency;
    private Button mBtnNextPreview;
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
        return inflater.inflate(R.layout.fragment_price_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mBtnNextPreview = view.findViewById(R.id.btnPreview);
        mEtPrise = view.findViewById(R.id.etPrise);
        mEtCurrency = view.findViewById(R.id.etCurrency);
        mBtnNextPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getArguments() != null){
                    Bundle bundle = getArguments();

                    String Prise = mEtPrise.getText().toString();
                    String Currency = mEtCurrency.getText().toString();
                    bundle.putString("Prise",Prise);
                    bundle.putString("Currency",Currency);

                    listener.dataFromPrisePage(bundle);

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