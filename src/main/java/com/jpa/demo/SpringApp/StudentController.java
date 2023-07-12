package com.jpa.demo.SpringApp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

	@Autowired
	StudentRepository repo;
	
	@RequestMapping("/")
	public String display()
	{
		System.out.println("called StudentController...");
		return "home.jsp";
	}
	
	@RequestMapping("/addStudent")
	public String addStudent(Student student)
	{
		System.out.println("called addStudent...");
		repo.save(student);
		return "home.jsp";
	}
	
	@RequestMapping("/getStudent")
	public ModelAndView getStudent(@RequestParam("sid")int sid)
	{
		System.out.println("called getStudent...");
		ModelAndView mv=new ModelAndView("showStudent.jsp");		
		Student student = repo.findById(sid).orElse(new Student());
//		System.out.println(repo.findByCourse("Java"));
		mv.addObject(student);
		
		/*Optional<Student> student = repo.findById(sid);
		if(student.isPresent())
		{
			mv.addObject("obj", student.get());
		}
		else
		{
			Student s1= new Student();
			s1.setSid(111);
			s1.setSname("Default");
			mv.addObject("obj", student.orElse(s1));
		}*/
		return mv;
	}
	
	@RequestMapping("/getAllStudents")
	public ModelAndView getStudents()
	{
		System.out.println("called getAllStudents()...");
		List<Student> st=new ArrayList<>();
		Iterator<Student> itr=repo.findAll().iterator();
		ModelAndView mv = new ModelAndView("showStudents.jsp");
		mv.addObject("student", itr);
		/*while(itr.hasNext())
		{	
			mv.addObject(itr.next());
		}*/
		return  mv ;
	}
	
	@RequestMapping(path="/students",produces= {"application/xml"})
	@ResponseBody
	public List<Student> getAllStudents()
	{
		return repo.findAll();
	}
	
	@RequestMapping("/student/{id}")
	@ResponseBody
	public Optional<Student> getStudent1(@PathVariable("id")int id)
	{
		return repo.findById(id);
	}

}
