package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.opencsv.CSVWriter;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

public class ProductMgmtApp {
    public static void main(String[] args) throws JAXBException, IOException {
        Product[] products = {
                new Product(3128874119l, "Banana", LocalDate.of(2000, 10, 5), 124, 0.55),
                new Product(2927458265l, "Apple", LocalDate.of(2000, 10, 5), 18, 1.99),
                new Product(9189927460l, "Carrot", LocalDate.of(2000, 10, 5), 89, 2.99) };

        System.out.println(productsAsJSON(products));
        productsAsXML(products);
        System.out.println(productsAsCSV(products));

    }

    public static String productsAsJSON_2(Product[] products) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
                .setPrettyPrinting().create();
        return gson.toJson(products);
    }

    public static String productsAsJSON(Product[] products) {
        JsonbConfig config = new JsonbConfig();
        Jsonb jsonb = JsonbBuilder.create(config);
        String result = jsonb.toJson(products);
        return result;
    }

    public static void productsAsXML(Product[] products) throws JAXBException {
        Products peopleWrapper = new Products(products); // Wrap the array if using a wrapper
        JAXBContext context = JAXBContext.newInstance(Products.class); // Or Person.class if no wrapper
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // Formatted
        marshaller.marshal(peopleWrapper, System.out); // Or marshaller.marshal(person1, System.out); for a single
                                                       // object
    }

    public static String productsAsCSV(Product[] products) throws IOException {
        StringWriter stringWriter = new StringWriter();
        CSVWriter writer = new CSVWriter(stringWriter);

        String[] header = { "Name", "ID", "Unit Price", "Date" };
        writer.writeNext(header);

        for (Product product : products) {
            String[] productData = { product.getName(), String.valueOf(product.getProductId()),
                    String.valueOf(product.getUnitPrice()), formatter.format(product.getDateSupplied()) };
            writer.writeNext(productData);
        }

        writer.close();
        String csvString = stringWriter.toString();
        return csvString;

    }

    @XmlRootElement(name = "product")
    @XmlAccessorType(XmlAccessType.FIELD)
    static class Products {
        private Product[] product;

        public Product[] getProduct() {
            return product;
        }

        public void setProduct(Product[] product) {
            this.product = product;
        }

        public Products() {
        } // Empty constructor required by JAXB

        public Products(Product[] product) {
            this.product = product;
        }
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    static class LocalDateSerializer implements JsonSerializer<LocalDate> {

        @Override
        public JsonElement serialize(LocalDate localDate, Type type,
                JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(formatter.format(localDate));
        }
    }
}
