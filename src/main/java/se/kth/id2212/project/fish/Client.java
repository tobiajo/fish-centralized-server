package se.kth.id2212.project.fish;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Client {

    private static final String DEFAULT_SHARED_FILE_PATH = "shared";
    private static final String DEFAULT_SERVER_ADDRESS = "localhost";
    private static final String DEFAULT_SERVER_PORT = "6958"; // FI5H => 6-9-5-8

    private String sharedFilePath, serverAddress, serverPort;

    public Client(String sharedFilePath, String serverAddress, String serverPort) {
        if (sharedFilePath != null) {
            this.sharedFilePath = sharedFilePath;
        } else {
            this.sharedFilePath = DEFAULT_SHARED_FILE_PATH;
        }
        if (serverAddress != null) {
            this.serverAddress = serverAddress;
        } else {
            this.serverAddress = DEFAULT_SERVER_ADDRESS;
        }
        if (serverPort != null) {
            this.serverPort = serverPort;
        } else {
            this.serverPort = DEFAULT_SERVER_PORT;
        }
    }

    public void run() {
        System.out.println("FISH client started.\n   path | " + sharedFilePath +
                "\naddress | " + serverAddress + "\n   port | " + serverPort);
        List<String> fileList = getFileList();
        // TODO: Implement a Client-Server protocol
    }

    private List<String> getFileList() {
        ArrayList<String> ret = new ArrayList<>();

        System.out.println("\nShared files:");
        File dir = new File(sharedFilePath);
        dir.mkdir();
        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                System.out.println(f.getName());
                ret.add(f.getName());
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        new Client(args[0], args[1], args[2]).run();
    }
}