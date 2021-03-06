package com.yoke.backend.ServiceImpl.Course;

import com.yoke.backend.Dao.Course.CourseDao;
import com.yoke.backend.Dao.Course.CourseRecommendDao;
import com.yoke.backend.Entity.Course.CourseInfo;
import com.yoke.backend.Entity.Course.CourseRecommendModel;
import com.yoke.backend.Entity.CourseMessage.CourseEvaluation;
import com.yoke.backend.Entity.Tools.TimeUtil;
import com.yoke.backend.Entity.User.User;
import com.yoke.backend.Service.Course.CourseMessage.CourseEvaluationService;
import com.yoke.backend.Service.Course.CourseRecommendService;
import com.yoke.backend.Service.Course.CourseService;
import com.yoke.backend.Service.User.UserService;
import org.apache.mahout.cf.taste.impl.model.MemoryIDMigrator;
import org.apache.mahout.cf.taste.impl.model.jdbc.ReloadFromJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/29
 * @description:
 * Mahout DataMode 有两个来源，一个基于Mysql数据库，一个是基于文件。
 * 基于数据库的对于大数据效率极低，Mahout推荐使用Hadoop文件系统
 **/
@Service
public class CourseRecommendServiceImpl implements CourseRecommendService {
    @Autowired
    CourseEvaluationService courseEvaluationService;

    @Autowired
    CourseDao courseDao;

    @Autowired
    CourseRecommendDao courseRecommendDao;

    @Autowired
    CourseService courseService;

    @Autowired
    UserService userService;

    /**
     * 作为全局变量，保持映射的一致性与可返回性
     */
    MemoryIDMigrator stringToLong=new MemoryIDMigrator();



    final private Integer NEIGHBORHOOD_NUM = 10;

    @Resource(name = "mysqlDataModel")
    private JDBCDataModel jdbcDataModel;

