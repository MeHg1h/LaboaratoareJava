package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.example.CsvData;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void readCVS(List<CsvData> dataList)
    {

        String csvFilePath = "C:\\Users\\matei\\Desktop\\Lab 6-7\\train.csv"; // Replace with the actual path to your CSV file

        try (CSVReader csvReader = new CSVReader(new FileReader(csvFilePath))) {
            List<String[]> csvDataList = csvReader.readAll();

            boolean firstRowSkipped = false;

            for (String[] csvRow : csvDataList) {

                if (!firstRowSkipped) {
                    firstRowSkipped = true;
                    continue; // Skip the first row
                }

                // Assuming the columns are in order: id, question, article_ids, category, subcategory, extra_description
                int id = Integer.parseInt(csvRow[0]);
                String question = csvRow[1];
                String articleIds = csvRow[2]; // Assuming article_ids is a comma-separated list of integers
                String category = csvRow[3];
                String subcategory = csvRow[4];
                String extraDescription = csvRow[5];

                CsvData csvData = new CsvData(id, question, articleIds, category, subcategory, extraDescription);
                dataList.add(csvData);
            }

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        List<CsvData> dataList = new ArrayList<>();
        readCVS(dataList);

        Collections.sort(dataList);                 //Citire nomrmala

        // Print the mapped data
        for (CsvData data : dataList) {
            System.out.println(data);
        }


        ///////////////////////////////  PARALEL  ////////////////////////////////////////////

        /*List<CsvData> dataList = Collections.synchronizedList(new ArrayList<>()); // Synchronize the list for thread safety

        // Create an ExecutorService with a single thread
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Submit the CSV reading task to the ExecutorService
        executorService.submit(() -> readCVS(dataList));

        // Shutdown the ExecutorService
        executorService.shutdown();

        // Wait for the CSV reading task to complete
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        // Sort the dataList by id
        Collections.sort(dataList);

        // Print the mapped data
        for (CsvData data : dataList) {
            System.out.println(data);
        }*/
    }

}
