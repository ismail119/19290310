
package com.mycompany.main;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static List<ModelNew> models = null;
      
    public static List<ModelNew> getInstance(){
        if(models==null){
            models=new ArrayList();
            for(var model:Model.DATA){
                ModelNew temp = new ModelNew((long)model[0],(String)model[1],(String)model[2],
                        (String)model[3],(String)model[4],(Double)model[5],(int)model[6]);
                models.add(temp);
            }
        }
        return models;
    }
}
