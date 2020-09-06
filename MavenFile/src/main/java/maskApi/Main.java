package maskApi;

public class Main {

	public static void main(String[] args) {
		
//		mShow(new MaskStore());
//		mShow(new MaskSales());
		mShow(new MaskInfo());
		
	}

	private static void mShow(MaskShow maskShow) {
		// TODO Auto-generated method stub
		maskShow.maskInfoShow();
	}
}
