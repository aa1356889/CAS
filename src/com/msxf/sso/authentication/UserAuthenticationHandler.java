package com.msxf.sso.authentication;  
  
import java.security.GeneralSecurityException;  
  
import javax.annotation.Resource;  
import javax.security.auth.login.FailedLoginException;  
  
import org.jasig.cas.authentication.HandlerResult;  
import org.jasig.cas.authentication.PreventedException;  
import org.jasig.cas.authentication.UsernamePasswordCredential;  
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;  
import org.jasig.cas.authentication.principal.SimplePrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;  
  
@Component(value="primaryAuthenticationHandler")  
public class UserAuthenticationHandler extends AbstractUsernamePasswordAuthenticationHandler {  
   
	public UserDaoJdbc getUserDaoJdbc() {
		return userDaoJdbc;
	}

	public void setUserDaoJdbc(UserDaoJdbc userDaoJdbc) {
		this.userDaoJdbc = userDaoJdbc;
	}

	 @Autowired
    private UserDaoJdbc userDaoJdbc;  
   
    /** 
     * 认证用户名和密码是否正确 
     * @see UsernamePasswordCredential参数包含了前台页面输入的用户信息 
     */  
    @Override  
    protected HandlerResult authenticateUsernamePasswordInternal(UsernamePasswordCredential transformedCredential) throws GeneralSecurityException, PreventedException {  
        String username = transformedCredential.getUsername();  
     
        String password = transformedCredential.getPassword();  
        if(userDaoJdbc.verifyAccount(username, password)){  
        	  return createHandlerResult(transformedCredential,new SimplePrincipal(username, null),null); 
        }  
        throw new FailedLoginException();  
    }  
}  