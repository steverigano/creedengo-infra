package org.greencodeinitiative.creedengo.infra.integration.tests;

import org.junit.jupiter.api.Test;
import org.sonarqube.ws.Issues;
import org.sonarqube.ws.Measures;

import java.util.List;
import java.util.Map;

import static java.util.Optional.ofNullable;
import static org.assertj.core.api.Assertions.assertThat;

class GCIRulesIT extends GCIRulesBase {

    @Test
    void testMeasuresAndIssues() {
        String projectKey = analyzedProjects.get(0).getProjectKey();

        Map<String, Measures.Measure> measures = getMeasures(projectKey);

        assertThat(ofNullable(measures.get("code_smells")).map(Measures.Measure::getValue).map(Integer::parseInt).orElse(0))
                .isGreaterThan(1);

        List<Issues.Issue> projectIssues = searchIssuesForComponent(projectKey, null).getIssuesList();
        assertThat(projectIssues).isNotEmpty();

    }

    @Test
    void testGCI1024() {
        String filePath = "src/main/java/org/greencodeinitiative/creedengo/infra/checks/UseOfProbesCheck.java";
        int[] startLines = new int[]{18};
        int[] endLines = new int[]{18};
        String ruleId = "creedengo-infra:GCI1024";
        String ruleMsg = "Please configure the probes to ensure the application is healthy and read.";
        checkIssuesForFile(filePath, ruleId, ruleMsg, startLines, endLines);

    }

}
