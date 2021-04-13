package com.example.tugas5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    // TODO: Rename and change types of parameters
    private TextView textView;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        // komponen
        textView = view.findViewById(R.id.text);
        textView.setText("Fragment 1");
        return view;
    }
}