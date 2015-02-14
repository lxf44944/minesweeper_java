package bean;

public class HeroBean implements Comparable<HeroBean> {
	private int time;
	private String name;

	public HeroBean(int time, String name) {
		super();
		this.time = time;
		this.name = name;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(HeroBean o) {

		return this.time - o.time;

	}

	@Override
	public String toString() {

		return time + "√Î\t" + name;
	}

}
