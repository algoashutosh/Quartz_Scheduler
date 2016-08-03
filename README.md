# Quartz_Scheduler

I have used scheduler initalization logic in controller's getViewResolver method and introduced 2 new classes for Quartz scheduler.
So as soon as applicaiton is up schecduler is initilized.
I have used cron scheduler for this and it will run every day 3pm(using cron expression).
Database update logic has been used as it is from dao.

DDl.sql is database file

How to run:-  run as maven install
              locate sample.war and copy it to webApp of apache tomcat and rename it as ROOT.war
              restart tomcat
              access http://localhost:8080/
