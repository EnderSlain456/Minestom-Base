package net.enderslain;

import net.enderslain.properties.PropertiesManager;
import net.minestom.server.MinecraftServer;

public class Main {
    public static void main(String[] args) {

        // init Properties
        PropertiesManager propertiesManager = new PropertiesManager();

        // Load properties from the resources folder
        if (propertiesManager.loadProperties()) {
            System.out.println("Loaded Properties: " + propertiesManager.getProperties());
        } else {
            System.out.println("Failed to load properties.");
        }

        // Save Properties

        if (propertiesManager.saveProperties()) {
            System.out.println("Properties saved successfully.");
        } else {
            System.out.println("Failed to save properties.");
        }

        // Initialise the Server and getting IP and Port from Properties.yml
        MinecraftServer mcServer = MinecraftServer.init();
        String ip = propertiesManager.getProperties().getIP();
        int port = propertiesManager.getProperties().getPort();

        // Starting the Server on the IP and Port gotten from the Properties.yml
        mcServer.start(ip, port);


    }
}