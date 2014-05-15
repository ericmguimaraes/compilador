/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.pascal.node;

import org.sablecc.pascal.analysis.*;

@SuppressWarnings("nls")
public final class ADeclarations extends PDeclarations
{
    private PVariablesDeclaration _variablesDeclaration_;

    public ADeclarations()
    {
        // Constructor
    }

    public ADeclarations(
        @SuppressWarnings("hiding") PVariablesDeclaration _variablesDeclaration_)
    {
        // Constructor
        setVariablesDeclaration(_variablesDeclaration_);

    }

    @Override
    public Object clone()
    {
        return new ADeclarations(
            cloneNode(this._variablesDeclaration_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADeclarations(this);
    }

    public PVariablesDeclaration getVariablesDeclaration()
    {
        return this._variablesDeclaration_;
    }

    public void setVariablesDeclaration(PVariablesDeclaration node)
    {
        if(this._variablesDeclaration_ != null)
        {
            this._variablesDeclaration_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._variablesDeclaration_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._variablesDeclaration_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._variablesDeclaration_ == child)
        {
            this._variablesDeclaration_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._variablesDeclaration_ == oldChild)
        {
            setVariablesDeclaration((PVariablesDeclaration) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
