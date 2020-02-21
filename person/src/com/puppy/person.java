package com.puppy;

public class person {
    private String firstName;
    private String secondName;
    private int age;
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setSecondName(String secondName){
        this.secondName=secondName;
    }
    public void setAge(int age){
      int validage=this.age;
      if(validage>100||validage<0){
          this.age=0;
      }else{
          this.age=age;
      }
    }
    public String getFirstName(){
        return this.firstName=firstName;
    }
    public String getSecondName(){
        return this.secondName=secondName;
    }
    public int getAge(){
        return this.age=age;
    }
    public boolean isTeen(){
        if(this.age>12||this.age<20){
            return true;
        }
        return false;
    }
    public String getFullname(){
        if(firstName.isEmpty() && secondName.isEmpty()){
            return "";
        }else if(firstName.isEmpty()){
            return secondName;
        }else if(secondName.isEmpty()){
            return firstName;
        }
        return firstName+""+secondName;
    }

}
