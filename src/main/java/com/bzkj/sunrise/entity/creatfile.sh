for i in `find . -name "*.java"`;
do
 str=${i%*.java}
 str=${str#*./}
 path=/home/syu/java/project/bzworkspace/newsunrise/src/main/java/com/bzkj/sunrise/dao/
 path2=/home/syu/java/project/bzworkspace/newsunrise/src/main/resources/mapper/res/
 xml=${path2}${str}"Dao.xml"
 dao=${path}${str}"Dao.java"
 touch $dao
 touch $xml
cls="package com.bzkj.sunrise.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bzkj.sunrise.entity."${str}";

public interface "${str}"Dao extends BaseMapper<"${str}">{}"
 xmlstr="
<?xml version=\"1.0\" encoding=\"UTF-8\" ?>
<!DOCTYPE mapper
    PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"
    \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">

<mapper namespace=\"com.bzkj.sunrise.dao."${str}"Dao\">
   
</mapper>


"
  echo $cls > $dao
  echo $xmlstr > $xml
  echo $cls
done
