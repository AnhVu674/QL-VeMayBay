package VeMayBay;

import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VeMayBay {
	private String id;
	private String ten;
	private String day;
	private String hanhLy;
	private double gia;

	public VeMayBay() {

	}

	public VeMayBay(String id, String tenVe, String day, String hanhLy, double gia) {
		this.id = id;
		this.ten = tenVe;
		this.day = day;
		this.hanhLy = hanhLy;
		this.gia = gia;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTenVe() {
		return ten;
	}

	public void setTenVe(String tenVe) {
		this.ten = tenVe;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getHanhLy() {
		return hanhLy;
	}

	public void setHanhLy(String hanhLy) {
		this.hanhLy = hanhLy;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public void inputVe() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhap ma ve:");
		while (true) {
			id = input.nextLine();
			String pattermStr = "";
			if(id.startsWith("VJ")) {
				pattermStr = "VJ[1-9]{1}[0-9]{2}";
			} else if (id.startsWith("VN")){
				 pattermStr = "VN[1-9]{1}[0-9]{2}";
			} else if(id.startsWith("JET")) {
				 pattermStr = "JET[1-9]{1}[0-9]{2}";
			} else {
				System.err.println("Nhap sai, nhap lai!!!1");
				continue;
			}
			Pattern pattern = Pattern.compile(pattermStr);
			Matcher matcher = pattern.matcher(id);
			if(matcher.find()) {
				break;
			} else {
				System.err.println("Nhap sai, Nhap lai!!!");
			}
		}
		System.out.println("Nhap ten chuyen bay:");
		ten = input.nextLine();
		System.out.println("Nhap ngay bay:");
		day = input.nextLine();
		System.out.println("Nhap hanh ly ky gui:");
		hanhLy = input.nextLine();
		System.out.println("Nhap gia ve:");
		gia = Double.parseDouble(input.next());
		
	}

	@Override
	public String toString() {
		return "VeMayBay [id=" + id + ", tenVe=" + ten + ", day=" + day + ", hanhLy=" + hanhLy + ", gia=" + gia + "]";
	}

	public void display() {
		System.out.println(toString());
	}

}
