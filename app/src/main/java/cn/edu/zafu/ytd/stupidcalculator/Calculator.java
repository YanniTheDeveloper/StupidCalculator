package cn.edu.zafu.ytd.stupidcalculator;

import java.util.ArrayList;

public class Calculator {
    boolean check = false;
    ArrayList<String> input = new ArrayList<>();
    ArrayList<String> tool = new ArrayList<>();

    public void addInput(String s){
        check =  true;
        input.add(s);
    }
    public void addTool(String t){
        check =  false;
        tool.add(t);
    }
    public void clear(){
        input.clear();
        tool.clear();
    }
    public void erase(){
        if(check)input.remove(input.size()-1);
        else tool.remove(tool.size()-1);
        check = !check;
    }
    public String result(){
        double myResult = 0.0;
        int i;
        for (i=0; i<=input.size()-1;i++){
            if(i==0 || tool.get(i-1).equals("+"))
            myResult += Double.parseDouble(input.get(i));
            else if(tool.get(i-1).equals("*"))
            myResult *= Double.parseDouble(input.get(i));
            else if(tool.get(i-1).equals("/"))
            myResult /= Double.parseDouble(input.get(i));
            else if(tool.get(i-1).equals("-"))
            myResult -= Double.parseDouble(input.get(i));
        }
        return ""+myResult;
    }
}

