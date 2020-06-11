package com.github.jinahya.jsonrpc.glue.v2;

public abstract class JsonrpcResponseMessageErrorGlue<CodeType, MessageType, DataType>
        implements IJsonrpcResponseMessageErrorGlue<CodeType, MessageType, DataType> {

    @Override
    public String toString() {
        return super.toString() + "{"
               + "code" + getCode()
               + ",result=" + getMessage()
               + ",data=" + getData()
               + "}";
    }

    // MUST be an integer
    private CodeType code;

    // SHOULD be limited to a concise single sentence.
    private MessageType message;

    // Primitive or Structured
    // may be omitted
    private DataType data;
}
