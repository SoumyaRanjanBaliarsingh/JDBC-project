package Com.proj.controller;

import java.util.ArrayList;
import java.util.Scanner;

import Com.proj.dao.TeacherDao;
import Com.proj.dto.Teacher;

public class TeacherController {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) 
	{
		System.out.println("Please Enter Your Choice");
		System.out.println("1 for Save Teacher");
		System.out.println("2 for Get Teacher By ID");
		System.out.println("3 for Update Teacher By ID");
		System.out.println("4 for Delete Teacher By ID");
		System.out.println("5 Delete All Teacher");
		System.out.println("6 get all Teachers");
		System.out.println("7 add multiple teacher data");
		
		int i=scanner.nextInt();
		switch(i)
		{
		case 1:
		{
		
		System.out.println("enter the teacher ID");
		int ID= scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the teacher Name");
		String Name= scanner.nextLine();
		System.out.println("Enter the Subject");
		String Sub= scanner.nextLine();
		System.out.println("Enter the Gender");
		String Gender=scanner.next();
		
		Teacher teacher=new Teacher();
		teacher.setID(ID);
		teacher.setName(Name);
		teacher.setSub(Sub);
		teacher.setGender(Gender);
		
		TeacherDao dao= new TeacherDao();
		int j = dao.saveTeacher(teacher);
		
		if(j==1){
			System.out.println("data added successfully");
		}else {
			System.out.println("something went wrong, try again");
		}
		
		}
		break;
		case 2:
		{
			Scanner scanner= new Scanner(System.in);
			System.out.println("Enter the teacher Id");
			int id= scanner.nextInt();
			TeacherDao dao= new TeacherDao();
			String result= dao.getTeacherByID(id);
			System.out.println(result);	
		}
			
			break;
		case 3:
		{
			Scanner scanner= new Scanner(System.in);
			System.out.println("Enter the teacher ID");
			int id= scanner.nextInt();
			TeacherDao dao=new TeacherDao();
			int result= dao.deleteTeacherById(id);
			System.out.println(result);
			if (i!=0)
			{
				System.out.println("Teacher detail deleted successfully");
			}
			else
			{
				System.out.println("invalid id");
			}
		}
		
			break;
		case 4:
		{
			Scanner scanner= new Scanner(System.in);
			System.out.println("Enter the teacher ID");
			int id= scanner.nextInt();
			TeacherDao dao=new TeacherDao();
			String result=dao.getTeacherByID(id);
			if("invalid ID".equalsIgnoreCase(result))
			{
				System.out.println("no teacher found with given id to update");
			}
			else
			{
				System.out.println("1 for updating the name");
				System.out.println("2 for updating the subject");
				System.out.println("3 for updating the gender");
				System.out.println("enter your choice");
				int choice= scanner.nextInt();
				switch (choice) {
				case 1:
				{
					String column="name";
					scanner.nextLine();
					System.out.println("enter new name");
					String value=scanner.nextLine();
					TeacherDao teacherDao=new TeacherDao();
					int res= teacherDao.updateTeacher(id, column, value);
					if(res==1)
					{
						System.out.println("name update successfully");
					}
					else
					{
						System.out.println("something went wrong");
					}
				}
				break ;
					case 2:
					{
						String column="subject";
						scanner.nextLine();
						System.out.println("enter new name");
						String value=scanner.nextLine();
						TeacherDao teacherDao=new TeacherDao();
						int res= teacherDao.updateTeacher(id, column, value);
						if(res==1)
						{
							System.out.println("subject update successfully");
						}
						else
						{
							System.out.println("something went wrong");
						}
					}
					break ;
					case 3:
					{
						String column="gender";
						scanner.nextLine();
						System.out.println("enter new name");
						String value=scanner.nextLine();
						TeacherDao teacherDao =new TeacherDao();
						int res= teacherDao.updateTeacher(id, column, value);
						if(res==1)
						{
							System.out.println("gender update successfully");
						}
						else
						{
							System.out.println("something went wrong");
						}
					}
					break;
				}
			}
		}
			
				
		case 5:
		{
			TeacherDao dao= new TeacherDao();
			int k= dao.clearAllTeacherData();
			if(k==1)
			{
				System.out.println("all records deleted successfully");
			}
			else {
				System.out.println("something went wrong");
			}
		}
			break;
		case 6:
		{
			TeacherDao dao= new TeacherDao();
			dao.getAllTeacherData();
		}
			break;
			case 7:
			{
				ArrayList<Teacher> teachers= new ArrayList<Teacher>();
				boolean flag= true;
				while(flag)
				{
				System.out.println("Enter 1 to add teacher details");
				System.out.println("enter any other key to stop adding");
				int input= scanner.nextInt();
				if(input==1)
				{
					System.out.println("enter the teacher ID");
					int ID= scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter the teacher Name");
					String Name= scanner.nextLine();
					System.out.println("Enter the Subject");
					String Sub= scanner.nextLine();
					System.out.println("Enter the Gender");
					String Gender=scanner.next();
					
					Teacher teacher=new Teacher();
					teacher.setID(ID);
					teacher.setName(Name);
					teacher.setSub(Sub);
					teacher.setGender(Gender);
					
					teachers.add(teacher);	
				}
				else
				{
				flag=false;	
				}
				}
				TeacherDao dao=new TeacherDao();
				int res=dao.saveAllTeacher(teachers);
				if(res==1)
				{
				System.out.println("data added Successfully");
				
			}
				else
				{
					System.out.println("something went wrong try again");
				}
			}
		default:
			System.out.println("Please enter a valid input");
	
			break;
		}
			}
		}
