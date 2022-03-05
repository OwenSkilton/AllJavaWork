package coupling;

public class Service {

    // The Service is dependent on the Repo
    // The assoc. is a HAS-A type; the Service HAS-A Repo
    // HAS-A associations are either composition or aggregation
    // Aggregation implies that the dependency CAN exist without the dependent
    // Composition implies that the dependency CANNOT exist without the dependent

    // If Repo is a concrete class (one that can be instantiated) then the coupling between the classes is TIGHT
    // This means that changes to the Repo may break the Service (this is to be avoided)
    // If Repo is an abstract class then the coupling between the classes is LOOSE
    // This means that changes to the Repo should NOT break the Service
    private Repo repo;

    // This constructor suggests aggregation because the Repo has to exist before it can be passed in
    // Aggregation is probably RIGHT in this particular case
    public Service(Repo repo) {
        this.repo = repo;
    }

    // This constructor suggests composition because the Repo is created internally
    // Composition is probably WRONG in this particular case
//    public Service() {
//        this.repo = new Repo();
//    }

    public void addNew(String record) {
        repo.insertRecord(record);
    }
}
