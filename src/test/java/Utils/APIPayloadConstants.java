package Utils;

import org.json.JSONObject;

public class APIPayloadConstants {
    public static String createEmployeePayload(){
        String createEmployeePayload="{\n" +
                "   \n" +
                "        \"emp_firstname\": \"Tony\",\n" +
                "        \"emp_middle_name\": \"Anthony\",\n" +
                "        \"emp_lastname\": \"Anthonyson\",\n" +
                "        \"emp_gender\": \"M\",\n" +
                "        \"emp_birthday\": \"2022-02-22\",\n" +
                "        \"emp_job_title\": \"HR\",\n" +
                "        \"emp_status\": \"Retired\"\n" +
                "    \n" +
                "}";
        return createEmployeePayload;
    }

    public static String createEmployeePayloadJSON(){
        JSONObject obj=new JSONObject();
        obj.put("emp_firstname","Tony");
        obj.put("emp_middle_name","Anthony");
        obj.put("emp_lastname","Anthonyson");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","2022-02-22");
        obj.put("emp_job_title","HR");
        obj.put("emp_status","Retired");

        return obj.toString();

    }
    public static String createEmployeeDynamic(String fname, String lname, String mname,
                                               String gender, String bday, String status, String jobtitle){
        JSONObject obj=new JSONObject();
        obj.put("emp_firstname",fname);
        obj.put("emp_lastname",lname);
        obj.put("emp_middle_name",mname);
        obj.put("emp_gender",gender);
        obj.put("emp_birthday",bday);
        obj.put("emp_status",status);
        obj.put("emp_job_title",jobtitle);

        return obj.toString();
    }
    public static String updateEmployeePayloadJSON(){
        JSONObject obj=new JSONObject();
        obj.put("employee_id","57588A");
        obj.put("emp_firstname","Tony");
        obj.put("emp_lastname","Anthonyson");
        obj.put("emp_middle_name","Anthony");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","2002-02-22");
        obj.put("emp_status","Confirmed");
        obj.put("emp_job_title","QATester");


        return obj.toString();

    }

    public static String updateEmployeeDynamic(String fname, String lname, String mname,
                                               String gender, String bday, String status, String jobtitle){
        JSONObject obj=new JSONObject();
        obj.put("emp_firstname",fname);
        obj.put("emp_lastname",lname);
        obj.put("emp_middle_name",mname);
        obj.put("emp_gender",gender);
        obj.put("emp_birthday",bday);
        obj.put("emp_status",status);
        obj.put("emp_job_title",jobtitle);

        return obj.toString();
    }

}
