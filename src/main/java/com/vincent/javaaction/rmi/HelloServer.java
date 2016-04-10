package com.vincent.javaaction.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by Vincent on 4/10/16.
 */
public class HelloServer {
    public static void main(String[] args) {
        try {
            IHello rhello = new HelloImpl();
            LocateRegistry.createRegistry(8888);
            Naming.bind("rmi://localhost:8888/RHello", rhello);

            System.out.println("bind success");
        } catch (RemoteException e) {
            System.out.println("create object failure");
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            System.out.println("Already bound");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            System.out.println("malformed url");
            e.printStackTrace();
        }
    }
}
