package task3;

class HourlyPayWorker extends Worker {
    private double hourlySalary;

    HourlyPayWorker(int id, String name, double hourlySalary) {
        super(id, name);
        this.hourlySalary = hourlySalary;
    }

    @Override
    double getMonthlySalary() {
        return 20.8 * 8 * hourlySalary;
    }

    @Override
    String toFileString() {
        return String.format("hourly %d %s %f", id, name, hourlySalary);
    }
}
