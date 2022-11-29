package com.holub.life;

import com.holub.ui.FacadeLogCaller;
import com.holub.ui.MenuSite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                FacadeLogCaller.SetLogValRule("B3/S23/2");
            }
        });

        MenuSite.addLine(this, "Rule", "B3457/S2367/5", new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                rule = new RuleBanners();
                FacadeLogCaller.SetLogValRule("B3457/S2367/5");
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


}
