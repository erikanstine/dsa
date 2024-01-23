package week_4;

import org.junit.jupiter.api.Test;

public class TestRSelect {
    @Test
    public void testRSelectLowest() {
        RSelect rs = new RSelect();
        Integer[] testCase = {3, 2, 5, 1, 7, 8, 4, 6};
        Integer expected = 1;
        Integer actual = rs.randomSelect(testCase, 0);
        assert expected.equals(actual);
    }

    @Test
    public void testRSelectHighest() {
        RSelect rs = new RSelect();
        Integer[] testCase = {3, 2, 5, 1, 7, 8, 4, 6};
        Integer expected = 8;
        Integer actual = rs.randomSelect(testCase, 7);
        assert expected.equals(actual);
    }

    @Test
    public void testRSelectThird() {
        RSelect rs = new RSelect();
        Integer[] testCase = {3, 2, 5, 1, 7, 8, 4, 6};
        Integer expected = 4;
        Integer actual = rs.randomSelect(testCase, 3);
        assert expected.equals(actual);
    }
}
