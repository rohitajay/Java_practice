/*
Out of Date Software

Consider the following data in array of strings
Server1, Database, MySQL, 5.5
Server2, Database, MySQL, 5.1
Server3, OS, Ubuntu, 12.04
Server1, OS, Ubuntu, 12.04
Server2, OS, Ubuntu, 18.04
Server3, Language, Python, 2.6.3

Server1 has version 5.5 of MySQL installed, Server2 has version 5.1 installed, and Server3 has version 12.04 of Ubuntu installed. For the purposes of this program, assume that all version numbers are of the form X.Y or X.Y.Z where X, Y, and Z are made up of only digits.

Write a java program to display a list of software package names for which an out-of-date version  (i.e. a version which is not the latest version) is installed on at least 2 different servers. 
Thus, in this case, the output of your program should be:
Ubuntu
Because Ubuntu 12.04 is an out-of-date version (the latest version is 18.04), and it is installed on two servers (Server 3, and Server 1).

*/


package Assignment2;

import java.util.*;

class Software {
    private String server;
    private String database;
    private String OS;
    private Double version;

    public String getServer() {
        return server;
    }
    public void setServer(String server) {
        this.server = server;
    }
    public String getDatabase() {
        return database;
    }
    public void setDatabase(String database){
        this.database = database;
    }
    public String getOS() {
        return OS;
    }
    public void setOS(String OS){
        this.OS = OS;
    }
    public Double getVersion() {
        return version;
    }
    public  void setVersion() {
        this.version = version;
    }

    public Software(String server, String database, String OS, double version) {
        this.server = server;
        this.database = database;
        this.OS = OS;
        this.version = version;
    }
}



public class Q1 {

    public static void main(String[] args) {
        List<Software> list = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);

        list.add(new Software("Server1", "Database", "MySQL", 5.5));
        list.add(new Software("Server2", "Database", "MySQL", 5.1));
        list.add(new Software("Server3", "OS", "Ubuntu", 12.04));
        list.add(new Software("Server1", "OS", "Ubuntu", 18.04));
        list.add(new Software("Server2", "OS", "Ubuntu", 12.04));
        list.add(new Software("Server3", "Language", "Python", 2.6));

        Iterator<Software> it = list.iterator();
//        Set<String> st = new HashSet<String>();
        HashMap<String, Double> highest = new HashMap<String, Double>();

        while(it.hasNext()){
            Software sft = it.next();
            if(highest.containsKey(sft.getOS())) {
                highest.replace(sft.getOS(), Math.max(sft.getVersion(), highest.get(sft.getOS())));
            } else {
                highest.put(sft.getOS(), sft.getVersion());
            }
        }
        HashMap<String, Integer> count = new HashMap<String,Integer>();
        Iterator<Software> it1 = list.iterator();
        while(it1.hasNext()) {
            Software sft = it1.next();
            if(sft.getVersion()< highest.get(sft.getOS())) {
                if(count.containsKey(sft.getOS())) {
                    count.replace(sft.getOS(), count.get(sft.getOS()) + 1);
                } else {
                    count.put(sft.getOS(), 1);
                }
            }
        }
        for(Map.Entry<String, Integer> entry:count.entrySet()){
            if(entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }
    }
}
