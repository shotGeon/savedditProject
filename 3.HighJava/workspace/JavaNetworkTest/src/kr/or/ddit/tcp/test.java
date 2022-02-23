package kr.or.ddit.tcp;

public class test {
	public static void main(String[] args) {
		String msg = "/w asdf asdf asdfjk ;asldfj asdflk";
		int num = msg.indexOf(" ");
		int num2 = msg.indexOf(" ", num +1);
		String from = msg.substring(3, num2).trim();

		System.out.println(num);
		System.out.println(num2);
		System.out.println(from);
	}
}
