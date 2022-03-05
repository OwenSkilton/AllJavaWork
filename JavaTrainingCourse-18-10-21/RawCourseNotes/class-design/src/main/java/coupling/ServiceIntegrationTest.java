package coupling;

import org.junit.jupiter.api.BeforeEach;

public class ServiceIntegrationTest {

    private Service service;

    @BeforeEach
    public void testServiceInstantiation() {
        service = new Service(new InMemoryRepo());
    }
}
