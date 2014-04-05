import junit.framework.TestCase;

import com.whereismymoney.model.PasswordManager;


public class ZhuomingTest extends TestCase {

/**
 * This unit test tests the login feature with a test case of wrong password (request denied) and a case of right password (request confirmed)
 * NOTE: excluded the Strict Mode settings to avoid noClassDefFoundException
 * @author Zhuoming Li (Ming)
 *
 */
	PasswordManager manager;
	
	
	/**
	 * login denied with wrong password
	 */
	public void testLoginWithWrongPassword(){
		 manager = new PasswordManager();

		System.out.println(manager.login("admin","wrongpassword"));
	}
	
	
	/**
	 * login accepted with right password
	 */
	public void testLoginWithRightPassword(){
		 manager = new PasswordManager();

		assertTrue(manager.login("admin","pass123"));
	}

}
