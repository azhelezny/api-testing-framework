package sandbox;

import framework.rest.models.github_contributors.MGithubResponseModel;
import framework.rest.requests.GetContributorsRequest;
import framework.rest.responses.GetContributorsResponse;

import java.io.IOException;

public class Sandbox {
    public static void main(String... args) throws IOException {
        GetContributorsRequest getContributorsRequest = new GetContributorsRequest("docker", "distribution");
        GetContributorsResponse getContributorsResponse = getContributorsRequest.execute();
        MGithubResponseModel model = getContributorsResponse.getModel();
        System.out.println("");
    }
}