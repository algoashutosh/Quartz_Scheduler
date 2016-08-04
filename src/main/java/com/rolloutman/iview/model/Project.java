package com.rolloutman.iview.model;

public class Project {
	  
  private String projectid;
  private String projectName;
  private String changeNumber;
  private String status;
  private String description;
  
  
	  

	/**
	 * @return the projectid
	 */
	public String getProjectid() {
		return projectid;
	}
	/**
	 * @param projectid the projectid to set
	 */
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * @return the changeNumber
	 */
	public String getChangeNumber() {
		return changeNumber;
	}
	/**
	 * @param changeNumber the changeNumber to set
	 */
	public void setChangeNumber(String changeNumber) {
		this.changeNumber = changeNumber;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	} 
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	    
	
	 public String toString() {
	        return String.format("[%s - %s - %s - %s]", projectid, projectName, changeNumber, status);
	   }
}
