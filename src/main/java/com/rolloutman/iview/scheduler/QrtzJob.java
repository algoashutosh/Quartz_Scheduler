package com.rolloutman.iview.scheduler;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.rolloutman.iview.dao.ProjectDao;
import com.rolloutman.iview.model.Project;
import com.rolloutman.iview.web.ProjectController;

public class QrtzJob implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		//System.out.println("Staring update operation for projects");

		try {
			ProjectController projectController=new ProjectController();
			ProjectDao projectDao=projectController.getProjectDao();
			List<Project> projects=projectDao.getAllProjects();
			if(projects!=null && !projects.isEmpty())
			{
				for(Project p:projects)
				{
					if(p.getStatus().equals("Open For Edit"))
					{
						projectDao.updateProjectStatus(p.getProjectid(), "Expired");
						//System.out.println("Project status for project id "+p.getProjectid()+" is updated.");
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
