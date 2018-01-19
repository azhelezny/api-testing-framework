package sandbox;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sun.org.apache.xpath.internal.SourceTree;
import framework.enums.RestMethod;
import framework.rest.RestRequest;
import framework.rest.RestResponse;
import framework.utils.RestEngine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sandbox {
    public static void main(String... args) throws IOException {
        String companyName = "spring-projects";
        String projectName = "spring-framework";
        RestRequest githubRequest = new RestRequest("https://api.github.com/repos/" + companyName + "/" + projectName + "/stats/contributors", RestMethod.GET);
        RestResponse response = RestEngine.sendRequest(githubRequest);
        List<String> contributors = new ArrayList<String>();
        JsonNode rootNode = new ObjectMapper().readTree(response.getBody());
        for (int a = 0; a < rootNode.size(); a++) {
            JsonNode data = rootNode.get(a);
            JsonNode weeks = data.get("weeks");
            int modifications = 0;
            long w;
            for (int i = 0; i < weeks.size(); i++) {
                w = weeks.get(i).get("w").asLong();
                if (w < 1500422400)
                    continue;
                modifications += weeks.get(i).get("c").asInt();
                modifications += weeks.get(i).get("a").asInt();
                modifications += weeks.get(i).get("d").asInt();
            }
            if (modifications > 0)
                contributors.add(data.get("author").get("login").asText());
        }
        System.out.println("list of contributors for project of " + companyName + " named " + projectName + " since Wed, 19 Jul 2017 00:00:00 GMT");
        for (String contributor : contributors)
            System.out.println(contributor);
        System.out.println(contributors.size());
    }
}
