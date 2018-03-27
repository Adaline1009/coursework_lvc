package model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Adelya on 27.03.2018.
 */
public class Server  {
    public static void main(String[] args) {
        Set<Device> deviceSet = new HashSet<>();
        try {
            //Создаем слушатель
           ServerSocket serverSocket = new ServerSocket(1234);

            while (true) {
                Socket client = serverSocket.accept();
                //
                // создаём обработчик клиента, который подключился к серверу

               //нужна проверка на существование
               // Device device = new Device(client,);
               // deviceSet.add(device);
             //   device.start();
                // каждое подключение клиента обрабатываем в новом потоке
            }

        } catch (SocketException e) {
            System.err.println("Socket exception");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("I/O exception");
            e.printStackTrace();
        } /*catch (IOException e) {
            e.printStackTrace();
        }*/
    }


}
