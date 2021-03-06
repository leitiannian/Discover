package com.example.discover.http;

import com.example.discover.bean.AuthorDetailBean;
import com.example.discover.bean.DetailBean.FindCategory;
import com.example.discover.bean.DetailBean.ItemList;
import com.example.discover.bean.DetailBean.Replies;
import com.example.discover.bean.GankBean;
import com.example.discover.bean.HotEyeBean;
import com.example.discover.bean.ResultBean;
import com.example.http.HttpUtils;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created by Administrator on 2017/12/9 0009.
 */

public interface HttpClient {
    class Builder {
        public static HttpClient getEyeService() {
            return HttpUtils.getInstance().getEyeServer(HttpClient.class);
        }

        public static HttpClient getGankService() {
            return HttpUtils.getInstance().getGankServer(HttpClient.class);
        }
    }

    /**
     *
     * @param start 从多少开始，如从“0”开始
     * @param num   一次请求的数目（从start开始计算）
     * @return
     */
    @GET("v4/discovery/hot")
    Flowable<HotEyeBean> getEyeHot(@Query("start") int start, @Query("num") int num);

    /**
     *
     * @param id = 2创意4开胃6旅行8预告10动画12剧情14广告18运动20音乐22记录24时尚26萌宠28搞笑30游戏32科普34集锦36生活38综艺
     * @return
     */
    @GET("v3/categories/detail")
    Flowable<FindCategory> getEyeCateGory(@Query("id") int id);

    @GET("v3/pgc/videos")
    Flowable<AuthorDetailBean> getAuthorRelated(@Query("start") int start, @Query("pgcId") int id, @Query("strategy") String strategy);

    @GET("v3/queries/hot")
    Flowable<List<String>> getTrendingTag();

    @GET("v1/search?num=10")
    Flowable<ResultBean> getResult(@Query("query") String key, @Query("start") int start);

    @GET("v1/replies/video")
    Flowable<Replies> fetchReplies(@Query("id") int id);

    @GET("v1/replies/video?num=10")
    Flowable<Replies> fetchReplies(@Query("id") int id, @Query("lastId") int lastId);


    @GET("data/{type}/{number}/{page}")
    Flowable<GankBean> getGankData(@Path("type") String id, @Path("number") int number, @Path("page") int page);
}
