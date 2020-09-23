package com.company;
import java.io.IOException;
import java.io.*;
//import java.util.stream.*;
import java.util.*;
import com.opencsv.CSVWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class Main {

    public static void main(String[] args) throws IOException {
        File csvFile = new File("tags.csv");
        csvFile.createNewFile();
        FileWriter csvWriter = new FileWriter("tags.csv");
        CSVWriter writer= new CSVWriter(csvWriter);

        String header[]= {"TAG", "TEXT"};
        writer.writeNext(header);

        File urlFile = new File("text.csv");
        urlFile.createNewFile();
        FileWriter urlWriter = new FileWriter("text.csv");
        CSVWriter writer2= new CSVWriter(urlWriter);

        String header2[]= {"TEXT", "URL"};
        writer2.writeNext(header2);
        String seedUrl = "https://pec.ac.in/";

        ArrayList<String> urlList = new ArrayList<String>();
        Set<String> urlSet = new HashSet<String>();
        int count=0;

        urlSet.add(seedUrl);
        urlList.add(seedUrl);

        for(int i=0;i<urlList.size();i++)
        {
            if(i==100)
            {
                break;
            }
            if(count>=1000)
            {
                break;
            }
            Document doc = Jsoup.connect(urlList.get(i)).ignoreHttpErrors(true).ignoreContentType(true).get();
            Elements ele= doc.getAllElements();
            for(Element temp: ele)
            {
                String[] line = new String[2];
                if(temp.text().length()!=0)
                {
                    line[0]= temp.tagName();
                    if(line[0]=="div")
                    {
                        continue;
                    }
                    line[1]= temp.text();
                    writer.writeNext(line);
                }
                if(temp.text().length()!=0 && temp.tagName()== "a")
                {
                    String[] url= new String[2];
                    url[0]= temp.text();
                    url[1]= temp.absUrl("href");
                    if(url[1].contains("https://pec.ac.in/") && !urlSet.contains(url[1]))
                    {
                        count++;
                        urlSet.add(url[1]);
                        urlList.add(url[1]);
                        //System.out.println("Current: "+ currUrl);
                        System.out.println("Url[1] "+url[1]+" "+ count);
                        writer2.writeNext(url);
                    }
                }
                //System.out.println(temp.tagName()+ " "+ temp.text());
            }

        }
        writer.flush();
        writer2.flush();
    }



}
