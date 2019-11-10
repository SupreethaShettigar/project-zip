package grocery;

public class UserStatus {
 public User user; 
 boolean queryStatus;

 public UserStatus() {

}

public UserStatus(User user, boolean queryStatus) {

	this.user = user;
	this.queryStatus = queryStatus;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public boolean isQueryStatus() {
	return queryStatus;
}

public void setQueryStatus(boolean queryStatus) {
	this.queryStatus = queryStatus;
}

public void queryStatus(boolean b) {
	// TODO Auto-generated method stub
	
}
 
 
}
