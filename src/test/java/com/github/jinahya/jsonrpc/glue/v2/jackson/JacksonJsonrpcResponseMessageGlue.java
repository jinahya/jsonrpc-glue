package com.github.jinahya.jsonrpc.glue.v2.jackson;

import com.fasterxml.jackson.databind.node.BaseJsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

class JacksonJsonrpcResponseMessageGlue
        extends JacksonJsonrpcMessageGlue
        implements IJacksonJsonrpcResponseMessageGlue {

    @Override
    public String toString() {
        return super.toString() + "{"
               + "result=" + getResult()
               + ",error=" + getError()
               + "}";
    }

    private BaseJsonNode result;

    private ObjectNode error;
}
