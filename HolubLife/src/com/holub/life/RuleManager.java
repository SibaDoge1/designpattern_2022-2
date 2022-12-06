package com.holub.life;

import com.holub.ui.FacadeLogCaller;
import com.holub.ui.MenuSite;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class RuleManager
{
    private RuleManager()
    {
        establish();
    }

    private static RuleManager instance;

    public synchronized static RuleManager instance()
    {	if( instance == null )
        instance = new RuleManager();
        return instance;
    }

    public void establish(){
        rule = new RuleDefault();
        MenuSite.addLine(this, "Rule", "B3/S23/2", new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                rule = new RuleDefault();
                FacadeLogCaller.SetLogValRule();
            }
        });

        MenuSite.addLine(this, "Rule", "B3457/S2367/5", new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                rule = new RuleBanners();
                FacadeLogCaller.SetLogValRule();
            }
        });
    }


    private Rule rule;
    public Rule getRule()
    {
        return rule;
    }
    public void setRule(Rule rule)
    {
        this.rule = rule;
    }

    public Integer checkState(Resident cell, int neighbors) {
        return rule.checkState(cell, neighbors);
    }

    public String getRuleName() {
        return rule.getRuleName();
    }

    public int getStates()
    {
        return rule.getStates();
    }

    public Map<Integer, Color> getStateColors()
    {
        return rule.getStateColors();
    }


}
