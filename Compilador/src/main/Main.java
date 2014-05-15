package main;

import interpret.Interpreter;

import java.io.FileReader;
import java.io.PushbackReader;

import org.sablecc.portugol.lexer.Lexer;
import org.sablecc.portugol.node.Start;
import org.sablecc.portugol.parser.Parser;

/* Create an AST, then invoke our interpreter. */ 

public class Main { 
   public static void main(String[] args) { 
      if (args.length > 0) { 
         try { 
            /* Form our AST */ 
            Lexer lexer = new Lexer (new PushbackReader( 
               new FileReader(args[0]), 1024)); 
            Parser parser = new Parser(lexer); 
            Start ast = parser.parse() ; 
  
            /* Get our Interpreter going. */ 
            Interpreter interp = new Interpreter () ; 
            ast.apply(interp) ; 
         } 
         catch (Exception e) { 
            System.out.println (e) ; 
         } 
      } else { 
         System.err.println("usage: java simpleAdder inputFile"); 
         System.exit(1); 
      } 
   } 
}