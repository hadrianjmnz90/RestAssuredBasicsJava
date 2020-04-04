public class payload {


    public static String AddPlace() {
        return "{\r\n" +
                "  \"location\": {\r\n" +
                "    \"lat\": -38.383494,\r\n" +
                "    \"lng\": 33.427362\r\n" +
                "  },\r\n" +
                "  \"accuracy\": 50,\r\n" +
                "  \"name\": \"Adrian\",\r\n" +
                "  \"phone_number\": \"(+91) 1234 345 345\",\r\n" +
                "  \"address\": \"Aguascalientes\",\r\n" +
                "  \"types\": [\r\n" +
                "    \"shoe park\",\r\n" +
                "    \"shop\"\r\n" +
                "  ],\r\n" +
                "  \"website\": \"http://rahulshettyacademy.com\",\r\n" +
                "  \"language\": \"Spanish-SP\"\r\n" +
                "}\r\n" +
                "";
    }

    public static String UpdateAddress(String placeId, String newAddress) {
        return "{\r\n" +
                "\"place_id\":\"" + placeId + "\",\r\n" +
                "\"address\":\"" + newAddress + "\",\r\n" +
                "\"key\":\"qaclick123\"\r\n" +
                "}";
    }

    public static String DeletePlace(String placeId) {
        return "{\r\n" +
                "\"place_id\":\"" + placeId + "\",\r\n" +
                "\"key\":\"qaclick123\"\r\n" +
                "}";
    }

    public static String CoursePrice() {

        return "{\r\n" +
                "  \"dashboard\": {\r\n" +
                "    \"purchaseAmount\": 1162,\r\n" +
                "    \"website\": \"rahulshettyacademy.com\"\r\n" +
                "  },\r\n" +
                "  \"courses\": [\r\n" +
                "    {\r\n" +
                "      \"title\": \"Selenium Python\",\r\n" +
                "      \"price\": 50,\r\n" +
                "      \"copies\": 6\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"title\": \"Cypress\",\r\n" +
                "      \"price\": 40,\r\n" +
                "      \"copies\": 4\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"title\": \"RPA\",\r\n" +
                "      \"price\": 45,\r\n" +
                "      \"copies\": 10\r\n" +
                "    },\r\n" +
                "     {\r\n" +
                "      \"title\": \"Appium\",\r\n" +
                "      \"price\": 36,\r\n" +
                "      \"copies\": 7\r\n" +
                "    }\r\n" +
                "    \r\n" +
                "    \r\n" +
                "    \r\n" +
                "  ]\r\n" +
                "}\r\n" +
                "";
    }

    public static String addBook(String bookTitle, String isbn, String aisle, String author) {
        String addBookBody = "{\n" +
                "\n" +
                "\"name\":\"" + bookTitle + "\",\n" +
                "\"isbn\":\"" + isbn + "\",\n" +
                "\"aisle\":\"" + aisle + "\",\n" +
                "\"author\":\"" + author + "\"\n" +
                "}";
        return addBookBody;
    }

    public static String deleteBook(String id) {
        String deleteBookBody = "{\r\n" +
                "\"ID\":\"" + id + "\",\r\n" +
                "}";
        return deleteBookBody;
    }

}
