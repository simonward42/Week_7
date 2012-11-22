public class Paper {
	public static void main(String[] args) {
		System.out.println("A0: "+ printSize("A0")+"mm^2");
		
		String str = "A00";
		String st = str.substring(0, str.length()-1);
		System.out.println(str+", "+st);
		
		System.out.println("A1: "+ printSize("A1")+"mm^2");
		
		
		
		//System.out.println("A2: "+getArea("A2")+"mm^2");
		//System.out.println("A3: "+getArea("A3")+"mm^2");
		//System.out.println("A4: "+getArea("A4")+"mm^2");
		//System.out.println("A00: "+getArea("A00")+"mm^2");
		//System.out.println("A000: "+getArea("A000")+"mm^2");
	}
	public static Dimension getDimension(String name) {
		Dimension d0 = new Dimension(841, 1189);
		if(sizeStr.charAt(0) != 'A') {
			System.out.println("Paper size must start with an 'A'!");
			return -1;
		}
		int sizeV = 1189;
		int sizeH = 841; 
		int area = sizeV * sizeH;
		if(sizeStr == "A0") {
			return area;
		}
		String secondChar = ""+sizeStr.charAt(1);
		Integer firstNum = Integer.parseInt(secondChar);
		if(firstNum > 0) {
			firstNum--;
			String biggerSize = "A" + firstNum.toString();
			System.out.println(biggerSize+".");
			return 0.5*getArea(biggerSize);
		}
		else if(firstNum == 0) {
			String smallerSize = sizeStr.substring(0,(sizeStr.length()-2));
			System.out.println(smallerSize+".");
			return 2*getArea(smallerSize);
		}
		else if(firstNum < 0) {
			return -1;
		}
		return -1;
	}
}