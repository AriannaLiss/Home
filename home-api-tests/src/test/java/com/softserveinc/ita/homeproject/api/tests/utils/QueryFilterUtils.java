package com.softserveinc.ita.homeproject.api.tests.utils;

import com.softserveinc.ita.homeproject.ApiException;

import java.util.StringJoiner;

public final class QueryFilterUtils {

    public static String getBetweenPredicate(String selector, String arg1, String arg2) {
        StringJoiner joiner = new StringJoiner(", ", "(", ")");
        joiner.add(arg1);
        joiner.add(arg2);
        return selector
                .concat(FilterPredicateEnum.BETWEEN.getPredicate())
                .concat(joiner.toString());
    }

    public static String getIgnoreCaseLikePredicate(String selector, String arg) {
        return selector
                .concat(FilterPredicateEnum.IGNORE_CASE_LIKE.getPredicate())
                .concat(arg);
    }

    public static String createExceptionMessage(ApiException exception){
        return new StringBuilder()
                .append("{\"responseCode\":")
                .append(exception.getCode())
                .append(",\"errorMessage\":\"")
                .append(exception.getMessage())
                .append("\"}").toString();
    }

}
