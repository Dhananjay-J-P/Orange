/**
 * 
 */
package orange.user.role.impl;

import java.util.HashSet;
import java.util.Set;

import orange.user.ifc.UserIfc;
import orange.user.role.RoleIfc;

/**
 * @author Dhananjay P
 *
 */
public class Role implements RoleIfc {
	
	int roleId;
	
	String roleName;
	
	String roleDescriptions;
	  
	Set<UserIfc> userSet=new HashSet<UserIfc>(); 
	
	
	

	/**
	 * @return the userSet
	 */
	public Set<UserIfc> getUserSet() {
		return userSet;
	}

	/**
	 * @param userSet the userSet to set
	 */
	public void setUserSet(Set<UserIfc> userSet) {
		this.userSet = userSet;
	}

	/**
	 * @param roleId
	 * @param roleName
	 * @param roleDescriptions
	 */
	public Role(int roleId, String roleName, String roleDescriptions) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDescriptions = roleDescriptions;
	}

	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the roleDescriptions
	 */
	public String getRoleDescriptions() {
		return roleDescriptions;
	}

	/**
	 * @param roleDescriptions the roleDescriptions to set
	 */
	public void setRoleDescriptions(String roleDescriptions) {
		this.roleDescriptions = roleDescriptions;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleDescriptions=" + roleDescriptions + "]";
	}



	/**
	 * 
	 */
	public Role() {
	}
	
	
	

}
