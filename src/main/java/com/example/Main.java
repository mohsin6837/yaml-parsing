package com.example;

import com.example.entity.Customer;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.inspector.TagInspector;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        LoaderOptions loaderOptions=new LoaderOptions();
        TagInspector tagInspector=tag -> tag.getClassName().equals(Customer.class.getName());
        loaderOptions.setTagInspector(tagInspector);
        Yaml yaml = new Yaml(new Constructor(Customer.class,loaderOptions));
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("customer.yaml");
        Customer customer = yaml.load(inputStream);
        System.out.println(customer.getFirstName());
        System.out.println(customer.getLastName());
        System.out.println(customer.getAge());
        System.out.println(customer.getLastName);
    }
}

