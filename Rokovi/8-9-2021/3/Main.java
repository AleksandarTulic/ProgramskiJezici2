import java.util.*;

public class Main{
	public static int br = 0;
	public static Random rand = new Random();
	public static void main(String []args){
		try{
			UlancaniStek<Integer> stack = new UlancaniStek<Integer>();
			AddThread add = new AddThread(stack, 50);
			RemoveThread remove = new RemoveThread(stack, 30);
			
			add.start();
			remove.start();
		
			do{
				Thread.sleep(1000);
			}while(br < 2);
			
			stack.iter();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}

class UlancaniStek<T>{
	public T value;
	public UlancaniStek<T> tos  = null;
	public UlancaniStek<T> referenceNext = null;
	
	public UlancaniStek(){
	}
	
	public void iter(){
		UlancaniStek ul = tos;
		while (ul != null){
			System.out.println(ul.value);
			ul = ul.referenceNext;
		}
	}
	
	public synchronized void push(T value){
		System.out.println(value);
		UlancaniStek<T> node = new UlancaniStek<T>();
		node.value = value;
		node.referenceNext = tos;
		this.tos = node;
	}
	
	public synchronized T pop() throws StackEmptyException{
		T valuee = null;
		
		if (this.tos != null){
			valuee = this.tos.value;
			this.tos = this.tos.referenceNext;
		}else{
			throw new StackEmptyException();
		}
		
		return valuee;
	}
}

class StackEmptyException extends Exception{
	public StackEmptyException(){
		super();
	}
	
	public StackEmptyException(String value){
		super(value);
	}
}

class AddThread extends Thread{
	public int num = 0;
	public UlancaniStek<Integer> stek = null;
	
	public AddThread(UlancaniStek<Integer> stek, int num){
		this.num = num;
		this.stek = stek;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void run(){
		for (int i=0;i<num;i++){
			try{
				System.out.println("DODAVANJE");
				Integer value = Main.rand.nextInt(100);
				stek.push(value);
				Thread.sleep(200);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		
		Main.br++;
	}
}

class RemoveThread extends Thread{
	public int num = 0;
	public UlancaniStek stek = null;
	
	public RemoveThread(UlancaniStek stek, int num){
		this.num = num;
		this.stek = stek;
	}
	
	@Override
	public void run(){
		for (int i=0;i<num;i++){
			try{
				System.out.println("BRISANJE");
				
				try{
					stek.pop();
				}catch(StackEmptyException s){
					s.printStackTrace();
				}
				
				Thread.sleep(300);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		
		Main.br++;
	}
}