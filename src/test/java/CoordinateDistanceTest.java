import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import sun.applet.Main;

import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;

public class CoordinateDistanceTest {


    @Test
    public void testWhenInputCoordinateisOrigin(){
        CoordinateDistance coordinateDistance=new CoordinateDistance();
        Map<String, Double> sortedListOfDistanceFromOrigin = coordinateDistance
                .getSortedListOfDistanceFromOrigin("0", "0");
        Assert.assertThat(Collections.min(sortedListOfDistanceFromOrigin.values()),
                CoreMatchers.equalTo(sortedListOfDistanceFromOrigin.values().iterator().next()));
    }

    @Test
    public void testWhenInputCoordinateisRandom(){
        CoordinateDistance coordinateDistance=new CoordinateDistance();
        Map<String, Double> sortedListOfDistanceFromOrigin = coordinateDistance
                .getSortedListOfDistanceFromOrigin("2", "6");
        Assert.assertThat(Collections.min(sortedListOfDistanceFromOrigin.values()),
                CoreMatchers.equalTo(sortedListOfDistanceFromOrigin.values().iterator().next()));
    }

}
