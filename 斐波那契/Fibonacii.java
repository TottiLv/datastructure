/*
经典的生兔子游戏：
说如果兔子在出生两个月后，就有繁殖能力，一对兔子每个月能生出一对小兔子来；
假如所有兔都不死，那么一年以后可以繁殖多少对兔子呢？
*/
class Fibonacii {
	public static void main(String[] argv){
		int result = fibonacii(12);
		System.out.println(result);
	}
	//斐波那契函数实现（递归调用）
	public static int fibonacii(int n){
		if (n<2) {
			return n==0?0:1; 
		}
		//这里的fibonacii就是函数自己，它在调用自己
		return fibonacii(n-1)+fibonacii(n-2);
	}
}
