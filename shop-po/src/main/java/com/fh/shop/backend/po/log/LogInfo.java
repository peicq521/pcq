package com.fh.shop.backend.po.log;

import com.fh.shop.backend.po.Page;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class LogInfo extends Page implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
    //用户名
    private String userName;
    //事件
    private String info;
    //状态(1:成功，0:失败),
    private Integer status;
    //创建时间
    private Date createTime;
    //用时
    private Long useTime;
    //最小创建时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date minCreateTime;
    //最大创建时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date maxCreateTime;
    //最小用时
    private Long minUserTime;
    //最大用时
    private Long maxUserTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUseTime() {
        return useTime;
    }

    public void setUseTime(Long useTime) {
        this.useTime = useTime;
    }

    public Date getMinCreateTime() {
        return minCreateTime;
    }

    public void setMinCreateTime(Date minCreateTime) {
        this.minCreateTime = minCreateTime;
    }

    public Date getMaxCreateTime() {
        return maxCreateTime;
    }

    public void setMaxCreateTime(Date maxCreateTime) {
        this.maxCreateTime = maxCreateTime;
    }

    public Long getMinUserTime() {
        return minUserTime;
    }

    public void setMinUserTime(Long minUserTime) {
        this.minUserTime = minUserTime;
    }

    public Long getMaxUserTime() {
        return maxUserTime;
    }

    public void setMaxUserTime(Long maxUserTime) {
        this.maxUserTime = maxUserTime;
    }
}
