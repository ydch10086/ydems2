package com.yd.ems.code.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.yd.common.data.CIPPageInfo;
import com.yd.common.data.CIPReqCondition;
import com.yd.common.runtime.CIPRuntimeOperator;
import com.yd.common.runtime.CIPErrorCode;
import com.yd.common.exception.CIPServiceException;
import com.yd.common.function.admin.data.po.CIP_admin_op_logPO;
import com.yd.common.function.admin.dao.CIP_admin_op_logDao;

import com.yd.ems.code.dao.EMS_parameterDao;
import com.yd.ems.code.dao.EMS_store_spare_dmDao;
import com.yd.ems.code.data.EMS_store_spare_dmData;
import com.yd.ems.code.data.po.EMS_store_spare_dmPO;
import com.yd.ems.code.data.vo.EMS_store_spare_dmVO;
import com.yd.ems.code.service.EMS_store_spare_dmService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Service实现类</p>
 * <p>Class: EMS_storage_spare_dmService</p>
 *
 * @since 2015-05-29 02:42:12
 */

@Service
public class EMS_store_spare_dmServiceImpl implements EMS_store_spare_dmService {
	
	@Autowired
	private EMS_store_spare_dmDao dataDao = null;
	@Autowired
	private CIP_admin_op_logDao opLogDao =null;

	/** 
	 * 修改数据
	 */
	@Override
	public void updateData(EMS_store_spare_dmVO vo, CIPRuntimeOperator operateInf){
		//TODO
		EMS_store_spare_dmPO po = vo.toPO();
		Object[] keys = po.getKeys();
		EMS_store_spare_dmPO po0 = dataDao.getSingle(keys);
		if( po0 == null ){
			throw new CIPServiceException(CIPErrorCode.ERROR_RECORD_NOT_EXISTS);
		}
		
		po.setOperator(Integer.parseInt(operateInf.getSubject_id()));	
		
		po.setOp_time(operateInf.getOperate_tm());
		
		dataDao.update(po);
		
	}
	
	/** 
	 * 添加数据
	 */
	@Override
	public void addStoreData(EMS_store_spare_dmVO vo, CIPRuntimeOperator operateInf){
		EMS_store_spare_dmPO po = vo.toPO();
		Object[] keys = po.getKeys();
		EMS_store_spare_dmPO po0 = dataDao.getSingle(keys);
		if( po0!= null ){
			throw new CIPServiceException(CIPErrorCode.ERROR_DUMPLICATE_PRIMARY_KEY);
		}
		
		//TODO　添加记录基本判断
		po.setOperator(Integer.parseInt(operateInf.getSubject_id()));	
		po.setOp_time(operateInf.getOperate_tm());
		po.setSpare_in_store_num(BigDecimal.valueOf(0));
		po.setSpare_out_store_num(BigDecimal.valueOf(0));
		po.setSpare_store_num(BigDecimal.valueOf(0));
		po.setUnit_code(0);
		dataDao.add(po);
		
	}
	
	/** 
	 * 删除数据
	 */
	@Override
	public void deleteData(Object[] keys, CIPRuntimeOperator operateInf){
		dataDao.delete(keys);
		
	}
	
	/** 
	 * 获取数据
	 */		
	@Override
	public EMS_store_spare_dmVO getData(Object[] keys ){
		EMS_store_spare_dmPO  po = dataDao.getSingle(keys);
		if(po == null)
			throw new CIPServiceException(CIPErrorCode.ERROR_RECORD_NOT_EXISTS);
			
		return po.toVO();
	}
	
	/** 
	 * 检索数据
	 */		
	@Override
	public List<EMS_store_spare_dmData> searchData(CIPPageInfo page, CIPReqCondition[] conditions){
		
		List<EMS_store_spare_dmData> datas = dataDao.searchData(page, conditions);
		return datas;
	}

	
	public List<Map<String, Object>> exportEntities(CIPPageInfo page,CIPReqCondition[] conditions,
			CIPRuntimeOperator operateInf, boolean xFirst){
		if(xFirst){
			CIP_admin_op_logPO log = new CIP_admin_op_logPO();
			log.setOp_seq_no(System.currentTimeMillis());
			log.setOp_table_id("em_storage_spare_dm");
			log.setOp_obj_id("");
			log.setOp_type("E");
			log.setRemark("批量导出数据");
			log.setOperator(operateInf.getSubject_id());
			log.setCreate_time(operateInf.getOperate_tm());
			opLogDao.add(log);
		}
		return dataDao.exportEntities(page, conditions, xFirst);
	}
		
}