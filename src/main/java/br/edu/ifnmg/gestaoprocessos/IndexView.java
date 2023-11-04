package br.edu.ifnmg.gestaoprocessos;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "indexView")
@RequestScoped
public class IndexView {
    
    private String color = "#00FF00";
    
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
}
