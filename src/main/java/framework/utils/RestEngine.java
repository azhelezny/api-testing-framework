package framework.utils;

import framework.rest.RestRequest;
import framework.rest.RestResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * class with static methods to interact with REST API of client application
 */
public class RestEngine {
    private static RestTemplate restTemplate = new RestTemplate();

    public static RestResponse sendRequest(RestRequest request) {
        HttpEntity<String> httpEntity = new HttpEntity<String>(request.getBody(), RestUtils.getSpringHeaders(request.getHeaders()));
        ResponseEntity<String> responseEntity = restTemplate.exchange(request.getUrl(), request.getMethod().getHttpMethod(), httpEntity, String.class);
        RestResponse response = new RestResponse();
        response.setCode(responseEntity.getStatusCodeValue());
        response.setBody(responseEntity.getBody());
        return response;
    }
}
