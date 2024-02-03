package com.techpalle.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techpalle.dao.ConnectionCode;
import com.techpalle.model.Student;
@Controller
public class StudentController {
	
	@RequestMapping("delete")
	public ModelAndView deleteStudent(int id)
	{
		ModelAndView mv = new ModelAndView();
		//setp 1:call delete method present in Connection code
		
		ConnectionCode cc=new ConnectionCode();
		cc.delete(id);
		//setp 2: redirect user to display.jsp with new values(remaining rows)
		
		ArrayList<Student> al=cc.getAllStudents();
		mv.addObject("lst", al);
			
		mv.setViewName("display.jsp");
		return mv;
	}
	@RequestMapping("update")
	public ModelAndView updateStydent(HttpServletRequest request) {
		ModelAndView mv= new ModelAndView();
		//step 1:Read the data from register.jsp page
	int i=Integer.parseInt(request.getParameter("tbid"));
		String n= request.getParameter("tbname");
		String e=request.getParameter("tbemail");
		String p=request.getParameter("tbpass");
		long m=Long.parseLong(request.getParameter("tbmbl"));
		Student s= new Student(i,n,e,p,m);
		//step 2 : call the update method
		
		ConnectionCode cc=new ConnectionCode();
		cc.update(s);
		
		//step 3: redirect usert display.jsp with updated values
		ArrayList<Student> al=cc.getAllStudents();
		mv.addObject("lst", al);
			
		mv.setViewName("display.jsp");
		
		return mv;
	}
	
		@RequestMapping("edit")
		public ModelAndView displayEditForm(int id){
			
			ModelAndView mv= new ModelAndView();
			//step 1: Retrieve the data from DB:
			ConnectionCode cc=new ConnectionCode();
			Student stud=cc.getStudentById(id);
			
			mv.addObject("student",stud);
			//Step 2:Redirect user to edit form register.jsp to display the old data
			
			mv.setViewName("Register.jsp");
			
			return mv;
			
		}
		
		@RequestMapping(value="crud" ,params="reg")
		public ModelAndView getRegister(String fno,String sno) {
			
			
			ModelAndView mv = new ModelAndView();
			
			mv.setViewName("Register.jsp");
			return mv;
		}
		
		@RequestMapping(value="crud" ,params="show")
		public ModelAndView getDetails() {
			
			
			ModelAndView mv = new ModelAndView();
			
			ConnectionCode cc=new ConnectionCode();
			ArrayList<Student> al=cc.getAllStudents();
			mv.addObject("lst", al);
  			
			mv.setViewName("display.jsp");
			return mv;
		}
		@RequestMapping("reg")
		//for inserting data when register page button clicked
		public ModelAndView insertStudent(HttpServletRequest request) {
		String n=	request.getParameter("tbname");
		String e=	request.getParameter("tbemail");
		String p=	request.getParameter("tbpass");
		long   mob=   Long.parseLong(request.getParameter("tbmbl"));
		
		Student s= new Student(n,e,p,mob);
		
		//jdbc connections code
		ConnectionCode cc=new ConnectionCode();
		cc.insert(s);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("res", "inserted");
		mv.setViewName("Register.jsp");
		return mv;
		
		}

}
