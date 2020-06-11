package com.github.jinahya.jsonrpc.glue.v2.jackson;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Iterator;

import static com.github.jinahya.jsonrpc.glue.JsonrpcGlueTests.applyResourceStream;
import static com.github.jinahya.jsonrpc.glue.v2.jackson.JacksonTests.applyObjectMapper;
import static com.github.jinahya.jsonrpc.util.BeanValidationUtils.requireValid;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class JacksonRequestMessageGlueTest {

    @Test
    void jsonrpc_org_positional_parameters_01_request() throws IOException {
        applyResourceStream(
                "jsonrpc.org/positional_parameters_01_request.json",
                s -> {
                    return applyObjectMapper(m -> {
                        try {
                            final JacksonRequestMessageGlue value = m.readValue(s, JacksonRequestMessageGlue.class);
                            log.debug("value: {}", value);
                            requireValid(value);
                            assertEquals("subtract", value.getMethod().asText());
                            assertTrue(value.getParams() instanceof ArrayNode);
                            assertEquals(42, value.getParams().get(0).asInt());
                            assertEquals(23, value.getParams().get(1).asInt());
                            assertTrue(value.getId() instanceof IntNode);
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
    void jsonrpc_org_positional_parameters_02_request() throws IOException {
        applyResourceStream(
                "jsonrpc.org/positional_parameters_02_request.json",
                s -> {
                    return applyObjectMapper(m -> {
                        try {
                            final JacksonRequestMessageGlue value = m.readValue(s, JacksonRequestMessageGlue.class);
                            log.debug("value: {}", value);
                            requireValid(value);
                            assertEquals("subtract", value.getMethod().asText());
                            assertTrue(value.getParams() instanceof ArrayNode);
                            assertEquals(23, value.getParams().get(0).asInt());
                            assertEquals(42, value.getParams().get(1).asInt());
                            assertTrue(value.getId() instanceof IntNode);
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
    void jsonrpc_org_named_parameters_01_request() throws IOException {
        applyResourceStream(
                "jsonrpc.org/named_parameters_01_request.json",
                s -> {
                    return applyObjectMapper(m -> {
                        try {
                            final JacksonRequestMessageGlue value = m.readValue(s, JacksonRequestMessageGlue.class);
                            log.debug("value: {}", value);
                            requireValid(value);
                            assertEquals("subtract", value.getMethod().asText());
                            assertTrue(value.getParams() instanceof ObjectNode);
                            final Iterator<String> fieldNames = value.getParams().fieldNames();
                            assertEquals("subtrahend", fieldNames.next());
                            assertEquals("minuend", fieldNames.next());
                            assertFalse(fieldNames.hasNext());
                            assertEquals(23, value.getParams().get("subtrahend").asInt());
                            assertEquals(42, value.getParams().get("minuend").asInt());
                            assertTrue(value.getId() instanceof IntNode);
                            assertEquals(3, value.getId().asInt());
                        } catch (final IOException ioe) {
                            throw new UncheckedIOException(ioe);
                        }
                        return null;
                    });
                }
        );
    }

    @Test
    void jsonrpc_org_named_parameters_02_request() throws IOException {
        applyResourceStream(
                "jsonrpc.org/named_parameters_02_request.json",
                s -> {
                    return applyObjectMapper(m -> {
                        try {
                            final JacksonRequestMessageGlue value = m.readValue(s, JacksonRequestMessageGlue.class);
                            log.debug("value: {}", value);
                            requireValid(value);
                            assertEquals("subtract", value.getMethod().asText());
                            assertTrue(value.getParams() instanceof ObjectNode);
                            final Iterator<String> fieldNames = value.getParams().fieldNames();
                            assertEquals("minuend", fieldNames.next());
                            assertEquals("subtrahend", fieldNames.next());
                            assertFalse(fieldNames.hasNext());
                            assertEquals(42, value.getParams().get("minuend").asInt());
                            assertEquals(23, value.getParams().get("subtrahend").asInt());
                            assertTrue(value.getId() instanceof IntNode);
                            assertEquals(4, value.getId().asInt());
                        } catch (final IOException ioe) {
                            throw new UncheckedIOException(ioe);
                        }
                        return null;
                    });
                }
        );
    }

    @Test
    void notification_01_request() throws IOException {
        applyResourceStream(
                "jsonrpc.org/notification_01_request.json",
                s -> {
                    return applyObjectMapper(m -> {
                        try {
                            final JacksonRequestMessageGlue value = m.readValue(s, JacksonRequestMessageGlue.class);
                            log.debug("value: {}", value);
                            requireValid(value);
                            assertEquals("update", value.getMethod().asText());
                            assertTrue(value.getParams() instanceof ArrayNode);
                            assertEquals(1, value.getParams().get(0).asInt());
                            assertEquals(2, value.getParams().get(1).asInt());
                            assertEquals(3, value.getParams().get(2).asInt());
                            assertEquals(4, value.getParams().get(3).asInt());
                            assertEquals(5, value.getParams().get(4).asInt());
                            assertNull(value.getId());
                        } catch (final IOException ioe) {
                            throw new UncheckedIOException(ioe);
                        }
                        return null;
                    });
                }
        );
    }

    @Test
    void notification_02_request() throws IOException {
        applyResourceStream(
                "jsonrpc.org/notification_02_request.json",
                s -> {
                    return applyObjectMapper(m -> {
                        try {
                            final JacksonRequestMessageGlue value = m.readValue(s, JacksonRequestMessageGlue.class);
                            log.debug("value: {}", value);
                            requireValid(value);
                            assertEquals("foobar", value.getMethod().asText());
                            assertNull(value.getParams());
                        } catch (final IOException ioe) {
                            throw new UncheckedIOException(ioe);
                        }
                        return null;
                    });
                }
        );
    }

    @Test
    void non_existent_method_request() throws IOException {
        applyResourceStream(
                "jsonrpc.org/non_existent_method_request.json",
                s -> {
                    return applyObjectMapper(m -> {
                        try {
                            final JacksonRequestMessageGlue value = m.readValue(s, JacksonRequestMessageGlue.class);
                            log.debug("value: {}", value);
                            requireValid(value);
                            assertEquals("foobar", value.getMethod().asText());
                            assertNull(value.getParams());
                            assertEquals(1, value.getId().asInt());
                        } catch (final IOException ioe) {
                            throw new UncheckedIOException(ioe);
                        }
                        return null;
                    });
                }
        );
    }
}