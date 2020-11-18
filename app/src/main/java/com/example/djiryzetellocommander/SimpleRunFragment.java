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
                Thread sendDate = new Thread() {
                    @Override
                    public void run() {
                        String serverString = "192.168.10.1";
                        int port = 8889;


                        Log.d("adam", "Debug");



                        DatagramSocket socket = null ;



                        String msg = "cv 360";



                        try {
                            socket = new DatagramSocket() ;



                            InetAddress host = InetAddress.getByName(serverString);
                            byte [] data = msg.getBytes() ;
                            DatagramPacket packet = new DatagramPacket( data, data.length, host, port );
                            Log.d("adam", "Debug2");



                            socket.send(packet) ;



                            Log.d("adam", "Packet sent" );
                        } catch( Exception e )
                        {
                            Log.d("adam", "Exception");
                            Log.e("adam", Log.getStackTraceString(e));
                        }
                        finally
                        {
                            if( socket != null ) {
                                socket.close();
                            }
                        }
                    }
                };
                sendDate.start();

            }
        });
        final Button btnLand = view.findViewById(R.id.btn_land);
        btnLand.setText(R.string.btn_land);
        btnLand.setClickable(false);
        btnLand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Thread sendDate = new Thread() {
                    @Override
                    public void run() {
                        String serverString = "192.168.10.1";
                        int port = 8889;


                        Log.d("adam", "Debug");



                        DatagramSocket socket = null ;



                        String msg = "land";



                        try {
                            socket = new DatagramSocket() ;



                            InetAddress host = InetAddress.getByName(serverString);
                            byte [] data = msg.getBytes() ;
                            DatagramPacket packet = new DatagramPacket( data, data.length, host, port );
                            Log.d("adam", "Debug2");



                            socket.send(packet) ;



                            Log.d("adam", "Packet sent" );
                        } catch( Exception e )
                        {
                            Log.d("adam", "Exception");
                            Log.e("adam", Log.getStackTraceString(e));
                        }
                        finally
                        {
                            if( socket != null ) {
                                socket.close();
                            }
                        }
                    }
                };
                sendDate.start();
            }
        });
        final Button btnTakeOff = view.findViewById(R.id.btn_take_off);
        btnTakeOff.setText(R.string.btn_take_off);
        btnTakeOff.setClickable(false);
        btnTakeOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread sendDate = new Thread() {
                    @Override
                    public void run() {
                        String serverString = "192.168.10.1";
                        int port = 8889;


                        Log.d("adam", "Debug");



                        DatagramSocket socket = null ;



                        String msg = "takeoff";



                        try {
                            socket = new DatagramSocket() ;



                            InetAddress host = InetAddress.getByName(serverString);
                            byte [] data = msg.getBytes() ;
                            DatagramPacket packet = new DatagramPacket( data, data.length, host, port );
                            Log.d("adam", "Debug2");



                            socket.send(packet) ;



                            Log.d("adam", "Packet sent" );
                        } catch( Exception e )
                        {
                            Log.d("adam", "Exception");
                            Log.e("adam", Log.getStackTraceString(e));
                        }
                        finally
                        {
                            if( socket != null ) {
                                socket.close();
                            }
                        }
                    }
                };
                sendDate.start();
            }
        });
        Button btnConnect = view.findViewById(R.id.btn_connect);
        btnConnect.setText(R.string.btn_connect);
        btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread sendDate = new Thread() {
                    @Override
                    public void run() {
                        String serverString = "192.168.10.1";
                        int port = 8889;


                        Log.d("adam", "Debug");



                        DatagramSocket socket = null ;



                        String msg = "command";



                        try {
                            socket = new DatagramSocket() ;



                            InetAddress host = InetAddress.getByName(serverString);
                            byte [] data = msg.getBytes() ;
                            DatagramPacket packet = new DatagramPacket( data, data.length, host, port );
                            Log.d("adam", "Debug2");



                            socket.send(packet) ;



                            Log.d("adam", "Packet sent" );
                        } catch( Exception e )
                        {
                            Log.d("adam", "Exception");
                            Log.e("adam", Log.getStackTraceString(e));
                        }

                    }
                };
                sendDate.start();
                btnTakeOff.setClickable(true);
                btnClockwise.setClickable(true);
                btnLand.setClickable(true);

            }
        });
    }



}




