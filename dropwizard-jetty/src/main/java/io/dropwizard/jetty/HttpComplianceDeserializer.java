package io.dropwizard.jetty;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.eclipse.jetty.http.HttpCompliance;

import java.io.IOException;

public class HttpComplianceDeserializer extends JsonDeserializer<HttpCompliance> {
    @Override
    public HttpCompliance deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return HttpCompliance.valueOf(jsonParser.getText());
    }
}
