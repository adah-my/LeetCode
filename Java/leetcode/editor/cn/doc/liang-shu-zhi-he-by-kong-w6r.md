/*两数之和，我觉得对于新手这个比那些什么哈西表简单多了，也可以做成动态数组，我也是新手，写的不好求建议，勿喷*/
//给定一个整数数组nums和一个目标值target，在该数组中找出和为目标值的两个整数，并返回他们的数组下标。
public class A//随便定义的类名
{
	public static void main(String args[]){
		
		int i = 3;
		int [] nums = {2,7,11,15};
		for(int j=0;j<=i;j++){//嵌套循环
			for(int k=0;k<=i;k++){
			boolean isRight = add(j,nums[k]);
			int count = 0;
			if(isRight){
			U.s(count+"+"+k);/*U.s是我自己创的一个类，在下面，我是图简单，可以把U.s换成System.out.println*/
			count++;
			}

			}
		}
		
	}
	
	public static boolean add(int d,int y){
		
			int target = 9;
			int nums = d + y;
			boolean isRight = false;//做一个boolean返回值
			if(target == nums){
			U.s("数值匹配成功，下标值分别为");
			isRight = true;
			}
			return isRight;
		}
			
	}

/*以下是关于U.S,如果用System.out.println不用管下面的*/
public class U//自定义类
{
	public static void s(byte b){
	
		System.out.println(b);
	}
	public static void s(short b){
	
		System.out.println(b);
	}
	public static void s(int b){
	
		System.out.println(b);
	}
	public static void s(long b){
	
		System.out.println(b);
	}
	public static void s(boolean b){
	
		System.out.println(b);
	}
	public static void s(float b){
	
		System.out.println(b);
	}
	public static void s(double b){
	
		System.out.println(b);
	}
	public static void s(String b){
	
		System.out.println(b);
	}
}
