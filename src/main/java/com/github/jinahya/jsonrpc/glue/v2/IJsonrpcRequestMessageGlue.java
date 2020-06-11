package com.github.jinahya.jsonrpc.glue.v2;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import static com.github.jinahya.jsonrpc.glue.v2.JsonrpcMessageGlueHelper.get;
import static com.github.jinahya.jsonrpc.glue.v2.JsonrpcMessageGlueHelper.set;

public interface IJsonrpcRequestMessageGlue<VersionType, MethodType, ParamsType, IdType>
        extends IJsonrpcMessageGlue<VersionType, IdType> {

    String PROPERTY_NAME_METHOD = "method";

    String PROPERTY_NAME_PARAMS = "params";

    String METHOD_NAME_PREFIX_RESERVED_FOR_RPC_INTERNAL = "rpc.";

    @AssertTrue
    boolean isMethodContextuallyValid();

    // rpc.
    @AssertFalse
    boolean isMethodReservedForRpcInternal();

    @AssertTrue
    boolean isParamsContextuallyValid();

    @NotNull
    @SuppressWarnings({"unchecked"})
    default MethodType getMethod() {
        return (MethodType) get(getClass(), PROPERTY_NAME_METHOD, this);
    }

    default void setMethod(final MethodType method) {
        set(getClass(), PROPERTY_NAME_METHOD, this, method);
    }

    // MAY be omitted.
    @SuppressWarnings({"unchecked"})
    default ParamsType getParams() {
        return (ParamsType) get(getClass(), PROPERTY_NAME_PARAMS, this);
    }

    default void setParams(final ParamsType params) {
        set(getClass(), PROPERTY_NAME_PARAMS, this, params);
    }
}
