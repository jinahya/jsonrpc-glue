package com.github.jinahya.jsonrpc.glue.v2;

import javax.validation.constraints.AssertTrue;

import static com.github.jinahya.jsonrpc.glue.v2.JsonrpcMessageGlueHelper.get;
import static com.github.jinahya.jsonrpc.glue.v2.JsonrpcMessageGlueHelper.set;

public interface IJsonrpcResponseMessageGlue<VersionType, ResultType, ErrorType, IdType>
        extends IJsonrpcMessageGlue<VersionType, IdType> {

    String MEMBER_NAME_RESULT = "result";

    String MEMBER_NAME_ERROR = "error";

    String MEMBER_NAME_ERROR_CODE = "code";

    String MEMBER_NAME_ERROR_MESSAGE = "message";

    String MEMBER_NAME_ERROR_DATA = "data";

    @AssertTrue
    boolean isResultContextuallyValid();

    @AssertTrue
    boolean isErrorContextuallyValid();

    /**
     * Returns the current value of {@value #MEMBER_NAME_RESULT} property.
     *
     * @return the current value of {@value #MEMBER_NAME_RESULT} property.
     */
    @SuppressWarnings({"unchecked"})
    default ResultType getResult() {
        return (ResultType) get(getClass(), MEMBER_NAME_RESULT, this);
    }

    default void setResult(final ResultType result) {
        set(getClass(), MEMBER_NAME_RESULT, this, result);
        if (result != null) {
            setError(null);
        }
    }

    // MAY be omitted.
    @SuppressWarnings({"unchecked"})
    default ErrorType getError() {
        return (ErrorType) get(getClass(), MEMBER_NAME_ERROR, this);
    }

    default void setError(final ErrorType error) {
        set(getClass(), MEMBER_NAME_ERROR, this, error);
        if (error != null) {
            setResult(null);
        }
    }
}
