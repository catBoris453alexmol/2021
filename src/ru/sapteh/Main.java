package ru.sapteh;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        // Ввод названия архива через консоль
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = "c:/javaProject/2021";
        System.out.println("Input Name archive: ");
        String pathZip = reader.readLine();
        System.out.println("Input Name copy File: ");
        String pathFile = reader.readLine();
        System.out.println("Input URL: ");
        String pathURL = reader.readLine();
        System.out.println("Input Name Image: ");
        String pathImage = reader.readLine();
        // create zip.archive
        FileOutputStream zipArchive = new FileOutputStream(path + File.separator +pathZip);
        ZipOutputStream zip = new ZipOutputStream(zipArchive);
        // copy words from file in File archive
        zip.putNextEntry(new ZipEntry(pathFile));
        Path docPath = Paths.get(path + File.separator + pathFile);
        Files.copy(docPath, zip);
        // Скачивание картинки с интернета
        URL url = new URL(pathURL);
        InputStream stream = url.openStream();
        // перенос картинки в папку с расширением
        Path picturePath = Paths.get(path + File.separator + pathImage);
        Files.copy(stream, picturePath, StandardCopyOption.REPLACE_EXISTING);
        // перенос картинки с папки в архив с расширением
        zip.putNextEntry(new ZipEntry(pathImage));
        Files.copy(picturePath, zip);
        zip.close();
        stream.close();

}
}
