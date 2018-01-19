package framework.enums;

import org.springframework.http.HttpMethod;

public enum RestMethod {
    GET(HttpMethod.GET),
    PUT(HttpMethod.PUT),
    POST(HttpMethod.POST),
    DELETE(HttpMethod.DELETE);

    private HttpMethod httpMethod;

    RestMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }
}
