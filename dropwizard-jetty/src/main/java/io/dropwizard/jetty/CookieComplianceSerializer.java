package io.dropwizard.jetty;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.eclipse.jetty.http.CookieCompliance;

import java.io.IOException;

public class CookieComplianceSerializer extends JsonSerializer<CookieCompliance> {
    @Override
    public void serialize(CookieCompliance cookieCompliance, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(cookieCompliance.getName());
    }
}
