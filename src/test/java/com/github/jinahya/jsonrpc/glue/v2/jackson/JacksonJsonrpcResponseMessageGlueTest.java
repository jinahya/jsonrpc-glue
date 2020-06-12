package com.github.jinahya.jsonrpc.glue.v2.jackson;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.UncheckedIOException;

import static com.github.jinahya.jsonrpc.BeanValidations.requireValid;
import static com.github.jinahya.jsonrpc.JacksonTests.applyObjectMapper;
import static com.github.jinahya.jsonrpc.JsonrpcTests.applyResourceStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@Slf4j
class JacksonJsonrpcResponseMessageGlueTest {

    @Test
    void jsonrpc_org_positional_parameters_01_response() throws IOException {
        applyResourceStream(
                "examples/jsonrpc.org/positional_parameters_01_response.json",
                s -> {
                    return applyObjectMapper(m -> {
                        try {
                            final JacksonJsonrpcResponseMessageGlue value = m.readValue(s, JacksonJsonrpcResponseMessageGlue.class);
                            log.debug("value: {}", value);
                            requireValid(value);
                            assertEquals(19, value.getResult().asInt());
                            assertEquals(1, value.getId().asInt());
                        } catch (final IOException ioe) {
                            throw new UncheckedIOException(ioe);
                        }
                        return null;
                    });
                }
        );
    }

    @Test
    void jsonrpc_org_positional_parameters_02_response() throws IOException {
        applyResourceStream(
                "examples/jsonrpc.org/positional_parameters_02_response.json",
                s -> {
                    return applyObjectMapper(m -> {
                        try {
                            final JacksonJsonrpcResponseMessageGlue value = m.readValue(s, JacksonJsonrpcResponseMessageGlue.class);
                            log.debug("value: {}", value);
                            requireValid(value);
                            assertEquals(-19, value.getResult().asInt());
                            assertEquals(2, value.getId().asInt());
                        } catch (final IOException ioe) {
                            throw new UncheckedIOException(ioe);
                        }
                        return null;
                    });
                }
        );
    }

    @Test
    void non_existent_method_response() throws IOException {
        applyResourceStream(
                "examples/jsonrpc.org/non_existent_method_response.json",
                s -> {
                    return applyObjectMapper(m -> {
                        try {
                            final JacksonJsonrpcResponseMessageGlue message = m.readValue(s, JacksonJsonrpcResponseMessageGlue.class);
                            log.debug("value: {}", message);
                            requireValid(message);
                            assertNull(message.getResult());
                            assertNotNull(message.getError());
                            final JacksonJsonrpcResponseMessageErrorGlue error = m.reader().readValue(
                                    message.getError(), JacksonJsonrpcResponseMessageErrorGlue.class);
                            assertEquals(-32601, error.getCode().asInt());
                            assertEquals("Method not found", error.getMessage().asText());
                            assertEquals(1, message.getId().asInt());
                        } catch (final IOException ioe) {
                            throw new UncheckedIOException(ioe);
                        }
                        return null;
                    });
                }
        );
    }
}