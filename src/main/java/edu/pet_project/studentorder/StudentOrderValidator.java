package edu.pet_project.studentorder;

import edu.pet_project.studentorder.dao.StudentOrderDaoImpl;
import edu.pet_project.studentorder.domain.*;
import edu.pet_project.studentorder.domain.register.AnswerCityRegister;
import edu.pet_project.studentorder.exception.DaoException;
import edu.pet_project.studentorder.mail.MailSender;
import edu.pet_project.studentorder.validator.ChildrenValidator;
import edu.pet_project.studentorder.validator.CityRegisterValidator;
import edu.pet_project.studentorder.validator.StudentValidator;
import edu.pet_project.studentorder.validator.WeddingValidator;

import java.util.List;

public class StudentOrderValidator {
    private CityRegisterValidator cityRegisterVal;
    private WeddingValidator weddingVal;
    private ChildrenValidator childrenVal;
    private StudentValidator studentVal;
    private MailSender mailSender;

    public StudentOrderValidator(){
        cityRegisterVal = new CityRegisterValidator();
        weddingVal = new WeddingValidator();
        childrenVal = new ChildrenValidator();
        studentVal = new StudentValidator();
        mailSender = new MailSender();
    }

    public static void main(String[] args) {



        StudentOrderValidator sov = new StudentOrderValidator();
        sov.checkAll();

    }
    public void checkAll() {
        try {
            List<StudentOrder> soList = readStudentOrders();
            for (StudentOrder so : soList) {
                checkOneOrder(so);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public List <StudentOrder> readStudentOrders() throws DaoException {
//        List<StudentOrder> soList = new LinkedList<>();
//        for (int j=0; j<5; j++){
//            StudentOrder so= SaveStudentOrder.buildStudentOrder(j);
//            soList.add(so);
//        }
//        return soList;
//
        return new StudentOrderDaoImpl().getStudentOrders();
    }

    public void checkOneOrder (StudentOrder so){
            AnswerCityRegister cityAnswer = checkCityRegister(so);
//            AnswerChildren childAnswer = chekChildren(so);
//            AnswerStudent  studentAnswer = checkStudent(so);
//            AnswerWedding weddingAnswer = checkWedding(so);
//            sendMail(so);
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so){

       return cityRegisterVal.checkCityRegister(so);
    }

    public AnswerWedding checkWedding(StudentOrder so){
        return weddingVal.checkWedding(so);
    }
    public AnswerChildren chekChildren(StudentOrder so){
        return childrenVal.chekChildren(so);
    }
    public AnswerStudent checkStudent(StudentOrder so){
        return studentVal.checkStudent(so);
    }

    public void sendMail (StudentOrder so){
        new MailSender().sendMail(so);
    }
}
