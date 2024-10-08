package ast.Statment.FunctionStatment;

import ast.CodeGeneartion;
import ast.Statment.Statment;
import ast.Statment.Variable.Variable;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;

public class Function extends Statment  {
    public int line ;
    public String functionName ;
    public ArrayList<Variable> params ;
    public ArrayList<Statment> statments ;
    public Variable returnValue ;
    public Function(int line , String functionName , ArrayList<Variable> params, ArrayList<Statment> statments , Variable returnValue ){
        this.statments = statments;
        this.params = params ;
        this.returnValue = returnValue;
        this.functionName = functionName ;
        this.setLine(line);
    }
    public Function(){

    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public Variable getReturnValue() {
        return returnValue;
    }
    public void setReturnValue(Variable returnValue) {
        this.returnValue = returnValue;
    }

    public void setStatments(ArrayList<Statment> statments) {
        this.statments = statments;
    }

    public void setParams(ArrayList<Variable> params) {
        this.params = params;
    }

    public ArrayList<Variable> getParams() {
        return params;
    }

    public ArrayList<Statment> getStatments() {
        return statments;
    }

    public void setLine(int line) {
        this.line = line;
    }
    @Override
    public int getLine() {
        return line;
    }
    public String toString(){
        return symbol();
    }
    @Override
    public String symbol() {
        String str =  "Function { \n " + "params={" + params.toString()  + "}\n" ;
        str +=  ", statments= { \n" ;
        for(int i =0  ;i < statments.size() ;i++){
            str+= statments.get(i).toString() + " \n ";
        }
        str += "}\n";
        str += ", returnStatment={" + returnValue.toString() + "}\n" +
                " }\n" ;
        return str ;

    }
    public Pair<String,String> generate(){
        String html = "" ;
        String js = "function " + functionName + "("  ;
        for(int i =0 ;i < params.size() ;i++){
            js += params.get(i).getVarName() ;
            if(i != params.size()-1){
                js+= ", " ;
            }
        }
        js += ") { \n " ;
        for(int i =0 ;i < statments.size() ;i++){
            if(statments.get(i).generate().b != null )
                js += statments.get(i).generate().b + " \n" ;
        }
        js+= "return " + returnValue.getVarValue() + "\n";
        js += "}\n";

        return new Pair(html ,js);
    }
}
