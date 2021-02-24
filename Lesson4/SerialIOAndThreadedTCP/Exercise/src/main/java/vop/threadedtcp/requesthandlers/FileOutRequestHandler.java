package vop.threadedtcp.requesthandlers;

import vop.serialio.Species;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class FileOutRequestHandler  extends AbstractRequestHandler{
    File file;

    public FileOutRequestHandler(Socket socket, String fileName) {
        super(socket);
        file= new File(fileName);

    }

    public void writeToFile(String message){
        if(file.exists()){
            try (ObjectOutputStream outputStream = new ObjectOutputStream(
                    new FileOutputStream(file.getName(), true)) {
                @Override
                protected void writeStreamHeader() throws IOException {
                    reset();
                }
            }) {

            outputStream.writeObject(new Date());
            outputStream.writeUTF("\t");
            outputStream.writeObject(super.socket.getInetAddress());
            outputStream.writeUTF(":");
            outputStream.writeInt(super.socket.getPort());
            outputStream.writeUTF("\t");
            outputStream.writeUTF(message);



            } catch (IOException e) {
                System.err.println("Error opening output file "
                        + file.getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }
        else
            try (ObjectOutputStream outputStream = new ObjectOutputStream(
                    new FileOutputStream(file.getName(), true))) {
                outputStream.writeObject(new Date());
                outputStream.writeUTF("\t");
                outputStream.writeObject(super.socket.getInetAddress());
                outputStream.writeUTF(":");
                outputStream.writeInt(super.socket.getPort());
                outputStream.writeUTF("\t");
                outputStream.writeUTF(message);

            } catch (IOException e) {
                System.err.println("Error opening output file "
                        + file.getName() + ": " + e.getMessage());
                System.exit(0);
            }
    }

    @Override
    public void run() {
        System.out.println("RequestHandler started for den her " + socket.getPort());
        if(file.exists()){
            try ( Scanner scanner = new Scanner(socket.getInputStream());
                  ObjectOutputStream outputStream = new ObjectOutputStream(
                    new FileOutputStream(file.getName(), true)) {

                @Override
                protected void writeStreamHeader() throws IOException {
                    reset();
                }

            }) {
                String message="";
                while(scanner.hasNextLine()){
                    System.out.println(" test");
                    message+=scanner.nextLine() + "\n";
                }

                outputStream.writeObject(new Date());
                outputStream.writeUTF("\t");
                outputStream.writeObject(super.socket.getInetAddress());
                outputStream.writeUTF(":");
                outputStream.writeInt(super.socket.getPort());
                outputStream.writeUTF("\t");
                outputStream.writeUTF(message);



            } catch (IOException e) {
                System.err.println("Error opening output file "
                        + file.getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }
        else
            try (Scanner scanner=new Scanner(socket.getInputStream());
                 ObjectOutputStream outputStream = new ObjectOutputStream(
                    new FileOutputStream(file.getName(), true))) {
                String message="";
                while(scanner.hasNextLine()){
                    System.out.println("test");
                    message+=scanner.nextLine() + "\n";
                }
                outputStream.writeObject(new Date());
                outputStream.writeUTF("\t");
                outputStream.writeObject(super.socket.getInetAddress());
                outputStream.writeUTF(":");
                outputStream.writeInt(super.socket.getPort());
                outputStream.writeUTF("\t");
                outputStream.writeUTF(message);

            } catch (IOException e) {
                System.err.println("Error opening output file "
                        + file.getName() + ": " + e.getMessage());
                System.exit(0);
            }
    }
}
