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
    Thread Thread1 = null;
    String SERVER_IP;
    int SERVER_PORT;

    // Инициализация view

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
        SERVER_IP = "";
        SERVER_PORT = 9000;
        Thread1 = new Thread(new Thread1());
        Thread1.start();
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
                String n = "cv 180".trim();
                new Thread(new Thread3(n)).start();
            }
        });
        Button btnLand = view.findViewById(R.id.btn_land);
        btnLand.setText(R.string.btn_land);
        btnLand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = "land".trim();
                new Thread(new Thread3(n)).start();
            }
        });
        Button btnTakeOff = view.findViewById(R.id.btn_take_off);
        btnTakeOff.setText(R.string.btn_take_off);
        btnTakeOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = "takeoff".trim();
                new Thread(new Thread3(n)).start();
            }
        });
    }

    private PrintWriter output;
    private BufferedReader input;

    class Thread1 implements Runnable {
        public void run() {
            Socket socket;
            try {
                socket = new Socket(SERVER_IP, SERVER_PORT);
                output = new PrintWriter(socket.getOutputStream());
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                new Thread(new Thread2()).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class Thread2 implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    final String message = input.readLine();
                    if (message != null) {

                    } else {
                        Thread1 = new Thread(new Thread1());
                        Thread1.start();
                        return;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Thread3 implements Runnable {
        private String message;

        Thread3(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            output.write(message);
            output.flush();

        }
    }
}