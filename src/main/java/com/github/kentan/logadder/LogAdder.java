package com.github.kentan.logadder;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.Statement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;


public class LogAdder {
	private String importingClassName;
	private Statement logStatement;
	public void setImportingClassName(String importingClassName){
		this.importingClassName = importingClassName;
	}
	public void setLogStatement(Statement logStatement){
		this.logStatement = logStatement;
	}
	public void addLog(String rootDirectory) throws Exception {

		findJavaAndAddLog(rootDirectory);

	}

	private void addImportStatement(CompilationUnit cu){
		if(this.importingClassName == null){
			return ;
		}
		ImportDeclaration importDecl = new ImportDeclaration();
		NameExpr nameExpr = new NameExpr();
		nameExpr.setName(this.importingClassName);
		importDecl.setName(nameExpr);
		cu.getImports().add(importDecl);
	}

	private void addLogStatement(CompilationUnit cu){
		for(TypeDeclaration typeDecl : cu.getTypes()){

			for(BodyDeclaration bodyDecl: typeDecl.getMembers()){
				if(bodyDecl instanceof MethodDeclaration) {
					MethodDeclaration methodDecl = (MethodDeclaration)bodyDecl;
					BlockStmt blockStmt = methodDecl.getBody();
					ExpressionStmt expressionStmt = new ExpressionStmt();
					blockStmt.getStmts().add(0,logStatement);

				}
			}

		}
	}
	private void addStatements(String path){
		FileInputStream in = null;
		CompilationUnit cu = null;
		FileWriter fw = null;
		try {
			in = new FileInputStream(path);
			// parse the file
			cu = JavaParser.parse(in);


			addImportStatement(cu);
			addLogStatement(cu);

			fw = new FileWriter(path,false);
			String newSource = cu.toString();
			fw.write(newSource);

		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				in.close();
				fw.close();
			}catch(Exception e1){}
		}
	}

	private void findJavaAndAddLog(String dir){
		File file = new File(dir);
		findJavaAndAddLogRec(file);
	}
	private void findJavaAndAddLogRec(File file){
		if(file.isDirectory()){
			for(File f : file.listFiles()) {
				findJavaAndAddLogRec(f);
			}
		}else if(file.getAbsolutePath().endsWith(".java")){

			addStatements(file.getAbsolutePath());
		}
	}
}
