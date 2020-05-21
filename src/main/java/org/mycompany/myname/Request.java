package org.mycompany.myname;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import org.xml.sax.SAXException;



public class Request {
    private String bodyPath;// адрес где лежит хмл
    String endPoint;// локалхост куда я отправляю
    String body;// содержимое хмл
    private byte[] buffer;

    public  Request(String endPoint, String bodyPath){
        this.endPoint = endPoint;
        this.bodyPath = bodyPath;
    }


    public  void init() throws SAXException, IOException {

        body = XMLReader.read(bodyPath);

    }
    public void action() throws IOException {
        String responseString = "";
        String outputString = "";
        URL url = new URL(endPoint);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection) connection;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        buffer = new byte[body.length()];
        byte[] buffer = body.getBytes();
        bout.write(buffer);
        byte[] b = bout.toByteArray();
        String SOAPAction = "getUserDetails";
        httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
        httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        httpConn.setRequestProperty("SOAPAction", SOAPAction);
        httpConn.setRequestMethod("POST");
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);
        OutputStream out = httpConn.getOutputStream();
        // Write the content of the request to the outputstream of the HTTP
        // Connection.
        out.write(b);
        out.close();
        // Ready with sending the request.
        // Read the response.
        InputStreamReader isr = new InputStreamReader(httpConn.getInputStream(), Charset.forName("UTF-8"));
        BufferedReader in = new BufferedReader(isr);
        // Write the SOAP message response to a String.
        while ((responseString = in.readLine()) != null) {
            outputString = outputString + responseString;
        }

    }
    public void end(){
    }
}

