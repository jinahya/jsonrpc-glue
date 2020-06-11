package com.github.jinahya.jsonrpc.glue.v2;

public abstract class JsonrpcRequestMessageGlue<VersionType, MethodType, ParamsType, IdType>
        extends JsonrpcMessageGlue<VersionType, IdType>
        implements IJsonrpcRequestMessageGlue<VersionType, MethodType, ParamsType, IdType> {

    @Override
    public String toString() {
        return super.toString() + "{"
               + "method=" + getMethod()
               + ",params=" + getParams()
               + "}";
    }

    private MethodType method;

    // may be omitted
    private ParamsType params;
}
