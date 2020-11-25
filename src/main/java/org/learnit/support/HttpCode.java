package org.learnit.support;

public enum HttpCode {
    OK(200),
    ERROR(300),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    INTERNAL_SERVER_ERROR(500);

    private final Integer value;

    private HttpCode(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return this.value;
    }

    public String toString() {
        return this.value.toString();
    }

    public String msg() {
        return new String("HTTPCODE_" + this.value);
    }
}

