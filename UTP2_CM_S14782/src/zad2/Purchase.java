/**
 *
 *  @author Czerniak Mieszko S14782
 *
 */

package zad2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.io.Serializable;

public class Purchase implements Serializable, PropertyChangeListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PropertyChangeSupport chg = new PropertyChangeSupport(this);
	private VetoableChangeSupport vChg = new VetoableChangeSupport(this);
	private String prod;
	private String data;
	private double price;

	public Purchase()
	{

	}

	public Purchase(String prod, String data, double price)
	{
		this.prod = prod;
		this.data = data;
		this.price = price;
	}
	public String getProd()
	{
		return prod;
	}

	synchronized void setProd(String newProd)
	{
		String oldValue = prod;
		prod = newProd;
		chg.firePropertyChange("prod", oldValue, newProd);
	}

	public String getData()
	{
		return data;
	}

	synchronized void setData(String newData)
	{
		String oldValue = data;
		data = newData;
		chg.firePropertyChange("data", oldValue, newData);
	}

	public double getPrice()
	{
		return price;
	}

	synchronized void setPrice(double newPrice) throws PropertyVetoException
	{
		double oldValue = price;
		vChg.fireVetoableChange("price", oldValue, newPrice);
		chg.firePropertyChange("price", oldValue, newPrice);
		price = newPrice;
	}

	@Override
	public String toString()
	{
		return "Purchase [prod=" + prod + ", data=" + data + ", price=" + price
				+ "]";
	}

	public synchronized void addPropertyChangeListener(PropertyChangeListener l)
	{
		chg.addPropertyChangeListener(l);
	}

	public synchronized void removePropertyChangeListener(
			PropertyChangeListener l)
	{
		chg.removePropertyChangeListener(l);

	}
	public synchronized void addVetoableChangeListener(VetoableChangeListener l)
	{
		vChg.addVetoableChangeListener(l);
	}

	public synchronized void removeVetoableChangeListener(
			VetoableChangeListener l)
	{
		vChg.removeVetoableChangeListener(l);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt)
	{
		if (evt.getNewValue() != evt.getOldValue())
			System.out.println(
					"Change value of: " + evt.getPropertyName() + " from: "
							+ evt.getOldValue() + " to: " + evt.getNewValue());

	}

}
