package com.github.kentan.logadder.sample;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.stmt.Statement;
import com.github.kentan.logadder.LogAdder;

public class StdOutAdder {

    public static void main(String args[]) {
        LogAdder logAdder = new  LogAdder();
        //		String filePath = "C:\\develop\\LogAdder\\src\\main\\java\\com\\github\\kentan\\logadder\\sample\\StdOutAdder.java";
        String filePath = "C:\\develop\\LogAdder\\src\\main\\java\\com\\github\\kentan\\logadder\\sample\\data";
        String message = "\"I\'m at \"+";
        String addingStatement = "System.out.println(" + message + "new Exception().getStackTrace()[0].toString());";
        try {
            Statement statement = JavaParser.parseStatement(addingStatement);
            logAdder.setLogStatement(statement);
            logAdder.addLog(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
