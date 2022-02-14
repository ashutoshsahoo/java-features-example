package com.ashu.practice.dp.structural.adapter;

interface SocketAdapter {
    Volt get120Volts();

    Volt get12Volts();

    Volt get4Volts();
}

record SocketAdapterImpl(Socket socket) implements SocketAdapter {

    @Override
    public Volt get120Volts() {
        return convertVolt(2);
    }

    @Override
    public Volt get12Volts() {
        return convertVolt(20);
    }

    @Override
    public Volt get4Volts() {
        return convertVolt(60);
    }

    private Volt convertVolt(int i) {
        return new Volt(socket.getVolt().getVolts() / i);
    }
}

public class AbstractFactoryExample {
    public static void main(String[] args) {
        Socket socket = new Socket();
        SocketAdapter socketAdapter = new SocketAdapterImpl(socket);
        System.out.println("Result 4volt " + socketAdapter.get4Volts());
        System.out.println("Result 12volt " + socketAdapter.get12Volts());
        System.out.println("Result 120volt " + socketAdapter.get120Volts());
    }
}

class Volt {
    private int volts;

    public Volt(int volts) {
        this.volts = volts;
    }

    public int getVolts() {
        return volts;
    }

    public void setVolts(int volts) {
        this.volts = volts;
    }

    @Override
    public String toString() {
        return "Volt{" +
                "volts=" + volts +
                '}';
    }
}

class Socket {
    public Volt getVolt() {
        return new Volt(240);
    }


}

