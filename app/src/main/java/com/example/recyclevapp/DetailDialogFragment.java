package com.example.recyclevapp;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DetailDialogFragment extends DialogFragment {

    private String name;
    private String description;
    private int image;

    public static DetailDialogFragment newInstance(String name, String description, int image) {
        DetailDialogFragment fragment = new DetailDialogFragment();

        // העברת נתונים באמצעות Bundle
        Bundle args = new Bundle();
        args.putString("NAME", name);
        args.putString("DESCRIPTION", description);
        args.putInt("IMAGE", image);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // שימוש ב-layout הקיים
        View view = inflater.inflate(R.layout.cardrow, container, false);

        // קבלת הנתונים מ-Bundle
        if (getArguments() != null) {
            name = getArguments().getString("NAME");
            description = getArguments().getString("DESCRIPTION");
            image = getArguments().getInt("IMAGE");
        }

        // קישור לתצוגות
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView nameView = view.findViewById(R.id.textView);
        TextView descriptionView = view.findViewById(R.id.textView2);

        // הצגת הנתונים בתצוגות
        imageView.setImageResource(image);
        nameView.setText(name);
        descriptionView.setText(description);

        return view;
    }
}


