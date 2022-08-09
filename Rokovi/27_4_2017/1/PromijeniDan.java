public class PromijeniDan extends Thread{
	private boolean flag = true;
	public static Object o = new Object();
	
	@Override
	public void run(){
		do{
			try{
				Thread.sleep(3000);
			}catch (Exception e){
				e.printStackTrace();
			}
			
			synchronized(PromijeniDan.o){
				Muzej.dan = (Muzej.dan + 1) % 7;
				
				TipAtrakcije tip = Muzej.dan % 2 == 0 ? TipAtrakcije.placa : TipAtrakcije.besplatna;
				for (Muzej i : Main.arrMuzej)
					i.setTipAtrakcije(tip);
			}
		}while(flag);
	}
	
	public void stopWorking(){
		flag = false;
	}
}