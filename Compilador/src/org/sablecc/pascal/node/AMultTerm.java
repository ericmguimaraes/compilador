/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.pascal.node;

import org.sablecc.pascal.analysis.*;

@SuppressWarnings("nls")
public final class AMultTerm extends PTerm
{
    private PTerm _term_;
    private TMult _mult_;
    private PFactor _factor_;

    public AMultTerm()
    {
        // Constructor
    }

    public AMultTerm(
        @SuppressWarnings("hiding") PTerm _term_,
        @SuppressWarnings("hiding") TMult _mult_,
        @SuppressWarnings("hiding") PFactor _factor_)
    {
        // Constructor
        setTerm(_term_);

        setMult(_mult_);

        setFactor(_factor_);

    }

    @Override
    public Object clone()
    {
        return new AMultTerm(
            cloneNode(this._term_),
            cloneNode(this._mult_),
            cloneNode(this._factor_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMultTerm(this);
    }

    public PTerm getTerm()
    {
        return this._term_;
    }

    public void setTerm(PTerm node)
    {
        if(this._term_ != null)
        {
            this._term_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._term_ = node;
    }

    public TMult getMult()
    {
        return this._mult_;
    }

    public void setMult(TMult node)
    {
        if(this._mult_ != null)
        {
            this._mult_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._mult_ = node;
    }

    public PFactor getFactor()
    {
        return this._factor_;
    }

    public void setFactor(PFactor node)
    {
        if(this._factor_ != null)
        {
            this._factor_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._factor_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._term_)
            + toString(this._mult_)
            + toString(this._factor_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._term_ == child)
        {
            this._term_ = null;
            return;
        }

        if(this._mult_ == child)
        {
            this._mult_ = null;
            return;
        }

        if(this._factor_ == child)
        {
            this._factor_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._term_ == oldChild)
        {
            setTerm((PTerm) newChild);
            return;
        }

        if(this._mult_ == oldChild)
        {
            setMult((TMult) newChild);
            return;
        }

        if(this._factor_ == oldChild)
        {
            setFactor((PFactor) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
