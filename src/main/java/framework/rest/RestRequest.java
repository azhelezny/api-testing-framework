package framework.rest;

import framework.QaException;
import framework.enums.RestMethod;

import java.util.ArrayList;
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

    public void putHeader(String headerName, String... headerParams) {
        headers.put(headerName, Arrays.asList(headerParams));
    }

    public void addHeader(String headerName, String... headerParams) {
        if (this.headers.containsKey(headerName))
            throw new QaException("Requested header " + headerName + " already exists, try to rewrite it's value with putHeader method or add new value with addHeaderValues method");
        this.putHeader(headerName, headerParams);
    }

    public void addHeaderValues(String headerName, String... headerParams) {
        if (!this.headers.containsKey(headerName))
            throw new QaException("Requested header " + headerName + " doesn't exist, you can add new header using addHeader or putHeader methods");
        List<String> headerOptions = new ArrayList<String>();
        headerOptions.addAll(headers.get(headerName));
        headerOptions.addAll(Arrays.asList(headerParams));
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
