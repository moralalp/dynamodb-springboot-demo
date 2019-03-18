package com.company.dynamodbspringbootdemo.repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.company.dynamodbspringbootdemo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    public UserDAOImpl(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    @Override
    public List<User> findById(String theId) {
        HashMap<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":v1", new AttributeValue().withS(theId));

        DynamoDBQueryExpression scanExpression = new DynamoDBQueryExpression()
                .withKeyConditionExpression("Id = :v1")
                .withExpressionAttributeValues(eav);

        List<User> replies =  dynamoDBMapper.query(User.class, scanExpression);
        return replies;
    }

    @Override
    public List<User> findAll() {
        return dynamoDBMapper.scan(User.class, new DynamoDBScanExpression());
    }

    @Override
    public void save(User theUser) {
        dynamoDBMapper.save(theUser);
    }

    @Override
    public void deleteUser(User theUser) {
        dynamoDBMapper.delete(theUser);
    }
}
