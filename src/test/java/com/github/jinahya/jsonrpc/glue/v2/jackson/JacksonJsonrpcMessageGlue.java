package com.github.jinahya.jsonrpc.glue.v2.jackson;

import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.ValueNode;

public abstract class JacksonJsonrpcMessageGlue
        implements IJacksonJsonrpcMessageGlue {

    @Override
    public String toString() {
        return super.toString() + "{"
               + "jsonrpc=" + getJsonrpc()
               + ",id=" + getId()
               + "}";
    }

    private TextNode jsonrpc;

    private ValueNode id;
}
