package com.vincent.javaaction.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by Vincent on 4/10/16.
 */
public class HelloClient {
    public static void main(String[] args) {
        try {
            IHello rhello = (IHello) Naming.lookup("rmi://localhost:8888/RHello");
            System.out.println(rhello.sayHelloWorld());
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
