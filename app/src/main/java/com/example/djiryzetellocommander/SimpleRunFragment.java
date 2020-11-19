package com.example.djiryzetellocommander;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
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
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SimpleRunFragment extends Fragment {

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
        btnBackSimpleRun.setText(R.string.btn_back_simple_run);
        btnBackSimpleRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
        final Button btnClockwise = view.findViewById(R.id.btn_clockwise);
        btnClockwise.setText(R.string.btn_clockwise);
        btnClockwise.setClickable(false);
        btnClockwise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage("cw 360");
            }
        });
        final Button btnLand = view.findViewById(R.id.btn_land);
        btnLand.setText(R.string.btn_land);
        btnLand.setClickable(false);
        btnLand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage("land");
            }
        });
        final Button btnTakeOff = view.findViewById(R.id.btn_take_off);
        btnTakeOff.setText(R.string.btn_take_off);
        btnTakeOff.setClickable(false);
        btnTakeOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage("takeoff");
            }
        });
        Button btnConnect = view.findViewById(R.id.btn_connect);
        btnConnect.setText(R.string.btn_connect);
        btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage("command");
                btnTakeOff.setClickable(true);
                btnClockwise.setClickable(true);
                btnLand.setClickable(true);
            }
        });
    }

    private void sendMessage(final String message) {
        //final Handler handler = new Handler();
        Thread thread = new Thread(new Runnable() {
            String stringData;
            @Override
            public void run() {
                DatagramSocket ds = null;
                try {
                    ds = new DatagramSocket();
                    // IP Address below is the IP address of that Device where server socket is opened.
                    InetAddress serverAddr = InetAddress.getByName("192.168.10.1");
                    DatagramPacket dp;
                    dp = new DatagramPacket(message.getBytes(), message.length(), serverAddr, 8889);
                    ds.send(dp);
                    byte[] lMsg = new byte[1000];
                    dp = new DatagramPacket(lMsg, lMsg.length);
                    ds.receive(dp);
                    stringData = new String(lMsg, 0, dp.getLength());
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (ds != null) {
                        ds.close();
                    }
                }
            }
        });
        thread.start();
    }
}




