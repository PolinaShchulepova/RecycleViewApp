package com.example.recyclevapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.MyViewHolder> {

    private ArrayList<DataModel> dataSet;
    private ArrayList<DataModel> filteredList;

    public CustomeAdapter(ArrayList<DataModel> dataSet) {
        this.dataSet = dataSet;
        this.filteredList = new ArrayList<>(dataSet); // התחלת הרשימה המסוננת עם כל הנתונים
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewVersion;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {//שליפת נתונים
            super(itemView);//
            textViewName = itemView.findViewById(R.id.textView);
            textViewVersion = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public CustomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardrow, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomeAdapter.MyViewHolder holder, int position) {

        holder.textViewName.setText(filteredList.get(position).getName());
        holder.textViewVersion.setText(filteredList.get(position).getVersion());
        holder.imageView.setImageResource(filteredList.get(position).getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int actualPosition = holder.getAdapterPosition();
                if (actualPosition != RecyclerView.NO_POSITION) {
                    DataModel clickedModel = filteredList.get(actualPosition);
                    Toast.makeText(
                            v.getContext(),
                            "You cliked on: " + clickedModel.getName(),
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });
     }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }
    public void filter(String text) {
        filteredList.clear();
        String lowerCaseQuery = text.toLowerCase().trim();
        if (text.isEmpty()) {
            filteredList.addAll(dataSet); // אם אין חיפוש, להחזיר הכל
        } else {
            for (DataModel item : dataSet) {
                if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                    filteredList.add(item); // הוספת פריטים שמתאימים לחיפוש
                }
            }
        }
        notifyDataSetChanged(); // עדכון ה-RecyclerView
    }
}