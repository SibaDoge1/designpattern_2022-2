package com.holub.life;

import com.holub.ui.LogPanel;
import com.holub.ui.MenuSite;
import com.holub.ui.RuleLogCaller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RuleManager
{
	private RuleLogCaller rulelogcaller = null; 
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
        rulelogcaller = new RuleLogCaller("Current Rule : ");
        rulelogcaller.setCurrentVal("B3/S23/2");
        rule = new RuleDefault();
        MenuSite.addLine(this, "Rule", "B3/S23/2", new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                rule = new RuleDefault();
                rulelogcaller.setCurrentVal("B3/S23/2");
        		LogPanel.PostRefreshLog();
            }
        });

        MenuSite.addLine(this, "Rule", "B3457/S2367/5", new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                rule = new RuleBanners();
                rulelogcaller.setCurrentVal("B3457/S2367/5");
        		LogPanel.PostRefreshLog();
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
