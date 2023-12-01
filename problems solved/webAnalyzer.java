/*
Aravinth got web analyst internship offer at ZinZing Corporation. The primary task of webanalyst is to examine the web page source code and 
prepare a analysis report which indicates the coding standard followed in a web page. He has allotted with command oriented environment to do 
this task (No GUI environment). So he decided to develop a java application to connect with web site and to do the web analyst task. Write a 
java program to help him to do the task.
*/

import java.io.*;
import java.net.*;
import java.util.regex.*;

public class webAnalyzer {

    public static void main(String[] args) {
        try {
            String targetURL = "https://www.google.com"; 
            URL url = new URL(targetURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                StringBuilder sourceCode = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sourceCode.append(line).append("\n");
                }

                generateCodingStandardsReport(sourceCode.toString());
                
                reader.close();
            } else {
                System.out.println("Unable to fetch data. Response code: " + responseCode);
            }

            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateCodingStandardsReport(String sourceCode) {
        StringBuilder report = new StringBuilder("Coding Standards Report:\n");

        boolean hasHTML5Doctype = checkPattern(Pattern.compile("<!DOCTYPE\\s+html>", Pattern.CASE_INSENSITIVE), sourceCode);
        report.append("HTML5 Doctype: ").append(hasHTML5Doctype ? "Present" : "Missing or not standard-compliant").append("\n");

        boolean hasUTF8Charset = checkPattern(Pattern.compile("<meta\\s+charset=['\"]UTF-8['\"]", Pattern.CASE_INSENSITIVE), sourceCode);
        report.append("UTF-8 Charset in Meta Tag: ").append(hasUTF8Charset ? "Present" : "Missing or not standard-compliant").append("\n");

        boolean hasCSS = checkPattern(Pattern.compile("<link\\s+[^>]*rel=['\"]stylesheet['\"][^>]*>|<style>", Pattern.CASE_INSENSITIVE), sourceCode);
        report.append("CSS Stylesheets: ").append(hasCSS ? "Present" : "Missing").append("\n");

        boolean hasJavaScript = checkPattern(Pattern.compile("<script\\s+[^>]*>", Pattern.CASE_INSENSITIVE), sourceCode);
        report.append("JavaScript Scripts: ").append(hasJavaScript ? "Present" : "Missing").append("\n");

        System.out.println(report.toString());
    }

    private static boolean checkPattern(Pattern pattern, String sourceCode) {
        Matcher matcher = pattern.matcher(sourceCode);
        return matcher.find();
    }
}
