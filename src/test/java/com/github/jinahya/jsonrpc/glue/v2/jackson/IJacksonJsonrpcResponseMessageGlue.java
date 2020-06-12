package com.github.jinahya.jsonrpc.glue.v2.jackson;

import com.fasterxml.jackson.databind.node.BaseJsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.ValueNode;
import com.github.jinahya.jsonrpc.glue.v2.IJsonrpcResponseMessageGlue;

import javax.validation.constraints.AssertTrue;

public interface IJacksonJsonrpcResponseMessageGlue
        extends IJsonrpcResponseMessageGlue<TextNode, BaseJsonNode, ObjectNode, ValueNode>,
                IJacksonJsonrpcMessageGlue {

    @Override
    default @AssertTrue boolean isResultContextuallyValid() {
        return true;
    }

    @Override
    default @AssertTrue boolean isErrorContextuallyValid() {
        return true;
    }
}
