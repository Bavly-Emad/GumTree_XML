# GumTree_XML
Tool for differentiating two XML snippet of codes or couple of files that contains XML code.
The Main idea is to draw a fine tree for the differentiation between the two XML codes.

You will need to build new Maven project and add this to POM.xml file

<dependencies>
        <dependency>
            <groupId>org.xmlunit</groupId>
            <artifactId>xmlunit-core</artifactId>
            <version>2.9.0</version>
        </dependency>
        <dependency>
            <groupId>org.xmlunit</groupId>
            <artifactId>xmlunit-matchers</artifactId>
            <version>2.9.0</version>
        </dependency>
</dependencies>

then reload the project to download the dependencies
