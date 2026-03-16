package com.quanxiaoha.xiaohashu.note.biz.constant;

public class MQConstants {
    /**
     * Topic 主题：删除笔记本地缓存
     */
    public static final String TOPIC_DELETE_NOTE_LOCAL_CACHE = "DeleteNoteLocalCacheTopic";
    /**
     * Topic 主题：延迟双删 Redis 笔记缓存
     */
    public static final String TOPIC_DELAY_DELETE_NOTE_REDIS_CACHE = "DelayDeleteNoteRedisCacheTopic";
    /**
     * Topic: 点赞、取消点赞共用一个
     */
    public static final String TOPIC_LIKE_OR_UNLIKE = "LikeUnlikeTopic";

    /**
     * 点赞标签
     */
    public static final String TAG_LIKE = "Like";

    /**
     * Tag 标签：取消点赞
     */
    public static final String TAG_UNLIKE = "Unlike";
    /**
     * Topic: 计数 - 笔记点赞数
     */
    public static final String TOPIC_COUNT_NOTE_LIKE = "CountNoteLikeTopic";
    /**
     * Topic: 收藏、取消收藏共用一个
     */
    public static final String TOPIC_COLLECT_OR_UN_COLLECT = "CollectUnCollectTopic";
    /**
     * Tag 标签：收藏
     */
    public static final String TAG_COLLECT = "Collect";

    /**
     * Tag 标签：取消收藏
     */
    public static final String TAG_UN_COLLECT = "UnCollect";
    /**
     * Topic: 计数 - 笔记收藏数
     */
    public static final String TOPIC_COUNT_NOTE_COLLECT = "CountNoteCollectTopic";
    /**
     * Topic: 笔记操作（发布、删除）
     */
    public static final String TOPIC_NOTE_OPERATE = "NoteOperateTopic";

    /**
     * Tag 标签：笔记发布
     */
    public static final String TAG_NOTE_PUBLISH = "publishNote";

    /**
     * Tag 标签：笔记删除
     */
    public static final String TAG_NOTE_DELETE = "deleteNote";


}
