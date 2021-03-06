package com.yd.common.function.admin.data.po;


import com.yd.common.function.admin.data.vo.CIP_admin_auth_attrVO;

/**
 * <p>实体类</p>
 * <p>Table: cip_admin_auth_attr - 权限对象属性信息</p>
 *
 * @since 2015-05-21 12:44:17
 */
public class CIP_admin_auth_attrPO {

	public Object[] getKeys(){
		return new Object[]{ 
			obj_attr_id,
					obj_id
		};
	}


    /** 
    * obj_attr_id - 权限对象属性id 
    */
    private String obj_attr_id;

    /** 
    * obj_id - 权限对象id 
    */
    private String obj_id;

    /** 
    * obj_attr_name - 权限对象描述
    */
    private String obj_attr_name;


    public String getObj_attr_id(){
        return this.obj_attr_id;
    }
    public void setObj_attr_id(String obj_attr_id){
        this.obj_attr_id = obj_attr_id;
    }

    public String getObj_id(){
        return this.obj_id;
    }
    public void setObj_id(String obj_id){
        this.obj_id = obj_id;
    }

    public String getObj_attr_name(){
        return this.obj_attr_name;
    }
    public void setObj_attr_name(String obj_attr_name){
        this.obj_attr_name = obj_attr_name;
    }

	public CIP_admin_auth_attrVO toVO(){
		CIP_admin_auth_attrVO vo = new CIP_admin_auth_attrVO();
		
    	vo.setObj_attr_id(obj_attr_id);
    	vo.setObj_id(obj_id);
		vo.setObj_attr_name(obj_attr_name);
		
		return vo;
	}
		
}