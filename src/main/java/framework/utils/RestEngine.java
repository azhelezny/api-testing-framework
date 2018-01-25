package framework.utils;

import framework.rest.RestRequestStructure;
import framework.rest.RestResponseStructure;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * class with static methods to interact with REST API of client application
 */
public class RestEngine {
    private static RestTemplate restTemplate = new RestTemplate();

    public static RestResponseStructure sendRequest(RestRequestStructure request) {
        HttpEntity<String> httpEntity = new HttpEntity<String>(request.getBody(), RestUtils.getSpringHeaders(request.getHeaders()));
        ResponseEntity<String> responseEntity = restTemplate.exchange(request.getUrl(), request.getMethod().getHttpMethod(), httpEntity, String.class);
        RestResponseStructure response = new RestResponseStructure();
        response.setCode(responseEntity.getStatusCodeValue());
        response.setBody(responseEntity.getBody());
        return response;
    }
}