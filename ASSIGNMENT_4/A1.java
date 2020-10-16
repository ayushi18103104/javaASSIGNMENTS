import java.util.Scanner;

class A1 {
	
	public static int replant (String[] crops){

		int cnt = 0;
		
		//converting array of strings into char array
		char[][] cropsArr = new char[crops.length][];

		for(int i=0; i<cropsArr.length; i++) {

			cropsArr[i] = new char[crops[i].length()];

			for(int j=0; j<crops[i].length(); j++) {
				cropsArr[i][j] = crops[i].charAt(j);
			}
		}
		
		for(int i=0; i<cropsArr.length; i++) {

			for(int j=0; j<cropsArr[i].length; j++) {
				
				if(j-1 >= 0 && i-1 >=0 ) 
				{

					if(cropsArr[i][j-1] == cropsArr[i][j] || cropsArr[i-1][j] == cropsArr[i][j]) {
						cnt++;
						cropsArr[i][j]='A';
					}
				}
				else if(j+1 < crops[i].length() && i+1 < cropsArr.length) 
				{

					if((cropsArr[i][j] == cropsArr[i+1][j]) && (cropsArr[i][j] == cropsArr[i][j+1])) {
						cnt++;
						cropsArr[i][j]='A';
					}
				}
				else if(i-1>=0) {

					if(cropsArr[i-1][j] == cropsArr[i][j]) {
						cnt++;
						cropsArr[i][j]='A';
					}
				}
				else if(j-1>=0) {

					if(cropsArr[i][j-1] == cropsArr[i][j]) {
						cnt++;
						cropsArr[i][j]='A';
					}
				}
				
			}
		}
		return cnt;
	}
	
	public static void main(String[] args){
		int n;
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		sc.nextLine();
		String[] crops = new String[n];

		for (int i=0; i<n; i++){
			crops[i] = sc.nextLine().trim();
		}
		System.out.println(replant(crops));
	}
}
