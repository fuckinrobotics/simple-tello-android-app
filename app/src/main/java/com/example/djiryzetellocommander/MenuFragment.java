package com.example.djiryzetellocommander;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MenuFragment extends Fragment{

    // Инициализация view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.content_menu_fragment, container             // родитель, куда потом будет вставлена верстка
                , false     // стоит false, что бы инфлейтер вернул верстку.
                // Если поставить true, то инфлейтер вставит верстку в parent, и вернет тоже parent
                // Мы сами в шоке от того, почему была сделана такая логика работы метод:(
        );
    }

    // когда View создано, инициализируем фрагменты view
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // инициализируем View для отображения списка
        TextView textTitleMenu = view.findViewById(R.id.text_menu);
        textTitleMenu.setText(R.string.text_menu);
        Button btnStartMenu = view.findViewById(R.id.btn_start);
        btnStartMenu.setText(R.string.btn_start);
        Button btnAboutMenu = view.findViewById(R.id.btn_about);
        btnAboutMenu.setText(R.string.btn_about);
    }
}
