package com.liff.blog.mapper;
import com.liff.blog.pojo.Fileimg;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FileimgMapper {

    @Select("select * from fileimg")
    List<Fileimg> findAllfileimg();

    @Select("select * from fileimg where fileuuid = #{fileuuid}")
    Fileimg findfileimgById(int fileuuid);

    @Select("select * from fileimg where filename = #{filename}")
    Fileimg findfileimgByName(String filename);

    @Select("select * from fileimg where articleid=#{articleid}")
    Fileimg findefileimgByName(String articleid);


    @Insert("insert into fileimg(fileuuid,articleid,filename,path,uploadtime)values(#{fileuuid},#{articleid},#{filename},#{path},#{uploadtime})")
    int addfileimg(Fileimg fileimg);

    @Delete("delete from fileimg where fileuuid=#{fileuuid}")
    int deletefileimg(int fileimgid);

}
