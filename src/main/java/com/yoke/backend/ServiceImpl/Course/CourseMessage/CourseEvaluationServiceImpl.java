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
import com.yoke.backend.Dao.Course.CourseRecommendDao;
import com.yoke.backend.Dao.CourseMessage.CourseEvaluateDao;
import com.yoke.backend.Dao.CourseMessage.Praise.CourseEvaluatePraiseDao;
import com.yoke.backend.Entity.Course.CourseRecommendModel;
import com.yoke.backend.Entity.CourseMessage.CourseEvaluation;
import com.yoke.backend.Entity.CourseMessage.Praise.CourseEvaluationPraise;
import com.yoke.backend.Entity.Tools.TimeUtil;
import com.yoke.backend.Service.Course.CourseMessage.CourseEvaluationService;
import com.yoke.backend.Service.Course.CourseService;
import org.apache.mahout.cf.taste.impl.model.MemoryIDMigrator;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    private CourseRecommendDao courseRecommendDao;

    @Override
    public List<CourseEvaluation> allEvaluation()
    {
        return courseEvaluateDao.findAll();
    }

    @Override
    public List<CourseEvaluation> findEvaluationByCourseId(String course_id,String user_id)
    {
        /**
         * 服务器 mongodb://root:XunKeTeam2019@127.0.0.1:27017/
         */
        MongoClient mongoClient=new MongoClient(new MongoClientURI("mongodb://127.0.0.1:27017/"));
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
        /**
         * 存放在mysql 的course_evaluate中，用作数据存储与表关联
          */
        courseEvaluation=courseEvaluateDao.save(courseEvaluation);

        /**
         * 存放在mysql中的course_recommend_data_model表中，用来作为课程推荐的数据源
         */
        String suser_id,scourse_id,sevaluate_time;
        Integer evaluate_point;
        long luser_id,lcourse_id,levaluate_time;

        suser_id=jsonObject.getString("user_id");
        scourse_id=jsonObject.getString("course_id");
        evaluate_point=jsonObject.getInteger("evaluate_point");
        sevaluate_time= TimeUtil.CurrentTime();

        MemoryIDMigrator stringToLong=new MemoryIDMigrator();
        luser_id=stringToLong.toLongID(suser_id);
        lcourse_id=stringToLong.toLongID(scourse_id);
        levaluate_time=stringToLong.toLongID(sevaluate_time);
        stringToLong.storeMapping(luser_id,suser_id);
        stringToLong.storeMapping(lcourse_id,scourse_id);     //保存映射关系
        stringToLong.storeMapping(levaluate_time,sevaluate_time);

        CourseRecommendModel courseRecommendModel=new CourseRecommendModel(luser_id,lcourse_id,evaluate_point,levaluate_time);
        courseRecommendDao.save(courseRecommendModel);

        /**
         * 存放在mongodb中的evaluate文档中，用来存储评测的用户自定义扩展项
         */
        jsonObject.put("evaluate_id",courseEvaluation.getEvaluate_id());
        MongoClient mongoClient=new MongoClient(new MongoClientURI("mongodb://127.0.0.1:27017/"));
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
