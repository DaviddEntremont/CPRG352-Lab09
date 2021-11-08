
package models;

import java.io.Serializable;

public class Role implements Serializable {
    private int id;
    private String name;

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Role(){
        
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    
    
}
