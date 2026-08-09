package com.example.creation.Builder;

public class QueryBuilder {
    private String query;

    private QueryBuilder(){
        this.query = "";
    }

    QueryBuilder select(String column){
        this.query = this.query + "select " + column;
        return this;
    }

    QueryBuilder from(String table){
        this.query = this.query + " from " + table;
        return this;
    }

    QueryBuilder where(String condition){
        this.query = this.query + " where " + condition;
        return this;
    }

    QueryBuilder orderBy(String column){
        this.query = this.query + " orderBy " + column;
        return this;
    }

    String builder(){
        return this.query;
    }
}
