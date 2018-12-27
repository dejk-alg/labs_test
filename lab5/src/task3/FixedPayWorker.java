package task3;

class FixedPayWorker extends Worker {

    private double monthlySalary;

    FixedPayWorker(int id, String name, double monthlySalary) {
        super(id, name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    double getMonthlySalary() {
        return monthlySalary;
    }

    @Override
    String toFileString() {
        return String.format("fixed %d %s %f", id, name, monthlySalary);
    }
}
