

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yankee
 */
public class Doctor {
    private String code;
    private String name;
    private String special;
    private int avalable;

    public Doctor() {
    }

    public Doctor(String code, String name, String special, int avalable) {
        this.code = code;
        this.name = name;
        this.special = special;
        this.avalable = avalable;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public int getAvalable() {
        return avalable;
    }

    public void setAvalable(int avalable) {
        this.avalable = avalable;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-10s%-10s%-10d", code, name, special, avalable);
    }
    
    
}
