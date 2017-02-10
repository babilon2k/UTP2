package zad2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

public class PriceLimitator implements VetoableChangeListener
{
	private double min;

	public PriceLimitator(double min)
	{
		this.min = min;
	}

	@Override
	public void vetoableChange(PropertyChangeEvent evt)
			throws PropertyVetoException
	{
		Double newVal = (Double) evt.getNewValue();
		double val = newVal.doubleValue();
		if (val < min)
			throw new PropertyVetoException(
					"Price change to: " + evt.getNewValue() + " not allowed",
					evt);

	}

}
