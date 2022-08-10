package drugi.knjiga;

import java.util.*;

public class GrupaKnjiga {
	public HashSet<Knjiga> set = new HashSet<>();
	
	public GrupaKnjiga() {
		for (int i=0;i<20;i++) {
			set.add(new Knjiga());
		}
	}
}
