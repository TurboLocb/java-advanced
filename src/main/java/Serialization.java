import objects.ProxyForSerialization;

import java.io.*;

public class Serialization {

    /*
        Тестовый метод
    */
    public static void main(String[] args) throws Exception {

        ProxyForSerialization[] proxys = new ProxyForSerialization[10];

        for (int i = 0; i < 10; i++) {
            proxys[i] = new ProxyForSerialization("255.255.255.25" + i, 8080 + i);
        }

        //= new ProxyForSerialization("255.255.255.255", 8080);

        FileOutputStream fos = new FileOutputStream("files/proxy");
        ObjectOutputStream ous = new ObjectOutputStream(fos);
        //ous.writeObject(proxy);
        for (ProxyForSerialization p : proxys) {
            ous.writeObject(p);
        }
        ous.close();

        FileInputStream fis = new FileInputStream("files/proxy");
        ObjectInputStream ois = new ObjectInputStream(fis);
        //ProxyForSerialization proxy1 = (ProxyForSerialization) ois.readObject();

        ProxyForSerialization[] proxies1 = new ProxyForSerialization[10];

        for (ProxyForSerialization p : proxies1) {
            p = (ProxyForSerialization) ois.readObject();
            System.out.println(p.getIp() + " " + p.getPort());
        }

        ois.close();

        //System.out.println(proxy1.getIp() + " " + proxy1.getPort());
    }
}
