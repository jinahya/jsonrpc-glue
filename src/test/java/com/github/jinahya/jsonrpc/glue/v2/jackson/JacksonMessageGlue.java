package com.github.jinahya.jsonrpc.glue.v2.jackson;

import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.ValueNode;
import com.github.jinahya.jsonrpc.glue.v2.JsonrpcMessageGlue;

abstract class JacksonMessageGlue
        extends JsonrpcMessageGlue<TextNode, ValueNode> {

}
