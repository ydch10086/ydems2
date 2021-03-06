package com.yd.ems.storage.dao;

import org.springframework.stereotype.Repository;
import com.yd.ems.storage.data.EMS_storage_inout_dmData;
import com.yd.ems.storage.data.po.EMS_storage_inout_dmPO;

import java.util.List;
import java.util.Map;

import com.yd.common.dao.IDao;
import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;

/**
 * <p>Dao类</p>
 * <p>Class: code_spare_dm - 对象类型</p>
 *
 * @since 2015-05-29 02:42:12
 */
 
@Repository
public interface EMS_storage_inout_dmDao extends IDao<EMS_storage_inout_dmPO> {
	
	public List<EMS_storage_inout_dmData> searchData(CIPPageInfo page, CIPReqCondition[] conditions);
	
	public List<Map<String, Object>> exportEntities(CIPPageInfo page, CIPReqCondition[] conditions, boolean xFirst);
}
