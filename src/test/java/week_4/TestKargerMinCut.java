package week_4;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestKargerMinCut {
    @Test
    public void testKargerMinCutBasic() {
        KargerMinCut kmc = new KargerMinCut();
        Map<Integer, List<Integer>> testCase = new HashMap<>() {{
            put(1, Stream.of(2, 3, 4).collect(Collectors.toList()));
            put(2, Stream.of(1).collect(Collectors.toList()));
            put(3, Stream.of(1, 4).collect(Collectors.toList()));
            put(4, Stream.of(1, 3).collect(Collectors.toList()));
        }};
        Integer expected = 1;
        Integer actual = kmc.findMinCut(testCase);
        assert expected.equals(actual);
    }

    @Test
    public void testKargerMinCutTxtInput() {
        KargerMinCut kmc = new KargerMinCut();
        Map<Integer, List<Integer>> testCase = utils.readTxtFileInput.readTxtFileIntoGraph("graph_week_4.txt");
        Integer actual = kmc.findMinCut(testCase);
        System.out.println(actual);
    }
}
