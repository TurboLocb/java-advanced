package objects;

import java.io.Serializable;

public class ProxyForSerialization implements Serializable{
    String ip;
    int port;

    public ProxyForSerialization() {
    }

    public ProxyForSerialization(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
