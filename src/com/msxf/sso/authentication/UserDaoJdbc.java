package com.msxf.sso.authentication;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.spire.cas.core.authentication.MD5Tools;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoJdbc {  
    private static final String SQL_VERIFY_ACCOUNT = "select count(1) from users u where u.username=? and u.password=?";  
  
    private JdbcTemplate jdbcTemplate;  
  
    @Resource  
    public void setDataSource(DataSource dataSource){  
        this.jdbcTemplate = new JdbcTemplate(dataSource);  
    }  
  
    /** 
     * 验证用户名和密码是否正确 
     * @create 2015-7-17 下午3:56:54 
     * @author 玄玉<http://blog.csdn.net/jadyer> 
     */  
    public boolean verifyAccount(String username, String password){  
    	password=MD5Tools.MD5(password);
        try{  
            return 1==this.jdbcTemplate.queryForObject(SQL_VERIFY_ACCOUNT, new Object[]{username, password}, Integer.class);  
        }catch(Exception e){  
        	System.out.println(e.getMessage()); 
            return false;  
        }  
    }  
}  