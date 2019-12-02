package com.fsy.util;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fsy.dto.ColumnDto;
import com.fsy.dto.TableDto;
import com.fsy.po.BaseModel;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 遵守mybatis plus的实体　生成sql语句
 */
public class MybatisPlusEntity2SqlUtil {
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

    /**
     * 测试demo
     * @param args
     */
    public static void main(String[] args) throws ClassNotFoundException {
        String poPath = "/Users/xxx/Downloads/视频源码/后端接口源码/后台/mybatisEntity2Sql/src/main/java/com/fsy/po";
        File[] files = new File(poPath).listFiles();
        for(File f:files){
            Class obj  = Class.forName("com.fsy.po."+f.getName().split(".java")[0]);

            if(obj == BaseModel.class){
                continue;
            }

            TableDto superTable = null;
            if(obj.getSuperclass() != null){
                superTable = getTableDtoByClass(obj.getSuperclass());
            }

            TableDto subTable = null;
            if(superTable != null){
                subTable = getTableDtoByClass(obj);
                subTable.getColumns().addAll(superTable.getColumns());
                subTable.setPrimaryColumnName(superTable.getPrimaryColumnName());
            }

            String sql = generateTableSql(subTable);

            System.out.println(sql);
        }
    }

    /**
     * 根据表结构生成sql
     * @param subTable
     * @return CREATE TABLE `t_warn_set` (
     *   `id` int(11) NOT NULL AUTO_INCREMENT,
     *   `device_type` int(2) DEFAULT NULL COMMENT '设备类型1,弃流井（排口），2调蓄池3.点源，4.除臭',
     *   `device_name` varchar(50) DEFAULT NULL COMMENT '设备名称',
     *   `device_id` varchar(50) DEFAULT NULL COMMENT '设备id',
     *   `max_level` float DEFAULT NULL COMMENT '最高液位告警值',
     *   `min_level` float DEFAULT NULL COMMENT '最低液位告警值',
     *   `cod` float DEFAULT NULL COMMENT 'cod告警值',
     *   `nh3N2_Light` float DEFAULT NULL COMMENT '氨氮轻度告警值',
     *   `nh3N2_serious` float DEFAULT NULL COMMENT '氨氮重度告警值',
     *   `light_o2` float DEFAULT NULL COMMENT '溶解氧轻度',
     *   `serious_o2` float DEFAULT NULL COMMENT '溶解氧重度',
     *   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
     *   `river_code` varchar(20) DEFAULT NULL COMMENT '河道编码',
     *   `electric_stop` float DEFAULT NULL COMMENT '断电告警，时间分钟',
     *   `electricity` float DEFAULT NULL COMMENT '电量告警百分比',
     *   `net` float DEFAULT NULL COMMENT '网络失联告警，分钟',
     *   PRIMARY KEY (`id`)
     * ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
     */
    private static String generateTableSql(TableDto subTable) {
        String primaryColumnName = subTable.getPrimaryColumnName();

        String tableName = subTable.getTableName();

        List<ColumnDto> columns = subTable.getColumns();

        StringBuffer sb = new StringBuffer();
        sb.append("CREATE TABLE ");
        sb.append(tableName);
        sb.append(" (");
        for(ColumnDto columnDto : columns){
            String columnName = columnDto.getColumnName();
            Integer columnLength = columnDto.getColumnLength();
            String columnType = columnDto.getColumnType();

            sb.append(columnName);
            sb.append(" ");
            sb.append(columnType);
            if(columnLength != null){
                sb.append("(");
                sb.append(columnLength);
                sb.append(")");
            }

            if(primaryColumnName.equals(columnName)){
                sb.append("NOT NULL AUTO_INCREMENT");
            }
            sb.append(",");
        }

        sb.append("PRIMARY KEY");
        sb.append("(`");
        sb.append(primaryColumnName);
        sb.append("`)");
        sb.append(")");

        sb.append(" ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;");
        return sb.toString();

    }

    public static TableDto getTableDtoByClass(Class targetClass){
        TableDto tableDto = new TableDto();

        Class objClazz = targetClass;

        TableName tableName = (TableName)objClazz.getAnnotation(TableName.class);
        String tablename = null;
        if(tableName != null){
            tablename = tableName.value();
        }

        //设置表名
        tableDto.setTableName(tablename);

        Field[] fields = objClazz.getDeclaredFields();

        List<ColumnDto> columnDtoList = new ArrayList<ColumnDto>();
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

            if("id".equals(columnName)){
                tableDto.setPrimaryColumnName(columnName);
            }

            ColumnDto columnDto = new ColumnDto();
            columnDto.setColumnName(columnName);
            //整形
            if (field.getType()==Integer.class){
                columnDto.setColumnType("INT");
                columnDto.setColumnLength(11);
            }else if (field.getType()==String.class){
                //字符串
                columnDto.setColumnType("VARCHAR");
                columnDto.setColumnLength(100);
            }else if (field.getType()== Date.class){
                //日期
                columnDto.setColumnType("DATETIME");
            }else if (field.getType()==Float.class){
                //
                columnDto.setColumnType("FLOAT");
            }else if (field.getType()==Long.class){
                //
                columnDto.setColumnType("BIGINT");
                columnDto.setColumnLength(20);
            }else if (field.getType()==Double.class){
                columnDto.setColumnType("DOUBLE");
            }else{
                System.out.println(tableName);
                System.out.println("无法识别的类型");
                continue;

            }
            columnDtoList.add(columnDto);

        }
        tableDto.setColumns(columnDtoList);
        return tableDto;
    }
}
