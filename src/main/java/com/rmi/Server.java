package com.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) throws RemoteException {
        System.out.println("create World clock remote service...");

        WorldClock worldClock = new WorldClockService();

        WorldClock skeleton = (WorldClock) UnicastRemoteObject.exportObject(worldClock, 0);

        Registry registry = LocateRegistry.createRegistry(1099);

        registry.rebind("WorldClock", skeleton);
    }
}
