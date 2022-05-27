package com.example.t_helper21.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.t_helper21.R;
import com.example.t_helper21.activities.MainActivity;
import com.example.t_helper21.domain.Person;
import com.example.t_helper21.problemclass.Pain;
import com.example.t_helper21.registration.Registration;
import com.example.t_helper21.rest.ProblemApiVolley;

import java.util.List;

public class PainAdapter extends RecyclerView.Adapter<PainAdapter.ViewHolderPain> {

    SharedPreferences sharedPreferences = MainActivity.sharedPreferences;
    Registration registration = new Registration();

    private LayoutInflater inflater;
    private List<Pain> pains;
    private Context context;

    public PainAdapter(Context context, List<Pain> pains) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.pains = pains;
    }

    @NonNull
    @Override
    public ViewHolderPain onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.problem_item, parent, false);
        return new ViewHolderPain(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPain holder, int position) {

        Pain pain = pains.get(position);
        holder.logo_pain.setImageBitmap(pain.getPain_logo());
        holder.reason_pain.setText(pain.getPainProblem());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (holder.reason_pain.getText().toString()) {
                    case ("ГОЛОВНАЯ БОЛЬ"):
                        Toast.makeText(view.getContext(), "Сигнал о головной боли отправлен!", Toast.LENGTH_SHORT).show();

                        //запрос на вставку проблемы на сервер
                        new ProblemApiVolley(context).addProblem(
                                new com.example.t_helper21.domain.Problem(
                                        "Головная боль",
                                        new Person(sharedPreferences.getString(registration.save_name, ""),
                                                sharedPreferences.getString(registration.save_surname, ""),
                                                Integer.parseInt (sharedPreferences.getString(registration.save_room, "")),
                                                Integer.parseInt(sharedPreferences.getString(registration.save_bed, "")))
                                )
                        );

                        break;

                    case ("БОЛЬ В ПОСЛЕОПЕРАЦИОННОЙ РАНЕ"):
                        Toast.makeText(view.getContext(), "Сигнал о боли в послеоперационной ране отправлен!", Toast.LENGTH_SHORT).show();

                        //запрос на вставку проблемы на сервер
                        new ProblemApiVolley(context).addProblem(
                                new com.example.t_helper21.domain.Problem(
                                        "Боль в послеоперационной ране",
                                        new Person(sharedPreferences.getString(registration.save_name, ""),
                                                sharedPreferences.getString(registration.save_surname, ""),
                                                Integer.parseInt (sharedPreferences.getString(registration.save_room, "")),
                                                Integer.parseInt(sharedPreferences.getString(registration.save_bed, "")))
                                )
                        );

                        break;

                    case ("БОЛЬ В ЖИВОТЕ"):
                        Toast.makeText(view.getContext(), "Сигнал о боли в животе отправлен!", Toast.LENGTH_SHORT).show();

                        //запрос на вставку проблемы на сервер
                        new ProblemApiVolley(context).addProblem(
                                new com.example.t_helper21.domain.Problem(
                                        "Боль в животе",
                                        new Person(sharedPreferences.getString(registration.save_name, ""),
                                                sharedPreferences.getString(registration.save_surname, ""),
                                                Integer.parseInt (sharedPreferences.getString(registration.save_room, "")),
                                                Integer.parseInt(sharedPreferences.getString(registration.save_bed, "")))
                                )
                        );

                        break;
                    case ("ЗАГРУДИННАЯ БОЛЬ"):
                        Toast.makeText(view.getContext(), "Сигнал о загрудинной боли отправлен!", Toast.LENGTH_SHORT).show();

                        //запрос на вставку проблемы на сервер
                        new ProblemApiVolley(context).addProblem(
                                new com.example.t_helper21.domain.Problem(
                                        "Загрудинная боль",
                                        new Person(sharedPreferences.getString(registration.save_name, ""),
                                                sharedPreferences.getString(registration.save_surname, ""),
                                                Integer.parseInt (sharedPreferences.getString(registration.save_room, "")),
                                                Integer.parseInt(sharedPreferences.getString(registration.save_bed, "")))
                                )
                        );

                        break;

                    case ("ДРУГАЯ БОЛЬ"):
                        Toast.makeText(view.getContext(), "Сигнал отправлен, ожидайте мед.персонал!", Toast.LENGTH_SHORT).show();

                        //запрос на вставку проблемы на сервер
                        new ProblemApiVolley(context).addProblem(
                                new com.example.t_helper21.domain.Problem(
                                        "Неизвестная боль",
                                        new Person(sharedPreferences.getString(registration.save_name, ""),
                                                sharedPreferences.getString(registration.save_surname, ""),
                                                Integer.parseInt (sharedPreferences.getString(registration.save_room, "")),
                                                Integer.parseInt(sharedPreferences.getString(registration.save_bed, "")))
                                )
                        );


                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {

        return pains.size();
    }

    public static class ViewHolderPain extends RecyclerView.ViewHolder {

        TextView reason_pain;
        ImageView logo_pain;

        public ViewHolderPain(@NonNull View itemView) {
            super(itemView);

            logo_pain = itemView.findViewById(R.id.numeration);
            reason_pain = itemView.findViewById(R.id.reason);
        }
    }

}
