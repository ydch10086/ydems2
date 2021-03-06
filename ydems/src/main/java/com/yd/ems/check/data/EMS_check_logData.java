package com.yd.ems.check.data;


/**
 * <p>Data实体类</p>
 * <p>View: em_check_log - 设备日常巡检日志</p>
 * 用于检索数据，建立在视图基础上
 * @since 2015-05-29 02:42:12
 */
public class EMS_check_logData {


    /** 
    * check_are - 巡检区域
    */
    private String check_are;

    /** 
    * check_beg_time - 巡检开始时间
    */
    private String check_beg_time;

    /** 
    * check_end_time - 巡检结束时间
    */
    private String check_end_time;

    /** 
    * check_org - 分拨中心
    */
    private int check_org;

    /** 
    * check_org_name - 分拨中心名称
    */
    private String check_org_name;

    /** 
    * check_no - 巡检流水号 
    */
    private long check_no;

    /** 
    * check_op - 巡检人工号 
    */
    private int check_op;


    public String getCheck_are(){
        return this.check_are;
    }
    public void setCheck_are(String check_are){
        this.check_are = check_are;
    }

    public String getCheck_beg_time(){
        return this.check_beg_time;
    }
    public void setCheck_beg_time(String check_beg_time){
        this.check_beg_time = check_beg_time;
    }

    public String getCheck_end_time(){
        return this.check_end_time;
    }
    public void setCheck_end_time(String check_end_time){
        this.check_end_time = check_end_time;
    }

    public int getCheck_org(){
        return this.check_org;
    }
    public void setCheck_org(int check_org){
        this.check_org = check_org;
    }

    public long getCheck_no(){
        return this.check_no;
    }
    public void setCheck_no(long check_no){
        this.check_no = check_no;
    }

    public int getCheck_op(){
        return this.check_op;
    }
    public void setCheck_op(int check_op){
        this.check_op = check_op;
    }
	public String getCheck_org_name() {
		return check_org_name;
	}
	public void setCheck_org_name(String check_org_name) {
		this.check_org_name = check_org_name;
	}

}