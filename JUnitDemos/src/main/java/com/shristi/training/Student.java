package com.shristi.training;

import com.shristi.exceptions.ExceedingMaximumException;
import com.shristi.exceptions.InvalidNumException;
import com.shristi.exceptions.NegativeValueException;

public class Student {
	
	
	
	
	
	public int totalMarks(int sub1 , int sub2 , int sub3) throws NegativeValueException, ExceedingMaximumException {
		
		if(sub1<0 || sub2 <0 || sub3 <0) {
			throw new NegativeValueException("Marks should not be less than 0");
		}else if(sub1 > 100 || sub2>100 ||sub3 >100) {
			throw new ExceedingMaximumException("Marks should not exceed more than 100");
		}
		return sub1+sub2+sub3;
	}
	
	//90 -A , 80-90 B
	
	
public String getGrade(int[] marks) throws ExceedingMaximumException {
	int sum = 0;
    if (marks != null) {
        for (int mark : marks) {
        	
        	if(mark > 100 || mark < 0) {
        		throw new ExceedingMaximumException("error");
        	}
            sum += mark;
            
        }
        int average = sum / marks.length;
        if (average > 90)
            return "A"; 
        if (average >= 80 && average < 90)
            return "B";
        if (average >= 70 && average < 80)
            return "C";
        if (average >= 60 && average < 70)
            return "D";
        
        if (average< 50)
            return "F";
    }
    return "completed";
}

}
