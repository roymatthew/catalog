
package com.exercise.catalog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.util.StringUtils;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

/**
 * Utility class to read a CSV file.
 *
 * @author rmathew
 */
public class CatalogReader
{
 
    public List<Product> getProducts()
    {
        Path path;
        Reader reader = null;
        try
        {
            path = Paths.get(ClassLoader.getSystemResource("catalog.csv").toURI());
            reader = Files.newBufferedReader(path);
        }
        catch (URISyntaxException e)
        {
            e.printStackTrace();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        CSVParser parser = new CSVParserBuilder().withSeparator(',')
            // .withIgnoreQuotations(true)
            .build();

        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(0).withCSVParser(parser).build();

        List<Product> products = new ArrayList<>();
        Product product = null;
        final List<String> errors = new ArrayList<>();
        int rowNum = 0;
        Integer partNumber;
        Double price;
        Double discount;

        String[] productColumns;
        try
        {
            // Skip header
            csvReader.readNext();
            while ((productColumns = csvReader.readNext()) != null)
            {
                ++rowNum;
                if (productColumns.length >= 5 && !StringUtils.isEmpty(productColumns[0].trim()))
                {
                    try
                    {
                        partNumber = Integer.valueOf(productColumns[0]);
                        product = new Product(partNumber);
                        product.setDescription(productColumns[1]);
                        product.setCategory(productColumns[2]);
                        product.setUom(productColumns[3]);
                        price = Double.valueOf(productColumns[4]);
                        product.setPrice(price);
                        int index = 0;
                        if (productColumns.length > 5 && (index = productColumns[5].indexOf("%")) > 0)
                        {
                            discount = Double.valueOf(productColumns[5].substring(0, index));
                            product.setDiscount(discount);
                        }
                        products.add(product);
                    }
                    catch (final NumberFormatException e)
                    {
                        errors.add(rowNum + " Invalid number for partnumber, price or discount");
                    }
                }
                else
                {
                    errors.add(rowNum + ": Invalid row, wrong number of columns or missing part number");
                }

            }
            
            //Handle errors - write to log or send email to user group

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return products;
    }

}
