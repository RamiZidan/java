package ast.Statment;

import ast.CodeGeneartion;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;

public class Export extends Statment  {
    public int line ;
    public ArrayList<String> items ;
    public String exportType ;

    public Export(int line , String exportType, ArrayList<String> items){
        this.exportType = exportType ;
        this.items = items;
        this.setLine(line);
    }

    public void setExportType(String exportType){
        this.exportType = exportType;
    }
    public void setItems(ArrayList<String> items ){
        this.items= items ;
    }
    public String getExportType(){
        return exportType;
    }
    public ArrayList<String> getItems(){
        return items;
    }
    public String toString(){
        return symbol();
    }
    public String symbol(){
        return "Export Statment { \n" + "type={" + exportType + "} items={" + items.toString() + "}\n }\n" ;
    }
    @Override
    public Pair<String,String> generate() {

        return new Pair("","");
    }
    public void setLine(int line){
        this.line = line ;
    }
    public int getLine(){
        return line;
    }
}
