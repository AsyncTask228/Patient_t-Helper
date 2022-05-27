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
import com.example.t_helper21.adapters.PhysiologyAdapter;
import com.example.t_helper21.problemclass.Physiology;

import java.util.ArrayList;


public class PhysiologyFragment extends Fragment {


    private ArrayList<Physiology> physiologies = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_physiology, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rv_physiology);

        initializeDataPhysiology();
        PhysiologyAdapter physiologyAdapter = new PhysiologyAdapter(view.getContext(), physiologies);
        recyclerView.scrollToPosition(physiologyAdapter.getItemCount());
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(physiologyAdapter);

        return view;
    }

    private void initializeDataPhysiology() {

        Bitmap defecation = BitmapFactory.decodeResource(this.getResources(), R.drawable.defecation);
        Bitmap urination = BitmapFactory.decodeResource(this.getResources(), R.drawable.urination);

        physiologies.add(new Physiology(defecation, "ТРЕБУЕТСЯ ИСПРАЖНЕНИЕ КИШЕЧНИКА"));
        physiologies.add(new Physiology(urination, "ТРЕБЕТСЯ АКТ МОЧЕИСПУСКАНИЯ"));
    }
}