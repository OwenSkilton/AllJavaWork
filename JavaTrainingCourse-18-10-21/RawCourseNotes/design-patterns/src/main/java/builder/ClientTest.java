package builder;

import org.junit.jupiter.api.Test;

public class ClientTest {

    @Test
    public void testClientBuilder() {
        var client = new Client.Builder()
                .city("London")
                .street("Long Lane")
                .houseNumber("6")
                .postcode("EC1")
                .lastName("Bailey")
                .firstName("Stuart")
                .email("stuartb@stayahead.com")
                .build();
    }

    @Test
    public void testClientBuilderInStages() {
        var builder = new Client.Builder();
        builder.firstName("Stuart").lastName("Bailey");
        builder.email("stuartb@stayahead.com");
        builder.houseNumber("6").street("Long Lane").city("London").postcode("EC1");
        var client = builder.build();
    }
}