    @Override
    public List<RecommendedItem> userBasedRecommend(String user_id,Integer size) {
        List<RecommendedItem> recommendedItems=null;
        try {
            /**
             * 将数据拿入内存，提升性能
             */
            ReloadFromJDBCDataModel dataModel = new ReloadFromJDBCDataModel(jdbcDataModel);
            UserSimilarity similarity = new EuclideanDistanceSimilarity(dataModel);
            NearestNUserNeighborhood neighborhood = new NearestNUserNeighborhood(NEIGHBORHOOD_NUM, similarity, dataModel);
            Recommender recommender = new CachingRecommender(new GenericUserBasedRecommender(dataModel, neighborhood, similarity));

            /**
             * 由于mahout的协同过滤包只支持long型的参数与long型的数据源，这里需要对用户ID进行转换
             */
            long luser_id=stringToLong.toLongID(user_id);
            System.out.println(luser_id);
            recommendedItems = recommender.recommend(luser_id, size);
            System.out.println(recommendedItems.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recommendedItems;
    }

    @Override
    public List<CourseInfo> popularRecommend(String user_id,Integer size)
    {
        List<CourseInfo> popularCourses=courseDao.popularGeneralCourse(user_id,size);
        for(CourseInfo course:popularCourses)
        {
            course.setClasses(null);
        }
        return popularCourses;
    }

    @Override
    public List<CourseInfo> courseRecommend(String user_id,Integer size)
    {
        /**
         * 课程号字符型数组，从RecommendedItem中抽取转换获得
         */
        List<String> userBasedRecommenedIdList=new ArrayList<>();
        /**
         * 最终的推荐结果
         */
        List<CourseInfo> courseRecommendList=new ArrayList<>();
        /**
         * 热门课程
         */
        List<CourseInfo> popularRecommendList=new ArrayList<>();
        /**
         * 用户协同过滤推荐课程的RecommendedItem
         */
        List<RecommendedItem> recommendedItemList=userBasedRecommend(user_id,size);

        /**
         * recommendedItem转化为IDstring
         */
        if(recommendedItemList!=null) {
            for (RecommendedItem recommendedItem : recommendedItemList) {
                long lcourse_id = recommendedItem.getItemID();
                String scourse_id = stringToLong.toStringID(lcourse_id);
                System.out.println(lcourse_id);
                System.out.println(scourse_id);
                userBasedRecommenedIdList.add(scourse_id);
            }

            /**
             * IDstrings 转化为课程列表
             */
            for (String course_id : userBasedRecommenedIdList) {
                if (course_id == null) continue;
                CourseInfo courseInfo = courseDao.findCourseInfoByCourseId(course_id);
                courseInfo.setClasses(null);                  //统一设置class为null
                courseRecommendList.add(courseInfo);
            }
        }

        /**
         * 如果推荐课程不足，补充热门课程
         */
        int userBasedSize;
        if(recommendedItemList!=null)
             userBasedSize=recommendedItemList.size();
        else
            userBasedSize=0;

        if(userBasedSize<size)
        {
            popularRecommendList=popularRecommend(user_id,size-userBasedSize);
            for(CourseInfo courseInfo:popularRecommendList)
            {
                courseRecommendList.add(courseInfo);
            }
        }
        return courseRecommendList;
    }

    @Override
    public void saveDataModel(String suser_id,String scourse_id,Integer evaluate_point)
    {
        long luser_id,lcourse_id,levaluate_time;
        String sevaluate_time;
        sevaluate_time= TimeUtil.CurrentTime();

        luser_id=stringToLong.toLongID(suser_id);
        lcourse_id=stringToLong.toLongID(scourse_id);
        levaluate_time=stringToLong.toLongID(sevaluate_time);
        stringToLong.storeMapping(luser_id,suser_id);
        stringToLong.storeMapping(lcourse_id,scourse_id);     //保存映射关系
        stringToLong.storeMapping(levaluate_time,sevaluate_time);

        CourseRecommendModel courseRecommendModel=new CourseRecommendModel(luser_id,lcourse_id,evaluate_point,levaluate_time);
        courseRecommendDao.save(courseRecommendModel);
    }

    @Override
    public void saveDataModel(String suser_id,String scourse_id,Integer evaluate_point,String evaluate_time)
    {
        long luser_id,lcourse_id,levaluate_time;

        luser_id=stringToLong.toLongID(suser_id);
        lcourse_id=stringToLong.toLongID(scourse_id);
        levaluate_time=stringToLong.toLongID(evaluate_time);
        stringToLong.storeMapping(luser_id,suser_id);
        stringToLong.storeMapping(lcourse_id,scourse_id);     //保存映射关系
        stringToLong.storeMapping(levaluate_time,evaluate_time);

        CourseRecommendModel courseRecommendModel=new CourseRecommendModel(luser_id,lcourse_id,evaluate_point,levaluate_time);
        courseRecommendDao.save(courseRecommendModel);
    }

    public String generateData()
    {
        List<User> userList=userService.findAll();
        List<CourseInfo> courseInfoList=courseService.findAll();
        for(CourseInfo courseInfo:courseInfoList)
        {
            courseInfo.setClasses(null);
        }
        Random random;
        CourseRecommendModel courseRecommendModel;
        for(User user:userList)
        {
            for(CourseInfo courseInfo:courseInfoList)
            {
                random=new Random();
                if(Math.abs(random.nextInt())%15!=0)
                    continue;
                String suser_id,scourse_id,sevaluate_time;
                Integer evaluate_point;
                long luser_id,lcourse_id,levaluate_time;

                suser_id=user.getId();
                System.out.println(suser_id);
                scourse_id=courseInfo.getCourse_id();
                random=new Random();
                evaluate_point=Math.abs(random.nextInt())%10;
                sevaluate_time= TimeUtil.CurrentTime();

                luser_id=stringToLong.toLongID(suser_id);
                System.out.println(luser_id);
                lcourse_id=stringToLong.toLongID(scourse_id);
                levaluate_time=stringToLong.toLongID(sevaluate_time);
                stringToLong.storeMapping(luser_id,suser_id);
                stringToLong.storeMapping(lcourse_id,scourse_id);     //保存映射关系
                stringToLong.storeMapping(levaluate_time,sevaluate_time);

                courseRecommendModel=new CourseRecommendModel(luser_id,lcourse_id,evaluate_point,levaluate_time);
                courseRecommendDao.save(courseRecommendModel);
            }
        }
        return "success";
    }

    public Integer loadData()
    {
        List<CourseEvaluation> courseEvaluationList=courseEvaluationService.allEvaluation();
        if(courseEvaluationList!=null)
        {
            for(CourseEvaluation courseEvaluation:courseEvaluationList)
            {
                String user_id=courseEvaluation.getUser_id();
                String course_id=courseEvaluation.getCourse_id();
                Integer evaluate_point=courseEvaluation.getEvaluate_point();
                String evaluate_time=courseEvaluation.getEvaluate_time();
                saveDataModel(user_id,course_id,evaluate_point,evaluate_time);
            }
        }
        return courseEvaluationList.size();
    }
}
