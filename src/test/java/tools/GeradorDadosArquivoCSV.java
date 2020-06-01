package tools;

import com.opencsv.CSVWriter;

import java.io.*;
import java.util.*;

public class GeradorDadosArquivoCSV {

    public void addDataToCSV(String output, List<String[]> Dados) {
        // first create file object for file placed at location2
        // specified by filepath
        File file = new File(output);
        Scanner sc = new Scanner(System.in);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter with ';' as separator
            CSVWriter writer = new CSVWriter(outputfile, ';',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            // create a List which contains Data
            List<String[]> data = new ArrayList<String[]>();

            for (int i = 0; i < Dados.size(); i++) {
                String[] rowdata = Dados.get(i);
                data.add(rowdata);
            }

            writer.writeAll(data);

            // closing writer connection
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
