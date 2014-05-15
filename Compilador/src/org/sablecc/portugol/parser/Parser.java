/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.portugol.parser;

import org.sablecc.portugol.lexer.*;
import org.sablecc.portugol.node.*;
import org.sablecc.portugol.analysis.*;
import java.util.*;

import java.io.DataInputStream;
import java.io.BufferedInputStream;
import java.io.IOException;

@SuppressWarnings("nls")
public class Parser
{
    public final Analysis ignoredTokens = new AnalysisAdapter();

    protected ArrayList<Object> nodeList;

    private final Lexer lexer;
    private final ListIterator<Object> stack = new LinkedList<Object>().listIterator();
    private int last_pos;
    private int last_line;
    private Token last_token;
    private final TokenIndex converter = new TokenIndex();
    private final int[] action = new int[2];

    private final static int SHIFT = 0;
    private final static int REDUCE = 1;
    private final static int ACCEPT = 2;
    private final static int ERROR = 3;

    public Parser(@SuppressWarnings("hiding") Lexer lexer)
    {
        this.lexer = lexer;
    }

    protected void filter() throws ParserException, LexerException, IOException
    {
        // Empty body
    }

    private void push(int numstate, ArrayList<Object> listNode, boolean hidden) throws ParserException, LexerException, IOException
    {
        this.nodeList = listNode;

        if(!hidden)
        {
            filter();
        }

        if(!this.stack.hasNext())
        {
            this.stack.add(new State(numstate, this.nodeList));
            return;
        }

        State s = (State) this.stack.next();
        s.state = numstate;
        s.nodes = this.nodeList;
    }

    private int goTo(int index)
    {
        int state = state();
        int low = 1;
        int high = gotoTable[index].length - 1;
        int value = gotoTable[index][0][1];

        while(low <= high)
        {
            // int middle = (low + high) / 2;
            int middle = (low + high) >>> 1;

            if(state < gotoTable[index][middle][0])
            {
                high = middle - 1;
            }
            else if(state > gotoTable[index][middle][0])
            {
                low = middle + 1;
            }
            else
            {
                value = gotoTable[index][middle][1];
                break;
            }
        }

        return value;
    }

    private int state()
    {
        State s = (State) this.stack.previous();
        this.stack.next();
        return s.state;
    }

    private ArrayList<Object> pop()
    {
        return ((State) this.stack.previous()).nodes;
    }

    private int index(Switchable token)
    {
        this.converter.index = -1;
        token.apply(this.converter);
        return this.converter.index;
    }

    @SuppressWarnings("unchecked")
    public Start parse() throws ParserException, LexerException, IOException
    {
        push(0, null, true);
        List<Node> ign = null;
        while(true)
        {
            while(index(this.lexer.peek()) == -1)
            {
                if(ign == null)
                {
                    ign = new LinkedList<Node>();
                }

                ign.add(this.lexer.next());
            }

            if(ign != null)
            {
                this.ignoredTokens.setIn(this.lexer.peek(), ign);
                ign = null;
            }

            this.last_pos = this.lexer.peek().getPos();
            this.last_line = this.lexer.peek().getLine();
            this.last_token = this.lexer.peek();

            int index = index(this.lexer.peek());
            this.action[0] = Parser.actionTable[state()][0][1];
            this.action[1] = Parser.actionTable[state()][0][2];

            int low = 1;
            int high = Parser.actionTable[state()].length - 1;

            while(low <= high)
            {
                int middle = (low + high) / 2;

                if(index < Parser.actionTable[state()][middle][0])
                {
                    high = middle - 1;
                }
                else if(index > Parser.actionTable[state()][middle][0])
                {
                    low = middle + 1;
                }
                else
                {
                    this.action[0] = Parser.actionTable[state()][middle][1];
                    this.action[1] = Parser.actionTable[state()][middle][2];
                    break;
                }
            }

            switch(this.action[0])
            {
                case SHIFT:
		    {
		        ArrayList<Object> list = new ArrayList<Object>();
		        list.add(this.lexer.next());
                        push(this.action[1], list, false);
                    }
		    break;
                case REDUCE:
                    {
                        int reduction = this.action[1];
                        if(reduction < 500) reduce_0(reduction);
                    }
                    break;
                case ACCEPT:
                    {
                        EOF node2 = (EOF) this.lexer.next();
                        PProgram node1 = (PProgram) pop().get(0);
                        Start node = new Start(node1, node2);
                        return node;
                    }
                case ERROR:
                    throw new ParserException(this.last_token,
                        "[" + this.last_line + "," + this.last_pos + "] " +
                        Parser.errorMessages[Parser.errors[this.action[1]]]);
            }
        }
    }

