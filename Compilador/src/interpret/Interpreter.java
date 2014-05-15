package interpret;

import org.sablecc.portugol.analysis.DepthFirstAdapter;
import org.sablecc.portugol.node.AProgram;

  
public class Interpreter extends DepthFirstAdapter { 
  
   public void caseAProgram(AProgram node) { 
      String lhs = node.getDot().getText().trim(); 
      String rhs = node.getDot().getText().trim(); 
      int result = (new Integer(lhs)).intValue() + (new Integer(rhs)).intValue(); 
      System.out.println(lhs + "+" + rhs + "=" + result); 
   } 
}