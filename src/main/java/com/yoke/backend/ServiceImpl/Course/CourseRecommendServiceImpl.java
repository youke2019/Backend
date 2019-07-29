package com.yoke.backend.ServiceImpl.Course;

import com.yoke.backend.Service.Course.CourseMessage.CourseEvaluationService;
import com.yoke.backend.Service.Course.CourseRecommendService;
import org.apache.mahout.cf.taste.common.TasteException;
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

    final private Integer NEIGHBORHOOD_NUM = 10;

    @Resource(name = "mysqlDataModel")
    private DataModel dataModel;

    @Override
    public List<RecommendedItem> userBasedRecommend(long user_id,Integer size) throws TasteException
    {
        UserSimilarity similarity=new EuclideanDistanceSimilarity(dataModel);
        NearestNUserNeighborhood neighborhood=new NearestNUserNeighborhood(NEIGHBORHOOD_NUM,similarity,dataModel);
        Recommender recommender=new CachingRecommender(new GenericUserBasedRecommender(dataModel,neighborhood,similarity));
        List<RecommendedItem> recommendedItems=recommender.recommend(user_id,size);
        System.out.println("here");
        System.out.println(recommendedItems.size());
        return recommendedItems;
    }
}
