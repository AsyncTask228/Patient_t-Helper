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
import com.example.t_helper21.problemclass.Physiology;
import com.example.t_helper21.registration.Registration;
import com.example.t_helper21.rest.ProblemApiVolley;

import java.util.List;

public class PhysiologyAdapter extends RecyclerView.Adapter<PhysiologyAdapter.ViewHolderPhysiology> {

    SharedPreferences sharedPreferences = MainActivity.sharedPreferences;
    Registration registration = new Registration();

    private LayoutInflater inflater;
    private List<Physiology> physiologies;
    private Context context;

    public PhysiologyAdapter(Context context, List<Physiology> physiologies) {
        this.inflater = LayoutInflater.from(context);
        this.physiologies = physiologies;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderPhysiology onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.problem_item, parent, false);
        return new ViewHolderPhysiology(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPhysiology holder, int position) {
        Physiology physiology = physiologies.get(position);
        holder.logo_physiology.setImageBitmap(physiology.getLogo_physiology());
        holder.reason_physiology.setText(physiology.getName_physiology());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (holder.reason_physiology.getText().toString()) {
                    case ("ТРЕБУЕТСЯ ИСПРАЖНЕНИЕ КИШЕЧНИКА"):
                        Toast.makeText(context, "Сигнал с запросом отправлен!", Toast.LENGTH_SHORT).show();

                        //запрос на вставку проблемы на сервер
                        new ProblemApiVolley(context).addProblem(
                                new com.example.t_helper21.domain.Problem(
                                        "Требуется акт дефекации",
                                        new Person(sharedPreferences.getString(registration.save_name, ""),
                                                sharedPreferences.getString(registration.save_surname, ""),
                                                Integer.parseInt (sharedPreferences.getString(registration.save_room, "")),
                                                Integer.parseInt(sharedPreferences.getString(registration.save_bed, "")))
                                )
                        );

                        break;

                    case ("ТРЕБЕТСЯ АКТ МОЧЕИСПУСКАНИЯ"):
                        Toast.makeText(context, "Сигнал с запросом отправлен !", Toast.LENGTH_SHORT).show();

                        //запрос на вставку проблемы на сервер
                        new ProblemApiVolley(context).addProblem(
                                new com.example.t_helper21.domain.Problem(
                                        "Требуется акт мочеиспускания",
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

        return physiologies.size();
    }

    public static class ViewHolderPhysiology extends RecyclerView.ViewHolder {

        TextView reason_physiology;
        ImageView logo_physiology;

        public ViewHolderPhysiology(@NonNull View itemView) {
            super(itemView);

            logo_physiology = itemView.findViewById(R.id.numeration);
            reason_physiology = itemView.findViewById(R.id.reason);
        }
    }
}
