package designpatterns.builder;

import org.junit.jupiter.api.Test;

public class ClientTest {

    @Test
    public void testClientBuilder(){
        var client = new Client.Builder()
                .city("London")
                .street("Lane")
                .lastName("Yeet")
                .firstName("McYeet")
                .email("Boii@Yeet.com")
                .houseNum("69")
                .postcode("SA1")
                .build();
    }
}
