package localisation;

import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalisationTest {

    @Test
    public void testLocale() {
        assertEquals("en_GB", Locale.getDefault().toString());
        Locale.setDefault(Locale.FRANCE);
        assertEquals("fr_FR", Locale.getDefault().toString());
    }

    @Test
    public void testResourceBundle1() {
        // By default the ResouceBundle will look for props files on the classpath that begin with Translation
        var resourceBundle = ResourceBundle.getBundle("Translation");
        assertEquals("Welcome", resourceBundle.getString("welcome"));
    }

    @Test
    public void testResourceBundle2() {
        // By default the ResouceBundle will look for props files on the classpath that begin with Translation
        Locale.setDefault(Locale.FRANCE);
        var resourceBundle = ResourceBundle.getBundle("Translation");
        assertEquals("Bienvenue", resourceBundle.getString("welcome"));
    }
}
