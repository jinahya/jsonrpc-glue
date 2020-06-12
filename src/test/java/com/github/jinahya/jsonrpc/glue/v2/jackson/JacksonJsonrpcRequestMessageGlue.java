package com.github.jinahya.jsonrpc.glue.v2.jackson;

import com.fasterxml.jackson.databind.node.ContainerNode;
import com.fasterxml.jackson.databind.node.TextNode;

public class JacksonJsonrpcRequestMessageGlue
        extends JacksonJsonrpcMessageGlue
        implements IJacksonJsonrpcRequestMessageGlue {

    @Override
    public String toString() {
        return super.toString() + "{"
               + "method=" + getMethod()
               + ",params=" + getParams()
               + "}";
    }

    private TextNode method;

    // may be omitted
    private ContainerNode<?> params;
}
