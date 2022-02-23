package g_oop2;

public class Time {

	private int hour;
	private int minute;
	private int second;
	
	
	public int getHour() { //변수의 값을 읽어오는 역할(get)
		return hour;
	}


	public void setHour(int hour){//변수의 값을 저장하는 역할(set)
		if(hour<0){
			hour=hour*-1;
			hour=hour%24;
		}else if(hour>24){
			hour=hour%24;
		}
		this.hour = hour;
	}


	public int getMinute() {
		
		return minute;
	}


	public void setMinute(int minute) {
		if(minute<0){
			minute=minute*-1;
			minute=minute%60;
		}else if(minute>=60){
			this.hour+=minute/60;
			minute=minute%60;
			
			
		}else if(minute<=-60){
			this.hour-=minute*-1/60;
			minute=60-minute*-1%60;
		}
		
		this.minute = minute;
	}


	public int getSecond() {
		return second;
	}


	public void setSecond(int second) {
		if(second<0){
			second=second*-1;
			second=second%60;
		}else if(second>=60){
				this.minute+=second/60;
				second=second%60;
			}
			
		this.second = second;
	}


	String getTime(){
		return hour + ":" + minute + ":"+ second;
		
	}
	void clock(){
		while(true){
			System.out.println(getTime());
			stop(1000);
			setSecond(second +1);
			if(second==60){
				second=0;
				minute++;
			}else if(minute==60){
				minute=0;
				hour++;
			}
		}
	}
	private void stop(int interval){
			try {
				  Thread.sleep(interval);//1000분의1초(1000을 넣으면 1초간 멈춘다)
				} catch (InterruptedException e) {
					e.printStackTrace();
					}
					}
	
	
}
