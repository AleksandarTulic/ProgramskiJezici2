package registar;

import java.util.*;

public class Registrator<T> extends ArrayList<T>{
	private List<T> arr = new ArrayList<T>();
	
	public Registrator(){
		super();
	}
	
	@Override
	public boolean add(T t){
		arr.add(t);
		
		return true;
	}
	
	@Override
	public T remove(int index){
		if (index >= 0 && index < arr.size())
			return null;
		
		T t = arr.get(index);
		return t;
	}
	
	@Override
	public Iterator<T> iterator(){
		return arr.iterator();
	}
}