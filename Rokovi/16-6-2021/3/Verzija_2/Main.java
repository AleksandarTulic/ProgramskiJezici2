import fileOperations.Operation;

public class Main {

	public static void main(String[] args) {
		if (args.length >= 3) {
			String where = args[0];
			String to = args[1];
			String ext = args[2]; //sa tackom nek se unosi
			
			Operation a = new Operation(ext);
			a.findAll(where);
			
			System.out.println("Broj Pojalvjivanja fajlova: " + a.arr.size());
			a.arr.stream().forEach(System.out::println);
			
			a.copyAll(to);
		}
	}

}
