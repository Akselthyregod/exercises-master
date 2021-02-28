package vop.threadedtcp;

import vop.serialio.Species;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Scanner;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] args) {
        String str;
        Scanner inputStream = null;
        PrintWriter outputStream = null;

        try (Socket clientSocket = new Socket("localhost", 3334);
             Scanner keyboard = new Scanner(System.in)) {
            // Set up streams to send/receive data
            inputStream = new Scanner(clientSocket.getInputStream());
            outputStream = new PrintWriter(clientSocket.getOutputStream(), true);

            if(keyboard.nextLine().equalsIgnoreCase("obj")){
                Species obj = new Species("Test", 20, 10);
                ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());

                oos.writeObject(obj);
                oos.close();
            }

            // Start massage from server:
            System.out.println(inputStream.nextLine());
            // Read a line from the keyboard:
            outputStream.println(keyboard.nextLine());

            // Read answer from the server and output it to the screen
            str = inputStream.nextLine();
            System.out.println(str);

        } catch (Exception e) {
            // If any exception occurs, display it
            System.out.println("Error " + e);
        } finally {
            inputStream.close();
            outputStream.close();
        }
    }
}
