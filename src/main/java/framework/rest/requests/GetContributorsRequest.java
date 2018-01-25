package framework.rest.requests;

import framework.enums.RestMethod;
import framework.rest.RestRequestStructure;
import framework.rest.responses.GetContributorsResponse;

public class GetContributorsRequest extends RestRequestStructure {

    public GetContributorsRequest(String companyName, String projectName) {
        super(String.format("https://api.github.com/repos/%s/%s/stats/contributors", companyName, projectName), RestMethod.GET);
    }

    public GetContributorsResponse execute(){
       return new GetContributorsResponse(super.executeBasic());
    }
}
