package com.basic;
interface Sayable{  
    void say();  
}  

interface Sayable2{  
    void say2();  
}  
public class MethodReference {  
    public static void saySomething(){  
        System.out.println("Hello, this is static method.");  
    }  
    public static void main(String[] args) {  
        // Referring static method  
        Sayable sayable = MethodReference::saySomething;  
        Sayable2 sayable2 = MethodReference::saySomething;
        // Calling interface method  
        
          
        
        sayable.say();  
        
        sayable2.say2();  
    }  
}  
