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
import com.example.t_helper21.activities.PainFragment;
import com.example.t_helper21.activities.PhysiologyFragment;
import com.example.t_helper21.domain.Person;
import com.example.t_helper21.problemclass.Problem;
import com.example.t_helper21.registration.Registration;
import com.example.t_helper21.rest.ProblemApiVolley;

import java.util.List;


public class ProblemAdapter extends RecyclerView.Adapter<ProblemAdapter.ViewHolder> {

    SharedPreferences sharedPreferences = MainActivity.sharedPreferences;
    Registration registration = new Registration();

    private LayoutInflater inflater;
    private List<Problem> problems;
    private Context context;


    public ProblemAdapter(Context context, List<Problem> problems) {
        this.inflater = LayoutInflater.from(context);
        this.problems = problems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.problem_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        Problem problem = problems.get(position);
        holder.next.setImageBitmap(problem.getNext());
        holder.image.setImageBitmap(problem.getNum());
        holder.reason.setText(problem.getReason());
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                switch (holder.reason.getText().toString()) {
                    case ("БОЛЬ"):
                        MainActivity activity = (MainActivity)view.getContext();
                        PainFragment painFragment = new PainFragment();
                        activity.setNewFragment(painFragment);
                        break;
                    case ("ТЕМПЕРАТУРА"):
                        //UI тост
                        Toast.makeText(context, "Сигнал о температуре отправлен!", Toast.LENGTH_SHORT).show();


                        //запрос на вставку проблемы на сервер
                        new ProblemApiVolley(context).addProblem(
                                new com.example.t_helper21.domain.Problem(
                                        "Температура",
                                        new Person(sharedPreferences.getString(registration.save_name, ""),
                                                sharedPreferences.getString(registration.save_surname, ""),
                                               Integer.parseInt (sharedPreferences.getString(registration.save_room, "")),
                                                Integer.parseInt(sharedPreferences.getString(registration.save_bed, "")))
                                )
                        );

                        break;

                    case ("ЗАТРУДНЕНИЕ ДЫХАНИЯ"):
                        Toast.makeText(context, "Сигнал о затруднении дыхания отправлен!", Toast.LENGTH_SHORT).show();

                        //запрос на вставку проблемы на сервер
                        new ProblemApiVolley(context).addProblem(
                                new com.example.t_helper21.domain.Problem(
                                        "Затруднение дыхания",
                                        new Person(sharedPreferences.getString(registration.save_name, ""),
                                                sharedPreferences.getString(registration.save_surname, ""),
                                                Integer.parseInt (sharedPreferences.getString(registration.save_room, "")),
                                                Integer.parseInt(sharedPreferences.getString(registration.save_bed, "")))
                                )
                        );

                        break;

                    case ("ПОТРЕБНОСТЬ ВО СНЕ"):
                        Toast.makeText(context, "Сигнал о потребности во сне отправлен!", Toast.LENGTH_SHORT).show();

                        //запрос на вставку проблемы на сервер
                        new ProblemApiVolley(context).addProblem(
                                new com.example.t_helper21.domain.Problem(
                                        "Потребность во сне",
                                        new Person(sharedPreferences.getString(registration.save_name, ""),
                                                sharedPreferences.getString(registration.save_surname, ""),
                                                Integer.parseInt (sharedPreferences.getString(registration.save_room, "")),
                                                Integer.parseInt(sharedPreferences.getString(registration.save_bed, "")))
                                )
                        );

                        break;

                    case ("ТРЕБУЮТСЯ ГИГИЕНИЧЕСКИЕ ПРОЦЕДУРЫ"):
                        Toast.makeText(context, "Сигнал о потребности в гигиенических процедурах отправлен!", Toast.LENGTH_SHORT).show();

                        //запрос на вставку проблемы на сервер
                        new ProblemApiVolley(context).addProblem(
                                new com.example.t_helper21.domain.Problem(
                                        "Требуются гигиенические процедуры",
                                        new Person(sharedPreferences.getString(registration.save_name, ""),
                                                sharedPreferences.getString(registration.save_surname, ""),
                                                Integer.parseInt (sharedPreferences.getString(registration.save_room, "")),
                                                Integer.parseInt(sharedPreferences.getString(registration.save_bed, "")))
                                )
                        );

                        break;

                    case ("ЭМОЦИОНАЛЬНОЕ НАПРЯЖЕНИЕ"):
                        Toast.makeText(context, "Сигнал о психоэмоциональном напряжении отправлен!", Toast.LENGTH_SHORT).show();

                        //запрос на вставку проблемы на сервер
                        new ProblemApiVolley(context).addProblem(
                                new com.example.t_helper21.domain.Problem(
                                        "Психоэмоциональное напряжение",
                                        new Person(sharedPreferences.getString(registration.save_name, ""),
                                                sharedPreferences.getString(registration.save_surname, ""),
                                                Integer.parseInt (sharedPreferences.getString(registration.save_room, "")),
                                                Integer.parseInt(sharedPreferences.getString(registration.save_bed, "")))
                                )
                        );

                        break;

                    case ("ПОХОД В УБОРНУЮ"):
                        MainActivity activity1 = (MainActivity)view.getContext();
                        PhysiologyFragment physiologyFragment = new PhysiologyFragment();
                        activity1.setNewFragment(physiologyFragment);
                        break;

                    case ("ПОТРЕБНОСТЬ В ПИЩЕ И ВОДЕ"):
                        Toast.makeText(context, "Сигнал о потребности в пище и воде отправлен!", Toast.LENGTH_SHORT).show();

                        //запрос на вставку проблемы на сервер
                        new ProblemApiVolley(context).addProblem(
                                new com.example.t_helper21.domain.Problem(
                                        "Потребность в пище и воде",
                                        new Person(sharedPreferences.getString(registration.save_name, ""),
                                                sharedPreferences.getString(registration.save_surname, ""),
                                                Integer.parseInt (sharedPreferences.getString(registration.save_room, "")),
                                                Integer.parseInt(sharedPreferences.getString(registration.save_bed, "")))
                                )
                        );

                        break;

                    case ("ДРУГОЕ"):
                        Toast.makeText(context, "Сигнал отправлен, ожидайте мед.персонал!", Toast.LENGTH_SHORT).show();

                        //запрос на вставку проблемы на сервер
                        new ProblemApiVolley(context).addProblem(
                                new com.example.t_helper21.domain.Problem(
                                        "Неизвестная причина вызова",
                                        new Person(sharedPreferences.getString(registration.save_name, ""),
                                                sharedPreferences.getString(registration.save_surname, ""),
                                                Integer.parseInt (sharedPreferences.getString(registration.save_room, "")),
                                                Integer.parseInt(sharedPreferences.getString(registration.save_bed, "")))
                                )
                        );
                }
            }
        });
    }

    @Override
    public int getItemCount() {

        return problems.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView reason;
        ImageView image, next;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            next = itemView.findViewById(R.id.dis);
            image = itemView.findViewById(R.id.numeration);
            reason = itemView.findViewById(R.id.reason);

        }

    }
}