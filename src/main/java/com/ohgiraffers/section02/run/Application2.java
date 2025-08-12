package com.ohgiraffers.section02.run;
import com.ohgiraffers.section02.model.dao.MemberDAO;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        MemberDAO dao=new MemberDAO();
        Servicelogic ser=new Servicelogic(dao);
        /*1.Insert MEMBER*/
        /*2.Read All ALL */
        /*3.Read ONE MEMBER */
        /*4.Update MEMBER, WORKOUT, EXERCISE*/
        /*5.Delete*/
        Scanner sc = new Scanner(System.in);
        int n=0;
        while(true) {
            System.out.println("1 : INSERT NEW MEMBER");    //checked
            System.out.println("2 : INSERT WORKOUTLOG");    //checked
            System.out.println("3 : INSERT EXERCISE");

            System.out.println("4 : READ ALL"); //checked
            System.out.println("5 : READ ONE");  //checked

            System.out.println("6 : UPDATE MEMBER");    //checked
            System.out.println("7 : DELETE MEMBER");    //checked
            System.out.println("0 : SHUT DOWN");//checked


            n = sc.nextInt();
            switch (n) {
                case 1:{
                    ser.InsertMember(); //checked
                    break;
                }
                case 2:{
                    ser.InsertWorkout(); //checked
                    break;
                }
                case 3:{
                    ser.InsertExercise();
                    break;
                }
                case 4: {
                    ser.SearchMemberAll();  //checked
                    break;
                }
                case 5:{
//                    ser.SearchOneMember();  //checked
//                    ser.SearchOneMember2();   //no
                    ser.SearchOneMember3();

                    break;
                }
                case 6:{
//                    ser.UpdateMember(); //checked
                    ser.UpdateMember2();
                    break;
                }
                case 7:{
                    ser.DeleteMember2(); //checked
                    break;
                }
                case 0:{
                    System.out.println("return 0");
                    return;
                }
                default:{
                    System.out.println("다시 눌러주세요.");
                }
            }
        }
    }
}
