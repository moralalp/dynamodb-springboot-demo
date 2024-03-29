package com.company.dynamodbspringbootdemo.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "User")
public class User {

    @DynamoDBAutoGeneratedKey
    @DynamoDBHashKey(attributeName = "Id")
    private String id;

    @DynamoDBRangeKey
    @DynamoDBAttribute(attributeName = "FirstName")
    private String firstName;

    public User() {

    }

    public User(String id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
