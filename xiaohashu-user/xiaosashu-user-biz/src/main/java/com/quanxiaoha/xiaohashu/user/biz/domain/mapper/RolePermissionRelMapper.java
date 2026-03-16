package com.quanxiaoha.xiaohashu.user.biz.domain.mapper;

import com.quanxiaoha.xiaohashu.user.biz.domain.dataobject.RolePermissionRel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePermissionRelMapper {
    /**
     * 根据角色 ID 集合批量查询
     *
     * @param roleIds
     * @return
     */
    List<RolePermissionRel> selectByRoleIds(@Param("roleIds") List<Long> roleIds);
    int deleteByPrimaryKey(Long id);

    int insert(RolePermissionRel record);

    int insertSelective(RolePermissionRel record);

    RolePermissionRel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RolePermissionRel record);

    int updateByPrimaryKey(RolePermissionRel record);
}
