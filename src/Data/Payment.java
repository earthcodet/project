/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author kong
 */
public class Payment {
        int OrderID;
        String nameBankCustomer;
        String numBankCustomer;
        String nameCustomer;
        String surnameCustomer;
        double priceTransfer;
        String date;
       String mounth;
        String year;
        String dateTransfer;
        String hour;
        String minute;
        String timeTransfer;
        
    public Payment(){
        nameBankCustomer ="";
        numBankCustomer="";
        nameCustomer="";
        surnameCustomer="";
        date="";
        mounth="";
        year="";
        dateTransfer= date+"/"+mounth+"/"+year;
        hour="";
        minute="";
        timeTransfer= hour+":"+minute;
    }
    
    public  void setOrderID(int ID){
        OrderID = ID;
    }
    public  void setNameBankCustomer(String NBC){
        nameBankCustomer = NBC;
    }
    
     public  void setNumBankCustomer(String NBC){
        numBankCustomer = NBC;
    }
     
     public  void setNameCustomer(String NC){
        nameCustomer = NC;
    }
     public  void setSurNameCustomer(String SNC){
        surnameCustomer = SNC;
    }
    public  void setPrice(double price){
        priceTransfer = price ;
    }
      public  void setDate(String Date){
         date = Date;
    }
     public  void setMounth(String Mounth){
         mounth = Mounth;
    }
      public  void setYear(String Year){
         year = Year;
         dateTransfer=dateTransfer= date+"/"+mounth+"/"+year;
    }
       public  void setHour(String Hour){
         hour = Hour;
    }
       public  void setMinute(String Minute){
         minute = Minute;
         timeTransfer= hour+":"+minute;
    }
      
   
     public  int getOrderID(){
       return OrderID ;
    }
     public  double getPrice(){
        return priceTransfer ;
    }
      public  String getNameBankCustomer(){
       return  nameBankCustomer ;
    }
    
     public  String getNumBankCustomer(){
       return numBankCustomer ;
    }
     
     public String getNameCustomer( ){
      return  nameCustomer ;
    }
     public  String getSurNameCustomer( ){
       return surnameCustomer ;
    }
      public  String getDate( ){
        return date  ;
    }
     public String getMounth( ){
       return  mounth ;
    }
      public  String getYear(){
       return  year ;
        
    }
       public  String getHour(){
        return hour ;
    }
       public  String getMinute(){
       return  minute ;
         
    }
}
