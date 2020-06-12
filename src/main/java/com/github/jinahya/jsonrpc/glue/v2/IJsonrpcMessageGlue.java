package com.github.jinahya.jsonrpc.glue.v2;

import javax.validation.constraints.AssertTrue;

import static com.github.jinahya.jsonrpc.glue.v2.JsonrpcMessageGlueHelper.get;

public interface IJsonrpcMessageGlue<JsonrpcType, IdType> extends IJsonrpcObjectGlue {

    String MEMBER_NAME_JSONRPC = "jsonrpc";

    String MEMBER_NAME_ID = "id";

    String MEMBER_VALUE_JSONRPC = "2.0";

    @AssertTrue
    boolean isJsonrpcContextuallyValid();

    @AssertTrue
    boolean isIdContextuallyValid();

    @SuppressWarnings({"unchecked"})
    default JsonrpcType getJsonrpc() {
        return (JsonrpcType) get(getClass(), MEMBER_NAME_JSONRPC, this);
    }

    default void setJsonrpc(final JsonrpcType jsonrpc) {
        JsonrpcMessageGlueHelper.set(getClass(), MEMBER_NAME_JSONRPC, this, jsonrpc);
    }

    @SuppressWarnings({"unchecked"})
    default IdType getId() {
        return (IdType) get(getClass(), MEMBER_NAME_ID, this);
    }

    default void setId(final IdType id) {
        JsonrpcMessageGlueHelper.set(getClass(), MEMBER_NAME_ID, this, id);
    }
}
