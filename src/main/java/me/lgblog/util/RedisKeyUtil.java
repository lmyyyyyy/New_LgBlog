package me.lgblog.util;

public class RedisKeyUtil {
	private static String SPLIT = ":";
    private static String BIZ_LIKE = "LIKE";
    private static String BIZ_DISLIKE = "DISLIKE";

    /**
     * 产生喜欢key
     */
    public static String getLikeKey(String ip, String type, int blogId){
        return BIZ_LIKE + SPLIT + SPLIT + type + SPLIT + blogId;
    }
    /**
     * 取消赞
     */
    public static String getDisLikeKey(String ip, String type, int blogId){
        return BIZ_DISLIKE +SPLIT + SPLIT + type + SPLIT + blogId;
    }
}
