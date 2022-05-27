package com.example.t_helper21.activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.t_helper21.R;
import com.example.t_helper21.adapters.PainAdapter;
import com.example.t_helper21.problemclass.Pain;
import com.example.t_helper21.registration.Registration;

import java.util.ArrayList;


public class PainFragment extends Fragment {

    Registration registration = new Registration();

    private ArrayList<Pain> pains = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pain, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rv_pain);

        initializeDataPain();
        PainAdapter painAdapter = new PainAdapter(view.getContext(), pains);
        recyclerView.scrollToPosition(painAdapter.getItemCount());
       // recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(painAdapter);

        return view;
    }

    private void initializeDataPain() {

        Bitmap after_operation = BitmapFactory.decodeResource(this.getResources(), R.drawable.after_operation);
        Bitmap chest = BitmapFactory.decodeResource(this.getResources(), R.drawable.chest);
        Bitmap stomach = BitmapFactory.decodeResource(this.getResources(), R.drawable.stomach);
        Bitmap other = BitmapFactory.decodeResource(this.getResources(), R.drawable.other);
        Bitmap headache = BitmapFactory.decodeResource(this.getResources(), R.drawable.headache);


        pains.add(new Pain(headache, "ГОЛОВНАЯ БОЛЬ"));
        pains.add(new Pain(after_operation, "БОЛЬ В ПОСЛЕОПЕРАЦИОННОЙ РАНЕ"));
        pains.add(new Pain(stomach, "БОЛЬ В ЖИВОТЕ"));
        pains.add(new Pain(chest, "ЗАГРУДИННАЯ БОЛЬ"));
        pains.add(new Pain(other, "ДРУГАЯ БОЛЬ"));

    }
}