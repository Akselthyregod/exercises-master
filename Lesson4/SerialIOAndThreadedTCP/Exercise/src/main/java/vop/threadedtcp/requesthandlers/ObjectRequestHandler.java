package vop.threadedtcp.requesthandlers;

import vop.serialio.Species;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ObjectRequestHandler extends AbstractRequestHandler {



    public ObjectRequestHandler(Socket socket) {
        super(socket);

    }

    @Override
    public void run() {
        System.out.println("RequestHandler started for den her " + socket.getPort());

        try(ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(System.out)
            ) {

            Object obj = objectInputStream.readObject();
            Species speciesObj = (Species) obj;
            objectOutputStream.writeObject(speciesObj.toString());


            objectOutputStream.close();


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
