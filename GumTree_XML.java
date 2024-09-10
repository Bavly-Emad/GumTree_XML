import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.*;
import org.xmlunit.diff.Comparison;
import org.xmlunit.diff.ComparisonResult;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String xml1 = "<root><element1 attr1='value1'/></root>";
        String xml2 = "<root><element1 attr1='value2' attr2='value3'/><element2/></root>";

        Diff diff = DiffBuilder.compare(xml1)
                .withTest(xml2)
                .withDifferenceEvaluator(DifferenceEvaluators.Default)
                .checkForSimilar()
                .ignoreWhitespace()
                .build();

        Map<ComparisonType, Integer> differenceCounts = new EnumMap<>(ComparisonType.class);
        int insertions = 0;
        int updates = 0;
        int deletions = 0;

        if (diff.hasDifferences()) {
            List<Difference> differences = (List<Difference>) diff.getDifferences();
            for (Difference difference : differences) {
                Comparison comparison = difference.getComparison();
                ComparisonType type = comparison.getType();
                differenceCounts.put(type, differenceCounts.getOrDefault(type, 0) + 1);

                ComparisonResult result = difference.getResult();
                switch (result) {
                    case DIFFERENT:
                        if (comparison.getControlDetails().getValue() == null) {
                            insertions++;
                        } else if (comparison.getTestDetails().getValue() == null) {
                            deletions++;
                        } else {
                            updates++;
                        }
                        break;
                    default:
                        break;
                }
            }
        }

        System.out.println("Differences by type:");
        for (Map.Entry<ComparisonType, Integer> entry : differenceCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nNumber of Insertions: " + insertions);
        System.out.println("Number of Updates: " + updates);
        System.out.println("Number of Deletions: " + deletions);
    }
}
