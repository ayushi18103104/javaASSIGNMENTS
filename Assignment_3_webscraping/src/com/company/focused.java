import java.io.*;
//import java.util.stream.*;
import java.util.*;

import com.opencsv.CSVWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class focused
{
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        File csvFile = new File("Ftags_text.csv");
        csvFile.createNewFile();
        FileWriter csvWriter = new FileWriter("Ftags_text.csv");
        CSVWriter writer= new CSVWriter(csvWriter);

        String header[]= {"URL","TAG", "TEXT"};
        writer.writeNext(header);

        File urlFile = new File("F_url.csv");
        urlFile.createNewFile();
        FileWriter urlWriter = new FileWriter("F_url.csv");
        CSVWriter writer2= new CSVWriter(urlWriter);

        String header2[]= {"URL"};
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
            Elements ele= doc.select("a[href]");
            for(Element temp: ele)
            {
                if(temp.text().length()!=0)
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
                        if(url[1].contains("faculty"))
                        {
                            String[] fac_url = new String[1];
                            fac_url[0]= url[1] ;
                            writer2.writeNext(fac_url);
                            System.out.println("****************************************");
                        }

                    }
                }
                //System.out.println(temp.tagName()+ " "+ temp.text());
            }

        }
        System.out.println(urlList.size());
        for(int i=0;i<urlList.size();i++)
        {
            String currUrl = urlList.get(i);
            if(currUrl.contains("faculty") || currUrl.contains("faculties"))
            {
                //System.out.println(currUrl);
                Document doc = Jsoup.connect(currUrl).ignoreHttpErrors(true).ignoreContentType(true).get();
                Elements ele= doc.getAllElements();
                for(Element temp: ele)
                {
                    String[] line = new String[3];
                    line[0]= currUrl;
                    if(temp.text().length()!=0)
                    {
                        line[1]= temp.tagName();
                        if(!line[0].contains("pdf") && (line[1]=="p" || line[1]=="h1" || line[1]=="h2" || line[1]=="h3" || line[1]=="h4" || line[1]=="a" || line[1]=="li"))
                        {
                            line[2]= temp.text();
                            writer.writeNext(line);
                        }
                    }
                }
            }
        }
        writer.flush();
        writer2.flush();
    }

}



