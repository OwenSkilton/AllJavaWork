package classdesign.coupling;

public class Service {

    // Service dependent on repo
    // Association is a HAS-A relationship. The service HAS-A repo
    // HAS-A association are either classdesign.composition or aggregation
    // Aggregation implies that the dependency CAN exist without the dependent
    // Composition implies that the dependency CANNOT exist without the dependent

    // If repo is a concrete class (one that can instantiated) then the classdesign.coupling between is TIGHT
    // Means that changes to the repo may break the service (Want to avoid)
    // If repo is an abstract class then the classdesign.coupling between is LOOSE
    // This means that changes to the repo should not break the service
    private Repo repo;

    // This constructor suggest aggregation as the repo has to exist before being passed in
    public Service(Repo repo) {
        this.repo = repo;
    }
}
