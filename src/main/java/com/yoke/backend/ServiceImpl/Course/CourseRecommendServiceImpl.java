package com.yoke.backend.ServiceImpl.Course;

import com.yoke.backend.Dao.Course.CourseDao;
import com.yoke.backend.Entity.Course.CourseInfo;
import com.yoke.backend.Service.Course.CourseMessage.CourseEvaluationService;
import com.yoke.backend.Service.Course.CourseRecommendService;
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
            //recommendedItems = recommender.recommend(user_id, size);
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
        List<String> userBasedRecommenedIdList=new ArrayList<>();
        List<CourseInfo> courseRecommendList=new ArrayList<>();
        List<CourseInfo> popularRecommendList=new ArrayList<>();
        List<RecommendedItem> recommendedItemList=userBasedRecommend(user_id,size);
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
