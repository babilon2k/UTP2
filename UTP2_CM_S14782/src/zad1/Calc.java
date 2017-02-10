/**
 *
 *  @author Czerniak Mieszko S14782
 *
 */

package zad1;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calc
{
	public String doCalc(String arg)
	{
		ScriptEngineManager m = new ScriptEngineManager();
		ScriptEngine e = m.getEngineByName("JavaScript");

		try
		{
			return e.eval(arg).toString();
		} catch (ScriptException e1)
		{
			System.out.println("Invalid command to calc");
		}
		return "";
	}
}
