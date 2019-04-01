package DataAlloc;

import processing.core.PApplet;

public class UsingProcessing extends PApplet{

    public static void main(String[] args) {
        PApplet.main("DataAlloc.UsingProcessing");
        System.out.print("what the fuck");
    }

    public void settings(){
        size(300,300);
    }

    public void setup(){
        fill(120,50,240);
    }

    public void draw(){
        ellipse(width/2,height/2,second(),second());
        System.out.print("whatthefuck");
    }
}