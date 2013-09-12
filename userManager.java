//********************************************************************
//  	userManager.java    Based on Lewis / Loftus
//		Manage Authorised Users
// 	Shell for Assignment 3.
//********************************************************************

import java.util.*;

public class userManager
{
	//-----------------------------------------------------------------
	// Constructor
	//-----------------------------------------------------------------

    final int MAX=100;
    private userList[] adminList=new userList[MAX];
    private int count;
    
    public void userManager()
    {
    	count=0;
    }
	
	public void addUser(String userFirst,String userLast,String userUser,String userDepart,int userPIN)
	{
		if(count==adminList.length)
			increaseSize();
		
		adminList[count]=new userList(userFirst,userLast,userUser,userDepart,userPIN);
		count++;

	}
	
	public void sortUsers()
	{
		userList[] temp=new userList[count];
		for(int i=0;i<count;i++)
			temp[i]=adminList[i];
		adminList=temp;
		listSort.insertionSort(adminList);
	}
	
	public void increaseSize()
	{
		userList[] adminTemp=new userList[adminList.length*2];
		for(int i=0;i<adminList.length;i++)
			adminTemp[i]=adminList[i];
		adminList=adminTemp;
	}
	
	public boolean validateUsernamePIN(String adminUser,int adminPIN)
	{
		boolean result=false;
		for(int i=0;i<adminList.length;i++)
			if(adminList[i].getUserName().equals(adminUser))
				result=adminList[i].validatePIN(adminPIN);
		return result;
	}
	
	public String toString()
	{
		String admin="User list as follow:\n";
		admin+="First Name     Last Name           User Name           Department          User PIN"+"\n";
		admin+="------------------------------------------------------------------------------------------\n";
		for(int i=0;i<adminList.length;i++)
			admin+=adminList[i];
		
		return admin;
	}
} // end of userManager class 
//-----------------------------------------------------------------
