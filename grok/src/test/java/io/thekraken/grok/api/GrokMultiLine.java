/**
 * 
 */
package io.thekraken.grok.api;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.Test;

import oi.thekraken.grok.api.Grok;
import oi.thekraken.grok.api.Match;

/**
 * @author Administrator
 * @version 1.0
 */
public class GrokMultiLine {
    
    @Test
    public void testMultiLine() throws Exception {
        Grok grok = new Grok();
        grok.compile("(?m)\\[2016\\-05\\-18\\s+02:52:16,017\\](?<name>[\\s\\S]*(?=\\[2016\\-05\\-18\\s+02:52:30,174\\].*))");
        
        BufferedReader br = new BufferedReader(new FileReader(ResourceManager.FILE));
        String line;
        String content = "";
        while ((line = br.readLine()) != null) {
            content+=line+"\n";
        }
        System.out.println(content);
        Match gm = grok.match(content);
        gm.captures();
        System.out.println(gm.toMap());
    }

}
