package test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import core.DataSource;
import core.Query;
import model.FoodModel;
import model.IorOModel;

public class Test {

	public static void main(String[] args) {
		DataSource.initDatabase("com.mec.bookmanage.model");
		Query query = new Query();
		
		Calendar cd =  Calendar.getInstance();
		Date data = cd.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String STtime = dateFormat.format(data);
		Timestamp T = Timestamp.valueOf(STtime);
		
		
		IorOModel cm = query.getsomething(new IorOModel().getClass(), "陕C14789", "004");
		double result = (T.getTime()-cm.getTime().getTime())/(1000 * 60.0 * 60);
		double c = result*3;
		BigDecimal b = new BigDecimal(c);
		double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(f1);
		
		
//		System.out.println(T.getTime());

//		query.updateBysome(new CarModel().getClass(), T, 100.00, "陕A88888","001");
//		BorrowModel bm = query.getbyid(BorrowModel.class,"AA001","li");
//		System.out.println(bm);
//		System.out.println("------------------------------------------");
//		BookModel Book = query.get(BookModel.class, "3");
//		System.out.println(Book);
		
		
//		query.update(BookModel.class, "被借阅", "4");
				
//		BookModel book = new BookModel();			
//		book.setBookid("1");
//		book.setBookname("1");
//		book.setBookprice("1");
//		book.setBooklocation("1");
//		book.setBookstatus("1");
//		query.save(book);
		
//		query.delete(StudentinfoModel.class,"06173015");
//
//		
//		List<BookModel> BookModellist = query.get(BookModel.class);
//		for (BookModel Book : BookModellist) {
//			System.out.println(Book);
//		}
		
//		System.out.println("----------------------------------------");
//		StudentinfoModel student = new StudentinfoModel();
//		student.setId("610322199807051542");
//		student.setName("张jiu");
//		student.setStudentId("06173015");
//		student.setSex("女");
//		student.setStatus("1");
//		student.setBrithday("1998/11/05");
//		query.save(student);
	}

}

