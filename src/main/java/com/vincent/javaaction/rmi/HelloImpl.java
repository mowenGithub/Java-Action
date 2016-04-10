package com.vincent.javaaction.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Vincent on 4/10/16.
 */
public class HelloImpl extends UnicastRemoteObject implements IHello {


    protected HelloImpl() throws RemoteException {
    }

    @Override
    public String sayHelloWorld() throws RemoteException {
        return "Hello World!";
    }

    @Override
    public String sayHelloToSomeOne(String someOne) throws RemoteException {
        return "Hello" + someOne + "!";
    }
}
