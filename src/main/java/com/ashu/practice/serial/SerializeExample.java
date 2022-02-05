package com.ashu.practice.serial;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class SerializeExample {
    public static void main(String[] args) {
        Employee emp = new Employee(1, "ashutosh", 1001L);
        log.debug(emp.toString());
        Employee.setCompany("tcs");
        log.debug(emp.toString());
        // serialize
        log.info("Serialization start");
        try (
                FileOutputStream fos = new FileOutputStream("employees.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(emp);
            log.info("Serialization complete");
        } catch (IOException e) {
            log.error(e.getMessage());
        }


        // deserialize
        log.info("Deserialization start");
        try (
                FileInputStream fis = new FileInputStream("employees.ser");
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            Object readObject = ois.readObject();
            if (readObject instanceof Employee emp2) {
                log.debug(emp2.toString());
            }
            log.info("Deserialization complete");
        } catch (IOException | ClassNotFoundException e) {
            log.error(e.getMessage());
        }
    }
/*
10:23:05.219 [main] INFO  com.ashu.practice.serial.Employee.<init>(62) - Employee constructor with params
10:23:05.235 [main] DEBUG c.a.practice.serial.SerializeExample.main(13) - Employee{id=1, name='ashutosh', company='null', companyId='1001'}
10:23:05.235 [main] DEBUG c.a.practice.serial.SerializeExample.main(15) - Employee{id=1, name='ashutosh', company='tcs', companyId='1001'}
10:23:05.235 [main] INFO  c.a.practice.serial.SerializeExample.main(17) - Serialization start
10:23:05.235 [main] INFO  com.ashu.practice.serial.Employee.writeReplace(123) - write resolve called
10:23:05.235 [main] INFO  com.ashu.practice.serial.Employee.writeObject(104) - Serializing employee
10:23:05.235 [main] INFO  c.a.practice.serial.SerializeExample.main(23) - Serialization complete
10:23:05.235 [main] INFO  c.a.practice.serial.SerializeExample.main(30) - Deserialization start
10:23:05.250 [main] INFO  com.ashu.practice.serial.Employee.readObject(113) - Deserializing employee
10:23:05.250 [main] INFO  com.ashu.practice.serial.Employee.readResolve(129) - read resolve method called
10:23:05.250 [main] INFO  com.ashu.practice.serial.Employee.validateObject(135) - Validating employee object
10:23:05.250 [main] DEBUG c.a.practice.serial.SerializeExample.main(37) - Employee{id=1, name='ashutosh', company='tcs', companyId='1001'}
10:23:05.250 [main] INFO  c.a.practice.serial.SerializeExample.main(39) - Deserialization complete
 */
}

@Getter
@Setter
@Slf4j
class Employee implements Serializable, ObjectInputValidation, Comparable<Employee> {
    @Serial
    private static final long serialVersionUID = 1L;
    private static String company;
    private int id;
    private String name;
    private transient long companyId;

    public Employee() {
        log.info("Employee default constructor");
    }

    public Employee(int id, String name, long companyId) {
        log.info("Employee constructor with params");
        this.id = id;
        this.name = name;
        this.companyId = companyId;
    }

    public static void setCompany(String company) {
        Employee.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (getId() != employee.getId()) return false;
        return getName() != null ? getName().equals(employee.getName()) : employee.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + Employee.company + '\'' +
                ", companyId='" + companyId + '\'' +
                '}';
    }

    // custom serialization

    @Serial
    private void writeObject(ObjectOutputStream oos) throws IOException {
        log.info("Serializing employee");
        oos.writeInt(id);
        oos.writeUTF(name);
        oos.writeLong(companyId);
        oos.writeUTF(Employee.company);
    }

    @Serial
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        log.info("Deserializing employee");
        ois.registerValidation(this, 0);
        id = ois.readInt();
        name = ois.readUTF();
        companyId = ois.readLong();
        Employee.company = ois.readUTF();
    }

    @Serial
    private Object writeReplace() throws ObjectStreamException {
        log.info("write resolve called");
        return this;
    }

    @Serial
    private Object readResolve() throws ObjectStreamException {
        log.info("read resolve method called");
        return this;
    }

    @Override
    public void validateObject() throws InvalidObjectException {
        log.info("Validating employee object");
        if (!name.equals("ashutosh")) {
            throw new InvalidObjectException("Name not ashutosh");
        }
    }

    @Override
    public int compareTo(Employee o) {
        return name.compareTo(o.getName());
    }
}