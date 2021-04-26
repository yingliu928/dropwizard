package io.dropwizard.jetty;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.eclipse.jetty.http.HttpCompliance;

import java.io.IOException;

public class HttpComplianceSerializer extends JsonSerializer<HttpCompliance> {
    @Override
    public void serialize(HttpCompliance httpCompliance, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(httpCompliance.getName());
    }
}
