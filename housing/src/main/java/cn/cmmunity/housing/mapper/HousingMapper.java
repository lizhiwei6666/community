package cn.cmmunity.housing.mapper;

import cn.cmmunity.beans.Housing;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HousingMapper {
    int addHousing(Housing housing);
    int updateHousing(Housing housing);
    int delHousing(Integer id);
    void del(@Param("housing") Housing housing);
    Housing getHousingById(Integer id);
    List<Housing> getHousingPage(Map<String,Object> parm);
    int getHousingCount();

}
