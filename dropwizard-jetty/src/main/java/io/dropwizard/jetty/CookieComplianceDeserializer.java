package io.dropwizard.jetty;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.eclipse.jetty.http.CookieCompliance;

import java.io.IOException;

public class CookieComplianceDeserializer extends JsonDeserializer<CookieCompliance> {
    @Override
    public CookieCompliance deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return CookieCompliance.valueOf(jsonParser.getText());
    }
}
