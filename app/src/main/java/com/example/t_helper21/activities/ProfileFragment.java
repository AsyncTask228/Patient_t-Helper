package com.example.t_helper21.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.t_helper21.R;
import com.example.t_helper21.registration.Registration;

public class ProfileFragment extends Fragment {

    public SharedPreferences sharedPreferences;
    public MainActivity activity;
    public Registration registration = new Registration();
    private TextView shared_name, shared_surname, shared_room_num, shared_bed_num;
    private AppCompatButton btn_delete_shared;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        btn_delete_shared = view.findViewById(R.id.btn_delete_shared);
        shared_name = view.findViewById(R.id.shared_name);
        shared_surname = view.findViewById(R.id.shared_surname);
        shared_room_num = view.findViewById(R.id.shared_room_num);
        shared_bed_num = view.findViewById(R.id.shared_bed_num);

        sharedPreferences = MainActivity.sharedPreferences;
        activity = new MainActivity();

        String profile_name = MainActivity.sharedPreferences.getString(registration.save_name, "");
        String profile_surname = MainActivity.sharedPreferences.getString(registration.save_surname, "");
        String profile_room_num = MainActivity.sharedPreferences.getString(registration.save_room, "");
        String profile_bed_num = MainActivity.sharedPreferences.getString(registration.save_bed, "");

        shared_name.setText(profile_name);
        shared_surname.setText(profile_surname);
        shared_room_num.setText(profile_room_num);
        shared_bed_num.setText(profile_bed_num);




        Log.e("============", "sharedPreference " + (sharedPreferences == null));
        Log.e("============", "registration " + (registration == null));


        //очищение сохраненных данных
        btn_delete_shared.setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick(View view) {

                sharedPreferences.edit().clear().apply();

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.remove(ProfileFragment.this);
                ft.commit();

                getActivity().recreate();

            }
        });

        //закрытие фрагмента
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.remove(ProfileFragment.this);
                    ft.commit();
                }
                return false;
            }
        });

        return view;
    }
}