    private void reduce_0(int reduction) throws IOException, LexerException, ParserException
    {
        switch(reduction)
        {
            case 0: /* reduce AProgram */
            {
                ArrayList<Object> list = new0();
                push(goTo(0), list, false);
            }
            break;
            case 1: /* reduce AProgramHeading */
            {
                ArrayList<Object> list = new1();
                push(goTo(1), list, false);
            }
            break;
            case 2: /* reduce AAdeclarations1Declarations */
            {
                ArrayList<Object> list = new2();
                push(goTo(2), list, false);
            }
            break;
            case 3: /* reduce AAdeclarations2Declarations */
            {
                ArrayList<Object> list = new3();
                push(goTo(2), list, false);
            }
            break;
            case 4: /* reduce AVariablesDeclaration */
            {
                ArrayList<Object> list = new4();
                push(goTo(3), list, false);
            }
            break;
            case 5: /* reduce ASingleVariablesDefinitionList */
            {
                ArrayList<Object> list = new5();
                push(goTo(4), list, false);
            }
            break;
            case 6: /* reduce AMultipleVariablesDefinitionList */
            {
                ArrayList<Object> list = new6();
                push(goTo(4), list, false);
            }
            break;
            case 7: /* reduce AVariablesDefinition */
            {
                ArrayList<Object> list = new7();
                push(goTo(5), list, false);
            }
            break;
            case 8: /* reduce ASingleIdentifierList */
            {
                ArrayList<Object> list = new8();
                push(goTo(6), list, false);
            }
            break;
            case 9: /* reduce AMultipleIdentifierList */
            {
                ArrayList<Object> list = new9();
                push(goTo(6), list, false);
            }
            break;
            case 10: /* reduce AType */
            {
                ArrayList<Object> list = new10();
                push(goTo(7), list, false);
            }
            break;
            case 11: /* reduce ABody */
            {
                ArrayList<Object> list = new11();
                push(goTo(8), list, false);
            }
            break;
            case 12: /* reduce ASingleStatementSequence */
            {
                ArrayList<Object> list = new12();
                push(goTo(9), list, false);
            }
            break;
            case 13: /* reduce AMultipleStatementSequence */
            {
                ArrayList<Object> list = new13();
                push(goTo(9), list, false);
            }
            break;
            case 14: /* reduce AWritelnStatement */
            {
                ArrayList<Object> list = new14();
                push(goTo(10), list, false);
            }
            break;
            case 15: /* reduce AAssignmentStatement */
            {
                ArrayList<Object> list = new15();
                push(goTo(10), list, false);
            }
            break;
            case 16: /* reduce AEmptyStatement */
            {
                ArrayList<Object> list = new16();
                push(goTo(10), list, false);
            }
            break;
            case 17: /* reduce ATermExpression */
            {
                ArrayList<Object> list = new17();
                push(goTo(11), list, false);
            }
            break;
            case 18: /* reduce APlusExpression */
            {
                ArrayList<Object> list = new18();
                push(goTo(11), list, false);
            }
            break;
            case 19: /* reduce AMinusExpression */
            {
                ArrayList<Object> list = new19();
                push(goTo(11), list, false);
            }
            break;
            case 20: /* reduce AFactorTerm */
            {
                ArrayList<Object> list = new20();
                push(goTo(12), list, false);
            }
            break;
            case 21: /* reduce AMultTerm */
            {
                ArrayList<Object> list = new21();
                push(goTo(12), list, false);
            }
            break;
            case 22: /* reduce ADivTerm */
            {
                ArrayList<Object> list = new22();
                push(goTo(12), list, false);
            }
            break;
            case 23: /* reduce AIdentifierFactor */
            {
                ArrayList<Object> list = new23();
                push(goTo(13), list, false);
            }
            break;
            case 24: /* reduce ANumberFactor */
            {
                ArrayList<Object> list = new24();
                push(goTo(13), list, false);
            }
            break;
            case 25: /* reduce AExpressionFactor */
            {
                ArrayList<Object> list = new25();
                push(goTo(13), list, false);
            }
            break;
        }
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new0() /* reduce AProgram */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList4 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PProgram pprogramNode1;
        {
            // Block
        PProgramHeading pprogramheadingNode2;
        PDeclarations pdeclarationsNode3;
        PBody pbodyNode4;
        TDot tdotNode5;
        pprogramheadingNode2 = (PProgramHeading)nodeArrayList1.get(0);
        pdeclarationsNode3 = (PDeclarations)nodeArrayList2.get(0);
        pbodyNode4 = (PBody)nodeArrayList3.get(0);
        tdotNode5 = (TDot)nodeArrayList4.get(0);

        pprogramNode1 = new AProgram(pprogramheadingNode2, pdeclarationsNode3, pbodyNode4, tdotNode5);
        }
	nodeList.add(pprogramNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new1() /* reduce AProgramHeading */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PProgramHeading pprogramheadingNode1;
        {
            // Block
        TProgram tprogramNode2;
        TIdentifier tidentifierNode3;
        TSemicolon tsemicolonNode4;
        tprogramNode2 = (TProgram)nodeArrayList1.get(0);
        tidentifierNode3 = (TIdentifier)nodeArrayList2.get(0);
        tsemicolonNode4 = (TSemicolon)nodeArrayList3.get(0);

        pprogramheadingNode1 = new AProgramHeading(tprogramNode2, tidentifierNode3, tsemicolonNode4);
        }
	nodeList.add(pprogramheadingNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new2() /* reduce AAdeclarations1Declarations */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        PDeclarations pdeclarationsNode1;
        {
            // Block
        @SuppressWarnings("unused") Object nullNode2 = null;

        pdeclarationsNode1 = new ADeclarations(null);
        }
	nodeList.add(pdeclarationsNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new3() /* reduce AAdeclarations2Declarations */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PDeclarations pdeclarationsNode1;
        {
            // Block
        PVariablesDeclaration pvariablesdeclarationNode2;
        pvariablesdeclarationNode2 = (PVariablesDeclaration)nodeArrayList1.get(0);

        pdeclarationsNode1 = new ADeclarations(pvariablesdeclarationNode2);
        }
	nodeList.add(pdeclarationsNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new4() /* reduce AVariablesDeclaration */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PVariablesDeclaration pvariablesdeclarationNode1;
        {
            // Block
        TVar tvarNode2;
        PVariablesDefinitionList pvariablesdefinitionlistNode3;
        tvarNode2 = (TVar)nodeArrayList1.get(0);
        pvariablesdefinitionlistNode3 = (PVariablesDefinitionList)nodeArrayList2.get(0);

        pvariablesdeclarationNode1 = new AVariablesDeclaration(tvarNode2, pvariablesdefinitionlistNode3);
        }
	nodeList.add(pvariablesdeclarationNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new5() /* reduce ASingleVariablesDefinitionList */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PVariablesDefinitionList pvariablesdefinitionlistNode1;
        {
            // Block
        PVariablesDefinition pvariablesdefinitionNode2;
        pvariablesdefinitionNode2 = (PVariablesDefinition)nodeArrayList1.get(0);

        pvariablesdefinitionlistNode1 = new ASingleVariablesDefinitionList(pvariablesdefinitionNode2);
        }
	nodeList.add(pvariablesdefinitionlistNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new6() /* reduce AMultipleVariablesDefinitionList */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PVariablesDefinitionList pvariablesdefinitionlistNode1;
        {
            // Block
        PVariablesDefinitionList pvariablesdefinitionlistNode2;
        PVariablesDefinition pvariablesdefinitionNode3;
        pvariablesdefinitionlistNode2 = (PVariablesDefinitionList)nodeArrayList1.get(0);
        pvariablesdefinitionNode3 = (PVariablesDefinition)nodeArrayList2.get(0);

        pvariablesdefinitionlistNode1 = new AMultipleVariablesDefinitionList(pvariablesdefinitionlistNode2, pvariablesdefinitionNode3);
        }
	nodeList.add(pvariablesdefinitionlistNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new7() /* reduce AVariablesDefinition */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList4 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PVariablesDefinition pvariablesdefinitionNode1;
        {
            // Block
        PIdentifierList pidentifierlistNode2;
        TColon tcolonNode3;
        PType ptypeNode4;
        TSemicolon tsemicolonNode5;
        pidentifierlistNode2 = (PIdentifierList)nodeArrayList1.get(0);
        tcolonNode3 = (TColon)nodeArrayList2.get(0);
        ptypeNode4 = (PType)nodeArrayList3.get(0);
        tsemicolonNode5 = (TSemicolon)nodeArrayList4.get(0);

        pvariablesdefinitionNode1 = new AVariablesDefinition(pidentifierlistNode2, tcolonNode3, ptypeNode4, tsemicolonNode5);
        }
	nodeList.add(pvariablesdefinitionNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new8() /* reduce ASingleIdentifierList */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PIdentifierList pidentifierlistNode1;
        {
            // Block
        TIdentifier tidentifierNode2;
        tidentifierNode2 = (TIdentifier)nodeArrayList1.get(0);

        pidentifierlistNode1 = new ASingleIdentifierList(tidentifierNode2);
        }
	nodeList.add(pidentifierlistNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new9() /* reduce AMultipleIdentifierList */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PIdentifierList pidentifierlistNode1;
        {
            // Block
        PIdentifierList pidentifierlistNode2;
        TComma tcommaNode3;
        TIdentifier tidentifierNode4;
        pidentifierlistNode2 = (PIdentifierList)nodeArrayList1.get(0);
        tcommaNode3 = (TComma)nodeArrayList2.get(0);
        tidentifierNode4 = (TIdentifier)nodeArrayList3.get(0);

        pidentifierlistNode1 = new AMultipleIdentifierList(pidentifierlistNode2, tcommaNode3, tidentifierNode4);
        }
	nodeList.add(pidentifierlistNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new10() /* reduce AType */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PType ptypeNode1;
        {
            // Block
        TInteger tintegerNode2;
        tintegerNode2 = (TInteger)nodeArrayList1.get(0);

        ptypeNode1 = new AType(tintegerNode2);
        }
	nodeList.add(ptypeNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new11() /* reduce ABody */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PBody pbodyNode1;
        {
            // Block
        TBegin tbeginNode2;
        PStatementSequence pstatementsequenceNode3;
        TEnd tendNode4;
        tbeginNode2 = (TBegin)nodeArrayList1.get(0);
        pstatementsequenceNode3 = (PStatementSequence)nodeArrayList2.get(0);
        tendNode4 = (TEnd)nodeArrayList3.get(0);

        pbodyNode1 = new ABody(tbeginNode2, pstatementsequenceNode3, tendNode4);
        }
	nodeList.add(pbodyNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new12() /* reduce ASingleStatementSequence */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PStatementSequence pstatementsequenceNode1;
        {
            // Block
        PStatement pstatementNode2;
        pstatementNode2 = (PStatement)nodeArrayList1.get(0);

        pstatementsequenceNode1 = new ASingleStatementSequence(pstatementNode2);
        }
	nodeList.add(pstatementsequenceNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new13() /* reduce AMultipleStatementSequence */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PStatementSequence pstatementsequenceNode1;
        {
            // Block
        PStatementSequence pstatementsequenceNode2;
        TSemicolon tsemicolonNode3;
        PStatement pstatementNode4;
        pstatementsequenceNode2 = (PStatementSequence)nodeArrayList1.get(0);
        tsemicolonNode3 = (TSemicolon)nodeArrayList2.get(0);
        pstatementNode4 = (PStatement)nodeArrayList3.get(0);

        pstatementsequenceNode1 = new AMultipleStatementSequence(pstatementsequenceNode2, tsemicolonNode3, pstatementNode4);
        }
	nodeList.add(pstatementsequenceNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new14() /* reduce AWritelnStatement */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList4 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PStatement pstatementNode1;
        {
            // Block
        TWriteln twritelnNode2;
        TLParen tlparenNode3;
        PExpression pexpressionNode4;
        TRParen trparenNode5;
        twritelnNode2 = (TWriteln)nodeArrayList1.get(0);
        tlparenNode3 = (TLParen)nodeArrayList2.get(0);
        pexpressionNode4 = (PExpression)nodeArrayList3.get(0);
        trparenNode5 = (TRParen)nodeArrayList4.get(0);

        pstatementNode1 = new AWritelnStatement(twritelnNode2, tlparenNode3, pexpressionNode4, trparenNode5);
        }
	nodeList.add(pstatementNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new15() /* reduce AAssignmentStatement */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PStatement pstatementNode1;
        {
            // Block
        TIdentifier tidentifierNode2;
        TAssignop tassignopNode3;
        PExpression pexpressionNode4;
        tidentifierNode2 = (TIdentifier)nodeArrayList1.get(0);
        tassignopNode3 = (TAssignop)nodeArrayList2.get(0);
        pexpressionNode4 = (PExpression)nodeArrayList3.get(0);

        pstatementNode1 = new AAssignmentStatement(tidentifierNode2, tassignopNode3, pexpressionNode4);
        }
	nodeList.add(pstatementNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new16() /* reduce AEmptyStatement */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        PStatement pstatementNode1;
        {
            // Block

        pstatementNode1 = new AEmptyStatement();
        }
	nodeList.add(pstatementNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new17() /* reduce ATermExpression */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpression pexpressionNode1;
        {
            // Block
        PTerm ptermNode2;
        ptermNode2 = (PTerm)nodeArrayList1.get(0);

        pexpressionNode1 = new ATermExpression(ptermNode2);
        }
	nodeList.add(pexpressionNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new18() /* reduce APlusExpression */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpression pexpressionNode1;
        {
            // Block
        PExpression pexpressionNode2;
        TPlus tplusNode3;
        PTerm ptermNode4;
        pexpressionNode2 = (PExpression)nodeArrayList1.get(0);
        tplusNode3 = (TPlus)nodeArrayList2.get(0);
        ptermNode4 = (PTerm)nodeArrayList3.get(0);

        pexpressionNode1 = new APlusExpression(pexpressionNode2, tplusNode3, ptermNode4);
        }
	nodeList.add(pexpressionNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new19() /* reduce AMinusExpression */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PExpression pexpressionNode1;
        {
            // Block
        PExpression pexpressionNode2;
        TMinus tminusNode3;
        PTerm ptermNode4;
        pexpressionNode2 = (PExpression)nodeArrayList1.get(0);
        tminusNode3 = (TMinus)nodeArrayList2.get(0);
        ptermNode4 = (PTerm)nodeArrayList3.get(0);

        pexpressionNode1 = new AMinusExpression(pexpressionNode2, tminusNode3, ptermNode4);
        }
	nodeList.add(pexpressionNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new20() /* reduce AFactorTerm */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PTerm ptermNode1;
        {
            // Block
        PFactor pfactorNode2;
        pfactorNode2 = (PFactor)nodeArrayList1.get(0);

        ptermNode1 = new AFactorTerm(pfactorNode2);
        }
	nodeList.add(ptermNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new21() /* reduce AMultTerm */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PTerm ptermNode1;
        {
            // Block
        PTerm ptermNode2;
        TMult tmultNode3;
        PFactor pfactorNode4;
        ptermNode2 = (PTerm)nodeArrayList1.get(0);
        tmultNode3 = (TMult)nodeArrayList2.get(0);
        pfactorNode4 = (PFactor)nodeArrayList3.get(0);

        ptermNode1 = new AMultTerm(ptermNode2, tmultNode3, pfactorNode4);
        }
	nodeList.add(ptermNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new22() /* reduce ADivTerm */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PTerm ptermNode1;
        {
            // Block
        PTerm ptermNode2;
        TDiv tdivNode3;
        PFactor pfactorNode4;
        ptermNode2 = (PTerm)nodeArrayList1.get(0);
        tdivNode3 = (TDiv)nodeArrayList2.get(0);
        pfactorNode4 = (PFactor)nodeArrayList3.get(0);

        ptermNode1 = new ADivTerm(ptermNode2, tdivNode3, pfactorNode4);
        }
	nodeList.add(ptermNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new23() /* reduce AIdentifierFactor */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PFactor pfactorNode1;
        {
            // Block
        TIdentifier tidentifierNode2;
        tidentifierNode2 = (TIdentifier)nodeArrayList1.get(0);

        pfactorNode1 = new AIdentifierFactor(tidentifierNode2);
        }
	nodeList.add(pfactorNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new24() /* reduce ANumberFactor */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PFactor pfactorNode1;
        {
            // Block
        TNumber tnumberNode2;
        tnumberNode2 = (TNumber)nodeArrayList1.get(0);

        pfactorNode1 = new ANumberFactor(tnumberNode2);
        }
	nodeList.add(pfactorNode1);
        return nodeList;
    }



    @SuppressWarnings({ "unchecked", "rawtypes" })
    ArrayList<Object> new25() /* reduce AExpressionFactor */
    {
        @SuppressWarnings("hiding") ArrayList<Object> nodeList = new ArrayList<Object>();

        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList<Object> nodeArrayList1 = pop();
        PFactor pfactorNode1;
        {
            // Block
        TLParen tlparenNode2;
        PExpression pexpressionNode3;
        TRParen trparenNode4;
        tlparenNode2 = (TLParen)nodeArrayList1.get(0);
        pexpressionNode3 = (PExpression)nodeArrayList2.get(0);
        trparenNode4 = (TRParen)nodeArrayList3.get(0);

        pfactorNode1 = new AExpressionFactor(tlparenNode2, pexpressionNode3, trparenNode4);
        }
	nodeList.add(pfactorNode1);
        return nodeList;
    }



    private static int[][][] actionTable;
/*      {
			{{-1, ERROR, 0}, {4, SHIFT, 1}, },
			{{-1, ERROR, 1}, {17, SHIFT, 4}, },
			{{-1, ERROR, 2}, {19, ACCEPT, -1}, },
			{{-1, REDUCE, 2}, {2, SHIFT, 5}, },
			{{-1, ERROR, 4}, {13, SHIFT, 8}, },
			{{-1, ERROR, 5}, {17, SHIFT, 9}, },
			{{-1, ERROR, 6}, {3, SHIFT, 13}, },
			{{-1, REDUCE, 3}, },
			{{-1, REDUCE, 1}, },
			{{-1, REDUCE, 8}, },
			{{-1, REDUCE, 4}, {17, SHIFT, 9}, },
			{{-1, REDUCE, 5}, },
			{{-1, ERROR, 12}, {11, SHIFT, 16}, {12, SHIFT, 17}, },
			{{-1, REDUCE, 16}, {5, SHIFT, 18}, {17, SHIFT, 19}, },
			{{-1, ERROR, 14}, {14, SHIFT, 22}, },
			{{-1, REDUCE, 6}, },
			{{-1, ERROR, 16}, {17, SHIFT, 23}, },
			{{-1, ERROR, 17}, {6, SHIFT, 24}, },
			{{-1, ERROR, 18}, {15, SHIFT, 26}, },
			{{-1, ERROR, 19}, {10, SHIFT, 27}, },
			{{-1, ERROR, 20}, {0, SHIFT, 28}, {13, SHIFT, 29}, },
			{{-1, REDUCE, 12}, },
			{{-1, REDUCE, 0}, },
			{{-1, REDUCE, 9}, },
			{{-1, REDUCE, 10}, },
			{{-1, ERROR, 25}, {13, SHIFT, 30}, },
			{{-1, ERROR, 26}, {15, SHIFT, 31}, {17, SHIFT, 32}, {18, SHIFT, 33}, },
			{{-1, ERROR, 27}, {15, SHIFT, 31}, {17, SHIFT, 32}, {18, SHIFT, 33}, },
			{{-1, REDUCE, 11}, },
			{{-1, REDUCE, 16}, {5, SHIFT, 18}, {17, SHIFT, 19}, },
			{{-1, REDUCE, 7}, },
			{{-1, ERROR, 31}, {15, SHIFT, 31}, {17, SHIFT, 32}, {18, SHIFT, 33}, },
			{{-1, REDUCE, 23}, },
			{{-1, REDUCE, 24}, },
			{{-1, ERROR, 34}, {7, SHIFT, 40}, {8, SHIFT, 41}, {16, SHIFT, 42}, },
			{{-1, REDUCE, 17}, {1, SHIFT, 43}, {9, SHIFT, 44}, },
			{{-1, REDUCE, 20}, },
			{{-1, REDUCE, 15}, {7, SHIFT, 40}, {8, SHIFT, 41}, },
			{{-1, REDUCE, 13}, },
			{{-1, ERROR, 39}, {7, SHIFT, 40}, {8, SHIFT, 41}, {16, SHIFT, 45}, },
			{{-1, ERROR, 40}, {15, SHIFT, 31}, {17, SHIFT, 32}, {18, SHIFT, 33}, },
			{{-1, ERROR, 41}, {15, SHIFT, 31}, {17, SHIFT, 32}, {18, SHIFT, 33}, },
			{{-1, REDUCE, 14}, },
			{{-1, ERROR, 43}, {15, SHIFT, 31}, {17, SHIFT, 32}, {18, SHIFT, 33}, },
			{{-1, ERROR, 44}, {15, SHIFT, 31}, {17, SHIFT, 32}, {18, SHIFT, 33}, },
			{{-1, REDUCE, 25}, },
			{{-1, REDUCE, 18}, {1, SHIFT, 43}, {9, SHIFT, 44}, },
			{{-1, REDUCE, 19}, {1, SHIFT, 43}, {9, SHIFT, 44}, },
			{{-1, REDUCE, 22}, },
			{{-1, REDUCE, 21}, },
        };*/
    private static int[][][] gotoTable;
/*      {
			{{-1, 2}, },
			{{-1, 3}, },
			{{-1, 6}, },
			{{-1, 7}, },
			{{-1, 10}, },
			{{-1, 11}, {10, 15}, },
			{{-1, 12}, },
			{{-1, 25}, },
			{{-1, 14}, },
			{{-1, 20}, },
			{{-1, 21}, {29, 38}, },
			{{-1, 34}, {27, 37}, {31, 39}, },
			{{-1, 35}, {40, 46}, {41, 47}, },
			{{-1, 36}, {43, 48}, {44, 49}, },
        };*/
    private static String[] errorMessages;
/*      {
			"expecting: program",
			"expecting: identifier",
			"expecting: EOF",
			"expecting: var, begin",
			"expecting: ';'",
			"expecting: begin",
			"expecting: ',', ':'",
			"expecting: begin, identifier",
			"expecting: end, writeln, ';', identifier",
			"expecting: '.'",
			"expecting: integer",
			"expecting: '('",
			"expecting: ':='",
			"expecting: end, ';'",
			"expecting: '(', identifier, number",
			"expecting: end, div, '+', '-', '*', ';', ')'",
			"expecting: '+', '-', ')'",
			"expecting: end, '+', '-', ';'",
        };*/
    private static int[] errors;
/*      {
			0, 1, 2, 3, 4, 1, 5, 5, 3, 6, 7, 7, 6, 8, 9, 7, 1, 10, 11, 12, 13, 13, 2, 6, 4, 4, 14, 14, 9, 8, 7, 14, 15, 15, 16, 15, 15, 17, 13, 16, 14, 14, 13, 14, 14, 15, 15, 15, 15, 15, 
        };*/

    static 
    {
        try
        {
            DataInputStream s = new DataInputStream(
                new BufferedInputStream(
                Parser.class.getResourceAsStream("parser.dat")));

            // read actionTable
            int length = s.readInt();
            Parser.actionTable = new int[length][][];
            for(int i = 0; i < Parser.actionTable.length; i++)
            {
                length = s.readInt();
                Parser.actionTable[i] = new int[length][3];
                for(int j = 0; j < Parser.actionTable[i].length; j++)
                {
                for(int k = 0; k < 3; k++)
                {
                    Parser.actionTable[i][j][k] = s.readInt();
                }
                }
            }

            // read gotoTable
            length = s.readInt();
            gotoTable = new int[length][][];
            for(int i = 0; i < gotoTable.length; i++)
            {
                length = s.readInt();
                gotoTable[i] = new int[length][2];
                for(int j = 0; j < gotoTable[i].length; j++)
                {
                for(int k = 0; k < 2; k++)
                {
                    gotoTable[i][j][k] = s.readInt();
                }
                }
            }

            // read errorMessages
            length = s.readInt();
            errorMessages = new String[length];
            for(int i = 0; i < errorMessages.length; i++)
            {
                length = s.readInt();
                StringBuffer buffer = new StringBuffer();

                for(int j = 0; j < length; j++)
                {
                buffer.append(s.readChar());
                }
                errorMessages[i] = buffer.toString();
            }

            // read errors
            length = s.readInt();
            errors = new int[length];
            for(int i = 0; i < errors.length; i++)
            {
                errors[i] = s.readInt();
            }

            s.close();
        }
        catch(Exception e)
        {
            throw new RuntimeException("The file \"parser.dat\" is either missing or corrupted.");
        }
    }
}
