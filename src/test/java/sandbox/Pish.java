package sandbox;

import framework.rest.models.github_contributors.MGithubResponseModel;
import framework.rest.requests.GetContributorsRequest;
import framework.rest.responses.GetContributorsResponse;
import org.testng.annotations.Test;

import java.io.IOException;

public class Pish {
    @Test
    public void test1() throws IOException {
        GetContributorsRequest getContributorsRequest = new GetContributorsRequest("docker", "distribution");
        GetContributorsResponse getContributorsResponse = getContributorsRequest.execute();
        MGithubResponseModel model = getContributorsResponse.getModel();
        System.out.println("");
    }
}
