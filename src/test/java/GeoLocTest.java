import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class GeoLocTest {
    @Test
    public void testValidCityState1() throws IOException, InterruptedException {
        String result = GeoLocUtil.fetchLocation("Madison, WI");
        assertTrue(result.contains("Latitude") && result.contains("Longitude"));
    }

    @Test
    public void testValidCityState2() throws IOException, InterruptedException {
        String result = GeoLocUtil.fetchLocation("New York, NY");
        assertTrue(result.contains("Latitude") && result.contains("Longitude"));
    }

    @Test
    public void testValidCityState3() throws IOException, InterruptedException {
        String result = GeoLocUtil.fetchLocation("Los Angeles, CA");
        assertTrue(result.contains("Latitude") && result.contains("Longitude"));
    }

    @Test
    public void testValidZipCode1() throws IOException, InterruptedException {
        String result = GeoLocUtil.fetchLocation("12345");
        assertTrue(result.contains("Latitude") && result.contains("Longitude"));
    }

    @Test
    public void testValidZipCode2() throws IOException, InterruptedException {
        String result = GeoLocUtil.fetchLocation("11235");
        assertTrue(result.contains("Latitude") && result.contains("Longitude"));
    }

    @Test
    public void testValidZipCode3() throws IOException, InterruptedException {
        String result = GeoLocUtil.fetchLocation("92587");
        assertTrue(result.contains("Latitude") && result.contains("Longitude"));
    }

    @Test
    public void testInvalidInput() throws IOException, InterruptedException {
        String result = GeoLocUtil.fetchLocation("InvalidPlace");
        assertTrue(result.contains("No data found"));
    }
}
