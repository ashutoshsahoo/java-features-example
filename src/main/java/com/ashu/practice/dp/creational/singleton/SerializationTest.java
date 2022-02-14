package com.ashu.practice.dp.creational.singleton;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class SerializationTest {

    static SingletonStatic instanceOne = SingletonStatic.getInstance();
    //static SingletonEnum instanceOne = SingletonEnum.INSTANCE;

    public static void main(String[] args) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
             ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"))) {
            // Serialize to a file
            out.writeObject(instanceOne);

            instanceOne.setI(20);

            // Serialize to a file
            SingletonStatic instanceTwo = (SingletonStatic) in.readObject();
           // SingletonEnum instanceTwo = (SingletonEnum) in.readObject();

            log.info("" + instanceOne.getI());
            log.info("" + instanceTwo.getI());

        } catch (IOException | ClassNotFoundException e) {
            log.error(e.getMessage(), e);
        }
    }
}
/*

 SingletonStatic O/P without readResolve

01:24:40.923 [main] INFO  c.a.p.dp.singleton.SerializationTest.main(25) - 20
01:24:40.923 [main] INFO  c.a.p.dp.singleton.SerializationTest.main(26) - 10

 SingletonStatic O/P after adding readResolve

01:24:06.835 [main] INFO  c.a.p.dp.singleton.SerializationTest.main(25) - 20
01:24:06.835 [main] INFO  c.a.p.dp.singleton.SerializationTest.main(26) - 20


 Enum O/P

01:22:44.036 [main] INFO  c.a.p.dp.singleton.SerializationTest.main(25) - 20
01:22:44.052 [main] INFO  c.a.p.dp.singleton.SerializationTest.main(26) - 20

 */