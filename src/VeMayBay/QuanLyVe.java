package VeMayBay;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class QuanLyVe implements Serializable {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		List<VeMayBay> listVe = new ArrayList<>();
		int choose;
		do {
			showMenu();
			choose = Integer.parseInt(input.next());
			switch (choose) {
			case 1:
				inputVeMayBay(listVe);
				break;
			case 2:
				save(listVe, "DuLieuBay.txt");
				break;
			case 3:
				listVe = showRead(listVe);
				break;
			case 4:
				sort(listVe);
				break;
			case 5:
				showFile("DSVe.txt");
				break;
			case 6:
				System.out.println("THoat!!!");
				break;

			default:
				System.out.println("input failed!!!");
				break;
			}
		} while (choose < 7);
	}

	private static List<VeMayBay> showFile(String fileName) {
		List<VeMayBay> listVe = new ArrayList<>();
		FileInputStream os = null;
		ObjectInputStream oos = null;
		try {
			os = new FileInputStream(fileName);
			oos = new ObjectInputStream(oos);
			listVe = (List<VeMayBay>) oos.readObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return listVe;

	}

	private static void sort(List<VeMayBay> listVe) {
		Collections.sort(listVe, (o1, o2) -> {
			if (o1.getGia() < o1.getGia()) {
				return -1;
			}
			return 1;
		});
		for (int i = 0; i < listVe.size(); i++) {
			listVe.get(i).display();
		}
	}

	private static List<VeMayBay> showRead(List<VeMayBay> listVe) {
		List<VeMayBay> listVietJetAirline = showReadByAirline(listVe, "VJ");
		save(listVe, "VietjetAirline.txt");
		List<VeMayBay> listVietNamAirline = showReadByAirline(listVe, "VN");
		save(listVe, "VietNamAirline.txt");
		List<VeMayBay> listJetAirline = showReadByAirline(listVe, "JET");
		save(listVe, "jetAirline.txt");
		return listJetAirline;
	}

	static List<VeMayBay> showReadByAirline(List<VeMayBay> listVe, String prex) {
		List<VeMayBay> listAirline = new ArrayList<>();
		for (VeMayBay veMayBay : listVe) {
			if (veMayBay.getId().startsWith(prex)) {
				listAirline.add(veMayBay);
			}
		}
		return listAirline;
	}

	private static void save(List<VeMayBay> listVe, String fileName) {
		FileOutputStream os = null;
		ObjectOutputStream oos = null;
		try {
			os = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(oos);
			oos.writeObject(listVe);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	private static void inputVeMayBay(List<VeMayBay> listVe) {
		System.out.println("Nhap so ve can them:");
		int n = Integer.parseInt(input.next());
		for (int i = 0; i < n; i++) {
			VeMayBay ve = new VeMayBay();
			ve.inputVe();
			listVe.add(ve);
		}

	}

	static void showMenu() {
		System.out.println("1. Nhap thong tin n chuyen bay");
		System.out.println("2. Luu thong tin");
		System.out.println("3. Doc thong tin tu file va hien thi");
		System.out.println("4. Sap xep theo gia");
		System.out.println("5. In thong tin moi chuyen bay ra file");
		System.out.println("6. Thoat");
		System.out.println("Nhap lua chon cua ban:");

	}
}
