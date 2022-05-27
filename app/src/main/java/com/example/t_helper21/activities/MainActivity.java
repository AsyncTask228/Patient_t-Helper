package com.example.t_helper21.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.t_helper21.R;
import com.example.t_helper21.adapters.ProblemAdapter;
import com.example.t_helper21.domain.Person;
import com.example.t_helper21.problemclass.Problem;
import com.example.t_helper21.registration.Registration;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static SharedPreferences sharedPreferences;
    private ArrayList<Problem> problems = new ArrayList<>();
    private ImageButton logo_profile;


     Registration registration = new Registration();
     ProfileFragment profileFragment = new ProfileFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("Registration", Context.MODE_PRIVATE);

        Log.e("Is_Null", "" + (sharedPreferences == null));

        String sharedName = sharedPreferences.getString(registration.save_name, "");
        String sharedSurname = sharedPreferences.getString(registration.save_surname, "");
        String sharedRoom = sharedPreferences.getString(registration.save_room, "");
        String sharedBed = sharedPreferences.getString(registration.save_bed, "");


        Log.e("Is_Null", "" + (sharedName));
        Log.e("Is_Null", "" + (sharedSurname));


        if (sharedSurname.isEmpty() || sharedName.isEmpty() ||          //проверка на сохраненные данные
                sharedRoom.isEmpty()  || sharedBed.isEmpty() ) {
            setNewFragment();
        }

        Log.e("Is_Null", "==========" + (sharedRoom));

        initializeData();
        RecyclerView recyclerView = findViewById(R.id.rv_problem);
        logo_profile = findViewById(R.id.logo_profile);
        ProblemAdapter problemAdapter = new ProblemAdapter(MainActivity.this, problems);
        recyclerView.scrollToPosition(problemAdapter.getItemCount());
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(problemAdapter);

        logo_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNewFragment(profileFragment);
            }
        });


    }


    private void initializeData() {
        Bitmap temperature = BitmapFactory.decodeResource(this.getResources(), R.drawable.termomiter);
        Bitmap difficulty_breathing = BitmapFactory.decodeResource(this.getResources(), R.drawable.difficulty_breathing);
        Bitmap sleep_photo = BitmapFactory.decodeResource(this.getResources(), R.drawable.sleep_photo);
        Bitmap shower = BitmapFactory.decodeResource(this.getResources(), R.drawable.shower);
        Bitmap psycho = BitmapFactory.decodeResource(this.getResources(), R.drawable.psycho);
        Bitmap wc = BitmapFactory.decodeResource(this.getResources(), R.drawable.wc);
        Bitmap eat = BitmapFactory.decodeResource(this.getResources(), R.drawable.eat);
        Bitmap other = BitmapFactory.decodeResource(this.getResources(), R.drawable.other);
        Bitmap next = BitmapFactory.decodeResource(this.getResources(), R.drawable.next);
        Bitmap nothing = BitmapFactory.decodeResource(this.getResources(), R.drawable.nothing);
        Bitmap all_pain = BitmapFactory.decodeResource(this.getResources(), R.drawable.all_pain);


        problems.add(new Problem(all_pain, "БОЛЬ", next));
        problems.add(new Problem(temperature, "ТЕМПЕРАТУРА", nothing));
        problems.add(new Problem(difficulty_breathing, "ЗАТРУДНЕНИЕ ДЫХАНИЯ", nothing));
        problems.add(new Problem(sleep_photo, "ПОТРЕБНОСТЬ ВО СНЕ", nothing));
        problems.add(new Problem(shower, "ТРЕБУЮТСЯ ГИГИЕНИЧЕСКИЕ ПРОЦЕДУРЫ", nothing));
        problems.add(new Problem(psycho, "ЭМОЦИОНАЛЬНОЕ НАПРЯЖЕНИЕ", nothing));
        problems.add(new Problem(wc, "ПОХОД В УБОРНУЮ", next));
        problems.add(new Problem(eat, "ПОТРЕБНОСТЬ В ПИЩЕ И ВОДЕ", nothing));
        problems.add(new Problem(other, "ДРУГОЕ", nothing));
    }

    public void setNewFragment() { //переключатель на фрагмент регистрации
        Registration registration = new Registration();
        FragmentTransaction ft = MainActivity.this.getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_choose, registration);
        ft.commit();
    }

    public void setNewFragment(Fragment fragment) { //переклюявтель на другие фрагменты
        FragmentTransaction ft = MainActivity.this.getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_choose, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void setNewFragment(Registration registration) { //переклюявтель на другие фрагменты
        FragmentTransaction ft = MainActivity.this.getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.profile, registration);
        ft.commit();
    }

    public void dataCheck(){

    }

}