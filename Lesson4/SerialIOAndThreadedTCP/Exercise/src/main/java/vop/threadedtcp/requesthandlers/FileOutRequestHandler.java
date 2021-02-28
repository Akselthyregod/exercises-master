package vop.threadedtcp.requesthandlers;

import vop.serialio.Species;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class FileOutRequestHandler  extends AbstractRequestHandler{
    File file;

    public FileOutRequestHandler(Socket socket, String fileName) {
        super(socket);
        file= new File(fileName);
        System.out.println(file.exists());

    }

    @Override
    public void run() {
        System.out.println("RequestHandler started for den her " + socket.getPort());
            try (Scanner scanner = new Scanner(socket.getInputStream());
                 PrintWriter outputStream = new PrintWriter(new FileWriter(file,true),true);
                 PrintWriter clientWriter= new PrintWriter(socket.getOutputStream(),true)

            ) {
                clientWriter.println("hej serveren kører");
                System.out.println("tester om den kommre her til");
                String message = "";
                while (scanner.hasNextLine()) {
                    System.out.println(" test");
                    message += scanner.nextLine() + "\n";
                    outputStream.println(new Date());
                    outputStream.println("\t");
                    outputStream.println(super.socket.getInetAddress());
                    outputStream.println(":");
                    outputStream.println(super.socket.getPort());
                    outputStream.println("\t");
                    outputStream.println(message);
                }

            } catch (IOException e) {
                System.err.println("Error opening output file "
                        + file.getName() + ": " + e.getMessage());
                System.exit(0);
            }

    }
}
