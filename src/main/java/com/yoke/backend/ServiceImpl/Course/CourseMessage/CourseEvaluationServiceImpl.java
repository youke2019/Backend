package com.yoke.backend.ServiceImpl.Course.CourseMessage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.yoke.backend.Dao.CourseMessage.CourseEvaluateDao;
import com.yoke.backend.Dao.CourseMessage.Praise.CourseEvaluatePraiseDao;
import com.yoke.backend.Entity.CourseMessage.CourseEvaluation;
import com.yoke.backend.Entity.CourseMessage.Praise.CourseEvaluationPraise;
import com.yoke.backend.Service.Course.CourseMessage.CourseEvaluationService;
import com.yoke.backend.Service.Course.CourseService;
import com.yoke.backend.repository.CourseMessage.CourseEvaluationRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private CourseService courseService;

    @Autowired
    CourseEvaluateDao courseEvaluateDao;

    @Autowired
    CourseEvaluatePraiseDao courseEvaluatePraiseDao;
    @Override
    public List<CourseEvaluation> allEvaluation()
    {
        /*MongoClient mongoClient=new MongoClient(new MongoClientURI("mongodb://root:XunKeTeam2019@127.0.0.1:27017/"));
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
        return result;*/
        return null;
    }

    @Override
    public List<CourseEvaluation> findEvaluationByCourseId(String course_id,String user_id)
    {
        /**
         * 服务器 mongodb://root:XunKeTeam2019@127.0.0.1:27017/
         */
        MongoClient mongoClient=new MongoClient(new MongoClientURI("mongodb://root:XunKeTeam2019@127.0.0.1:27017/"));
        MongoDatabase mongoDatabase=mongoClient.getDatabase("yoke");
        MongoCollection<Document> collection=mongoDatabase.getCollection("evaluation");
        List<CourseEvaluation> courseEvaluationList=courseEvaluateDao.findByCourse(course_id);
        for(CourseEvaluation courseEvaluation:courseEvaluationList)
        {
            FindIterable<Document> findIterable=collection.find(new BasicDBObject("evaluate_id",courseEvaluation.getEvaluate_id()));
            MongoCursor<Document> iterator=findIterable.iterator();
            if(iterator.hasNext())
            {
                Map map=iterator.next();
                map.remove("_id");
                courseEvaluation.setEvaluate_content(map);
            }
            for(CourseEvaluationPraise courseEvaluationPraise:courseEvaluation.getCourseEvaluationPraiseList())
            {
                if(courseEvaluation.getUser_id().equals(user_id))
                    courseEvaluation.setCurrent_user_praise(true);
            }
        }
        return courseEvaluationList;
    }

    @Override
    public void addCourseEvaluation(String json)
    {
        JSONObject jsonObject= JSON.parseObject(json);
        CourseEvaluation courseEvaluation=new CourseEvaluation(jsonObject.getString("course_id"),jsonObject.getString("user_id"));
        courseEvaluation=courseEvaluateDao.save(courseEvaluation);
        jsonObject.put("evaluate_id",courseEvaluation.getEvaluate_id());
        MongoClient mongoClient=new MongoClient(new MongoClientURI("mongodb://root:XunKeTeam2019@127.0.0.1:27017/"));
        MongoDatabase mongoDatabase=mongoClient.getDatabase("yoke");
        MongoCollection<Document> collection=mongoDatabase.getCollection("evaluation");
        json=JSON.toJSONString(jsonObject);
        Document document=Document.parse(json);
        collection.insertOne(document);
    }

    public void praiseCourseEvaluation(Integer course_evaluate_id,String user_id)
    {
        CourseEvaluationPraise courseEvaluationPraise=new CourseEvaluationPraise(course_evaluate_id,user_id);
        courseEvaluatePraiseDao.save(courseEvaluationPraise);
        CourseEvaluation courseEvaluation=courseEvaluateDao.findById(course_evaluate_id);
        courseEvaluation.setEvaluate_praise_point(courseEvaluation.getEvaluate_praise_point()+1);
    }
    public void unpraiseCourseEvaluation(Integer coures_evaluate_id,String user_id)
    {
        courseEvaluatePraiseDao.delete(coures_evaluate_id, user_id);
        CourseEvaluation courseEvaluation=courseEvaluateDao.findById(coures_evaluate_id);
        courseEvaluation.setEvaluate_praise_point(courseEvaluation.getEvaluate_praise_point()-1);
    }

}
