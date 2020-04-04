import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComplexJsonParse {
    @Test
    public void ComplexJsonParse() {
        JsonPath js = new JsonPath(payload.CoursePrice());

        //Print No of courses returned by API
        int count = js.getInt("courses.size()");
        System.out.println(count);
//Print Purchase Amount
        int totalAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(totalAmount);
//Print Title of the first course
        String titleFirstCourse = js.get("courses[2].title");
        System.out.println(titleFirstCourse);

        //Print All course titles and their respective Prices

        for (int i = 0; i < count; i++) {
            String courseTitles = js.get("courses[" + i + "].title");
            System.out.println(courseTitles);
            System.out.println(js.get("courses[" + i + "].price").toString());

        }
        //Print no of copies sold by RPA Course

        System.out.println("Print no of copies sold by RPA Course");

        for (int i = 0; i < count; i++) {
            String courseTitles = js.get("courses[" + i + "].title");
            if (courseTitles.equalsIgnoreCase("RPA")) {
                int copies = js.get("courses[" + i + "].copies");
                System.out.println(copies);
                break;
            }
        }

		System.out.println("Verify if total purchase amount is equal to sum of all copies sold");
        int multiplication = 0;
		for (int i = 0; i <  count; i++) {
		int price =	js.getInt("courses[" + i + "].price");
		int copies = 	js.getInt("courses[" + i + "].copies");
		multiplication   = multiplication + (price * copies);
		}
		System.out.println("total is... " + multiplication);
		System.out.println("total from json..." + totalAmount);
		Assert.assertEquals(totalAmount, multiplication);

    }
}
