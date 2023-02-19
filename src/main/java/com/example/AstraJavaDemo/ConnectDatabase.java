package com.example.AstraJavaDemo;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import java.nio.file.Paths;

public class ConnectDatabase {

    CqlSession session = null;

    public void connect(){
         session = CqlSession.builder()
                .withCloudSecureConnectBundle(Paths.get("C:\\Users\\Hari\\Downloads\\AstraJavaGradle\\AstraJavaDemo\\src\\main\\resources\\secure-connect-springbootdemo.zip"))
                .withAuthCredentials("BUmLMSShZbDFFhpuHTlZgjlU","Z30YSnXrjxCAbW8J01.mhSkGP35pieY-ebCdv1i_LLL71IJxsyM.Y1FfQjeih.tfsUQlY+UbWL33JQMrS1AfJSXTCD9r1OmNtk9zZMpMR4veZcwYvpc,S55nvbNZOyJS")
                .build();
    }

    public String getValue(String key) {

        if(session == null)
            connect();

        String value ="";
            ResultSet rs = session.execute("select fname from usersdb.userdetails where user_id =" + key + "");
            Row row = rs.one();
            if (row != null) {
                value = row.getString("fname");
            } else {
                System.out.println("An error occurred.");
            }
        return value;
    }
}