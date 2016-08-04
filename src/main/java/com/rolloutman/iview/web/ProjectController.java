package com.rolloutman.iview.web;

import java.util.List;

import javax.sql.DataSource;

import org.quartz.SchedulerException;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.rolloutman.iview.dao.ProjectDao;
import com.rolloutman.iview.model.Project;
import com.rolloutman.iview.scheduler.QrtzInitializer;

@Controller
public class ProjectController{
 
    @Bean
    public ViewResolver getViewResolver() throws SchedulerException{
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        QrtzInitializer.initialiseScheduling();
        return resolver;
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/iview");
        dataSource.setUsername("root");
        dataSource.setPassword("algo");
         
        return dataSource;
    }
     
    @Bean
    public ProjectDao getProjectDao() {
        return new ProjectDao(getDataSource());
    }
    
    @RequestMapping(value = "/getAllProjects.rm", method = RequestMethod.GET)
    public ModelAndView getAllProjects(ModelAndView model) throws Exception {
        Project project = new Project();
        List<Project> projectList = getProjectDao().getAllProjects();
        model.addObject("projectsList", projectList);
        model.setViewName("project");
        return model;
    }
    
    @RequestMapping(value = "/saveProjectStatus.rm", method = RequestMethod.GET)
    public ModelAndView saveProjectStatus(@RequestParam("projectId") String projectId,
    									@RequestParam("status") String status, 
    									ModelAndView model) throws Exception {
       
        System.out.println("Inputs to SaveProjectStatus ==> " + projectId + ":" + status);
        getProjectDao().updateProjectStatus(projectId, status);
        model.addObject("status", "success");
        List<Project> projectList = getProjectDao().getAllProjects();
        model.addObject("projectsList", projectList);
        model.setViewName("project");
        return model;
    }
}
