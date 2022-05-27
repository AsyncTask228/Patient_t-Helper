package com.example.t_helper21.registration;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.t_helper21.R;
import com.example.t_helper21.activities.MainActivity;
import com.example.t_helper21.activities.ProfileFragment;


public class Registration extends Fragment {

    public SharedPreferences sharedPreferences;
    public Activity activity;
    public final String save_name = "save_name";
    public final String save_surname = "save_surname";
    public final String save_room = "save_room";
    public final String save_bed = "save_bed";
    public SharedPreferences.Editor editor;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ProfileFragment profileFragment = new ProfileFragment();

        activity = getActivity();

        sharedPreferences = MainActivity.sharedPreferences;

        View view = inflater.inflate(R.layout.fragment_registration, container, false);

        EditText name = view.findViewById(R.id.name);
        EditText surname = view.findViewById(R.id.surname);
        EditText room_num = view.findViewById(R.id.room_num);
        EditText bed_num = view.findViewById(R.id.bed_num);
        AppCompatButton btn_reg = view.findViewById(R.id.btn_reg);

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (name.getText().toString().equals("") || surname.getText().toString().equals("") || room_num.getText()
                        .toString()
                        .equals("") || bed_num.getText().toString().equals("")) {

                    Toast toast = Toast.makeText(getActivity(), "Заполните все поля!", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Toast toast_true = Toast.makeText(getActivity(), "Регистрация прошла успешно!", Toast.LENGTH_SHORT);
                    toast_true.show();
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.remove(Registration.this);
                    ft.commit();


                }

                editor = sharedPreferences.edit();
                editor.putString(save_name, name.getText().toString());
                editor.putString(save_surname, surname.getText().toString());
                editor.putString(save_room, room_num.getText().toString());
                editor.putString(save_bed, bed_num.getText().toString());
                editor.apply();

            }
        });
        return view;
    }

}
