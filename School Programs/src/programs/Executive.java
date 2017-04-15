/*
 *Name: Brian Matthys
 *Date: 4/16/2013
 *Class: CSCI 1301
 *Section: 201
 *Name of Program: Executive
 *Description: Make a class Employee with a name and salary.
 * Make a class Manager inherit from Employee.
 * Add an instance variable, named department, of type String. 
 * Supply a method toString that prints the manager’s name, department, and salary.
 * Make a class Executive inherit from Manager.
 * Supply appropriate toString methods for all classes.
 * Supply a test program that tests these classes and methods.
 */

package programs;

public class Executive extends Manager
{
	public String toString()
	{
		return "Name: " + name + "Department: " + department + "Salary: " + salary;
	}
}
