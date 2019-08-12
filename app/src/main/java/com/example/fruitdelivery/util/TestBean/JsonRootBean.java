package com.example.fruitdelivery.util.TestBean;


import java.util.List;

public class JsonRootBean {

    private boolean error;
    private List<Results> results;
    public void setError(boolean error) {
        this.error = error;
    }
    public boolean getError() {
        return error;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }
    public List<Results> getResults() {
        return results;
    }

}