package cn.edu.zafu.ytd.stupidcalculator;

import android.util.Log;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class Calculator {
    boolean check = false;
    ArrayList<String> input = new ArrayList<>();
    ArrayList<String> tool = new ArrayList<>();
    public Calculator(){
        addTool("+");
    }

    public void addInput(String s){
        check =  true;
        input.add(s);
    }
    public void addTool(String t){
        check =  false;
        tool.add(t);
    }
    public void removeTool(){
        check =  true;
        tool.remove(tool.size()-1);
    }
    public void removeInput(){
        check =  false;
        input.remove(input.size()-1);
    }
    public void clear(){
        input.clear();
        tool.clear();
        addTool("+");
    }
    public void erase(){
        if(check)removeInput();
        else removeTool();
    }
    public String result(){
        double myResult = 0.0;
        int i;
        Log.e(TAG, "result: toolSize "+tool.size(), null );
        Log.e(TAG, "result: inputSize "+input.size(), null );
        for (i=0; i<input.size();i++){
            if(tool.get(i).equals("+"))
            myResult += Double.parseDouble(input.get(i));
            else if(tool.get(i).equals("x"))
            myResult *= Double.parseDouble(input.get(i));
            else if(tool.get(i).equals("/"))
            myResult /= Double.parseDouble(input.get(i));
            else if(tool.get(i).equals("-"))
            myResult -= Double.parseDouble(input.get(i));
            else if(tool.get(i).equals("%"))
                myResult /= 100;
        }
        return ""+myResult;
    }
}

