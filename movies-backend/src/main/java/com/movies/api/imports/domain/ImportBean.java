package com.movies.api.imports.domain;

public class ImportBean {

    private String[] values;

    public ImportBean(String[] values) {
        this.values = values;
    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }
}
