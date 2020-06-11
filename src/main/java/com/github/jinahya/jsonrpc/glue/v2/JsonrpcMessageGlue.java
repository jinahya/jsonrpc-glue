package com.github.jinahya.jsonrpc.glue.v2;

public abstract class JsonrpcMessageGlue<VersionType, IdType>
        implements IJsonrpcMessageGlue<VersionType, IdType> {

    @Override
    public String toString() {
        return super.toString() + "{"
               + "jsonrpc=" + getJsonrpc()
               + ",id=" + getId()
               + "}";
    }

    private VersionType jsonrpc;

    private IdType id;
}
