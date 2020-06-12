package com.github.jinahya.jsonrpc.glue.v2;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import static com.github.jinahya.jsonrpc.glue.v2.JsonrpcMessageGlueHelper.get;
import static com.github.jinahya.jsonrpc.glue.v2.JsonrpcMessageGlueHelper.set;

public interface IJsonrpcResponseMessageErrorGlue<CodeType, MessageType, DataType> extends IJsonrpcObjectGlue {

    String PROPERTY_NAME_CODE = "code";

    String PROPERTY_NAME_MESSAGE = "message";

    String PROPERTY_NAME_DATA = "data";

    @AssertTrue
    boolean isCodeContextuallyValid();

    @AssertTrue
    boolean isMessageContextuallyValid();

    @AssertTrue
    boolean isDataContextuallyValid();

    // Number
    // MUST be an integer
    @NotNull
    @SuppressWarnings({"unchecked"})
    default CodeType getCode() {
        return (CodeType) get(getClass(), PROPERTY_NAME_CODE, this);
    }

    default void setCode(final CodeType code) {
        set(getClass(), PROPERTY_NAME_CODE, this, code);
    }

    // String
    // SHOULD be limited to a concise single sentence
    @NotNull
    @SuppressWarnings({"unchecked"})
    default MessageType getMessage() {
        return (MessageType) get(getClass(), PROPERTY_NAME_MESSAGE, this);
    }

    default void setMessage(final MessageType message) {
        set(getClass(), PROPERTY_NAME_MESSAGE, this, message);
    }

    // Primitive or Structured
    // may be omitted.
    @SuppressWarnings({"unchecked"})
    default DataType getData() {
        return (DataType) get(getClass(), PROPERTY_NAME_DATA, this);
    }

    default void setData(final DataType data) {
        set(getClass(), PROPERTY_NAME_DATA, this, data);
    }
}
