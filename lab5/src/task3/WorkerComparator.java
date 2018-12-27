package task3;

import java.util.Comparator;

public class WorkerComparator implements Comparator<Worker> {
    public int compare(Worker worker1, Worker worker2) {
        if (worker1.getMonthlySalary() - worker2.getMonthlySalary() > 0) return 1;
        else if (worker1.getMonthlySalary() - worker2.getMonthlySalary() < 0) return -1;
        return worker1.getName().compareTo(worker2.getName());
    }
}
