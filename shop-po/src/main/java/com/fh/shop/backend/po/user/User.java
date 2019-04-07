/** 
 * <pre>项目名称:shop_admin_v2 
 * 文件名称:User.java 
 * 包名:com.fh.shop.backend.po.user 
 * 创建日期:2019年1月7日下午3:51:25 
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.backend.po.user;

import com.fh.shop.backend.po.Page;
import com.fh.shop.backend.po.dept.DeptInfo;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/** 
 * <pre>项目名称：shop_admin_v2    
 * 类名称：User    
 * 类描述：    
 * 创建人：王亚州 2592683566@qq.com    
 * 创建时间：2019年1月7日 下午3:51:25    
 * 修改人：王亚州 2592683566@qq.com     
 * 修改时间：2019年1月7日 下午3:51:25    
 * 修改备注：       
 * @version </pre>    
 */
public class User extends Page implements Serializable{
    
	private static final long serialVersionUID = -4804980232986157448L;
	private Integer id;
	private String userName;
	private String passWord;
	private String imageCode;
	private String headerPath;
	private String oldHeaderPath;
	private String salt;
	private int coount;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date correntDate;
	private String status;
	private int errorCount;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private int sex;
	private Integer salary;
	private String userRealName;
	private int deptId;
	private Integer minSalary;
	private Integer maxSalary;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date   minBirthday;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date maxBirthday;
	private String birthdayStr;
	private String deptName;
	private String deptIds;
	private List<Integer> deptIdsList ;
	private DeptInfo deptInfo = new DeptInfo();

	public String getOldHeaderPath() {
		return oldHeaderPath;
	}

	public void setOldHeaderPath(String oldHeaderPath) {
		this.oldHeaderPath = oldHeaderPath;
	}

	public String getHeaderPath() {
		return headerPath;
	}

	public void setHeaderPath(String headerPath) {
		this.headerPath = headerPath;
	}

	public Date getMinBirthday() {
		return minBirthday;
	}

	public void setMinBirthday(Date minBirthday) {
		this.minBirthday = minBirthday;
	}

	public Date getMaxBirthday() {
		return maxBirthday;
	}

	public void setMaxBirthday(Date maxBirthday) {
		this.maxBirthday = maxBirthday;
	}

	public String getDeptIds() {
		return deptIds;
	}

	public void setDeptIds(String deptIds) {
		this.deptIds = deptIds;
	}

	public List<Integer> getDeptIdsList() {
		return deptIdsList;
	}

	public void setDeptIdsList(List<Integer> deptIdsList) {
		this.deptIdsList = deptIdsList;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public DeptInfo getDeptInfo() {
		return deptInfo;
	}

	public void setDeptInfo(DeptInfo deptInfo) {
		this.deptInfo = deptInfo;
	}

	public String getBirthdayStr() {
		return birthdayStr;
	}

	public void setBirthdayStr(String birthdayStr) {
		this.birthdayStr = birthdayStr;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(int errorCount) {
		this.errorCount = errorCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCoount() {
        return coount;
    }

    public void setCoount(int coount) {
        this.coount = coount;
    }

    public Date getCorrentDate() {
		return correntDate;
	}

	public void setCorrentDate(Date correntDate) {
		this.correntDate = correntDate;
	}

	public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getImageCode() {
		return imageCode;
	}

	public void setImageCode(String imageCode) {
		this.imageCode = imageCode;
	}

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
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Integer getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Integer minSalary) {
		this.minSalary = minSalary;
	}

	public Integer getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Integer maxSalary) {
		this.maxSalary = maxSalary;
	}
}
