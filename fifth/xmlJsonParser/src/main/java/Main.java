import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.w3c.dom.Element;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.*;


public class Main {

    public static void main(String[] args) {
        String path = "data.xml";
        List<Employee> employees = parseXML(path);
        String listEmployee = listToJson(employees);
        writeStringToJson(listEmployee);


    }

    public static String listToJson(List<Employee> employees) {

        Type listType = new TypeToken<List<Employee>>() {
        }.getType();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(employees, listType);

    }

    public static void writeStringToJson(String json) {
        try (FileWriter file = new FileWriter("new_data_from_xml.json")) {
            file.write(json);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static List<Employee> parseXML(String xml) {
        Document doc = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = (Document) builder.parse(new File(xml));
        } catch (ParserConfigurationException | IOException | org.xml.sax.SAXException e) {
            e.printStackTrace();
        }

        assert doc != null;
        Node root = doc.getDocumentElement();
        NodeList nodeList = root.getChildNodes();

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (Node.ELEMENT_NODE == node.getNodeType()) {
                Element element = (Element) node;
                employees.add(new Employee(
                        Long.parseLong(getTextContent("id", element)),
                        getTextContent("firstName", element),
                        getTextContent("lastName", element),
                        getTextContent("country", element),
                        Integer.parseInt(getTextContent("age", element))
                ));
            }
        }
        return employees;
    }

    private static String getTextContent(String tag, Element element) {
        return element.getElementsByTagName(tag).item(0).getTextContent();
    }


}

