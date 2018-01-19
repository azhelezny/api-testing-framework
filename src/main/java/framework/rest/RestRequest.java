package framework.rest;

import framework.enums.RestMethod;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RestRequest {

    private String url;
    private RestMethod method;
    private Map<String, List<String>> headers;
    private String body;

    public RestRequest(String url, RestMethod method) {
        this.url = url;
        this.method = method;
    }

    public void addHeader(String headerName, String... headerParams) {
        List<String> headerOptions = Arrays.asList(headerParams);
        if (headers.containsKey(headerName))
            headerOptions.addAll(headers.get(headerName));
        headers.put(headerName, headerOptions);
    }

    public void setBody(String body) {
        this.body = body;
    }


    public String getUrl() {
        return url;
    }

    public RestMethod getMethod() {
        return method;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }
}
