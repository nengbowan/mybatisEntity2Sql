package com.fsy.po;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;


import java.io.File;
import java.lang.reflect.Field;
import java.util.Date;


/**
 * <p>
 * 视频标签
 * </p>
 *
 * @author haha
 * @since 2018-10-05
 */
@TableName("t_video_tags")
@SuppressWarnings("serial")
public class TVideoTags extends BaseModel {

    /**
     * 视频ID
     */
    @TableField("video_id")
    private Integer videoId;
    /**
     * 标签ID
     */
    @TableField("tag_id")
    private Integer tagId;


    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        String poPath = "/Users/fushiyong/Downloads/视频源码/后端接口源码/后台/videoadmin2/src/main/java/com/videoadmin/ying/po";
        File [] files = new File(poPath).listFiles();
        for(File f:files){
            Class obj  = Class.forName("com.videoadmin.ying.po."+f.getName().split(".java")[0]);
            printMybatisSql(obj);
        }

    }

    //公共字段

    // @TableId(value="id",type=IdType.AUTO)
    //    private Integer id;
    //    @TableField("create_by")
    //    private Integer createBy;
    //    @TableField("create_time")
    //    private Date createTime;
    //    @TableField("update_by")
    //    private Integer updateBy;
    //    @TableField("update_time")
    //    private Date updateTime;
    //
    //    @TableField(exist = false)
    //    private String keyword;

    public static void printMybatisSql(Class targetClass){
        Class objClazz = targetClass;

        TableName tableName = (TableName)objClazz.getAnnotation(TableName.class);
        String tablename = tableName.value();

        System.out.println("\n============"+tablename);
        Field[] fields = objClazz.getDeclaredFields();
        for(Field field : fields){
            TableField tableField = field.getAnnotation(TableField.class);

            if(tableField != null){
                boolean validDbColumn = tableField.exist();
                if(!validDbColumn){
                    //忽略不是数据库实体的字段
                    continue;
                }
            }

            String columnName = null;

            //为空　则映射为字段名
            if(tableField == null){
                columnName = field.getName();
            }else{
                columnName = field.getAnnotation(TableField.class).value();
            }
            System.out.print(columnName+"  ");

            //整形
            if (field.getType()==Integer.class){

            }else if (field.getType()==String.class){
                //字符串
            }else if (field.getType()==Date.class){
                //日期
            }else if (field.getType()==Float.class){
                //
            }else if (field.getType()==Long.class){
                //
            }else if (field.getType()==Double.class){
                //
            }else{
                System.out.println(tableName);
                System.out.println("无法识别的类型");
                return;

            }

        }
    }

}