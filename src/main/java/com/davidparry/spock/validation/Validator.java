package com.davidparry.spock.validation;

public interface Validator<T> {

    void validate(T value);

}
