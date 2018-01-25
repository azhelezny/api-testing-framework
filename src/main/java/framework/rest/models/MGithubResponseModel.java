package framework.rest.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import framework.rest.models.commons.MGithubResponse;

import java.io.IOException;

public class MGithubResponseModel {

    private MGithubResponse[] responses;

    public MGithubResponseModel(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        responses = mapper.readValue(json, MGithubResponse[].class);
    }

    public MGithubResponse[] getResponses() {
        return responses;
    }
}
