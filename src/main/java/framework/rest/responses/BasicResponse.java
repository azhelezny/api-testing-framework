package framework.rest.responses;

import framework.rest.RestResponseStructure;

class BasicResponse {
    private RestResponseStructure response;

    protected BasicResponse(RestResponseStructure response) {
        this.response = response;
    }

    public RestResponseStructure getResponse() {
        return response;
    }
}
