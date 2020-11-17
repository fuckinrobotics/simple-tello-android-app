package com.example.djiryzetellocommander;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleRunFragment extends Fragment {
    public JTello drone = new JTello();
    // Инициализация view

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.content_simple_run_fragment, container             // родитель, куда потом будет вставлена верстка
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
        Button btnBackSimpleRun = view.findViewById(R.id.btn_back_simple_run);
       // String n1 = "Command";
     //   new Thread(new Thread3(n1)).start();
        btnBackSimpleRun.setText(R.string.btn_back_simple_run);
        btnBackSimpleRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
        Button btnClockwise = view.findViewById(R.id.btn_clockwise);
        btnClockwise.setText(R.string.btn_clockwise);
        btnClockwise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    drone.cw(180);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Button btnLand = view.findViewById(R.id.btn_land);
        btnLand.setText(R.string.btn_land);
        btnLand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    drone.land();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Button btnTakeOff = view.findViewById(R.id.btn_take_off);
        btnTakeOff.setText(R.string.btn_take_off);
        btnTakeOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    drone.connect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    drone.takeOff();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
