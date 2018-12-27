package task3;

import java.io.IOException;
import java.util.Scanner;

abstract class Worker {
    int id;
    String name;

    Worker(int id, String name) {
        this.id = id;
        this.name = name;
    }

    String getName() {
        return name;
    }

    abstract double getMonthlySalary();

    @Override
    public String toString() {
        return String.format("id: %d\tname: %s\tmonthly salary: %f", id, name, getMonthlySalary());
    }

    abstract String toFileString();

    static Worker fromScanner(Scanner scanner) throws IOException {
        String type = scanner.next();
        int id = scanner.nextInt();
        String name = scanner.next();
        double salary = scanner.nextDouble();


        if (type.equals("fixed")) return new FixedPayWorker(id, name, salary);
        if (type.equals("hourly")) return new HourlyPayWorker(id, name, salary);
        throw new IOException("salary type not understood");
    }
}

