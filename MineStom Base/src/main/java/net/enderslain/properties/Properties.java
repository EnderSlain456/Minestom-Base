package net.enderslain.properties;

public class Properties {

    private String ip;
    private String motd;
    private int port;

    // Gets the IP
    public String getIP() {
        return ip;
    }
    // Sets the IP
    public void setIP (String ip) {
        this.ip = ip;
    }

    // Gets the Motd
    public String getMotd() {
        return motd;
    }

    // Sets the Motd
    public void setMotd(String motd) {
        this.motd = motd;
    }

    // Gets the Port
    public int getPort() {
        return port;
    }

    // Sets the Port
    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "Properties{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                ", motd='" + motd + '\'' +
                '}';
    }
}
