package com.yoke.backend.ServiceImpl.Course;

import com.yoke.backend.Dao.Course.CourseDao;
import com.yoke.backend.Entity.Course.CourseInfo;
import com.yoke.backend.Service.Course.CourseMessage.CourseEvaluationService;
import com.yoke.backend.Service.Course.CourseRecommendService;
import org.apache.mahout.cf.taste.impl.model.MemoryIDMigrator;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/29
 * @description:
 **/
@Service
public class CourseRecommendServiceImpl implements CourseRecommendService {
    @Autowired
    CourseEvaluationService courseEvaluationService;

    @Autowired
    CourseDao courseDao;

    final private Integer NEIGHBORHOOD_NUM = 10;

    @Resource(name = "mysqlDataModel")
    private DataModel dataModel;

    @Override
    public List<RecommendedItem> userBasedRecommend(String user_id,Integer size) {
        List<RecommendedItem> recommendedItems=null;
        try {
            UserSimilarity similarity = new EuclideanDistanceSimilarity(dataModel);
            NearestNUserNeighborhood neighborhood = new NearestNUserNeighborhood(NEIGHBORHOOD_NUM, similarity, dataModel);
            Recommender recommender = new CachingRecommender(new GenericUserBasedRecommender(dataModel, neighborhood, similarity));

            /**
             * 由于mahout的协同过滤包只支持long型的参数与long型的数据源，这里需要对用户ID进行转换
             */
            MemoryIDMigrator stringToLong=new MemoryIDMigrator();
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
        return courseDao.popularGeneralCourse(user_id, size);
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
        for(RecommendedItem recommendedItem:recommendedItemList)
        {
            long lcourse_id=recommendedItem.getItemID();
            MemoryIDMigrator stringToLong=new MemoryIDMigrator();
            String scourse_id=stringToLong.toStringID(lcourse_id);
            System.out.println(lcourse_id);
            System.out.println(scourse_id);
            userBasedRecommenedIdList.add(scourse_id);
        }

        /**
         * IDstrings 转化为课程列表
         */
        for(String course_id:userBasedRecommenedIdList)
        {
            CourseInfo courseInfo=courseDao.findCourseInfoByCourseId(course_id);
            courseRecommendList.add(courseInfo);
        }

        /**
         * 如果推荐课程不足，补充热门课程
         */
        int userBasedSize=recommendedItemList.size();
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

}
