
//import ErrorHandling.SemanticError;
//import ErrorHandling.SyntaxError;
////import sympolTable.SymbolTable;
////import sympolTable.SymbolTable;

import ast.Program;
import ast.Statment.Statment;
import ast.visitor.BaseVisitor;
import antlr.ReactParser;
import antlr.ReactLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.IOException;
import java.util.ArrayList;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Main {

    public static void main(String[] args) {
        System.out.println("te");
        try {

//            SyntaxError syntaxError=new SyntaxError();

            String source = "/home/social/IdeaProjects/React/src/tests/test.txt";
            CharStream cs = fromFileName(source);
            ReactLexer lexer = new ReactLexer(cs);
//            lexer.removeErrorListeners();
//            lexer.addErrorListener(syntaxError.INSTANCE);
            CommonTokenStream token  = new CommonTokenStream(lexer);
            ReactParser parser = new ReactParser(token);
//            System.out.println(cs);
//            parser.removeErrorListeners();
//            parser.addErrorListener(syntaxError.INSTANCE);

            ParseTree tree = parser.program();
            System.out.println("Tree " + tree.toString());
            BaseVisitor baseVisitor=  new BaseVisitor();
//            System.out.println(baseVisitor);
            Program program = (Program) baseVisitor.visit(tree);
            program.print_ast();
            program.generateCode();
            baseVisitor.symbolTable.printTable();

//            System.out.println("\n\n\n"+"******* SYMPOL TABLE  *******"+"\n");
//            for (int i=0;i<baseVisitor.AST.size();i++){
//                System.out.println(baseVisitor.AST.get(i).symbol());
//            }
//
//            System.out.println("\n\n\n"+"******* GENERATION CODE *******"+"\n");
//            for (int i=0;i<baseVisitor.AST.size();i++){
//                System.out.println(baseVisitor.AST.get(i).generateCode());
//            }
//
//            SymbolTable symbolTable =SymbolTable.getInstance();


//            SemanticError semanticError =new SemanticError();
//            semanticError.checkErrors();

//            if (!symbolTable.hasSyntaxError&&!symbolTable.hasSemanticError){
//                symbolTable.generateHtmlCode();
//
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}