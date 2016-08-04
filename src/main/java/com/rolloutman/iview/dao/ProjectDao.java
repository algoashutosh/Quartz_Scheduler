package com.rolloutman.iview.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rolloutman.iview.model.Project;

/**
 * This console application demonstrates how to do CRUD operations using JDBC
 * with Spring framework.
 * 
 * @author www.codejava.net
 *
 */
@Repository
public class ProjectDao {
	
	private DataSource dataSource = null;
	
	public ProjectDao (DataSource datasource){
		this.dataSource = datasource;
	}

	private JdbcTemplate getJDBCTemplate() throws Exception {
		
		/*SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(new com.mysql.jdbc.Driver());
		dataSource.setUrl("jdbc:mysql://localhost/iview");
		dataSource.setUsername("iview");
		dataSource.setPassword("iview"); */

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		return jdbcTemplate;
	}

	/**
	 * Inserts a record into projects table
	 * 
	 * @param projectName
	 * @param changeNumber
	 * @param status
	 * @param shortDescription
	 * @throws Exception
	 */
	public void insertProject(String projectName, String changeNumber,
			String status, String shortDescription) throws Exception {

		String sqlInsert = "INSERT INTO projects (projectname, changenumber, status, shortdescription)"
				+ " VALUES (?, ?, ?, ?,?)";
		getJDBCTemplate().update(sqlInsert, projectName, changeNumber, status,
				shortDescription);
	}

	public void updateProjectStatus(String projectId, String status
			) throws Exception { 

		
		String sqlUpdate = "Update projects set status = ? where projectid = ?";
		
		System.out.println("Executing SQL ==> " + sqlUpdate);
		
		getJDBCTemplate().update(sqlUpdate, status, projectId);
	}
	
	/**
	 * Gets all projects from DB
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Project> getAllProjects() throws Exception {

		String sqlSelect = "SELECT * FROM projects";
		List<Project> listProject = getJDBCTemplate().query(sqlSelect,
				new RowMapper<Project>() {

					public Project mapRow(ResultSet result, int rowNum)
							throws SQLException {
						Project project = new Project();
						project.setProjectid(result.getString("projectid"));
						project.setProjectName(result.getString("projectname"));
						project.setDescription(result
								.getString("shortdescription"));
						project.setChangeNumber(result
								.getString("changenumber"));
						project.setStatus(result.getString("status"));

						return project;
					}

				});

		return listProject;

	}

}