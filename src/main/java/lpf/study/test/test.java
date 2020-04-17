package lpf.study.test;

import java.util.Scanner;

class Parent{
    public static int i =0;

    public Parent(){
        System.out.println("Parent无参构造");
    }

}
class Children extends Parent{

    public Children(){

        System.out.println("children无参构造");
    }
    public Children(int num){
        Parent.i=30;
        System.out.println("children有参构造");
    }
}

public class test {

    public static void main(String[] args) {
        System.out.println(Parent.i);
        Children children = new Children(30);
        System.out.println(Parent.i);

        Scanner sc = new Scanner(System.in);
        int next = sc.nextInt();

        boolean flag =false;
        for (int i = 2; i <next ; i++) {
            if(next%i==0){
                flag =true;
                break;
            }
        }
        if(flag){
            System.out.println(next+"不是质数");
        }else System.out.println(next+"是质数");

    }
}
