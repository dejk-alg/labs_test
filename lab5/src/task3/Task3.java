package task3;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {

    private static ArrayList<Worker> createList() {
        ArrayList<Worker> workers = new ArrayList<>();

        workers.add(new FixedPayWorker(6, "bbb", 10000));
        workers.add(new HourlyPayWorker(5, "ddd", 230));
        workers.add(new FixedPayWorker(3, "ccc", 16000));
        workers.add(new HourlyPayWorker(8, "fff", 120));
        workers.add(new FixedPayWorker(14, "aaa", 17000));
        workers.add(new HourlyPayWorker(4, "eee", 170));

        return workers;
    }

    private static void writeWorkerListToFile(ArrayList<Worker> workers, String filename) {
        try {
            PrintWriter writer = new PrintWriter(filename, "UTF-8");
            for (Worker worker : workers)
                writer.println(worker.toFileString());

            writer.close();
        }
        catch (Exception e) {}
    }

    private static  ArrayList<Worker> readWorkerListFromFile(String filename) {
        ArrayList<Worker> workers = new ArrayList<>();
        File file = new File(filename);
        try {
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNext())
                workers.add(Worker.fromScanner(fileReader));
            System.out.println("\nSuccessfully read information from " + filename);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return workers;
    }

    public static void run() {
        //ArrayList<Worker> workers = createList();
        // writeWorkerListToFile(workers, "workers.txt");
        ArrayList<Worker> workers = readWorkerListFromFile("workers.txt");
        workers.sort(new WorkerComparator());

        List<Worker> minSalaryWorkers = workers.subList(0, 3);
        List<Worker> maxSalaryWorkers = workers.subList(workers.size() - 5, workers.size());

        System.out.println("\nWorkers with max salary: ");
        for (Worker worker: maxSalaryWorkers) System.out.println(worker.toString());

        System.out.println("\nWorkers with min salary: ");
        for (Worker worker: minSalaryWorkers) System.out.println(worker.toString());
    }
}
