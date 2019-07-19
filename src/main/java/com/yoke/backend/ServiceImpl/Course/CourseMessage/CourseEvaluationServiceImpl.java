package com.yoke.backend.ServiceImpl.Course.CourseMessage;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.yoke.backend.Service.Course.CourseMessage.CourseEvaluationService;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/15
 * @description:
 **/
@Service
public class CourseEvaluationServiceImpl implements CourseEvaluationService {

    @Override
    public List<Map> allEvaluation()
    {
        MongoClient mongoClient=new MongoClient(new MongoClientURI("mongodb://127.0.0.1:27017/"));
        MongoDatabase mongoDatabase=mongoClient.getDatabase("yoke");
        MongoCollection<Document> collection=mongoDatabase.getCollection("evaluation");
        FindIterable<Document> findIterable=collection.find();
        MongoCursor<Document> iterator=findIterable.iterator();
        List<Map> result=new ArrayList<>();
        while(iterator.hasNext())
        {
            Map map=iterator.next();
            map.remove("_id");
            result.add(map);
        }
        return result;
    }

    @Override
    public List<Map> findEvaluationByCourseId(String course_id)
    {
        MongoClient mongoClient=new MongoClient(new MongoClientURI("mongodb://127.0.0.1:27017/"));
        MongoDatabase mongoDatabase=mongoClient.getDatabase("yoke");
        MongoCollection<Document> collection=mongoDatabase.getCollection("evaluation");
        FindIterable<Document> findIterable=collection.find(new BasicDBObject("course_id",course_id));
        MongoCursor<Document> iterator=findIterable.iterator();
        List<Map> result=new ArrayList<>();
        while(iterator.hasNext())
        {
            Map map=iterator.next();
            map.remove("_id");
            result.add(map);
        }
        return result;
    }

    @Override
    public void addCourseEvaluation(String json)
    {
        MongoClient mongoClient=new MongoClient(new MongoClientURI("mongodb://127.0.0.1:27017/"));
        MongoDatabase mongoDatabase=mongoClient.getDatabase("yoke");
        MongoCollection<Document> collection=mongoDatabase.getCollection("evaluation");
        Document document=Document.parse(json);
        collection.insertOne(document);
    }

}
