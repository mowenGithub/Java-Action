package com.vincent.javaaction.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Vincent on 4/10/16.
 */
public interface IHello extends Remote {

    public String sayHelloWorld() throws RemoteException;

    public String sayHelloToSomeOne(String someOne) throws RemoteException;
}
