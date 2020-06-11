package com.github.jinahya.jsonrpc.glue.v2;

public abstract class JsonrpcResponseMessageGlue<VersionType, ResultType, ErrorType, IdType>
        extends JsonrpcMessageGlue<VersionType, IdType>
        implements IJsonrpcResponseMessageGlue<VersionType, ResultType, ErrorType, IdType> {

    @Override
    public String toString() {
        return super.toString() + "{"
               + "result=" + getResult()
               + ",error=" + getError()
               + "}";
    }

    private ResultType result;

    private ErrorType error;
}
