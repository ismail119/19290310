
package com.mycompany.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DbOperations {
    
    public boolean Insert(Long id,String name,String surname,String phoneNumber,
            String subsType,Double balance,int numberOfFollowers){
        
        for(var i: Database.getInstance()){
            if(Objects.equals(i.getId(), id)){
                return false;
            }
        }
        
        var temp = new ModelNew(id,name,surname,phoneNumber,subsType,balance,numberOfFollowers);
        var db = Database.getInstance();
        db.add(temp);
        System.out.println("Insert Edildi");
        return true;
    }
    
    public void Delete(Long id){
        var db = Database.getInstance();
        for(var model : db){
            if(Objects.equals(model.getId(), id)){
                db.remove(model);
                System.out.println("Delete Edildi");
                return;
            }
        }
         
        //show message
    }
    
    public void Update(Long id,String name,String surname,String phoneNumber,
            String subsType,Double balance,int numberOfFollowers){
        var db = Database.getInstance();
        for(var i=0;i< db.size();i++){
            if(Objects.equals(db.get(i).getId(), id)){
                db.get(i).setId(id);
                db.get(i).setName(name);
                db.get(i).setNumberOfFollowers(numberOfFollowers);
                db.get(i).setPhoneNumber(phoneNumber);
                db.get(i).setBalance(balance);
                db.get(i).setSubsType(subsType);
                db.get(i).setSurname(surname);
                System.out.println("Update Edildi");
                return;
            }
        }
        //show message
    }
    
    public ModelNew getModel(Long id){
        var db = Database.getInstance();
        
        for(var model : db){
            if(Objects.equals(model.getId(), id)){
                System.out.println("Delete Edildi");
                return model;
            }
        }
        return null;
    }

    
    public List<ModelNew> Filter(String subString){
        List<ModelNew> filteredList = new ArrayList();
        var db = Database.getInstance();
        for(var model : db){
            if(model.getId().toString().contains(subString)||
                    model.getId().toString().contains(subString)||
                    model.getName().contains(subString)||
                    model.getSurname().contains(subString)||
                    model.getSubsType().contains(subString)||
                    model.getPhoneNumber().contains(subString)||
                    model.getBalance().toString().contains(subString))
                {
                   filteredList.add(model);
                }
            }
        System.out.println("Filter Edildi");
        for(var i:filteredList){
            System.out.println(i.getId()+i.getName());
        }
        return filteredList;
        }
    }
        
