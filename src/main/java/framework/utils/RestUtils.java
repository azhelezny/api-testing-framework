package framework.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import java.util.List;
import java.util.Map;

public class RestUtils {
    public static HttpHeaders getSpringHeaders(Map<String, List<String>> headers) {
        HttpHeaders springHeaders = new HttpHeaders();
        if (headers == null)
            return springHeaders;
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            StringBuilder headerValue = new StringBuilder();
            if (entry.getValue().size() > 0) {
                for (String hv : entry.getValue())
                    headerValue.append(hv).append(";");
                headerValue.deleteCharAt(headerValue.length() - 1);
            }
            springHeaders.add(entry.getKey(), headerValue.toString());
        }
        return springHeaders;
    }
}
