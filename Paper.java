public class Paper {
	public void printSize(String sizeStr) {
		if(sizeStr.charAt(0) != 'A') {
			System.out.println("Paper size must start with an 'A'!");
			return;
		}
		int sizeV = 1189;
		int sizeH = 841; 
		if(sizeStr == "A0") {
			String output = sizeH + "mm x " + sizeV + " mm";
			System.out.println(output);
		}
	}
}